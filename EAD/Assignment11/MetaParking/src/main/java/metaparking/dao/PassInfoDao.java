package metaparking.dao;

import metaparking.models.PassInfo;

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
	PassInfo getPassInfo(String passType, String vehicleType);
}