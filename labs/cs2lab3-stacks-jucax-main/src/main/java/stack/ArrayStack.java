package stack;

import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T> {

	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	private T[] stack;
	private int topIndex;
	private boolean integrityOK;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		integrityOK = false;
		checkCapacity(capacity);

		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		stack = temp;
		topIndex = -1;

		integrityOK = true; // After successul initialization
	}

	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY || capacity <= 0) 
			throw new IllegalStateException("Capacity "+capacity+" is too large.");
	}

	private void checkIntegrity() {
		if(!integrityOK)
			throw new SecurityException("Stack not properly initialized");
	}

	public boolean isEmpty() {
		checkIntegrity();
		return topIndex < 0;	
	}

	public void push(T newEntry) {
		checkIntegrity();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	private void ensureCapacity() {
		if(topIndex == stack.length - 1) { // Array is full!
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			// Copies all elements of stack to a new array with length of newLength
			stack = Arrays.copyOf(stack, newLength);
		}
	}

	public T pop() {
		checkIntegrity();
		if(isEmpty()) throw new EmptyStackException();
		T result = stack[topIndex];
		stack[topIndex] = null;
		topIndex--;
		return result;
	}

	public void clear() {
		checkIntegrity();
		while (!isEmpty()) pop();
	}

	public T peek() {
		checkIntegrity();
		if(isEmpty()) throw new EmptyStackException();
		return stack[topIndex];
	}
}