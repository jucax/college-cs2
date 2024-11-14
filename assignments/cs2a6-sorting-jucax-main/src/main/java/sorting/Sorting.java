
package sorting;

import java.util.Arrays;

/**
 * You are required to implement several
 * sorting algorithms in this class:
 * selection sort, insertion sort, merge sort,
 * and quick sort. Much of the implementation
 * for these algorithms was provided in class            
 * and/or in the book. Your code must fit the 
 * method signatures below. Do not change any method 
 * signatures, or my JUnit tests will not be able to 
 * run when I grade your assignment. However, you can 
 * and should define additional               
 * helper methods.
 * 
 * @author Jacob Schrum
 */
public class Sorting {

	// You can use this main method to test out calls to individual sorting methods.
	// This can be useful if you add print statements anywhere in the code for debugging.
	public static void main(String[] args) {
		Integer[] intArray = new Integer[]{5, 20, -324, 54, 100, 3, 0, 2040, 3, 3532, -2411, 545, 0, 22};
		System.out.println("Before: "+Arrays.toString(intArray));
		selectionSort(intArray);
		System.out.println("After : "+Arrays.toString(intArray));
	}

	// To fully optimize quick sort, arrays of small size
	// (defined below) should be sorted with insertion sort 
	// instead of quick sort.
	public static final int MIN_QUICK_SORT_SIZE = 3;

	////// Utility methods ////////////////////    

	/**
	 * Swaps contents at two indices in an array. 
	 * This helpful method should be used in several
	 * of the search algorithms below.
	 * 
	 * @param a Array of Objects
	 * @param first index of first element
	 * @param second index of second element
	 */
	private static void swap(Object[] a, int first, int second) {
		Object temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

	/**
	 * Determines the approximate midpoint index between
	 * two given indices. Is useful for merge sort and
	 * for median-of-three pivot selection in quick sort.
	 * 
	 * @param first Lower index in array
	 * @param last Upper index in array
	 * @return Approximate midpoint between first and last
	 */
	private static int midpoint(int first, int last) {
		return first + (last - first) / 2;
	}

	////// Selection sort and associated methods ///////////////////

	/**
	 * Implements selection sort on the whole array.
	 * You may need to implement additional
	 * private methods to fully implement selection sort.
	 * I recommend implementing the iterative version of
	 * selection sort.
	 * 
	 * @param a Array of comparable objects to sort
	 * 
	 * 20 points for functionality
	 *  5 points for style and commenting
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
		for (int index = 0 ; index < a.length ; index++) {
			int indexOfNextSmallest = getIndexOfSmallest(a, index, a.length - 1);
			swap(a, index, indexOfNextSmallest);
		}
	}

	/**
	 * Get the smallest object in an array in the range 
	 * from first to the last index indicated using the 
	 * compareTo method, then it return the index of 
	 * this smallest object.
	 * 
	 * @param a Array of comparable objects
	 * @param first Index of first element
	 * @param last Index of last element
	 * @return Index of the smallest object in the specified range
	 */
	private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
		T smallest = a[first];
		int indexOfSmallest = first;

		for (int index = first + 1 ; index <= last ; index++) {
			if (a[index].compareTo(smallest) < 0) { //If it is smaller than
				smallest = a[index];
				indexOfSmallest = index;
			}
		}
		return indexOfSmallest;
	}

	////// Insertion sort and associated methods ///////////////////

	/**
	 * Implements insertion sort on the whole array.
	 * You may need to implement additional
	 * private methods to fully implement insertion sort.
	 * I recommend implementing the iterative version of
	 * insertion sort.                 
	 * 
	 * Also note: You will need to be able to apply insertion
	 * sort to small sub-arrays in order to complete the optimized
	 * version of quick sort below. However, you will not be able
	 * to call this method (which sorts the whole array) from
	 * the quicksort method.
	 * 
	 * @param a Array of comparable objects to sort
	 * 
	 * 20 points for functionality
	 *  5 points for style and commenting
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		insertionSort(a, 0, a.length - 1);
	}

	/**
	 * Implements the insertion sort algorithm in a specific 
	 * range of an array with comparable objects
	 * 
	 * @param a Array of comparable objects
	 * @param first Index of first element
	 * @param last Index of last element
	 */
	private static <T extends Comparable<? super T>> void insertionSort(T[] a, int first, int last) {
		for (int unsorted = first ; unsorted <= last ; unsorted++) {
			T nextToInsert = a[unsorted];
			insertInOrder(nextToInsert, a, 0, unsorted - 1);
		}
	}	

	/**
	 * Insert and specific object in into a sorted array
	 * in the correct position in an specific range, it 
	 * verify the correct order using the compareTo method 
	 * and make room to insert if it is necessary.
	 * 
	 * @param entry The object to insert
	 * @param a Array of comparable objects
	 * @param begin Index of the begin of the range in the array
	 * @param end Index of the end of the range in the array
	 */
	private static <T extends Comparable<? super T>> void insertInOrder(T entry, T[] a, int begin, int end) {
		int index = end;
		while ((index >= begin) && (entry.compareTo(a[index]) < 0)) {
			a[index + 1] = a [index]; //Make room for new entry
			index--;
		}
		a[index + 1] = entry; //Insert new entry
	}

	////// Merge sort and associated methods ///////////////////

