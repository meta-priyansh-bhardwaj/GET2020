package metaparking.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import metaparking.models.Pass;
import metaparking.models.Vehicle;
import metaparking.services.PassInfoService;
import metaparking.services.UserService;
import metaparking.services.VehicleService;

/**
 * Controller to implement Vehicle related endpoints  
 *
 */
@Controller
public class VehicleController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private PassInfoService passInfoService;

	/**
	 * Checks if user is already logged in
	 * @param session
	 * @param res
	 * @return true if logged in or false otherwise
	 */
	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}

	/**
	 * endpoint to add vehicle to database
	 * @param vehicle
	 * @param errors
	 * @param model
	 * @return pass
	 */
	@PostMapping("/addVehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "vehicle";
		} else {
			vehicle.setUser(userService.getUserById(vehicle.getUser().getEmpId()));
			int vehicleId = vehicleService.addVehicle(vehicle);
			model.addAttribute("vehicleId", vehicleId);
			Pass pass = new Pass();
			pass.setVehicle(new Vehicle());
			model.addAttribute("pass", pass);
			return "pass";
		}
	}

	/**
	 * endpoint to get vehicle details
	 * @param session
	 * @param model
	 * @param res
	 * @return showVehicleDetails
	 */
	@GetMapping("/getVehicleDetails")
	public String getVehicleDetails(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Vehicle vehicle = vehicleService.getVehicleByUser(userService.getUserById(empId));
			model.addAttribute("vehicle", vehicle);
			model.addAttribute("user", session.getAttribute("user"));
			return "showVehicleDetails";
		} else {
			return "redirect:login";
		}
	}

	/**
	 * endpoint to edit vehicle in database
	 * @param vehicle
	 * @param errors
	 * @param session
	 * @return showVehicleDetails
	 */
	@PostMapping("/editVehicle")
	public String updateVehicleDetails(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showVehicleDetails";
		} else {
			int empId = (int) session.getAttribute("empId");
			vehicle.setPass(passInfoService.getPassInfo(vehicle.getType(), vehicle.getPass().getPassType()));
			vehicle.setUser(userService.getUserById(empId));
			vehicleService.updateVehicle(vehicle);
			return "redirect:display";
		}
	}
}