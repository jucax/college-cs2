package client;

import bag.*;

/**
 * You will work on this file on the first day we use this repo.
 */
public class UseBag {

	public static void main(String[] args) {
		// Put code here to test out the methods
		System.out.println("Hello");
		// Declare a variable named intBag.
		// The type of intBag is BagInterface<Integer>
		// intBag is assigned to a new MysteryBag<Integer>
		// The MysteryBag is a specific implementation of the BagInterface
		BagInterface<Integer> intBag = new MysteryBag<>();

		System.out.println("Size of new bag: " + intBag.getCurrentSize());

		intBag.add(20);
		intBag.add(25);
		intBag.add(100);
		intBag.add(37);
		intBag.add(82);

		System.out.println("Size after adding: " + intBag.getCurrentSize());
	}

	/**
	 * Given two bags, return the one with the larger size.
	 * If they have the same size, return the first bag.
	 *
	 * @param <T> type of element in both bags
	 * @param bag1 a bag
	 * @param bag2 another bag
	 * @return Either bag1 or bag2, whichever is larger
	 */
	public static <T> BagInterface<T> biggerBag(BagInterface<T> bag1, BagInterface<T> bag2) {
		BagInterface<T> larger;

		if(bag1.getCurrentSize() >= bag2.getCurrentSize()) {
			larger = bag1;
		} else {
			larger = bag2;
		}

		return larger;
	}

	/**
	 * Returns a brand new bag containing nothing but a certain number
	 * of copies of a particular element.
	 *
	 * @param <T> type of element in result bag
	 * @param count Number of elements to add to the new bag
	 * @param element The specific element to add to the new bag
	 * @return A new bag containing only count number of copies of element
	 */
	public static <T> BagInterface<T> bagWithXOfY(int count, T element) {
		BagInterface<T> newBag = new MysteryBag<>();

		for (int i = 0 ; i < count ; i++) {
			newBag.add(element);
		}

		return newBag; 
	}

	/**
	 * Removes all copies of a specific element from a given bag.
	 *
	 * @param <T> type of element in bag
	 * @param bag A bag to remove elements from
	 * @param toRemove An element to remove from the bag
	 */
	public static <T> void removeAllFromBag(BagInterface<T> bag, T toRemove) {
		while (bag.remove(toRemove));
	}

	/**
	 * For a given element, determine how many more occurrences of that element
	 * one bag contains in comparison to another. The result is the absolute value
	 * of the difference between the frequency of the element in the two bags.
	 *
	 * @param <T> type of element in both bags
	 * @param bag1 First bag which might contain the element
	 * @param bag2 Second bag which might contain the element
	 * @param element Element to check for in the two bags
	 * @return Absolute difference in frequency of element within the two bags
	 */
	public static <T> int differenceInFrequency(BagInterface<T> bag1, BagInterface<T> bag2, T element) {
		return Math.abs(bag1.getFrequencyOf(element) - bag2.getFrequencyOf(element)); 
	}
}
