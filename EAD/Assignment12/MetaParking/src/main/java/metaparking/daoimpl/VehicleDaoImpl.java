/*
 * package metaparking.daoimpl;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.hibernate.Session; import org.hibernate.Transaction; import
 * org.hibernate.query.Query; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * import metaparking.dao.VehicleDao; import metaparking.models.User; import
 * metaparking.models.Vehicle;
 * 
 *//**
	 * Class to return vehicle related data
	 *
	 */
/*
 * @Repository public class VehicleDaoImpl implements VehicleDao {
 * 
 * @Autowired private EntityManager entityManager;
 * 
 *//**
	 * Get vehicle from Id
	 * 
	 * @param vehicleId
	 * @return vehicle
	 */
/*
 * @Override public Vehicle getVehicle(int vehicleId) { Session session =
 * entityManager.unwrap(Session.class); Vehicle vehicle =
 * session.get(Vehicle.class, vehicleId); return vehicle; }
 * 
 *//**
	 * Function to add vehicle
	 * 
	 * @param vehicle
	 * @return id of the vehicle
	 */
/*
 * @Override public int addVehicle(Vehicle vehicle) { Session session =
 * entityManager.unwrap(Session.class); session.beginTransaction();
 * session.saveOrUpdate(vehicle); Transaction transaction =
 * session.getTransaction(); transaction.commit(); return
 * vehicle.getVehicleId(); }
 * 
 *//**
	 * Function to get vehicle by userId
	 * 
	 * @param userId
	 * @return
	 */
/*
 * public Vehicle getVehicleByUser(User user) { Session session =
 * entityManager.unwrap(Session.class); Query<Vehicle> query =
 * session.createQuery("from Vehicle where user = :user", Vehicle.class);
 * query.setParameter("user", user); Vehicle vehicle = null; try { vehicle =
 * query.uniqueResult(); } catch (Exception ex) {
 * System.out.println(ex.getMessage()); } return vehicle; }
 * 
 *//**
	 * Function to update vehicle
	 * 
	 * @param vehicle
	 * @param vehicleId
	 * @return vehicle
	 *//*
		 * public Vehicle updateVehicle(Vehicle vehicle) { Session session =
		 * entityManager.unwrap(Session.class); session.beginTransaction(); Transaction
		 * transaction = session.getTransaction(); session.update(vehicle);
		 * transaction.commit(); return vehicle; } }
		 */