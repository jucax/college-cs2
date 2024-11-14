package stack;

import java.util.EmptyStackException;
import java.util.ArrayList;

public class ArrayListStack<T> implements StackInterface<T> {

	private ArrayList<T> stack;

	// Constructor with default capacity of 10 for ArrayLists
	public ArrayListStack() {
		stack = new ArrayList<>();
	}

	// Constructor with specific capacity
	public ArrayListStack(int capacity) {
		stack = new ArrayList<>(capacity);
	}

	// O(1) for all the cases
		// Comparison of the size of the ArrayList to zero is a constant-time operation
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	// Best and average case: O(1)
		// Adding an element to the end of an ArrayList is a constant-time operation
		// when the arrayList is not full and doesn't need to resize internally
	// Worst case: O(n)
		// The ArrayList needs to resize, it involves creating a new array, copying 
		// existing elements to the new array and add the new element
	public void push(T newEntry) {
		stack.add(newEntry);
	}

	// O(1) for all the cases
		// Remove an element from the end of an ArrayList is a constant-time operation
	public T pop() {
		if (isEmpty()) throw new EmptyStackException();
		return stack.remove(stack.size() - 1);
	}

	// O(n) for all the cases
		// Set the size to zero is a constant-time operation, but it involves deallocating
		// memory for the elements, which means traverse all the list.
	public void clear() {
		stack.clear();
	}

	// O(1) for all the cases
		// Get an element from an ArrayList is a constant-time operation
	public T peek() {
		if (isEmpty()) throw new EmptyStackException();
		return stack.get(stack.size() - 1);
	}
}