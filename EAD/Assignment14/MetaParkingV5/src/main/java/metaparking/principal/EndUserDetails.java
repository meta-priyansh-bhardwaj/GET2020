package metaparking.principal;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import metaparking.models.EndUser;

/**
 * Class to implement UserDetail
 *
 */
public class EndUserDetails implements UserDetails {

	private static final long serialVersionUID = 1140414051053412436L;
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	/**
	 * Constructor to create UserDetails from EndUser
	 * @param endUser
	 */
	public EndUserDetails(EndUser endUser) {
		System.out.println(endUser);
		this.userName = endUser.getUsername();
		this.password = endUser.getPassword();
		this.active = endUser.getActive();
		this.authorities = Arrays.stream(endUser.getRoles().split(","))
									.map(SimpleGrantedAuthority::new)
									.collect(Collectors.toList());
	}
	
	/**
	 * Default constructor
	 */
	public EndUserDetails() {}
	
	/**
	 * Function to get authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * Function to get password
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * Function to get username
	 */
	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	/**
	 * Function to return UserDetails as a string
	 */
	@Override
	public String toString() {
		return "EndUserDetails [userName=" + userName + ", password=" + password + ", active=" + active
				+ ", authorities=" + authorities + "]";
	}

}