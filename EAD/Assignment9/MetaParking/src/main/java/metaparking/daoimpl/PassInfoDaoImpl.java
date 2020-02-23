package metaparking.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import metaparking.dao.PassInfoDao;
import metaparking.models.Pass;
import metaparking.utils.ConnectionUtility;

/**
 * Class to get Pass Pricing related data
 *
 */
@Repository
public class PassInfoDaoImpl implements PassInfoDao {

	/**
	 * Get PassInfo from passType and vehicleType
	 * @param passType
	 * @param vehicleType
	 * @return PassInfo
	 */
	@Override
	public int getPassId(String passType, String vehicleType) {
		int passId = -1;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectPassId);
			st.setString(1, passType);
			st.setString(2, vehicleType);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				passId = rs.getInt("passId");
			}
		} catch (SQLException e) {
			System.out.println("Pass could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return passId;
	}

	/**
	 * Get pass type from passId
	 * @param passId
	 * @return passType
	 */
	public String getPassType(int passId) {
		String passType = "";
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectPassType);
			st.setInt(1, passId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				passType = rs.getString("passType");
			}
		} catch (SQLException e) {
			System.out.println("Pass type could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return passType;
	}

	/**
	 * Get price from pass id
	 * @param passId
	 * @return price
	 */
	public double getPassPrice(int passId) {
		double passPrice = 0.0;
		ConnectionUtility connectionUtility = new ConnectionUtility();
		Connection connection = connectionUtility.createConnection();
		try {
			PreparedStatement st = connection.prepareStatement(selectPassPrice);
			st.setInt(1, passId);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				passPrice = rs.getDouble("passPrice");
			}
		} catch (SQLException e) {
			System.out.println("Pass price could not be fetched...");
			e.printStackTrace();
		} finally {
			connectionUtility.closeConnection(connection);
		}
		return passPrice;
	}
}