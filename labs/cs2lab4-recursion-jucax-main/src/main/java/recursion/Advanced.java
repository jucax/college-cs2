package recursion;

import java.util.*;

/**
 * Used in Day 2 of our coverage of recursion. The examples here demonstrate situations
 * where recursion is more appropriate, but also bring up some examples where doing
 * recursion in the wrong way can be very inefficient.
 */
public class Advanced {

	/**
	 * As always, any code can be placed here, but the starter code here
	 * runs the maze problem and displays a solution, though it won't 
	 * work until you implement the solution code. Basically, running
	 * it before you solve the problem just displays a maze with
	 * the starting point marked, but not the solution path.
	 */
	public static void main(String[] args) {
		PathStep solution = solveMaze(maze1,1,1,10,7);
		while(solution != null) {
			System.out.println(solution.getRow() + "," + solution.getColumn());
			solution = solution.getNextStep();
		}
		showMaze(maze1);
	}

	/**
	 * For the exercises below, define the Fibonacci 
	 * numbers as follows: 
	 * 
	 * F(0) = 0 (base case)
	 * F(1) = 1 (base case)
	 * F(2) = 0+1 = 1
	 * F(3) = 1+1 = 2
	 * F(4) = 1+2 = 3
	 * F(5) = 2+3 = 5
	 * F(6) = 3+5 = 8
	 * ...
	 * and so on
	 */

	/**
	 * The standard recursive definition of the Fibonacci
	 * numbers that is inefficient to compute. Purposefully
	 * write the O(2^n) definition.
	 * 
	 * @param n position in the Fibonacci sequence
	 * @return n-th number in the sequence
	 */
	public static long fib1(long n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else return fib1(n - 1) + fib1(n - 2);
	}

	/**
	 * A kick-off for a more efficient recursive 
	 * definition of the Fibonacci numbers.
	 * 
	 * @param n position in the Fibonacci sequence
	 * @return n-th number in the sequence
	 */
	public static long fib2(long n) {
		return fibHelper(n, 0, 1);
	}

	/**
	 * Recursive helper method for fib2 that computes
	 * the n-th Fibonacci number in O(n) time by remembering
	 * what the last two Fibonacci numbers are.
	 * 
	 * @param n position in the Fibonacci sequence
	 * @param f1 number within Fibonacci sequence that is 
	 *           n positions before final desired result
	 * @param f2 number within Fibonacci sequence that is
	 *           n-1 positions before final desired result
	 * @return n-th number in the sequence
	 */
	private static long fibHelper(long n, long f1, long f2) {
		if (n == 0) return f1;
		else return fibHelper(n - 1, f2, f1 + f2);
	}

	/**
	 * This is a closed-form solution for the Fibonacci sequence
	 * that can compute any Fibonacci number in O(1) time. You
	 * don't need to change this. It's just an interesting formula.
	 * You'll learn why this formula works in Discrete Math.
	 * 
	 * @param n position in the Fibonacci sequence
	 * @return n-th number in the sequence
	 */
	public static long fib3(long n) {
		double root5 = Math.sqrt(5);
		double pow1 = Math.pow((1+root5)/2.0,n);
		double pow2 = Math.pow((1-root5)/2.0,n);
		return (long)((1.0/root5)*(pow1 - pow2));
	}

	/**
	 * This is a kick-off for a recursive procedure to
	 * evaluate a prefix expression where all operators
	 * have arity 2
	 * 
	 * @param prefixExpression Valid prefix expression with only "+", "-", "*", and "/"
	 * @return result of evaluating the expression
	 */
	public static double computePrefix(String prefixExpression) {
		Scanner scan = new Scanner(prefixExpression);
		double answer = computePrefix(scan);
		scan.close();
		return answer;
	}

	/**
	 * Recursive helper method that you must write. The Scanner
	 * is scanning a valid prefix expression. Use the apply
	 * method below to make the task easier.
	 * 
	 * @param scan Scanner of a prefix expression
	 * @return result of evaluating the expression
	 */
	private static double computePrefix(Scanner scan) {
		double result = Double.NaN; // Will be replaced
		// Base case
		if(scan.hasNextDouble()) { // Simplest expression is just a number
			result = scan.nextDouble();
		} else { // Recursive case
			String operator = scan.next(); // Valid expression should start with operator
			double lhs = computePrefix(scan);
			double rhs = computePrefix(scan);
			result = apply(operator,lhs,rhs);			
		}
		return result;
	}

	/**
	 * This helper method is given to you. For a given operator,
	 * that operation is applied to the two operands.
	 * @param operator String with either "+", "-", "/", or "*"
	 * @param operand1 First operand
	 * @param operand2 Second operand
	 * @return Result of applying operator to the two operands
	 */
	private static double apply(String operator, double operand1, double operand2) {
		switch(operator) {
		case "+": return operand1 + operand2;
		case "-": return operand1 - operand2;
		case "*": return operand1 * operand2;
		case "/": return operand1 / operand2;
		default:
			throw new IllegalArgumentException(operator+" is not a valid operator.");
		}
	}

	// These are display characters associated with the maze problem below
	public static final char EMPTY    = ' ';
	public static final char START    = 'S';
	public static final char GOAL     = 'G';
	public static final char VISITED  = '_';
	public static final char PATH     = '.';
	public static final char WALL     = 'W';

