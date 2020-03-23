package polynomial;

/**
 * Class to implement a variable term 
 *
 */
public class Variable {
	private int power;
	private char notation;
	private Variable next;
	
	/**
	 * Constructor to construct a variable of a multivariate term
	 * @param power should be a not-negative integer
	 * @param notation a character
	 */
	public Variable(int power, char notation){
		this.power = power;
		this.notation = notation;
	}
	
	/**
	 * Function to get power
	 * @return power
	 */
	public int getPower(){
		return this.power;
	}
	
	/**
	 * Function to get notation
	 * @return notation
	 */
	public char getNotation(){
		return this.notation;
	}
	
	/**
	 * Function to get next variable term
	 * @return next
	 */
	public Variable getNext(){
		return this.next;
	}
	
	/**
	 * Function to set next variable term
	 * @param next
	 */
	public void setNext(Variable next){
		this.next = next;
	}
}