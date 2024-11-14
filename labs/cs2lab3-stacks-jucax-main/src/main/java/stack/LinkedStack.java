package stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {

	private class Node {
		private T data;
		private Node next;

		private Node (T theData, Node theNext) {
			data = theData;
			next = theNext;
		}
	}

	private Node topNode;

	public LinkedStack() {
		topNode = null;
	}

	public boolean isEmpty() {
		return topNode == null;	
	}

	public void push(T newEntry) {
		Node newNode = new Node (newEntry, topNode);
		topNode = newNode;
	}

	public T pop() {

		if (isEmpty()) throw new EmptyStackException ();
		T result = topNode.data; // T result = peek();
		topNode = topNode.next; // Remove node by garbage collection
		return result;
	}

	public void clear() {
		topNode = null; // Remove by garbage collection
	}

	public T peek() {
		if (isEmpty()) throw new EmptyStackException ();
		else return topNode.data;
	}
}