package metaparking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import metaparking.models.User;

/**
 * Interface to return User related dataS 
 *
 */
public interface UserDao extends CrudRepository<User, Integer> {
	/**
	 * Query to get EmpId by EmailId
	 * @param emailId
	 * @return empId
	 */
	@Query("Select empId from User where emailId = :emailId")
	Integer findEmpIdByEmailId(@Param("emailId") String emailId);
	
	/**
	 * Query to get friends
	 * @param orgName
	 * @param empId
	 * @return List of Friends
	 */
	@Query("from User where orgName = :orgName and empId != :empId")
	List<User> findFriends(@Param("orgName") String orgName, @Param("empId") int empId);
}