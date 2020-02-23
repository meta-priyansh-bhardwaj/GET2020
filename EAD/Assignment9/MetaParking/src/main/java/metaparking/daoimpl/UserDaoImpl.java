package metaparking.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import metaparking.dao.UserDao;
import metaparking.models.User;
import metaparking.utils.ConnectionUtility;

/**
 * Class to return User related dataS 
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	/**
	 * Get user from id
	 * @param empId
	 * @return user
	 */
	@Override
	public User getUserById(int empId) {
		User user = new User();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectUser);
			st.setInt(1, empId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user.setEmpId(empId);
				user.setFullName(rs.getString("fullName"));
				user.setGender(rs.getString("gender"));
				user.setEmailId(rs.getString("emailId"));
				user.setPassword(rs.getString("password"));
				user.setConfirmPassword(rs.getString("confirmPassword"));
				user.setContactNumber(rs.getString("contactNumber"));
				user.setOrgName(rs.getString("orgName"));
				user.setProfilePicture(rs.getString("profilePicture"));
			}
		} catch (SQLException e) {
			System.out.println("User could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return user;
	}

	/**
	 * Update user function
	 * @param empId
	 * @param employee
	 * @return true if updated or false otherwise
	 */
	@Override
	public boolean updateUser(int empId, User employee) {
		boolean result = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(updateUser);
			st.setString(1, employee.getFullName());
			st.setString(2, employee.getGender());
			st.setString(3, employee.getEmailId());
			st.setString(4, employee.getPassword());
			st.setString(5, employee.getPassword());
			st.setString(6, employee.getContactNumber());
			st.setString(7, employee.getOrgName());
			st.setInt(8, empId);
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("User Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return result;
	}

	/**
	 * Function to add user
	 * @param user
	 * @return id of the user
	 */
	@Override
	public int addUser(User employee) {
		int empId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(insertUser);
			st.setInt(1, employee.getEmpId());
			st.setString(2, employee.getFullName());
			st.setString(3, employee.getGender());
			st.setString(4, employee.getEmailId());
			st.setString(5, employee.getPassword());
			st.setString(6, employee.getConfirmPassword());
			st.setString(7, employee.getContactNumber());
			st.setString(8, employee.getOrgName());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				st = connection.prepareStatement(lastRecord);
				ResultSet rs = st.executeQuery();
				rs.next();
				empId = rs.getInt("id");
			}
		} catch (SQLException e) {
			System.out.println("User Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return empId;
	}

	/**
	 * Fucntion to get user id from email
	 * @param emailId
	 * @return userId
	 */
	public int getUserId(String emailId) {
		int userId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(getUserIdByEmail);
			st.setString(1, emailId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("empId");
			}
		} catch (SQLException e) {
			System.out.println("User could not be Added");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return userId;
	}

	/**
	 * Get organisation name from Id
	 * @param empId
	 * @return organisation name
	 */
	public String getOrgName(int empId) {
		String orgName = "";
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectOrgName);
			st.setInt(1, empId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				orgName = rs.getString("orgName");
			}
		} catch (SQLException e) {
			System.out.println("Org name could not fetch...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return orgName;
	}

	/**
	 * Function to get list of all friends working in same organisation
	 * @param empId
	 * @return list of friends
	 */
	public List<User> getFriends(int empId) {
		String orgName = getOrgName(empId);
		List<User> friends = new ArrayList<User>();
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectFriends);
			st.setString(1, orgName);
			st.setInt(2, empId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setEmpId(rs.getInt("empId"));
				user.setFullName(rs.getString("fullName"));
				user.setGender(rs.getString("gender"));
				user.setEmailId(rs.getString("emailId"));
				user.setContactNumber(rs.getString("contactNumber"));
				user.setOrgName(rs.getString("orgName"));
				friends.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Org name could not fetch...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
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
		boolean result = false;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(uploadPicture);
			st.setString(1, pictureAddress);
			st.setInt(2, empId);
			if(st.executeUpdate() != 0) {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("Address was not stored...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return result;
	}
}