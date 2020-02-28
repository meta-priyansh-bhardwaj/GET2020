/*
 * package metaparking.daoimpl;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import org.hibernate.Transaction;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository; import org.hibernate.query.Query;
 * import org.hibernate.Session;
 * 
 * import metaparking.dao.UserDao; import metaparking.models.User;
 * 
 *//**
	 * Class to return User related data
	 *
	 */
/*
 * 
 * 
 * 
 * 
 * @Repository public class UserDaoImpl implements UserDao {
 * 
 * @Autowired private EntityManager entityManager;
 * 
 *//**
	 * Get user from id
	 * 
	 * @param empId
	 * @return user
	 */
/*
 * 
 * 
 * 
 * 
 * @Override public User getUserById(int empId) { Session session =
 * entityManager.unwrap(Session.class); Query<User> query =
 * session.createQuery("from User where empId = :empId", User.class);
 * query.setParameter("empId", empId); User user = query.getSingleResult();
 * return user; }
 * 
 *//**
	 * Update user function
	 * 
	 * @param empId
	 * @param user
	 * @return true if updated or false otherwise
	 */
/*
 * 
 * 
 * 
 * 
 * @Override public User updateUser(User user) { Session session =
 * entityManager.unwrap(Session.class); Transaction transaction =
 * session.beginTransaction(); session.update(user); transaction.commit();
 * return user; }
 * 
 *//**
	 * Function to add user
	 * 
	 * @param user
	 * @return id of the user
	 */
/*
 * 
 * 
 * 
 * 
 * @Override public int addUser(User user) { Session session =
 * entityManager.unwrap(Session.class); session.beginTransaction();
 * session.save(user); Transaction transaction = session.getTransaction();
 * transaction.commit(); return user.getEmpId(); }
 * 
 *//**
	 * Function to get user id from email
	 * 
	 * @param emailId
	 * @return userId
	 */
/*
 * 
 * 
 * 
 * 
 * public int getUserId(String emailId) { Session session =
 * entityManager.unwrap(Session.class); Query<Integer> query =
 * session.createQuery("Select empId from User where emailId = :emailId",
 * Integer.class); query.setParameter("emailId", emailId); int empId = -1; try {
 * empId = query.getSingleResult(); } catch (Exception ex) {
 * System.out.println(ex.getMessage()); } System.out.println(empId); return
 * empId; }
 * 
 *//**
	 * Function to get list of all friends working in same organisation
	 * 
	 * @param empId
	 * @return list of friends
	 */
/*
 * 
 * 
 * 
 * 
 * public List<User> getFriends(int empId) { Session session =
 * entityManager.unwrap(Session.class); User user = getUserById(empId);
 * Query<User> query =
 * session.createQuery("from User where orgName = :orgName and empId <> :empId",
 * User.class); query.setParameter("orgName", user.getOrgName());
 * query.setParameter("empId", user.getEmpId()); List<User> friends =
 * query.getResultList(); return friends; }
 * 
 *//**
	 * Get user from emailId
	 * 
	 * @param emailId
	 * @return userId
	 */
/*
 * 
 * 
 * 
 * 
 * @Override public int getUserIdByEmailId(String emailId) { Session session =
 * entityManager.unwrap(Session.class); Query<Integer> query =
 * session.createQuery("Select empId from User where emailId = :emailId",
 * Integer.class); query.setParameter("emailId", emailId); int empId = -1; try {
 * empId = query.getSingleResult(); } catch (Exception ex) {
 * System.out.println(ex.getMessage()); } System.out.println(empId); return
 * empId; }
 * 
 *//**
	 * Function to store address of uploaded profilepicture
	 * 
	 * @param empId
	 * @param pictureAddress
	 * @return true if stored
	 *//*
		 * @Override public User uploadProfilePicture(int empId, String pictureAddress)
		 * { Session session = entityManager.unwrap(Session.class);
		 * session.beginTransaction(); User user = getUserById(empId);
		 * user.setProfilePicture(pictureAddress); session.update(user); Transaction
		 * transaction = session.getTransaction(); transaction.commit(); return user; }
		 * }
		 */