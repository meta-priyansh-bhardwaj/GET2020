package studentmgmtsystem.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import studentmgmtsystem.model.Student;

/**
 * Class to implement HomeController
 *
 */
@Controller
@PropertySource("classpath:application.yml")
public class HomeController {
	
	@Value("${home.message}")
	private String welcomeMessage;
	
	/**
	 * Endpoint '/' and '/home'
	 * @param model
	 * @return
	 */
	@GetMapping({"/", "/home"})
	public String getHomePageController(Model model) {
		model.addAttribute("welcomeMessage", welcomeMessage);
		return "home";
	}
	
	/**
	 * Endpoint '/student'
	 * @param model
	 * @return
	 */
	@GetMapping("/student")
	public String addStudentController(Model model) {
		model.addAttribute("student", new Student());
		return "addstudent";
	}
}
