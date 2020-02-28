package metaparking.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class to implement a pass
 *
 */
@Entity
@Table(name="pass")
public class Pass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;
	
	private String passType;
	
	private double passPrice;

	/**
	 * Getter function to get passId
	 * @return passId
	 */
	@Column(name="empId")
	public int getPassId() {
		return passId;
	}

	/**
	 * Setter function to set passId
	 * @param passId
	 */
	public void setPassId(int passId) {
		this.passId = passId;
	}

	/**
	 * Getter function to get vehicle
	 * @return vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Setter function to set vehicle
	 * @param vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Getter function to get passType
	 * @return passType
	 */
	@Column(name="passType")
	public String getPassType() {
		return passType;
	}

	/**
	 * Setter function to set passType
	 * @param passType
	 */
	public void setPassType(String passType) {
		this.passType = passType;
	}
	
	/**
	 * Getter function to get passPrice
	 * @return passPrice
	 */
	@Column(name="passPrice")
	public double getPassPrice() {
		return passPrice;
	}

	/**
	 * Setter function to set passPrice
	 * @param passPrice
	 */
	public void setPassPrice(double passPrice) {
		this.passPrice = passPrice;
	}

	/**
	 * Function to return pass in string form
	 */
	@Override
	public String toString() {
		return "Pass [passId=" + passId + ", vehicle=" + vehicle + ", passType=" + passType + ", passPrice="
				+ passPrice + "]";
	}

}