	public static final char[][] maze1 = new char[][] {
		{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL,WALL},
		{WALL,EMPTY,EMPTY,EMPTY, WALL,EMPTY, WALL,EMPTY,WALL},
		{WALL,EMPTY, WALL,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,WALL},
		{WALL,EMPTY, WALL,EMPTY, WALL, WALL, WALL, WALL,WALL},
		{WALL,EMPTY, WALL,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,WALL},
		{WALL,EMPTY, WALL,EMPTY, WALL, WALL, WALL,EMPTY,WALL},
		{WALL,EMPTY, WALL,EMPTY, WALL,EMPTY,EMPTY, WALL,WALL},
		{WALL,EMPTY, WALL, WALL, WALL,EMPTY, WALL, WALL,WALL},
		{WALL,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY, WALL,WALL},
		{WALL,EMPTY, WALL, WALL, WALL, WALL,EMPTY, WALL,WALL},
		{WALL,EMPTY,EMPTY,EMPTY,EMPTY, WALL,EMPTY,EMPTY,WALL},
		{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL,WALL},
	};

	/**
	 * Displays the maze by printing the display characters
	 * to the console in a 2D layout.
	 * 
	 * @param maze The 2D character array containing the maze to display
	 */
	public static void showMaze(char[][] maze) {
		for(int r = 0; r < maze.length; r++) {
			for(int c = 0; c < maze[r].length; c++) {
				System.out.print(maze[r][c]);
			}
			System.out.println();
		}
	}

	/**
	 * Reset all non-wall characters in a maze back to EMPTY
	 * 
	 * @param maze The 2D character array containing the maze to display
	 */
	public static void clearMaze(char[][] maze) {
		for(int r = 0; r < maze.length; r++) {
			for(int c = 0; c < maze[r].length; c++) {
				if(maze[r][c] != WALL) maze[r][c] = EMPTY;
			}
		}
	}

	/**
	 * Represents one step toward the goal in a 2D maze
	 */
	public static class PathStep {
		private int row;
		private int column;
		private PathStep nextStep;

		/**
		 * Solution step is a maze location
		 * @param r row
		 * @param c column
		 */
		public PathStep(int r, int c) {
			row = r;
			column = c;
		}

		/**
		 * Return the row
		 * @return row
		 */
		public int getRow() {
			return row;
		}

		/**
		 * Return the column
		 * @return column
		 */
		public int getColumn() {
			return column;
		}

		/**
		 * Add a step after this one
		 * @param next Next step in solution path
		 */
		public void setNextStep(PathStep next) {
			nextStep = next;
		}

		/**
		 * Get next step
		 * @return next step in solution path
		 */
		public PathStep getNextStep() {
			return nextStep;
		}
	}

	/**
	 * Helper method that returns all orthogonal neighbors of a given
	 * maze location, meaning up, down, left, and right.
	 * 
	 * @param current a PathStep with a maze locations
	 * @return ArrayList of PathSteps containing the locations 
	 *         up, down, left and right from the start point.
	 */
	private static ArrayList<PathStep> neighbors(PathStep current) {
		ArrayList<PathStep> neighbors = new ArrayList<>(4);
		neighbors.add(new PathStep(current.getRow()+1, current.getColumn()));
		neighbors.add(new PathStep(current.getRow()-1, current.getColumn()));
		neighbors.add(new PathStep(current.getRow(), current.getColumn()+1));
		neighbors.add(new PathStep(current.getRow(), current.getColumn()-1));
		return neighbors;
	}

	/**
	 * Kick-off for recursive depth-first search of maze. If successful,
	 * returns a starting PathStep that is a chain of steps to the solution.
	 * 
	 * @param maze 2D character array representing the maze
	 * @param startRow starting row in the maze
	 * @param startColumn starting column in the maze
	 * @param exitRow row where goal location is
	 * @param exitColumn column where goal location is
	 * @return first PathStep in chain to the goal
	 */
	public static PathStep solveMaze(char[][] maze, int startRow, int startColumn, int exitRow, int exitColumn) {
		clearMaze(maze);
		PathStep start = new PathStep(startRow, startColumn);
		maze[startRow][startColumn] = START;
		solveMaze(maze, start, exitRow, exitColumn);
		return start;
	}

	/**
	 * Recursive procedure for solving the maze. Implement as follows:
	 * 1) First check if the current location is at the goal, in which 
	 *    case mark the maze location as GOAL and return true.
	 * 2) Otherwise, loop through all neighbors of the current location.
	 * 3) If the given neighbor is EMPTY, change the maze value to PATH
	 *    and search from that point recursively
	 * 4) Only if this recursive search is successful should the next PathStep
	 *    of current be set to the particular neighbor that led to success,
	 *    in which case true is returned.
	 * 5) Whenever the recursive search fails, the maze location needs to be 
	 *    changed from PATH to simply VISITED
	 * 6) If all neighbors are searched without success, then return false
	 * 
	 * @param maze 2D character array representing the maze
	 * @param current PathStep that the search is current at
	 * @param exitRow row where goal location is
	 * @param exitColumn column where goal location is
	 * @return true if current is at the goal, or a path to the goal
	 *         has been discovered
	 */
	private static boolean solveMaze(char[][] maze, PathStep current, int exitRow, int exitColumn) {
		if (current.getRow() == exitRow && current.getColumn() == exitColumn) {
			maze[exitRow][exitColumn] = GOAL;
			return true;
		} 
		else {
			for (PathStep step : neighbors(current)) {
				if (maze[step.getRow()][step.getColumn()] == EMPTY) {
					maze[step.getRow()][step.getColumn()] = PATH;
					boolean success = solveMaze(maze, step, exitRow, exitColumn);

					if (success) {
						current.nextStep = step;
						return true;
					}
				maze[step.getRow()][step.getColumn()] = VISITED;
				}
			}
		}
		return false;
	}
}
