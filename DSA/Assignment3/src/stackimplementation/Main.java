package stackimplementation;

public class Main {

	public static void main(String[] args) {

		SolveExpression expression = new SolveExpression();
		try{
			System.out.println(expression.evaluateExpression("13 && ! 0"));	
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}
