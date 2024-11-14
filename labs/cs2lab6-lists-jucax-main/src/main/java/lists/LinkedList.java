package lists;

import java.util.Arrays;
import java.util.Iterator; // since class is Iterable
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListInterface<T>, Iterable<T> {

	private class Node {
		T data;
		Node next;
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node firstNode;
	private Node lastNode;
	private int numberOfElements;

	public LinkedList() {
		firstNode = null;
		lastNode = null;
		numberOfElements = 0;
	}

	@Override
	public void add(T newEntry) { // Adding at the end
		Node newNode = new Node(newEntry, null);
		if(lastNode == null) { // Add first node to empty list
			firstNode = newNode;
		} else { // List is not empty
			lastNode.next = newNode;
		}
		lastNode = newNode;
		numberOfElements++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		if(0 > newPosition || newPosition > numberOfElements)
			throw new IndexOutOfBoundsException(newPosition + " out of bounds");

		if(newPosition == numberOfElements) // Adding at the end
			add(newEntry);

		else {
			Node newNode = new Node (newEntry, null);
			if (isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if (newPosition == 0) { // Case: add at beginning
				newNode.next = firstNode;
				firstNode = newNode;
			} else { // Case: add in middle
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.next;
				newNode.next = nodeAfter;
				nodeBefore.next = newNode;
			}
		numberOfElements++;
		}
	}

	@Override
	public T remove(int index) {
		T result = null;
		if(0 > index || index >= numberOfElements)
			throw new IndexOutOfBoundsException(index + " out of bounds");
		if (index == 0) { // Remove first entry
			result = firstNode.data;
			firstNode = firstNode.next;
			if (numberOfElements == 1) // Solitary entry
				lastNode = null;
		} else { // Not first entry
			Node nodeBefore = getNodeAt(index - 1);
			Node nodeToRemove = nodeBefore.next;
			Node nodeAfter = nodeToRemove.next;
			nodeBefore.next = nodeAfter;
			result = nodeToRemove.data;
			if (index == numberOfElements - 1)
				lastNode = nodeBefore;
		}
		numberOfElements--;
		return result;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		numberOfElements = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		if(0 > givenPosition || givenPosition >= numberOfElements)
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
		Node desiredNode = getNodeAt(givenPosition);
		T originalEntry = desiredNode.data;
		desiredNode.data = newEntry;
		return originalEntry;
	}

	@Override
	public T getEntry(int givenPosition) {
		if(0 > givenPosition || givenPosition >= numberOfElements)
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
		return getNodeAt(givenPosition).data;
	}

	/**
	 * Return the Node at the given index in the list
	 * @param position Index in the list
	 * @return Node at that position (0-based indexing)
	 */
	private Node getNodeAt(int position) {
		if(0 > position || position >= numberOfElements)
			throw new IndexOutOfBoundsException(position + " out of bounds");
		Node current = firstNode; // index 0
		for(int i = 0; i < position; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfElements];
		Node current = firstNode;
		for(int i = 0; i < numberOfElements; i++) {
			result[i] = current.data;
			current = current.next;
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else 
				currentNode = currentNode.next;
		}
		return found;
	}

	@Override
	public int getLength() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	private class LinkedListIterator implements Iterator<T> {

		private Node nextNode;

		private LinkedListIterator() {
			nextNode = firstNode; // start at beginning of array
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();

			T result = nextNode.data;
			nextNode = nextNode.next;

			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
}
