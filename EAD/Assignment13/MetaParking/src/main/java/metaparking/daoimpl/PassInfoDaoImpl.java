/*
 * package metaparking.daoimpl;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.hibernate.Session; import org.hibernate.query.Query; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Repository;
 * 
 * import metaparking.dao.PassInfoDao; import metaparking.models.PassInfo;
 * 
 *//**
	 * Class to get Pass Pricing related data
	 *
	 */
/*
 * @Repository public class PassInfoDaoImpl implements PassInfoDao {
 * 
 * @Autowired private EntityManager entityManager;
 * 
 *//**
	 * Get PassInfo from passType and vehicleType
	 * 
	 * @param passType
	 * @param vehicleType
	 * @return PassInfo
	 *//*
		 * @Override public PassInfo getPassInfo(String passType, String vehicleType) {
		 * Session session = entityManager.unwrap(Session.class); Query<PassInfo> query
		 * = session.
		 * createQuery("from PassInfo where vehicleType = :vehicleType and passType = :passType"
		 * , PassInfo.class); query.setParameter("vehicleType", vehicleType);
		 * query.setParameter("passType", passType); PassInfo passInfo =
		 * query.getSingleResult(); return passInfo; } }
		 */