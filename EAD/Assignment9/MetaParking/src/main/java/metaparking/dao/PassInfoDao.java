package metaparking.dao;

/**
 * Interface to get Pass Pricing related data
 *
 */
public interface PassInfoDao {
	String selectPassId = "SELECT PassId from PassInfo" + " where passType = ? and vehicleType = ?;";
	String selectPassType = "SELECT PassType from PassInfo where passId = ?;";
	String selectPassPrice = "SELECT PassPrice from PassInfo  where passId = ?;";

	/**
	 * Get PassInfo from passType and vehicleType
	 * @param passType
	 * @param vehicleType
	 * @return PassInfo
	 */
	int getPassId(String passType, String vehicleType);

	/**
	 * Get pass type from passId
	 * @param passId
	 * @return passType
	 */
	String getPassType(int passId);

	/**
	 * Get price from pass id
	 * @param passId
	 * @return price
	 */
	double getPassPrice(int passId);
}