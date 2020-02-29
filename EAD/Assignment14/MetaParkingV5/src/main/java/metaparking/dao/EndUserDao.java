package metaparking.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import metaparking.models.EndUser;

/**
 * Interface to implement EndUser data access object 
 *
 */
public interface EndUserDao extends CrudRepository<EndUser, Integer> {
	
	/**
	 * Function to find EndUser by its userName
	 * @param userName
	 * @return Optional<EndUser>
	 */
	@Query("from EndUser where username = :userName")
	Optional<EndUser> findByUsername(@Param("userName") String userName);
}