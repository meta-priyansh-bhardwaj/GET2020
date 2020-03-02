package springassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springassignment.mailsender.MailSender;

/**
 * Class to define controller for REST API 
 *
 */
@RestController
public class SendingController {

	/**
	 * Field injection
	 */
	// Uncomment @Autowired to perform name injection.
	// @Autowired
	// Uncomment @Qualifier to solve the multiple bean problem.
	// @Qualifier("smtpmailsender")
	private MailSender mailSender;

	/**
	 * Contructor Injection
	 * @param mailSender
	 */
	// Uncomment below lines and comment the setter to apply constructor injection.
//	  @Autowired
//	  public SendingController(MailSender mailSender) {
//	  	this.mailSender = mailSender;
//	  }
	 
	 
	/**
	 * Setter injection with mock bean
	 * @param mock
	 */
//	@Autowired
//	public void setMailSender(MailSender mock) {
//		this.mailSender = mock;
//	}
	
	/**
	 * Setter injection with smtp bean
	 * @param smtp
	 */
	@Autowired
	public void setMailSender(MailSender smtp) {
		this.mailSender = smtp;
	}

	/**
	 * Get mapping for endpoint send
	 * @return status message
	 */
	@GetMapping("/send")
	public String sendMail() {
		mailSender.send();
		return "Mail sent successfully...";
	}
}
