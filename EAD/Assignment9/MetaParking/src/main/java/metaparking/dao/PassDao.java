package metaparking.dao;

import metaparking.models.Pass;

/**
 * Interface to get Pass related data
 *
 */
public interface PassDao {
	String insertPass = "INSERT INTO Pass (passId, passType, passPrice, vehicleId) values (?, ?, ?, ?);";
	String selectPass = "SELECT * FROM Pass where passId = ?";
	String updatePass = "UPDATE Pass set passType = ?, passPrice = ?" + " where passId = ?";
	String lastRecord = "SELECT MAX(passId) as id FROM Pass";

	/**
	 * Get pass from passId
	 * @param passId
	 * @return pass
	 */
	Pass getPass(int passId);

	/**
	 * Function to update pass
	 * @param pass
	 * @return true if update or false otherwise
	 */
	boolean updatePass(Pass pass);

	/**
	 * Function to add new pass
	 * @param pass
	 * @return id of the pass
	 */
	int addPass(Pass pass);
}