package deque;

import java.util.ArrayList;

public class ArrayListDeque<T> implements DequeInterface<T> {

    private ArrayList<T> deque;

    public ArrayListDeque() {
        deque = new ArrayList<>();
    }

    public ArrayListDeque(int capacity) {
        deque = new ArrayList<>(capacity);
    }

	// O(n) for all the cases
		// Add an element to the front of an ArrayList is a constant-time operation,
		// but it involves shifting all existing elements to the right by one position
	@Override
	public void addToFront(T element) {
		deque.add(0, element);
	}

	// Best and average case: O(1)
		// Adding an element to the end of an ArrayList is a constant-time operation
		// when the arrayList is not full and doesn't need to resize internally
	// Worst case: O(n)
		// The ArrayList needs to resize, it involves creating a new array, copying 
		// existing elements to the new array and add the new element
	@Override
	public void addToBack(T element) {
		deque.add(element);
	}

	// O(n) for all the cases
		// Remove an element to the front of an ArrayList is a constant-time operation,
		// but it involves shifting all subsequent elements to the left by one position
	@Override
	public T removeFront() {
		if (isEmpty()) throw new EmptyQueueException();
		return deque.remove(0);
	}

	// O(1) for all the cases
		// Remove an element from the end of an ArrayList is a constant-time operation
	@Override
	public T removeBack() {
		if (isEmpty()) throw new EmptyQueueException();
		return deque.remove(deque.size() - 1);
	}

	// O(1) for all the cases
		// Get an element from an ArrayList is a constant-time operation
	@Override
	public T getFront() {
		if (isEmpty()) throw new EmptyQueueException();
        return deque.get(0);
	}

	// O(1) for all the cases
		// Get an element from an ArrayList is a constant-time operation
	@Override
	public T getBack() {
        if (isEmpty()) throw new EmptyQueueException();
        return deque.get(deque.size() - 1);
	}

	// O(n) for all the cases
		// Set the size to zero is a constant-time operation, but it involves deallocating
		// memory for the elements, which means traverse all the list.
	@Override
	public void clear() {
        deque.clear();
	}

	// O(1) for all the cases
		// Comparison of the size of the ArrayList to zero is a constant-time operation
	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}
}