package springassignment.mailsender;

import org.springframework.stereotype.Component;

/**
 * Class MockMailSender that implements MailSender 
 *
 */
//Uncomment @Component to make it component.
@Component("mockmailsender")
public class MockMailSender implements MailSender {
	
	/**
	 * Function to implement send of MockMailSender
	 */
	@Override
	public void send() {
		System.out.println("Mock mail sent");

	}

}
