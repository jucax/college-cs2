package client;

import stack.*;
import java.util.*;

public class UseStack {

	public static void main(String[] args) {
		// Put code here to test out the methods
	}

	/**
	 * Print elements of a stack to the console one line at
	 * a time from top to bottom. The stack will be emptied
	 * as a result of this operation.
	 *
	 * @param stack Stack to print
	 */
	public static <T> void printStack(StackInterface<T> stack) {
		while (!stack.isEmpty()) System.out.println(stack.pop());
	}

	/**
	 * Print elements of a stack to the console one line at
	 * a time from bottom to top by using an additional helper
	 * stack. The stack will be emptied as a result of this operation.
	 *
	 * @param stack Stack to print
	 */
	public static <T> void printStackReverse(StackInterface<T> stack) {
		StackInterface<T> tempStack = new MysteryStack<>();
		while (!stack.isEmpty()) tempStack.push(stack.pop());
		printStack(tempStack);
	}

	/**
	 * Returns a brand new stack containing nothing but a certain number
	 * of copies of a particular element.
	 *
	 * @param <T> type of element in result stack
	 * @param count Number of elements to add to the new stack
	 * @param element The specific element to add to the new stack
	 * @return A new stack containing only count number of copies of element
	 */
	public static <T> StackInterface<T> stackWithXOfY(int count, T element) {
		StackInterface<T> newStack = new MysteryStack<>();
		while (count > 0) {
			newStack.push(element);
			count--;
		}
		return newStack;
	}

	/**
	 * Given a string that contains delimiter characters such as
	 * '(', ')', '{', '}', '[', and ']', indicate whether or not the
	 * delimiters are properly balanced. That is, every opening
	 * delimiter has a corresponding closing delimiter that is nested
	 * at the same depth. Other characters may also be in the string.
	 *
	 * @param input String containing delimiters
	 * @return true if the delimiters are balanced, false otherwise
	 */
	public static boolean balancedDelimiters(String input) {
		StackInterface<Character> stack = new MysteryStack<>();
		boolean isBalanced = true;

		for (int i = 0 ; isBalanced && i < input.length() ; i++) {
			char nextCharacter = input.charAt(i);
			switch (nextCharacter) {
				case '(': case '[' : case '{' :
					stack.push(nextCharacter);
				break;
				case ')': case ']' : case '}' :
					if (stack.isEmpty()) isBalanced = false;
					else {
						char openDelimiter = stack.pop();
						isBalanced = delimiterMatch(openDelimiter, nextCharacter);
					}
				break;
			}
		}

		if (!stack.isEmpty()) isBalanced = false;

		return isBalanced;
	} 

	private static boolean delimiterMatch (char openDelimiter, char closeDelimiter) {
		return (openDelimiter == '(' && closeDelimiter == ')') ||
			   (openDelimiter == '[' && closeDelimiter == ']') ||
			   (openDelimiter == '{' && closeDelimiter == '}');
	}

	/**
	 * Given a string that contains a valid postfix expression using
	 * only arity-2 operators +, -, /, and *, compute the result of
	 * the expression as a double.
	 * 
	 * @param postfixExpression valid postfix expression
	 * @return result of evaluating the postfix expression
	 */
	public static double evaluatePostfix(String postfixExpression) {
		StackInterface<Double> valueStack = new MysteryStack<>();
		Scanner scanner = new Scanner(postfixExpression);

		while (scanner.hasNext()) {
			String nextToken = scanner.next();
			switch(nextToken) {
				case "+" : case "-" : case "*" : case "/" :
					double operandRight = valueStack.pop();
					double operandLeft = valueStack.pop();
					double result = mathOperation(operandLeft, nextToken, operandRight);
					valueStack.push(result);
				break;
				default :
					double value = Double.parseDouble(nextToken);
					valueStack.push(value);
			}
		}
		double result = valueStack.pop();

		return result;
	}

	private static double mathOperation (double left, String op, double right) {
		switch (op) {
			case "+" : return left + right;
			case "-" : return left - right;
			case "*" : return left * right;
			case "/" : return left / right;
		}
		throw new IllegalArgumentException(op + "is an invalid operator");
	}

}
