package polynomial;

/**
 * Function to implement a polynomial term 
 *
 */
public class Term {
	private double coefficient;
	private Variable variables;
	private Term next;
	
	/**
	 * Constructor that sets coefficient
	 * @param coefficient
	 */
	public Term(double coefficient){
		this.coefficient = coefficient;
	}
	
	/**
	 * Function to get coefficient
	 * @return coefficient
	 */
	public double getCoefficient(){
		return this.coefficient;
	}
	
	/**
	 * Fuction to get linked list of variables
	 * @return variables
	 */
	public Variable getVariables(){
		return this.variables;
	}
	
	/**
	 * Function to get next term
	 * @return next
	 */
	public Term getNext(){
		return this.next;
	}
	
	/**
	 * Function to set next polynomial term
	 * @param next
	 */
	public void setNext(Term next){
		this.next = next;
	}
	
	/**
	 * Function to add variable to the term
	 * @param power
	 * @param notation
	 */
	public void addVariable(int power, char notation){
		if(this.variables == null){
			this.variables = new Variable(power, notation);
		}
		Variable currentVariable = new Variable(power, notation);
		currentVariable.setNext(this.variables);
		this.variables = currentVariable;
	}
	
	/**
	 * Function to get sum of powers of the term
	 * @return sumOfPowers
	 */
	public int getSumOfPowers(){
		int sumOfPowers = 0;
		Variable currentVariable = this.variables;
		while(currentVariable != null){
			// System.out.print(currentVariable.getNotation() + "^" + currentVariable.getPower());
			sumOfPowers += currentVariable.getPower();
			currentVariable = currentVariable.getNext();
		}
		// System.out.println();
		return sumOfPowers;
	}
}