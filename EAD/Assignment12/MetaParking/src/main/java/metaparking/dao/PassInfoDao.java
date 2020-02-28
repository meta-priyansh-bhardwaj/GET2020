package metaparking.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import metaparking.models.PassInfo;

/**
 * Interface to get Pass Pricing related data
 *
 */
public interface PassInfoDao extends CrudRepository<PassInfo, Integer> {
	
	/**
	 * Function to get PassInfo
	 * @param vehicleType
	 * @param passType
	 * @return passInfo
	 */
	@Query("from PassInfo where vehicleType = :vehicleType and passType = :passType")
	PassInfo findPassInfoByPassTypeAndVehicleType(@Param("vehicleType") String vehicleType, @Param("passType") String passType);
}