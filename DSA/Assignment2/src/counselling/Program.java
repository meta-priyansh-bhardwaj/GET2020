package counselling;

/**
 * Class to visualise a Program available in counselling
 *
 */
public class Program {
	private String name;
	private final int availableSeats;
	private int seatsOccupied;

	/**
	 * Constructor to initialize name and availableSeats
	 * @param name of Program
	 * @param availableSeats
	 */
	public Program(String name, int availableSeats){
		this.name = name;
		this.availableSeats = availableSeats;
		this.seatsOccupied = 0;
	}
	
	/**
	 * Function to get name of program
	 * @return name of program
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Function to get number of available seats
	 * @return availableSeats
	 */
	public int getAvailableSeats(){
		return availableSeats;
	}
	
	/**
	 * Function to check if seat is available
	 * @return true if seat is available or false otherwise
	 */
	public boolean isSeatAvailable(){
		return this.seatsOccupied < this.availableSeats;
	}
	
	/**
	 * Function to occupy a seat
	 * @return true if seat is occupied or false otherwise
	 */
	public boolean occupySeat() {
		if(this.isSeatAvailable()){
			this.seatsOccupied++;
			return true;
		}
		return false;
	}
}
