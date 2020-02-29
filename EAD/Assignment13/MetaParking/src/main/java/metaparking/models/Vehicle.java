package metaparking.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class to represent a vehicle
 *
 */
@Entity
@Table(name="Vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid vehicle name")
	private String vehicleName;
	
	private String type;

	@Pattern(regexp = "^[a-zA-Z]{2}.{4}[0-9]{4}", message = "Please enter valid vehicle number")
	private String vehicleNumber;

	@NotBlank(message = "Please enter vehicle identification")
	private String identification;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passId")
	private PassInfo pass;

	/**
	 * Getter function to get vehicleId
	 * @return vehicleId
	 */
	@Column(name="vehicleId")
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * Setter function to set vehicleId
	 * @param vehicleId
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * Getter function to get vehicleName
	 * @return
	 */
	@Column(name="vehicleName")
	public String getVehicleName() {
		return vehicleName;
	}

	/**
	 * Setter function to set vehicleName
	 * @param vehicleName
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	/**
	 * Getter function to get type
	 * @return type
	 */
	@Column(name="type")
	public String getType() {
		return type;
	}

	/**
	 * Setter function to set type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter function to get vehicleNumber
	 * @return vehicleNumber
	 */
	@Column(name="vehicleNumber")
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * Setter function to set vehicleNumber
	 * @param vehicleNumber
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * Getter function to get identification
	 * @return identification
	 */
	@Column(name="identification")
	public String getIdentification() {
		return identification;
	}

	/**
	 * Setter function to set identification
	 * @param identification
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	/**
	 * Getter function to get user
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Setter function to set user
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Getter function to get pass
	 * @return passId
	 */
	public PassInfo getPass() {
		return pass;
	}

	/**
	 * Setter function to set pass
	 * @param pass
	 */
	public void setPass(PassInfo pass) {
		this.pass = pass;
	}

	/**
	 * Function to return Vehicle in string form
	 */
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", type=" + type
				+ ", vehicleNumber=" + vehicleNumber + ", identification=" + identification + ", user=" + user
				+ ", pass=" + pass + "]";
	}
}