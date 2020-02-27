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
import metaparking.services.VehicleService;

/**
 * Controller to implement Vehicle related endpoints  
 *
 */
@Controller
public class VehicleController {

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
			vehicle.setPassId(-1); // -1 represents that user does not have any pass.
			int vehicleId = vehicleService.addVehicle(vehicle);
			System.out.println("Vehicle Id : " + vehicleId);
			model.addAttribute("vehicleType", vehicle.getType());
			model.addAttribute("vehicleId", vehicleId);
			model.addAttribute("pass", new Pass());
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
			int vehicleId = vehicleService.getVehicleIdByEmpId(empId);
			Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
			model.addAttribute("vehicle", vehicle);
			model.addAttribute("user", session.getAttribute("user"));
			System.out.println(vehicle.getEmpId() + " " + vehicle.getPassId());
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
			System.out.println(empId);
			int vehicleId = vehicleService.getVehicleIdByEmpId(empId);
			String passType = passInfoService.getPassType(vehicle.getPassId());
			int passId = passInfoService.getPassId(vehicle.getType(), passType);
			vehicle.setPassId(passId);
			System.out.println("vehicle id : " + vehicleId);
			vehicleService.updateVehicle(vehicle, vehicleId);
			return "redirect:display";
		}
	}
}