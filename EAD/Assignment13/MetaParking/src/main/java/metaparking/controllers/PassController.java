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

import metaparking.dtos.UserDto;
import metaparking.models.Pass;
import metaparking.models.PassInfo;
import metaparking.models.Vehicle;
import metaparking.services.PassInfoService;
import metaparking.services.UserService;
import metaparking.services.VehicleService;

/**
 * Controller to implement Pass related endpoints 
 *
 */
@Controller
public class PassController {

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
	 * endpoint to add new pass to database
	 * @param pass
	 * @param errors
	 * @param model
	 * @return pass
	 */
	@PostMapping("/addPass")
	public String generatePass(@Valid @ModelAttribute("pass") Pass pass, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pass";
		} else {
			Vehicle vehicle = vehicleService.getVehicleById(pass.getVehicle().getVehicleId());
			String vehicleType = vehicle.getType();
			String passType = pass.getPassType();
			PassInfo passInfo = passInfoService.getPassInfo(vehicleType, passType);
			vehicle.setPass(passInfo);
			vehicleService.updateVehicle(vehicle);
			model.addAttribute("employeeDto", new UserDto());
			return "redirect:login";
		}
	}

	/**
	 * enpoint to get pass details
	 * @param model
	 * @param session
	 * @param res
	 * @return showPassDetails
	 */
	@GetMapping("/getPassDetails")
	public String getPassDetails(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Vehicle vehicle = vehicleService.getVehicleByUser(userService.getUserById(empId));

			PassInfo pass = vehicle.getPass();
			
			model.addAttribute("user", session.getAttribute("user"));
			model.addAttribute("pass", pass);
			model.addAttribute("vehicleType", vehicle.getType());

			return "showPassDetails";
		} else {
			return "redirect:login";
		}
	}

	/**
	 * endpoint to edit pass details
	 * @param pass
	 * @param errors
	 * @param session
	 * @return display
	 */
	@PostMapping("/editPass")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Pass pass, Errors errors,
			HttpSession session) {
		int empId = (int) session.getAttribute("empId");
		Vehicle vehicle = vehicleService.getVehicleByUser(userService.getUserById(empId));
		String passType = pass.getPassType();
		PassInfo passInfo = passInfoService.getPassInfo(vehicle.getType(), passType);
		vehicle.setPass(passInfo);
		vehicleService.updateVehicle(vehicle);
		return "redirect:display";
	}
}