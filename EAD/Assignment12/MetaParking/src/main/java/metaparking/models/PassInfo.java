package metaparking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class to implement PassInfo 
 *
 */
@Entity
@Table(name="PassInfo")
public class PassInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passId;
	
	private String passType;
	
	private String vehicleType;
	
	private double passPrice;

	/**
	 * Function to get passId
	 * @return passId
	 */
	@Column(name="passId")
	public int getPassId() {
		return passId;
	}

	/**
	 * Function to set passId
	 * @param passId
	 */
	public void setPassId(int passId) {
		this.passId = passId;
	}

	/**
	 * Function to get passType
	 * @return passType
	 */
	@Column(name="passType")
	public String getPassType() {
		return passType;
	}

	/**
	 * Function to set passType
	 * @param passType
	 */
	public void setPassType(String passType) {
		this.passType = passType;
	}

	/**
	 * Function to get vehicleType
	 * @return vehicleType
	 */
	@Column(name="vehicleType")
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * Function to set vehicleType
	 * @param vehicleType
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * Function to get passPrice
	 * @return passPrice
	 */
	@Column(name="passPrice")
	public double getPassPrice() {
		return passPrice;
	}

	/**
	 * Function to set passPrice
	 * @param passPrice
	 */
	public void setPassPrice(double passPrice) {
		this.passPrice = passPrice;
	}

	/**
	 * Function to return passInfo in String form
	 */
	@Override
	public String toString() {
		return "PassInfo [passId=" + passId + ", passType=" + passType + ", vehicleType=" + vehicleType + ", passPrice="
				+ passPrice + "]";
	}
}
