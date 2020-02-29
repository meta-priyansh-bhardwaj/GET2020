package metaparking.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *	Class to implement spring security configuration 
 *
 */
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * Defines in-memory login credentials
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}user").roles("USER")
			.and()
			.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	/**
	 * Defines resources access rules
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/**/*.js", "/**/*.css", "/**/*.jpg", "/**/*.jpeg", "/**/*.png").permitAll()
			.antMatchers("/**")
			.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.and()
			.formLogin().loginPage("/login").permitAll()
			.defaultSuccessUrl("/", true);
	}	
}
