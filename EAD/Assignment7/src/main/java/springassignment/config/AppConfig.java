package springassignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springassignment.mailsender.MailSender;
import springassignment.mailsender.MockMailSender;
import springassignment.mailsender.SMTPMailSender;

/**
 * Configuration file to supply beans
 * mock and smtp are the beans 
 *
 */
//Uncomment the @Configuration while using the @Component annotation.
@Configuration
public class AppConfig {

	/**
	 * mock bean to return MockMailSender
	 * @return MailSender of type MockMailSender
	 */
	@Bean("mock")
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

	/**
	 * mock bean to return SMTPMailSender
	 * @return MailSender of type SMTPMailSender
	 */
	@Bean("smtp")
	public MailSender SMTPMailSender() {
		return new SMTPMailSender();
	}
}
