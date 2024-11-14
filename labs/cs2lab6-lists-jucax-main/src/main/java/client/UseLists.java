package client;

import java.util.ArrayList;

/**
 * Use Java's built-in array list to complete the following problems.
 */
public class UseLists {

	public static void main(String[] args) {

	}

	/**
	 * Return an ArrayList containing the integers from 1 up to n
	 * in order.
	 * 
	 * @param n positive number, and last element of created list
	 * @return list containing 1, 2, ... , n
	 */
	public static ArrayList<Integer> listUpToN(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1 ; i <= n ; i++) {
			list.add(i);
		}
		return list; //TODO
	}

	/**
	 * Scan the list from left to right and return the index of 
	 * the first odd integer. If no such integer is found, then
	 * return -1.
	 * 
	 * @param list ArrayList to search
	 * @return index of first odd element
	 */
	public static int indexOfFirstOdd(ArrayList<Integer> list) {
		for (int i = 0 ; i < list.size() ; i++) {
			int element = list.get(i);
			if (element % 2 == 1) return i;
		}
		return -1; // TODO
	}

	/**
	 * Given a list and a character, return a new list that contains only the strings
	 * from the original list that start with the given character. The new list has
	 * these strings in the same order they appeared in the original list.
	 * 
	 * @param original list of strings
	 * @param letter letter that strings in result list must start with
	 * @return list of only the words starting with letter
	 */
	public static ArrayList<String> wordsStartingWith(ArrayList<String> original, char letter) {
		ArrayList<String> list = new ArrayList<>();
		for (String word : original) {
			if (word.charAt(0) == letter) list.add(word);
		}
		return list; // TODO
	}

	/**
	 * Return the maximum element in the list. If the list is empty, return NaN.
	 * 
	 * @param list List of numbers
	 * @return maximal element or NaN for empty list
	 */
	public static double maximum(ArrayList<Double> list) {
		if (list.size() > 0) {
			double max = list.get(0);
			for (int i = 0 ; i < list.size() ; i++) {
				if (list.get(i) >= max) max = list.get(i);
			}
			return max;
		}	
		return Double.NaN; // TODO
	}

	/**
	 * Return the index of the maximal element in the list.
	 * If there are ties, return the first element that is tied for
	 * max. If the list is empty, return -1.
	 * 
	 * @param <T> Type that can be compared to determine relative size
	 * @param elements list of comparable elements
	 * @return First index that contains a maximal value, or -1 for empty list
	 */
	public static <T extends Comparable<? super T>> int argMax(ArrayList<T> elements) {
		if (elements.size() > 0) {
			T max = elements.get(0);
			int maxIndex = 0;
			for (int i = 0 ; i < elements.size() ; i++) {
				if (elements.get(i).compareTo(max) >= 0) {
					max = elements.get(i);
					maxIndex = i;
				}
			}
			return maxIndex;
		}	
		return -1; // TODO
	}

	/**
	 * Remove all even integers from the list
	 * 
	 * @param nums list of integers
	 */
	public static void removeEvens(ArrayList<Integer> nums) {
		for (int i = nums.size() - 1 ; i >= 0 ; i--) {
			int element = nums.get(i);
			if (element % 2 == 0) nums.remove(i);
		}
	}
}
