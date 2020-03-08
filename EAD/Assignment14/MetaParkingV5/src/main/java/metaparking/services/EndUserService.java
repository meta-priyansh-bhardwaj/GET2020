package metaparking.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import metaparking.dao.EndUserDao;
import metaparking.models.EndUser;
import metaparking.principal.EndUserDetails;

/**
 * Class to implement services related to EndUser
 *
 */
@Service
public class EndUserService implements UserDetailsService {

	@Autowired
	private EndUserDao endUserDao;

	/**
	 * Function to load UserDetails by its userName
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<EndUser> endUser = endUserDao.findByUsername(username);
		endUser.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
		return endUser.map(EndUserDetails::new).get();
	}

	/**
	 * Function to update the EndUser
	 * @param endUser
	 * @return update EndUser
	 */
	@Transactional
	public EndUser updateEndUser(EndUser endUser) {
		EndUser end = endUserDao.findByUsername(endUser.getUsername()).orElse(new EndUser());
		endUser.setId(end.getId());
		UserDetails userDetails = new EndUserDetails(endUser);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return endUserDao.save(endUser);
	}
}