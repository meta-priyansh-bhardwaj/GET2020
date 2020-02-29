package metaparking.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaparking.dao.PassInfoDao;
import metaparking.models.PassInfo;

/**
 * Class to implement PassInfo related service
 *
 */
@Service
public class PassInfoService {

	@Autowired
	private PassInfoDao passInfoDao;

	/**
	 * Function to get passId from vehicle type and pass ype
	 * @param vehicleType
	 * @param passType
	 * @return passId
	 */
	@Transactional
	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.findPassInfoByPassTypeAndVehicleType(vehicleType, passType);
	}
}