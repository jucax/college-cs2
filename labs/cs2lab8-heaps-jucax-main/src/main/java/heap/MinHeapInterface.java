package heap;

/**
 * Like the MaxHeapInterface from the book, but removes
 * minimal elements from the heap instead.
 *
 * @author Jacob Schrum
 */
public interface MinHeapInterface<T extends Comparable<? super T>>  {
	/**
	 * Add new item to heap
	 * @param newEntry a comparable item
	 */
	public void add(T newEntry);
	/**
	 * Removes minimal element from heap (should be at top),
	 * and re-heaps the structure to adhere to invariants.
	 * @return Min element in heap, or null if empty
	 */
	public T removeMin();
	/**
	 * Look at minimal element of heap without removing it
	 * @return Min element in heap, or null if empty
	 */
	public T getMin();
	/**
	 * Whether heap is empty
	 * @return True if empty, false otherwise
	 */
	public boolean isEmpty();
	/**
	 * Number of elements in heap
	 * @return size
	 */
	public int getSize();
	/** 
	 * Remove all elements from heap
	 */
	public void clear();
}
