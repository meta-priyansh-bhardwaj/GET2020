package metaparking.models;

/**
 * Class to implement a pass
 *
 */
public class Pass {
	private int passId;
	private int vehicleId;
	private String passType;
	private double passPrice;

	/**
	 * Getter function to get PassId
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
	 * Getter function to get passType
	 * @return passType
	 */
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
		return "Pass [passId=" + passId + ", vehicleId=" + vehicleId + ", passType=" + passType + ", passPrice="
				+ passPrice + "]";
	}

}