package cricket;

/**
 * Class to record bowler's details
 *
 */
public class Bowler {
	private String name;
	private int deliveriesRemained;
	
	/**
	 * Constructor to initialize details
	 * @param name of bowler
	 * @param deliveriesRemained to bowl should be a positive integer 
	 */
	public Bowler(String name, int deliveriesRemained){
		this.name = name;
		this.deliveriesRemained = deliveriesRemained;
	}
	
	/**
	 * Function to get name of the bowler
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Function to get deliveries remained to bowl
	 * @return
	 */
	public int getDeliveriesRemained() {
		return this.deliveriesRemained;
	}
	
	/**
	 * Function that reduces number of balls bowled from deliveries remaining
	 * @param noOfDeliveries bowled
	 */
	public void bowlDeliveries(int noOfDeliveries){
		this.deliveriesRemained -= noOfDeliveries;
	}
}
