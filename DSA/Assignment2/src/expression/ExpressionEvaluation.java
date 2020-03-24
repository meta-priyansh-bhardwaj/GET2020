package expression;

import java.util.HashMap;
import java.util.Map;

import stack.Stack;
import stack.StackImplementation;

/**
 * Class to implement Expression Evaluation method
 *
 */
public class ExpressionEvaluation {
	private static Map<String, Integer> PRECEDENCE = new HashMap<String, Integer>();

	/**
	 * Storing precedence values of all operators
	 */
	static {
		PRECEDENCE.put("!", 1);

		PRECEDENCE.put("*", 2);
		PRECEDENCE.put("/", 2);

		PRECEDENCE.put("+", 3);
		PRECEDENCE.put("-", 3);

		PRECEDENCE.put("<", 4);
		PRECEDENCE.put("<=", 4);
		PRECEDENCE.put(">", 4);
		PRECEDENCE.put(">=", 4);

		PRECEDENCE.put("==", 5);
		PRECEDENCE.put("!=", 5);

		PRECEDENCE.put("&&", 6);
		PRECEDENCE.put("||", 6);
	}

	/**
	 * Checks whether given string is an operator
	 * @param operator
	 * @return true if it is an operator or false otherwise
	 */
	private static boolean isOperator(String operator) {
		return PRECEDENCE.containsKey(operator);
	}

	/**
	 * Function to evaluate unary expression
	 * @param operandString operand in string form
	 * @param operator in string form
	 * @return result
	 * @throws Exception if operand is not valid
	 */
	private static int evaluateUnaryExpression(String operandString,
			String operator) throws Exception {
		if (!"!".equals(operator)) {
			throw new Exception("Invalid Operator!");
		}
		return !(Integer.parseInt(operandString) != 0) ? 1 : 0;
	}

	/**
	 * Function to evaluate binary expression
	 * @param operandString1 operand in string form
	 * @param operandString2 operand in string form
	 * @param operator operator in string form
	 * @return result
	 * @throws Exception if operand is invalid
	 */
	private static int evaluateBinaryExpression(String operandString1,
			String operandString2, String operator) throws Exception {
		int operand1 = Integer.parseInt(operandString1);
		int operand2 = Integer.parseInt(operandString2);
		int answer = 0;

		switch (operator) {
		case "*":
			answer = operand1 * operand2;
			break;
		case "/":
			answer = operand1 / operand2;
			break;
		case "+":
			answer = operand1 + operand2;
			break;
		case "-":
			answer = operand1 - operand2;
			break;
		case "<":
			answer = (operand1 < operand2 ? 1 : 0);
			break;
		case "<=":
			answer = (operand1 <= operand2 ? 1 : 0);
			break;
		case ">":
			answer = (operand1 > operand2 ? 1 : 0);
			break;
		case ">=":
			answer = (operand1 >= operand2 ? 1 : 0);
			break;
		case "==":
			answer = (operand1 == operand2 ? 1 : 0);
			break;
		case "!=":
			answer = (operand1 != operand2 ? 1 : 0);
			break;
		case "&&":
			answer = ((operand1 != 0) && (operand2 != 0) ? 1 : 0);
			break;
		case "||":
			answer = ((operand1 != 0) || (operand2 != 0) ? 1 : 0);
			break;
		default:
			throw new Exception("Invalid Operator!");
		}
		return answer;
	}

	/**
	 * Function to evaluate operator on top of stack
	 * @param values stack of values
	 * @param operators stack of operators
	 * @throws Exception if any stack found empty
	 */
	private static void evaluateTopOperator(Stack values, Stack operators)
			throws Exception {
		if (values == null || operators == null) {
			throw new Exception("Null Stack passed!");
		}
		String operator = operators.pop();
		if ("!".equals(operator)) {
			String operand = values.pop();
			int answer = evaluateUnaryExpression(operand, operator);
			values.push(Integer.toString(answer));
		} else {
			String operand1 = values.pop();
			String operand2 = values.pop();
			int answer = evaluateBinaryExpression(operand2, operand1, operator);
			values.push(Integer.toString(answer));
		}
	}

	/**
	 * Function to evaluate infix expression using stack
	 * 
	 * @param expression
	 *            is a non null string of valid infix expression in which tokens
	 *            are separated by a space
	 * @return final answer
	 */
	public static int evaluateExpression(String expression) throws Exception {
		if (expression == null) {
			throw new Exception("Null expression provided!");
		}
		String[] tokens = expression.split(" ");
		Stack values = new StackImplementation();
		Stack operators = new StackImplementation();

		for (String token : tokens) {
			if ("(".equals(token)) {
				operators.push(token);
			} else if (")".equals(token)) {
				while (!"(".equals(operators.top())) {
					evaluateTopOperator(values, operators);
				}
				operators.pop();
			} else if (isOperator(token)) {
				while (!operators.isEmpty()
						&& !"(".equals(operators.top())
						&& PRECEDENCE.get(operators.top()) <= PRECEDENCE
								.get(token)) {
					evaluateTopOperator(values, operators);
				}
				operators.push(token);
			} else {
				values.push(token);
			}
		}

		while (!operators.isEmpty()) {
			evaluateTopOperator(values, operators);
		}
		// System.out.println(values.top());
		return Integer.parseInt(values.pop());
	}
}
