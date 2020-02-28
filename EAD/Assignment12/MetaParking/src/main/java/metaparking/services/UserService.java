package metaparking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaparking.dao.UserDao;
import metaparking.models.User;

/**
 * Class to implement User related service
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * Function to add new user
	 * @param user
	 * @return id of new user
	 */
	@Transactional
	public int addUser(User user) {
		userDao.save(user);
		return user.getEmpId();
	}

	/**
	 * Function to get user from id
	 * @param userId
	 * @return user
	 */
	@Transactional
	public User getUserById(int userId) {
		return userDao.findById(userId).orElse(new User());
	}

	/**
	 * Function to get user from emailId
	 * @param userId
	 * @return user
	 */
	@Transactional
	public int getUserId(String emailId) {
		Integer empId = userDao.findEmpIdByEmailId(emailId);
		if(empId == null) {
			empId = -1;
		}
		return empId;
	}

	/**
	 * Function to update user
	 * @param empId
	 * @param user
	 * @return true if updated or false otherwise
	 */
	@Transactional
	public User updateUser(User user) {
		return userDao.save(user);
	}

	/**
	 * Function to get list of all friends
	 * @param empId
	 * @return list of users in same organisation
	 */
	@Transactional
	public List<User> getFriends(int empId) {
		User user = userDao.findById(empId).orElse(new User());
		return userDao.findFriends(user.getOrgName(), empId);
	}
	
	/**
	 * Function to store address of uploaded profile picture
	 * @param empId
	 * @param pictureAddress
	 * @return user
	 */
	@Transactional
	public User uploadProfilePicture(int empId, String pictureAddress) {
		User user = userDao.findById(empId).orElse(new User());
		user.setProfilePicture(pictureAddress);
		return userDao.save(user);
	}
}