package metaparking.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import metaparking.dao.PassInfoDao;

/**
 * Class to get Pass Pricing related data
 *
 */
@Repository
public class PassInfoDaoImpl implements PassInfoDao {

	private JdbcTemplate jdbcTemplate;
	
	public PassInfoDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Get PassInfo from passType and vehicleType
	 * @param passType
	 * @param vehicleType
	 * @return PassInfo
	 */
	@Override
	public int getPassId(String passType, String vehicleType) {
		int passId = jdbcTemplate.queryForObject(selectPassId, new Object[] {passType, vehicleType}, Integer.class);
		return passId;
	}

	/**
	 * Get pass type from passId
	 * @param passId
	 * @return passType
	 */
	public String getPassType(int passId) {
		String passType = jdbcTemplate.queryForObject(selectPassType, new Object[] {passId}, String.class);
		return passType;
	}

	/**
	 * Get price from pass id
	 * @param passId
	 * @return price
	 */
	public double getPassPrice(int passId) {
		double passPrice = jdbcTemplate.queryForObject(selectPassPrice, new Object[] {passId}, Double.class);
		return passPrice;
	}
}