package search;

import java.awt.Point;

/**
 * This class defines three distinct ways of searching a sorted 2D array.
 * The array is of Comparable objects, and each method returns true if 
 * the sought value is found, and false otherwise. Some helper methods
 * are also included.                
 *                 
 * @author Jacob Schrum
 */
public class Sorted2DArraySearch {

	// Use this main method to test and troubleshoot your code
	// without using the unit tests.
	public static void main(String[] args) {
		Integer[][] test1 = {
			{ 10,  20,  30,  40,  45},
			{ 50,  60,  70,  80,  85},
			{ 90, 100, 110, 120, 125},
			{130, 140, 150, 160, 165},
			{170, 180, 190, 200, 210},	
		};

		if(verifySorted(test1)) {
			System.out.println("Is sorted");
			Integer value = Integer.valueOf(70);
			System.out.println("Contains "+value+"? "+threeQuadrantSubSearch(test1,value));
		} else {
			System.out.println("Not sorted");
		}
	}

	/**
	 * This method verifies that a 2D array is sorted,
	 * meaning that each row and column is non-decreasing.
	 * You don't actually need to use this method in your
	 * code, but I use it in my tests on each test case.
	 * 
	 * @param array Array of Comparable objects
	 * @return True if the array is sorted, false otherwise
	 */
	public static <T extends Comparable<T>> boolean verifySorted(T[][] array) {
		// Make sure each row is non-decreasing
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length - 1; j++) {
				// Return false if a value in a row is less than the value preceding it
				if(array[i][j+1].compareTo(array[i][j]) < 0) {
					return false;
				}
			}
		}
		// Make sure each column is non-decreasing
		for(int j = 0; j < array[0].length - 1; j++) {
			for(int i = 0; i < array.length; i++) {
				// Return false if a value in a column is less than the value preceding it
				if(array[i][j+1].compareTo(array[i][j]) < 0) {
					return false;
				}
			}
		}
		// All rows and columns were sorted, so return true
		return true;
	}

	/**
	 * Return midpoint between two values.
	 * It must be the case that first <= last.
	 * 
	 * @param first Lower value
	 * @param last Upper value
	 * @return Midpoint between first and last
	 */
	private static int midpoint(int first, int last) {
		if(first > last) throw new IllegalArgumentException(first + " greater than " + last);
		return first + (last - first) / 2;
	}	

	/**
	 * This method can check if you have defined an inappropriate
	 * sub-region within a 2D array. It is assumed that array is
	 * a rectangular 2D array (not jagged).
	 * 
	 * @param array Array is provided so that knowledge of its size is available.
	 * @param startRow Starting row of sub-region
	 * @param startCol Starting column of sub-region
	 * @param endRow Ending row of sub-region
	 * @param endCol Ending column of sub-region
	 * @return False if the sub-region is within bounds and the region has its starting
	 *         bounds before its ending bounds, true otherwise.
	 */
	private static <T> boolean invalidSubRegion(T[][] array, int startRow, int startCol, int endRow, int endCol) {
		return startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0 ||
				startRow >= array.length || endRow >= array.length || startCol >= array[0].length || endCol >= array[0].length ||
				startRow > endRow || startCol > endCol;
	}

	/**
	 * This is the kick-off method for a recursive approach to searching a sorted 2D array
	 * by quadrants. The recursive method checks the center of a designated region, and
	 * then recursively searches three quadrants of that region if the sought value was
	 * not found. The details of this implementation are in the assignment description.
	 * 
	 * @param array 2D array of Comparable objects.
	 * @param value Value to search for in the array.
	 * @return True if the value is found, false otherwise.
	 */
	public static <T extends Comparable<T>> boolean threeQuadrantSubSearch(T[][] array, T value) {
		return threeQuadrantSubSearch(array, value, 0, array.length - 1, 0, array[0].length - 1);
	}

	/**
	 * Recursively searches for the target value within a designated region of a sorted 2D array. 
	 * This method employs a recursive three quadrant subsearch method to efficiently locate the 
	 * target value by dividing the array into quadrants and recursively searching them. It search
	 * in different quadrants depending if tha value in the middle is less or greater than the target.
	 * 
	 * @param <T>        The type of objects stored in the array, which must implement the Comparable interface.
	 * @param array      A 2D array of Comparable objects, sorted in ascending order.
	 * @param value      The value to search for in the array.
	 * @param startRow   The starting row index of the current region.
	 * @param endRow     The ending row index of the current region.
	 * @param startCol   The starting column index of the current region.
	 * @param endCol     The ending column index of the current region.
	 * @return           True if the value is found in the specified region of the array, false otherwise.
	 */
	private static <T extends Comparable<T>> boolean threeQuadrantSubSearch(T[][] array, T value, 
														int startRow, int endRow, int startCol, int endCol) {

		if(!invalidSubRegion(array, startRow, startCol, endRow, endCol)) { // If the region is valid, then search it
			int midRow = midpoint(startRow, endRow);
			int midCol = midpoint(startCol, endCol);
			T midElement = array[midRow][midCol];

			// If the value is equal to the middle element, return true
			if (value.equals(midElement))
				return true;
			else if (value.compareTo(midElement) < 0) { //  If the value is less than the middle element, 
			// search top-left,top-right, and bottom-left
				return threeQuadrantSubSearch(array, value, startRow, midRow - 1, startCol, midCol - 1) ||
					   threeQuadrantSubSearch(array, value, midRow, endRow, startCol, midCol - 1) ||
					   threeQuadrantSubSearch(array, value, startRow, midRow - 1, midCol, endCol);
			} else { // If the value is greater than the middle element, 
			// recursively search top-right, bottom-left, and bottom-right
				return threeQuadrantSubSearch(array, value, startRow, midRow, midCol + 1, endCol) ||
					   threeQuadrantSubSearch(array, value, midRow + 1, endRow, startCol, midCol) ||
					   threeQuadrantSubSearch(array, value, midRow + 1, endRow, midCol + 1, endCol);
			}

		} else {
			return false; // was an invalid sub region
		}
	}

	/**
	 * This iterative search progresses from the lower-left corner of
	 * a sorted 2D array to the upper-right corner of the array. The 
	 * search path is a zig-zag, but the exact path depends on how
	 * the encountered values compare to the value being sought. Details
	 * are in the assignment description.
	 * 
	 * @param array 2D array of Comparable objects.
	 * @param value Value to search for in the array.
	 * @return True if the value is found, false otherwise.
	 */
	public static <T extends Comparable<T>> boolean zigzagSearch(T[][] array, T value) {
		boolean found = false;
		// We start with the lower left corner
		int row = array.length - 1;
		int col = 0;
		T zigzagValue;
		// Repeat ultil we find the value or ultil we finish the rows or columns possible
		while (!found && (row >= 0) && (col <= array[0].length - 1)) {
			zigzagValue = array[row][col];
			if (value.equals(zigzagValue))
				found = true;
			else if (value.compareTo(zigzagValue) < 0) // If the value is less than the zigzagValue, 
			// Move up one cell
				row --;
			else // If the value is greater than the zigzagValue, 
			// Move one cell to the right
				col ++;
		}	
		return found;
	}

	/**
	 * This helper method is needed by the next search method below. It performs a standard
	 * one-dimensional binary search along the diagonal of a sorted 2D array (since the array
	 * is sorted, its diagonal is also non-decreasing). However, instead of simply indicating
	 * whether the sought value was found, the method returns a Point, which is a convenient
	 * way to store two values. The values in the Point returned represent the row and column
	 * of the result of the binary search. Specifically, the location of the desired value
	 * is returned if it is found. If it is not found, then the returned location holds a value
	 * along the diagonal that is less than the sought value, but for which the following value
	 * on that same diagonal is greater than the sought value.
	 * 
	 * @param array 2D sorted array
	 * @param value Being searched for
	 * @param startRow Starting row of sub-rectangle to search
	 * @param startCol Starting column of sub-rectangle to search
	 * @param endRow Ending row of sub-rectangle to search
	 * @param endCol Ending column of sub-rectangle to search
	 * @return Point whose indices either contain the value, or bound it from below and above
	 */
	public static <T extends Comparable<T>> Point binarySearchDiagonal(T[][] array, T value, int startRow, int startCol, int endRow, int endCol) {
		if(startRow > endRow || startCol > endCol) { //base case: bounds overlap
			// If end point is not off the upper/left edge, it contains a point less than or equal to the value
			assert endRow == -1 || endCol == -1 || array[endRow][endCol].compareTo(value) <= 0;
			// If point after end point is not off the lower/right edge, it contains a point greater than the value
			assert endRow+1 == array[0].length || endCol+1 == array.length || array[endRow+1][endCol+1].compareTo(value) > 0;
			return new Point(endRow, endCol);            
		} else {
			int midpointRow = midpoint(startRow, endRow);
			int midpointCol = midpoint(startCol, endCol);
			if(array[midpointRow][midpointCol].equals(value)) { //found: return point
				return new Point(midpointRow, midpointCol);
			} else if(value.compareTo(array[midpointRow][midpointCol]) < 0) { //smaller search left
				return binarySearchDiagonal(array, value, startRow, startCol, midpointRow - 1, midpointCol - 1);
			} else{ // larger, search right
				return binarySearchDiagonal(array, value, midpointRow + 1, midpointCol + 1, endRow, endCol);
			}
		} 
	}

	/**
	 * This is the most complicated search method. This particular method is the kick-off method for
	 * a recursive procedure that recursively searches two sub-rectangles within the input array. 
	 * The particular rectangles that are searched depend on the result of performing a more-or-less
	 * standard binary search along the diagonal of the array. Details are in the assignment description.
	 * 
	 * @param array 2D array of Comparable objects.
	 * @param value Value to search for in the array.
	 * @return True if the value is found, false otherwise.
	 */
	public static <T extends Comparable<T>> boolean binarySearchDiagonalSearch(T[][] array, T value) {
		return binarySearchDiagonalSearch(array, value, 0, array.length - 1, 0, array[0].length - 1);
	}

	/**
	 * Recursively searches two sub-rectangles within the input 2D array for the target value using a 
	 * binary search algorithm along the diagonal. This method is part of a recursive search process 
	 * aimed at efficiently locating a value within a sorted 2D array. It divides the array into 
	 * smaller sub-rectangles and searches along their diagonals. It also consider that some sub-rectangles
	 * won't have the same height and width, so the process to find the diagonal change a little bit.
	 * 
	 * @param array 2D array of Comparable objects.
	 * @param value Value to search for in the array.
	 * @param startRow Starting row of sub-rectangle to search.
	 * @param endRow Ending row of sub-rectangle to search.
	 * @param startCol Starting column of sub-rectangle to search.
	 * @param endCol Ending column of sub-rectangle to search.
	 * @return True if the value is found, false otherwise.
	 */
	private static <T extends Comparable<T>> boolean binarySearchDiagonalSearch(T[][] array, T value, 
														int startRow, int endRow, int startCol, int endCol) {
		if(invalidSubRegion(array, startRow, startCol, endRow, endCol)) {
			return false;
		} else { // Search the valid region
			// Calculate the dimensions of the current little rectangle
			int rectangleHeight = endRow - startRow + 1;
			int rectangleWidth = endCol - startCol + 1;

			// Calculate the diagonal bounds for the new little rectangle
			int diagonalEndRow = startRow + Math.min(rectangleHeight, rectangleWidth) - 1;
			int diagonalEndCol = startCol + Math.min(rectangleHeight, rectangleWidth) - 1;

			Point p = binarySearchDiagonal(array, value, startRow, startCol, diagonalEndRow, diagonalEndCol);

			int resultRow = p.x;
			int resultCol = p.y;

			// Check if the result is within the bounds of the current little rectangle
        	if (resultRow < startRow || resultRow > endRow || resultCol < startCol || resultCol > endCol)
            	return false;

			T pointValue = array[resultRow][resultCol];

			if (pointValue.equals(value))
				return true;
			else {
				return binarySearchDiagonalSearch(array, value, resultRow + 1, endRow, startCol, resultCol) ||
				binarySearchDiagonalSearch(array, value, startRow, resultRow, resultCol + 1, endCol);
			}
		}
	}
}          
 
