package metaparking.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Vehicle {
	private int vehicleId;

	@Pattern(regexp = "^[a-zA-Z0-9]{2,}$", message = "Please enter valid vehicle name")
	private String vehicleName;
	private String type;

	@Pattern(regexp = "^[a-zA-Z]{2}.{4}[0-9]{4}", message = "Please enter valid vehicle number")
	private String vehicleNumber;

	@NotBlank(message = "Please enter vehicle identification")
	private String identification;
	private int empId;
	private int passId;

	/**
	 * Getter function to get vehicleId
	 * @return vehicleId
	 */
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
	 * Getter function to get empId
	 * @return empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * Setter function to set empId
	 * @param empId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * Getter function to get passId
	 * @return passId
	 */
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
	 * Function to return Vehicle in string form
	 */
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", type=" + type
				+ ", vehicleNumber=" + vehicleNumber + ", identification=" + identification + ", empId=" + empId + "]";
	}
}