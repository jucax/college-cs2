package lists;

import java.util.Arrays; // for Arrays.copyOf in the ensureCapacity method
import java.util.Iterator; // since class is Iterable
import java.util.NoSuchElementException;

public class ArrayList<T> implements ListInterface<T>, Iterable<T> {

	private static final int MAX_CAPACITY = 10000;
	private static final int DEFAULT_CAPACITY = 25;
	protected T[] list;
	protected int numberOfElements;
	private boolean initialized = false;

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayList(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[initialCapacity];
		list = temp;
		numberOfElements = 0;
		initialized = true;
	}

	protected void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY || capacity <= 0) 
			throw new IllegalStateException("Illegal capacity: "+capacity);
	}

	protected void checkInitialized() {
		if(!initialized)
			throw new SecurityException("List not properly initialized");
	}

	@Override
	public void add(T newEntry) {
		add(numberOfElements, newEntry);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		checkInitialized();
		if(newPosition < 0 || newPosition > getLength())
			throw new IndexOutOfBoundsException(newPosition + " out of bounds");
		else {
			if (newPosition < numberOfElements) makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfElements++;
			ensureCapacity();
		}
	}

	private void makeRoom(int givenPosition) {
		int newIndex = givenPosition;
		int lastIndex = getLength();
		for(int index = lastIndex ; index > newIndex ; index--) 
			list[index] = list[index - 1];
	}

	private void ensureCapacity() {
		int capacity = list.length;
		if(numberOfElements >= capacity) {
			int newCapacity = capacity * 2;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity);
		}
	}

	@Override
	public T remove(int givenPosition) {
		checkInitialized();
		if(givenPosition < 0 || givenPosition >= getLength())
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
		else {
			T result = list[givenPosition];
			if (givenPosition < numberOfElements - 1) removeGap(givenPosition);
			list[numberOfElements] = null;
			numberOfElements--;
			return result;
		}
	}

	private void removeGap(int givenPosition) {
		int removedIndex = givenPosition;
		for (int index = removedIndex ; index < numberOfElements ; index++)
			list[index] = list[index + 1];
	}

	@Override
	public void clear() {
		checkInitialized();
		numberOfElements = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(givenPosition < 0 || givenPosition >= getLength())
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
		else {
			T replaced = list[givenPosition];
			list[givenPosition] = newEntry;
			return replaced;
		}
	}

	@Override
	public T getEntry(int givenPosition) {
		checkInitialized();
		if(givenPosition < 0 || givenPosition >= getLength())
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
		return list[givenPosition];
	}

	@Override
	public T[] toArray() {
		checkInitialized();
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object [numberOfElements];
		for (int index = 0 ; index < numberOfElements ; index++)
			result[index] = list[index];
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		checkInitialized();
		boolean found = false;
		int index = 0;
		while (!found && (index < numberOfElements)) {
			if (anEntry.equals(list[index]))
				found = true;
			index++;
		}
		return found;
	}

	@Override
	public int getLength() {
		checkInitialized();
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		checkInitialized();
		return numberOfElements == 0;
	}

	private class ArrayListIterator implements Iterator<T> {

		private int nextIndex;

		private ArrayListIterator() {
			nextIndex = 0; // start at beginning of array
		}

		@Override
		public boolean hasNext() {
			return nextIndex < numberOfElements;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();

			// T result = list[nextIndex];
			// nextIndex++;
			// return result;

			return list[nextIndex++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
}
