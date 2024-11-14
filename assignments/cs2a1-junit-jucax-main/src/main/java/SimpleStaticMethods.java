import java.util.ArrayList;

/**
 * Most of the following methods are incomplete.
 * Complete all methods according to the provided
 * specifications. Your methods must also pass the
 * provided tests in SimpleStaticMethodsTest,
 * along with other tests you will write.
 * 
 * @author Jacob Schrum
 */
public class SimpleStaticMethods {

	public static void main(String[] args) {
		// Put method calls here if you want to test code using run-simple.bash
	}

	/**
	 * This method is given, but you must write unit tests for it.
	 * 
	 * Compute the sum of elements in an array using
	 * a standard for loop
	 *  
	 * @param array integers
	 * @return sum of input array
	 */
	public static int sumStandardLoop(int[] array) {
		int total = 0;
		for(int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total;
	}

	/**
	 * 3 points
	 * 
	 * Compute the sum of elements in an array using
	 * a for-each loop
	 * 
	 * @param array integers
	 * @return sum of input array
	 */
	public static int sumForEach(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	/**
	 * 3 points
	 * 
	 * Given an array of doubles, return the product of all
	 * the numbers in the array.
	 * (if the array has length 0, a value of 1 will be returned)
	 * 
	 * @param array of doubles
	 * @return product of all array values
	 */
	public static double product(double[] array) {
		double product = 1;

		if (array.length == 0) {
			return 1;
		}
		else {
			for (double i : array) {
				product *= i;
			}
		}

		return product; // TODO
	}

	/**
	 * 4 points
	 * 
	 * Takes two arrays and multiplies pairs of doubles from
	 * each array together to create a new array containing
	 * the products. Specifically, the i-th index of the
	 * result array contains a1[i]*a2[i]. The result array
	 * length equals that of the smaller input array. Extra
	 * elements in the larger input array (if sizes differ)
	 * are ignored.
	 * 
	 * @param a1 array of doubles
	 * @param a2 array of doubles
	 * @return array of products of doubles from two input arrays
	 */
	public static double[] zipMultiply(double[] a1, double[] a2) {
		// result has length of shorter input array
		double[] result = new double[(int) Math.min(a1.length, a2.length)];
		for (int i = 0 ; i < result.length ; i++) {
			result[i] = a1[i] * a2[i];
		}
		// TODO
		return result;
	}

	/**
	 * 4 points
	 * 
	 * If a given character x is in a given string, then
	 * return the substring of characters after 
	 * the first occurrence of x. Otherwise return the 
	 * empty string (which is just ""). 
	 * This can be accomplished without any loops at
	 * all if you use methods of the String class.
	 * Check the Java API for String.
	 * 
	 * @param x character to search for
	 * @param s string to get a substring from (not null)
	 * @return substring after first x, if it exists, else ""
	 */
	public static String subStringAfter(char x, String s) {
		if (s.indexOf(x) == -1) {
			return "";
		} else {
			return s.substring(s.indexOf(x) + 1);
		}
	}

	/**
	 * 5 points
	 * 
	 * Indicate if two ArrayLists of Integers start with the same
	 * sequence of elements. Specifically, the length of the shorter 
	 * list is used, and only those elements in the two lists are 
	 * compared. In other words, check if the beginning portion of 
	 * one list matches the entirety of another list. If either list
	 * is empty, then a result of true is returned. Note that you cannot
	 * know that you should return a result of true until you have looped
	 * as many iterations as the length of the shorter list. Also be aware
	 * that non-primitive Integers should be compared using the .equals method.
	 * 
	 * IMPORTANT: Do not modify the contents of either parameter list.
	 * 
	 * @param list1 First ArrayList of Integers
	 * @param list2 Second ArrayList of Integers
	 * @return Whether elements in shorter list match the
	 *         first elements of the longer list in the same order.
	 */
	public static boolean sameStart(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		int shorterLength = Math.min(list1.size(), list2.size());

		for (int i = 0 ; i < shorterLength ; i++) {
			if (! (list1.get(i).equals(list2.get(i)))) {
				return false;
			} 
		}
		return true; // TODO
	}

	/**
	 * 5 points
	 * 
	 * Given a (potentially jagged) 2D array, treat each sub-array
	 * as a collection of numbers, and determine the average across
	 * those numbers. The final result is an array with one element for
	 * each sub-array in the input, which equals the average of the
	 * values in that sub-array. Simply put, given an array of arrays,
	 * return an array of averages.
	 * 
	 * Note: arrayOfArrays[i][j] represents the j-th element of the i-th array.
	 *       If you want to know the length of the i-th array, use arrayOfArrays[i].length.
	 * 
	 * @param arrayOfArrays array of arrays of numbers, where each sub-array has a length of at least 1
	 * @return array of averages of the sub-arrays of the input
	 */
	public static double[] averages(double[][] arrayOfArrays) {
		double[] result = new double[arrayOfArrays.length]; // arrayOfArrays.length is the number of sub-arrays
		
		for (int i = 0 ; i < arrayOfArrays.length ; i++) {
			double average = 0;
			for (int j = 0 ; j < arrayOfArrays[i].length ; j++) {
				average += arrayOfArrays[i][j];
				result[i] = average / arrayOfArrays[i].length;
			}
		}
		// TODO (Hint: loop through all of the arrays with an outer loop, but have an inner loop through each sub-array that adds up values)
		return result;
	}
}
