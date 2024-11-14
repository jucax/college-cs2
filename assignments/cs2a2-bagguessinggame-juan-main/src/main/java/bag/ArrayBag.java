package bag;

/**
 * This class will be implemented the second day we work
 * using this lab.
 * 
 * This is a skeleton for the ArrayBag implementation
 * detailed in our text book. You do not need to worry 
 * about resizing the underlying array container when 
 * the array is full. This is a fixed-size bag.
 * 
 * @author Jacob Schrum
 */
public class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;

	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayBag(int capacity) {
		// TODO Auto-generated constructor stub
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object [capacity];
		bag = tempBag;
		numberOfEntries = 0;
		
	}

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		boolean result = true;

		if (isArrayFull()) {
			result = false;
		} else {
			bag[numberOfEntries] = newEntry;
			numberOfEntries ++;
		}

		return result;
	}

	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}

	@Override
	public T remove() {
		T result = null;

		if (numberOfEntries > 0) {
			result = bag[numberOfEntries - 1];
			bag[numberOfEntries - 1] = null;
			numberOfEntries --;
		}

		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		for(int i = 0; i < numberOfEntries; i++) {
			if(bag[i].equals(anEntry)) {
				bag[i] = bag[numberOfEntries - 1]; 
				remove(); 
				return true; 
			}
		}
		
		return false;
	}

	private T removeEntry (int givenIndex) {
		T result = null;

		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries - 1];
			bag [numberOfEntries] = null;
			numberOfEntries--;
		}

		return result;
	}

	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			} else {
				index ++;
			}
		}

		return where;
	}

	@Override
	public void clear() {
		while (!isEmpty()) remove();
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;

		for (int index = 0 ; index < numberOfEntries ; index++) {
			if (anEntry.equals(bag[index])) {
				counter ++;
			}
		}

		return counter;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
			} else {
				index ++;
			}
		}

		return found;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		for (int index = 0 ; index < numberOfEntries ; index++) {
			result[index] = bag[index];
		}

		return result;
	}
}
        
