package set;

import java.util.ArrayList;

public class ArrayListSet<T> implements SetInterface<T> {

	private ArrayList<T> set;

	// Constructor with default capacity of 10 for ArrayLists
	public ArrayListSet() {
		set = new ArrayList<>();
	}

	// Constructor with specific capacity
	public ArrayListSet(int capacity) {
		set = new ArrayList<>(capacity);
	}

	// O(1) for all the cases
		// Return the number of elements in the ArrayList is a constant-time operation
	public int getCurrentSize() {
		return set.size();
	}

	// O(1) for all the cases
		// Comparison of the size of the ArrayList to zero is a constant-time operation
	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	// Best and average case: O(1)
		// Adding an element to the end of an ArrayList is a constant-time operation
		// when the arrayList is not full and doesn't need to resize internally
	// Worst case: O(n)
		// The ArrayList needs to resize, it involves creating a new array, copying 
		// existing elements to the new array and add the new element
	@Override
	public boolean add(T newEntry) {
		if (!set.contains(newEntry)) return set.add(newEntry);
        return false;
	}

	// Best case: O(1)
		// When the element is at the end of the arrayList is a constant-time operation
	// Average and worst case: O(n)
		// When the element is at the beginning or middle of the arrayList, or when it 
		// is not in the arrayList, it needs to traverse to find it, and then shift the
		// elements to remove the gap.
    @Override
	public boolean remove(T anEntry) {
        return set.remove(anEntry);
	}

	// O(1) for all the cases
		// Remove an element from the end of an ArrayList is a constant-time operation
	@Override
	public T remove() {
        if (set.isEmpty()) return null;
		return set.remove(set.size() - 1);
	}

	// O(n) for all the cases
		// Set the size to zero is a constant-time operation, but it involves deallocating
		// memory for the elements, which means traverse all the list.
	@Override
	public void clear() {
		set.clear();
	}

	// Best case: O(1)
		// When the element is at the end of the arrayList is a constant-time operation
	// Average and worst case: O(n)
		// When the element is at the beginning or middle of the arrayList, or when it 
		// is not in the arrayList, it needs to traverse the list and check each element.
	public boolean contains(T anEntry) {
		return set.contains(anEntry);
	}

	// O(n) for all the cases
		// Convert the arrayList to an array involves traverse and copying each element 
		// to a new array
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
        T[] result = (T[]) set.toArray(new Object[0]);
        return result;
	}
}