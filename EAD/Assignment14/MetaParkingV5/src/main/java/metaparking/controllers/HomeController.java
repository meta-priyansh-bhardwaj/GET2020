package metaparking.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import metaparking.dtos.UserDto;
import metaparking.models.EndUser;
import metaparking.models.User;

/**
 * Class to implement controller that returns static pages 
 *
 */
@Controller
public class HomeController {

	/**
	 * Function to check is session is already logged in
	 * @param session
	 * @param res
	 * @return if logged in or false otherwise
	 */
	public static boolean isSessionValid(HttpSession session, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("empId") == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * endpoint '/' and '/home'
	 * @return home
	 */
	@GetMapping({ "/", "/home" })
	public String getHomePage(Model model) {
		System.out.println("In home controller...");
		model.addAttribute("endUser", new EndUser());
		return "home";
	}

	/**
	 * endpoint '/register' that return User Registration form 
	 * @param model
	 * @return register
	 */
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	/**
	 * endpoint '/register' that return User Login form 
	 * @param model
	 * @return login
	 */
	@GetMapping("/loginUser")
	public String getLoginPage(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "login";
	}
	
	/**
	 * endpoint 'login' to configure spring security authentication
	 * @param model
	 * @return springSecurityLoginPage
	 */
	@GetMapping("/login")
	public String getSpringSecurityLoginPage(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "springSecurityLoginPage";
	}

	/**
	 * endpoint '/display' to display welcome message if logged in already
	 * @param session
	 * @param res
	 * @return display if logged in or redirect to login otherwise
	 */
	@GetMapping("/display")
	public String getDisplayPage(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			model.addAttribute("user", session.getAttribute("user"));
			return "display";
		} else {
			return "redirect:login";
		}
	}
}