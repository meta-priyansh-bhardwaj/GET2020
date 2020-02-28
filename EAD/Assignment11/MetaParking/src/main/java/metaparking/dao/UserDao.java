package metaparking.dao;

import java.util.List;

import metaparking.models.User;

/**
 * Interface to return User related dataS 
 *
 */
public interface UserDao {
	String insertUser = "INSERT INTO User (empId, fullName, gender, emailId, password, confirmPassword, contactNumber, orgName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	String updateUser = "UPDATE User set fullName = ?, gender = ?, emailId = ?, password = ?"
			+ ", confirmPassword = ?, contactNumber = ?, orgName = ? where empId = ?";
	String selectUser = "SELECT * FROM User where empId = ?";
	String lastRecord = "SELECT MAX(empId) AS id FROM User";
	String getUserIdByEmail = "SELECT empId from User where emailId = ?;";
	String selectOrgName = "SELECT OrgName from User where empId = ?";
	String selectFriends = "SELECT * FROM User where orgName = ? and empId <> ?;";
	String uploadPicture = "UPDATE User set profilePicture = ? where empId = ?";

	/**
	 * Get user from id
	 * @param empId
	 * @return user
	 */
	User getUserById(int empId);

	/**
	 * Update user function
	 * @param empId
	 * @param user
	 * @return true if updated or false otherwise
	 */
	User updateUser(User user);
	
	/**
	 * Function to add user
	 * @param user
	 * @return id of the user
	 */
	int addUser(User user);

	/**
	 * Get organisation name from Id
	 * @param empId
	 * @return organisation name
	 */
	List<User> getFriends(int empId);
	
	/**
	 * Function to store address of uploaded profilepicture
	 * @param empId
	 * @param pictureAddress
	 * @return true if stored
	 */
	User uploadProfilePicture(int empId, String pictureAddress);

	/**
	 * Get user from emailId
	 * @param emailId
	 * @return userId
	 */
	int getUserIdByEmailId(String emailId);
}