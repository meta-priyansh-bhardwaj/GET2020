package metaparking.daoimpl;

import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import metaparking.dao.UserDao;
import metaparking.models.User;

/**
 * Class to return User related dataS 
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Get user from id
	 * @param empId
	 * @return user
	 */
	@Override
	public User getUserById(int empId) {
		User user;
		user = jdbcTemplate.queryForObject(selectUser, new Object[] {empId}, new BeanPropertyRowMapper<>(User.class));
		if(user==null) {
			user = new User();
		}
		return user;
	}

	/**
	 * Update user function
	 * @param empId
	 * @param user
	 * @return true if updated or false otherwise
	 */
	@Override
	public boolean updateUser(int empId, User user) {
		String fullName = user.getFullName();
		String gender = user.getGender();
		String emailId = user.getEmailId();
		String password = user.getPassword();
		String confirmPassword = user.getPassword();
		String contactNumber = user.getContactNumber();
		String orgName = user.getOrgName();
		Object[] args = new Object[] {fullName, gender, emailId, password, confirmPassword, contactNumber, orgName, empId};
		int[] mysqlArgTypes = new int[8];
		for (int index = 0; index <= 6; index++) {
			mysqlArgTypes[index] = Types.VARCHAR;
		}
		mysqlArgTypes[7] = Types.INTEGER;
		int rowsAffected = jdbcTemplate.update(updateUser, args, mysqlArgTypes);
		return rowsAffected != 0;
	}

	/**
	 * Function to add user
	 * @param user
	 * @return id of the user
	 */
	@Override
	public int addUser(User user) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Employee").usingColumns("fullName", "gender", "emailId", "password", "confirmPassword", "contactNumber", "orgName");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		insertActor.execute(param);
		int empId =  jdbcTemplate.queryForObject(lastRecord, new Object[0], Integer.class) - 1;
		return empId;
	}

	/**
	 * Fucntion to get user id from email
	 * @param emailId
	 * @return userId
	 */
	public int getUserId(String emailId) {
		System.out.println("In employee id...");
		Integer empId = -1;
		try {
			empId = jdbcTemplate.queryForObject(getUserIdByEmail, new Object[] {emailId}, Integer.class);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Employee Id : " + empId);
		return empId;
	}

	/**
	 * Get organisation name from Id
	 * @param empId
	 * @return organisation name
	 */
	public String getOrgName(int empId) {
		String orgName = jdbcTemplate.queryForObject(selectOrgName, new Object[] {empId}, String.class);
		return orgName;
	}

	/**
	 * Function to get list of all friends working in same organisation
	 * @param empId
	 * @return list of friends
	 */
	public List<User> getFriends(int empId) {
		String orgName = getOrgName(empId);
		List<User> friends = jdbcTemplate.query(selectFriends, new Object[] {orgName, empId}, new BeanPropertyRowMapper<>(User.class));
		return friends;
	}
	
	/**
	 * Function to store address of uploaded profilepicture
	 * @param empId
	 * @param pictureAddress
	 * @return true if stored
	 */
	@Override
	public boolean uploadProfilePicture(int empId, String pictureAddress) {
		int rowAffected = jdbcTemplate.update(uploadPicture, new Object[] {pictureAddress, empId}, new Object[] {Types.VARCHAR, Types.INTEGER});
		return rowAffected != 0;
	}
}