package metaparking.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import metaparking.models.User;
import metaparking.models.Vehicle;

/**
 * Interface to return vehicle related data 
 *
 */
public interface VehicleDao extends CrudRepository<Vehicle, Integer> {
	
	/**
	 * Function to find Vehicle of a User
	 * @param user
	 * @return Vehicle
	 */
	@Query("from Vehicle where user = :user")
	Vehicle findVehicleByUser(@Param("user") User user);
}