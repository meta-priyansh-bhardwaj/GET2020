package metaparking.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaparking.dao.VehicleDao;
import metaparking.models.User;
import metaparking.models.Vehicle;

/**
 * Class to implement Vehicle related service
 *
 */
@Service
public class VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	/**
	 * Function to add new vehicle
	 * @param vehicle
	 * @return id of new vehicle
	 */
	@Transactional
	public int addVehicle(Vehicle vehicle) {
		Vehicle veh = vehicleDao.save(vehicle);
		return veh.getVehicleId();
	}

	/**
	 * Function to get vehicle from id
	 * @param userId
	 * @return vehicle
	 */
	@Transactional
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.findById(vehicleId).orElse(new Vehicle());
	}

	/**
	 * Fucntion to update vehicle
	 * @param vehicle
	 * @param vehicleId
	 * @returntrue if updated or false otherwise
	 */
	@Transactional
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	/**
	 * Function to get vehicle from user
	 * @param userId
	 * @return vehicle
	 */
	@Transactional
	public Vehicle getVehicleByUser(User user) {
		return vehicleDao.findVehicleByUser(user);
	}
}