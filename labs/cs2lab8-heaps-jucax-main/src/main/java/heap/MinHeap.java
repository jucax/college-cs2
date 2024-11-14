package heap;

import java.util.Arrays;

/**
 * A heap that keeps the minimal element on top.
 * You can implement this by copying and slightly
 * tweaking the code for the MaxHeap in the book.
 * 
 * @author Jacob Schrum
 */
public class MinHeap<T extends Comparable<? super T>> implements MinHeapInterface<T> {

	// Run this main method to test the heap while debugging
	public static void main(String[] args) {
		MinHeap<Integer> intHeap = new MinHeap<Integer>();
		intHeap.add(1);
		intHeap.add(2);
		intHeap.add(3);
		intHeap.add(4);
		intHeap.add(5);
		intHeap.add(6);
		intHeap.add(7);
		intHeap.add(8);
		intHeap.add(9);
		intHeap.add(10);
		intHeap.add(11);

		System.out.println("Min = "+intHeap.getMin());
	}

	// Private member variables and constants
	private T[] heap;
	private int lastIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 100000;

	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}

	public MinHeap(int initialCapacity) {
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else 
			checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
		initialized = true;
	}

	/**
	 * Throw an exception if an attempt to create an overly large heap is made
	 * @param capacity Desired capacity of underlying array for heap
	 */
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY) throw new IllegalStateException("Cannot create a heap this big: " + capacity);
	}

	/**
	 * Double the size of the underlying array storing the heap data
	 * if necessary.
	 */
	private void ensureCapacity() {
		if(lastIndex == heap.length - 1) {
			int newLength = 2 * heap.length;
			checkCapacity(newLength);
			heap = Arrays.copyOf(heap,  newLength);
		}
	}

	/**
	 * Verify that heap was properly initialized to thwart security breaches
	 */
	private void checkInitialization() {
		if(!initialized) throw new SecurityException("Heap not initialized properly");
	}

	// You must provide the implementation and comments for all methods below this point.

	@Override
	public void add(T newEntry) {
		// TODO
		checkInitialization();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while ((parentIndex > 0) && (newEntry.compareTo(heap[parentIndex]) < 0)) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}		
		heap[newIndex] = newEntry;
		lastIndex++;
		ensureCapacity();
	}

	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;
		while (!done && (leftChildIndex <= lastIndex)) {
			int largerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if ((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) < 0) {
				largerChildIndex = rightChildIndex;
			} 
			if (orphan.compareTo(heap[largerChildIndex]) > 0) {
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;
			}
			else 
				done = true;
		}
		heap[rootIndex] = orphan;
	}

	@Override
	public T removeMin() {
		checkInitialization();
		T root = null;
		if(!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			lastIndex--;
			reheap(1);
		}
		return root;
	}

	@Override
	public T getMin() {
		checkInitialization();
		T root = null;
		if(!isEmpty()) {
			root = heap[1];
		}
		return root;
	}

	@Override
	public boolean isEmpty() {
		return lastIndex < 1;
	}

	@Override
	public int getSize() {
		return lastIndex;
	}

	@Override
	public void clear() {
		checkInitialization();
		while (lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;	
	}
}
