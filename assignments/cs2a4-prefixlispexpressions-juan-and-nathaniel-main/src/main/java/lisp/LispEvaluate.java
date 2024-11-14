
package lisp;

import java.util.Scanner;
import stack.*;

/**
 * The lispCalculate method takes a valid arithmetic 
 * Lisp expression and evaluates it to calculate the numeric
 * output. This code must be provided by you, and will          
 * make use of stacks.                          
 * 
 * @author Jacob Schrum
 */
public class LispEvaluate {

	/**
	 * Sets up a loop that treats entered user inputs from the console as Lisp
	 * expressions, then computes and prints their values. Behavior for badly
	 * formatted Lisp expressions is not defined, but will likely cause the code
	 * to crash or otherwise misbehave.
	 *
	 * @param args Ignored
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		String input = "";
		while(true) {
			System.out.print("Enter a Lisp expression or use \"q\" or \"quit\" to exit the program: ");
			input = console.nextLine();
			if(input.equals("q") || input.equals("quit")) break; // Exit the loop
			System.out.println("Evaluates to: " + lispCalculate(input));
		}
		System.out.println("Goodbye");
		console.close();
	}

	/**
	 * 35 points for the functioning of this method and the helper methods it uses
	 * 30 points for the comments and style of this method and the helper methods it uses
	 * 
	 * Given a String containing a valid Lisp expression using only
	 * the operators +, -, /, and *, evaluate the expression and
	 * return the result.
	 * 
	 * NOTE: You are NOT allowed to use arrays or ArrayLists. Your algorithm(s)
	 * should be based on stacks.
	 * 
	 * @param lispExpression Valid arithmetic Lisp expression.
	 * @return Numeric result of evaluating the Lisp expression.
	 */
	public static double lispCalculate(String lispExpression) {
		String spacedOut = addSpaces(lispExpression); // Adds extra white space around parentheses
		String postfixSpaced = prefixToPostfix(spacedOut); // Converts spaced prefix Lisp expression to spaced postfix Lisp expression
		return calculateSpacedPostfix(postfixSpaced); // Calculates the numeric result from processing the spaced postfix Lisp expression
	}

	///// You MUST provide complete and correctly formatted Javadoc comments to all methods below this point /////

	/**
	 * Adds extra spaces around parentheses to a valid Lisp 
	 * expression, it return the String modified.
	 * 
	 * @param lispExpression Valid Lisp expression to modify.
	 * @return String result with spaces added around operators, 
	 * operands and parentheses.
	 */
	private static String addSpaces(String lispExpression) {
		String result = "";

		for(int i = 0; i < lispExpression.length(); i++) {
			char c = lispExpression.charAt(i);
			switch(c) {
				case '(': case ')':
					result += " "+c+" "; //Add spaces around parentheses
					break;
				default:
					result += c; //Operators and operands stay the same
			}
		}

		return result;
	}

	/**
	 * Converts a valid Lisp expression with spaces around operators, 
	 * operands and parentheses from prefix notation to postfix notation.
	 * 
	 * @param spacedOut A valid Lisp expression with spaces added around 
	 * operators, operands and parentheses.
	 * @return String result of the converted Lisp expression in postfix 
	 * notation.
	 */
	private static String prefixToPostfix(String spacedOut) {
		LinkedStack<String> operators = new LinkedStack<>();
		Scanner scan = new Scanner(spacedOut);
		String result = "";

		while(scan.hasNext()) {
			String token = scan.next();
			switch(token) {
				case "+": case "-": case "/": case "*":
					operators.push(token); //We push operators to the stack
					break;
				case ")":
					//When we see closing parentheses, we add the operators in the stack before
					result += " " + operators.pop() + " " + ")" + " "; 
					break;
				default:
					result += " " + token + " "; //For operands just add spaces
					break;
			}
		}
		// For troubleshooting:
		//System.out.println(result);
		scan.close();
		return result;
	}

	/**
	 * Given a valid postfix expression, implement stacks to calculate
	 * the final result of the expression.
	 * 
	 * @param postfixSpaced A valid postfix expression with spaces around 
	 * operators, operands and parentheses.
	 * @return Double result of the calculation of the postfix expression.
	 * @throws ArithmeticException Throw an exception if there is a division by zero.
	 */
	private static double calculateSpacedPostfix(String postfixSpaced) {
		LinkedStack<Double> nums = new LinkedStack<>();
		LinkedStack<Double> temp = new LinkedStack<>(); //Support stack
		Scanner scan = new Scanner(postfixSpaced);
		while(scan.hasNext()) {
			String token = scan.next(); //Get the token
			double total = 0; //Support variable
			switch(token) {
				case "(":
					nums.push(Double.NaN); //Represent opening parenthesis with NaN in the stack
					break;

				case "+":
					if (nums.peek().isNaN()) total = 0.0; //If there is just symbol, return 0
					else total = nums.pop(); //Else, take the first operand
					//Do the operation with the rest of the operands
					while (!nums.isEmpty() && !(nums.peek().isNaN())) total += nums.pop();
					nums.pop(); //Eliminate the opening parenthesis
					nums.push(total); //Push result
					total = 0.0; // Restart support variable
					break;

				case "*":
					if (nums.peek().isNaN()) total = 1.0; //If there is just symbol, return 1
					else total = nums.pop();
					//Do the operation with the rest of the operands
					while (!nums.isEmpty() && !(nums.peek().isNaN())) total *= nums.pop();
					nums.pop(); 
					nums.push(total); 
					total = 0.0; 
					break;

				case "-":
					//Add the rest of the operands to the support stack and do the operation
					while (!(nums.peek().isNaN())) temp.push(nums.pop());
                    total = temp.pop(); //Take the first operand
                    if (temp.isEmpty()) total = (-1 * total); //If there is just one operand, return the negative of the operand
                    while (!temp.isEmpty()) total -= temp.pop(); //Do the operation with the rest of the operands
                    nums.pop(); 
                    nums.push(total); 
                    total = 0.0; 
                    break;

				case "/":
					while (!(nums.peek().isNaN())) temp.push(nums.pop());
					total = temp.pop(); //Take the first operand
					//If there is division by zero, throw exception
					if (temp.isEmpty() && total == 0) throw new ArithmeticException("Division by zero");
					if (temp.isEmpty()) total = (1 / total); //If there is just one operand, return one over the operand
					while (!temp.isEmpty()) total /= temp.pop(); 
					nums.pop(); 
					nums.push(total); 
					total = 0.0; 
					break;

				case ")":
					continue; //For closing parenthesis just go the next iteration
					
				default:
					double value = Double.parseDouble(token); 
					nums.push(value); //For operands push to stack
			}
		}
		
		return nums.pop(); //Return the last value that is the result
	}
}