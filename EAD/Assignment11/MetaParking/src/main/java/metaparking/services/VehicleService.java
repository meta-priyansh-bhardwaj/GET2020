package metaparking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaparking.daoimpl.VehicleDaoImpl;
import metaparking.models.User;
import metaparking.models.Vehicle;

/**
 * Class to implement Vehicle related service
 *
 */
@Service
public class VehicleService {

	@Autowired
	private VehicleDaoImpl vehicleDao;

	/**
	 * Fucntion to add new vehicle
	 * @param vehicle
	 * @return id of new vehicle
	 */
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	/**
	 * Function to get vehicle from id
	 * @param userId
	 * @return vehicle
	 */
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	/**
	 * Fucntion to update vehicle
	 * @param vehicle
	 * @param vehicleId
	 * @returntrue if updated or false otherwise
	 */
	public Vehicle updateVehicle(Vehicle vehicle) {
		return vehicleDao.updateVehicle(vehicle);
	}

	/**
	 * Function to get vehicle from user
	 * @param userId
	 * @return vehicle
	 */
	public Vehicle getVehicleByUser(User user) {
		return vehicleDao.getVehicleByUser(user);
	}
}