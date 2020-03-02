package springassignment.mailsender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Class SMTPMailSender that implements MailSender 
 *
 */
//Uncomment @Component to make it component.
@Component("smtpmailsender")
@Primary
public class SMTPMailSender implements MailSender {

	/**
	 * Function to implement send of SMTPMailSender
	 */
	@Override
	public void send() {
		System.out.println("SMTP Mail sent");

	}

}
