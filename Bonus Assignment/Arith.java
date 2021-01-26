import java.util.Stack;

// -------------------------------------------------------------------------
/**
 * Utility class containing validation/evaluation/conversion operations for
 * infix arithmetic expressions.
 *
 * @author Yifan Zhu
 * @version 1/12/15 13:03:48
 */

public class Arith {

	// ~ Validation methods
	// ..........................................................

	/**
	 * Validation method for infix notation.
	 *
	 * @param infixLiterals : an array containing the string literals hopefully in
	 *                      infix order. The method assumes that each of these
	 *                      literals can be one of: - "+", "-", "*", or "/" - or a
	 *                      valid string representation of an integer "0", "1" ,
	 *                      "2", ..., "-1", "-2", ...
	 *
	 * @return true if the parameter is indeed in infix notation, and false
	 *         otherwise.
	 **/
	public static boolean validateInfixOrder(String infixLiterals[]) {
		int counter = 1;
		for (int i = 0; i < infixLiterals.length; i++) {
			String str = infixLiterals[i];
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				counter++;
			} else {
				counter--;
			}
			if (counter != 0 && counter != 1) {
				return false;
			}
		}
		return counter == 0;
	}

	// ~ Evaluation methods
	// ..........................................................

	/**
	 * Evaluation method for infix notation.
	 *
	 * @param infixLiterals : an array containing the string literals in infix
	 *                      order. The method assumes that each of these literals
	 *                      can be one of: - "+", "-", "*", or "/" - or a valid
	 *                      string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 **/
	public static int evaluateInfixOrder(String infixLiterals[]) {
		String[] postFixLiterals = convertInfixToPostfix(infixLiterals);
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < postFixLiterals.length; i++) {
			String str = postFixLiterals[i];
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				int operand1 = Integer.parseInt(stack.pop());
				int operand0 = Integer.parseInt(stack.pop());
				if (str.equals("+")) {
					int result = operand0 + operand1;
					stack.push("" + result);
				} else if (str.equals("-")) {
					int result = operand0 - operand1;
					stack.push("" + result);
				} else if (str.equals("*")) {
					int result = operand0 * operand1;
					stack.push("" + result);
				} else {
					int result = operand0 / operand1;
					stack.push("" + result);
				}
			} else {
				stack.push(str);
			}
		}
		return Integer.parseInt(stack.pop());
	}

	// ~ Conversion methods
	// ..........................................................

	/**
	 * Converts infix to postfix.
	 *
	 * @param infixLiterals : an array containing the string literals in infix
	 *                      order. The method assumes that each of these literals
	 *                      can be one of: - "+", "-", "*", or "/" - or a valid
	 *                      string representation of an integer.
	 *
	 * @return the expression in postfix order.
	 **/
	public static String[] convertInfixToPostfix(String infixLiterals[]) {
		String[] postFix = new String[infixLiterals.length];
		int index = 0;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < infixLiterals.length; i++) {
			String str = infixLiterals[i];
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				if (stack.isEmpty()) {
					stack.push(str);
				} else {
					while (!stack.isEmpty() && (stack.get(stack.size() - 1).equals("*")
							|| stack.get(stack.size() - 1).equals("/")
							|| (stack.get(stack.size() - 1).equals("+") && (str.equals("+") || str.equals("-")))
							|| (stack.get(stack.size() - 1).equals("-") && (str.equals("+") || str.equals("-"))))) {
						postFix[index++] = stack.pop();
					}
					stack.push(str);
				}
			} else {
				postFix[index++] = str;
			}
		}
		while (!stack.isEmpty()) {
			postFix[index++] = stack.pop();
		}
		return postFix;
	}

	/**
	 * Converts postfix to infix.
	 *
	 * @param postfixLiterals : an array containing the string literals in postfix
	 *                        order. The method assumes that each of these literals
	 *                        can be one of: - "+", "-", "*", or "/" - or a valid
	 *                        string representation of an integer.
	 *
	 * @return the expression in infix order.
	 **/
	public static String[] convertPostfixToInfix(String postfixLiterals[]) {
		String[] infix = new String[postfixLiterals.length];
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < postfixLiterals.length; i++) {
			String str = postfixLiterals[i];
			if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				String operand1 = stack.pop();
				String operand0 = stack.pop();
				stack.push(operand0 + str + " " + operand1);
			} else {
				stack.push(str + " ");
			}
		}
		StringBuilder sb = new StringBuilder(stack.pop());
		int index = 0;
		for (int left = 0, right = 0; left < sb.length();) {
			while (sb.charAt(right) != ' ') {
				right++;
			}
			infix[index++] = sb.substring(left, right);
			left = right + 1;
			right++;
		}
		return infix;
	}

}