	/**
	 * Implements merge sort on the whole array.
	 * You may need to implement additional
	 * private methods to fully implement merge sort.
	 * I recommend implementing the recursive version of
	 * merge sort. 
	 * 
	 * This mergeSort method should just be a kick-off
	 * for the the actual recursive method. You will also
	 * need to define a separate merge method, and potentially
	 * other methods.
	 * 
	 * @param a Array of comparable objects to sort
	 * 
	 * 20 points for functionality
	 *  5 points for style and commenting
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
		@SuppressWarnings ("unchecked")
		T[] tempArray = (T[]) new Comparable<?>[a.length];
		mergeSort(a, tempArray, 0, a.length - 1);
	}

	/**
	 * Using recursive calls and the merge sort algorithm, 
	 * it sort the objects of an array in an specific range
	 * 
	 * @param a Array of comparable objects
	 * @param temp Temporary array for sorted objects
	 * @param first Index of first element
	 * @param last Index of last element
	 */
	private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] temp, int first, int last) {
		if (first < last) {
			int mid = midpoint(first, last);
			mergeSort(a, temp, first, mid);
			mergeSort(a, temp, mid + 1, last);
			merge(a, temp, first, mid, last);
		}
	}

	/**
	 * Merge two sorted subarrays into a temporary array
	 * and then pass the sorted objects to the original array
	 * 
	 * @param a Array of comparable objects
	 * @param temp Temporary array for sorted objects
	 * @param first Index of first element
	 * @param mid Index of the middle element
	 * @param last Index of last element
	 */
	private static <T extends Comparable<? super T>> void merge(T[] a, T[] temp, int first, int mid, int last) {
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;
		int index = first;

		while ((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)) {
			if (a[beginHalf1].compareTo(a[beginHalf2]) < 0) {
				temp[index] = a[beginHalf1];
				beginHalf1++;
			}
			else {
				temp[index] = a[beginHalf2];
				beginHalf2++;
			}
			index++;
		}

		//Copy remaining objects from Half1
		while (beginHalf1 <= endHalf1) {
			temp[index] = a[beginHalf1];
			beginHalf1++;
			index++;
		}

		//Copy remaining objects from Half2
		while (beginHalf2 <= endHalf2) {
			temp[index] = a[beginHalf2];
			beginHalf2++;
			index++;
		}
		
		//Replacing the methods in the correct order
		for (int i = first ; i < index ; i++) 
			a[i] = temp[i];
	}

	////// Quick sort and associated methods ///////////////////	

	/**
	 * Implements quick sort on the whole array.
	 * You may need to implement additional
	 * private methods to fully implement quick sort.
	 * I recommend implementing the recursive version of
	 * quick sort. 
	 * 
	 * Note: You must implement the fully optimized
	 * version of quick sort. This means that you must
	 * use insertion sort on small sub-arrays (the constant
	 * MIN_QUICK_SORT_SIZE indicates how small), and that        
	 * you must pick your pivot point using the median-of-three
	 * method. The complete code for this is not in the book,
	 * but the details of how it is done are described.           
	 * 
	 * This quickSort method should just be a kick-off
	 * for the the actual recursive method. Several other
	 * private methods should also be implemented.
	 * 
	 * @param a Array of comparable objects to sort
	 * 
	 * 20 points for functionality
	 *  5 points for style and commenting
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] a) {
		quickSort(a, 0, a.length - 1);
	}

	/**
	 *  Using recursive calls and the merge sort algorithm, 
	 * it sort the objects of an array in an specific range
	 * 
	 * @param a Array of comparable objects
	 * @param first Index of first element
	 * @param last  Index of last element
	 */
	private static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
		if (last - first + 1 < MIN_QUICK_SORT_SIZE) 
			insertionSort(a, first, last);
		else { 
			int pivotIndex = partition(a, first, last);
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		}
	}

	/**
 	 * Create partitions in an array based on the pivot
	 * index, obtained from the median-of-three method
	 *
	 * @param a Array of comparable objects
	 * @param first Index of first element
	 * @param last Index of last element
	 */
	private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
		int mid = midpoint(first, last);
		sortFirstMiddleLast(a, first, mid, last); //Median-of-three method
		swap(a, mid, last - 1);

		int pivotIndex = last - 1;
		T pivotValue = a[pivotIndex];

		int indexFromLeft = first + 1;
		int indexFromRight = last - 2;
		boolean done = false;

		while (!done) {
			while (a[indexFromLeft].compareTo(pivotValue) < 0)
				indexFromLeft++;
			while (a[indexFromRight].compareTo(pivotValue) > 0)
				indexFromRight--;
			if (indexFromLeft < indexFromRight) {
				swap(a, indexFromLeft, indexFromRight);
				indexFromLeft++;
				indexFromRight--;
			}
			else 
				done = true;
		}
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;

		return pivotIndex;
	}

	/**
	 * Sorts the first, middle, and last elements of an 
	 * array in a specific range, it is used for the 
	 * Median-of-three method
	 *
	 * @param a Array of comparable objects
	 * @param first Index of first element
	 * @param mid Index of middle element
	 * @param last Index of last element
	 */
	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(T[] a, int first, int mid, int last) {
		if (a[mid].compareTo(a[first]) < 0)
			swap(a, first, mid);
		if (a[last].compareTo(a[mid]) < 0) 
			swap(a, mid, last);
		if (a[mid].compareTo(a[first]) < 0)
			swap(a, first, mid);
	}
}
