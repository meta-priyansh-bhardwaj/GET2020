package polynomial;

/**
 *	Class to visualise a multivariate polynomial 
 *
 */
public class MultivariatePolynomial {
	private Term head;
	
	/**
	 * Constructor to construct visualisation of multivariate polynomials
	 * @param coefficients array of doubles
	 * @param variables array of variable notation characters
	 * @param powers array of non-negative powers
	 */
	public MultivariatePolynomial(double[] coefficients, char[][] variables, int[][] powers){
		if(coefficients == null || variables == null || powers == null){
			System.out.println("Null input provided");
			return;
		}
		if(coefficients.length != variables.length || variables.length != powers.length){
			System.out.println("Input count mismatch");
			return;
		}
		int length = coefficients.length;
		Term currentTerm = null;
		for(int i=0;i<length;i++){
			if(coefficients[i] == 0.0){
				continue;
			}
			if(this.head == null){
				this.head = new Term(coefficients[i]);
				currentTerm = head;
			} else {
				currentTerm.setNext(new Term(coefficients[i]));
				currentTerm = currentTerm.getNext();
			}
			if(variables[i] == null || powers[i] == null){
				System.out.println("Null input provided");
				head = null;
				return;
			}
			if(variables[i].length != powers[i].length){
				System.out.println("Input length mismatch");
				head = null;
				return;
			}
			for(int j=0;j<variables[i].length;j++){
				if(powers[i][j] < 0){
					System.out.println("Invalid negative power found!");
					head = null;
					return;
				}
				currentTerm.addVariable(powers[i][j], variables[i][j]);
			}
		}
	}
	
	/**
	 * Function to find degree of polynomial
	 * @return degree
	 */
	public int findDegree(){
		int degree = 0;
		Term currentTerm = head;
		while(currentTerm != null){
			// System.out.print(currentTerm.getCoefficient());
			degree = Math.max(degree, currentTerm.getSumOfPowers());
			currentTerm = currentTerm.getNext();
		}
		return degree;
	}
}