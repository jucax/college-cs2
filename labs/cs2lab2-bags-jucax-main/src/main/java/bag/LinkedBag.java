package bag;

/**
 * This class will be implemented the third day we work
 * using this lab.
 * 
 * This is a skeleton for the LinkedBag implementation
 * detailed in our text book.
 * 
 * @author Jacob Schrum
 */
public class LinkedBag<T> implements BagInterface<T> {

	private class Node {
		private T data;
		private Node next;

		private Node(T newData, Node nextNode){
			data = newData;
			next = nextNode;
		}
	}

	private Node firstNode;
	private int numberOfEntries;

	public LinkedBag() {
		firstNode = null;
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
		/* Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode; */

		firstNode = new Node (newEntry, firstNode);
		numberOfEntries++;
		
		return true; //While the computer has memory is always going to be true
	}

	@Override
	public T remove() {
		/*T result = null;

		if (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}

		return result;*/
		T result = null;

		if (!isEmpty()) {
			result = firstNode.data;
			numberOfEntries--;
			firstNode = firstNode.next;
		}

		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		for (Node current = firstNode ; current != null ; current = current.next) {
			if (anEntry.equals(current.data)) {
				current.data = firstNode.data;
				remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		// while (!isEmpty()) remove();
		// Works because of garbage collection
		firstNode = null;
		numberOfEntries = 0;

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;

		for (Node current = firstNode ; current != null ; current = current.next) {
			if (anEntry.equals(current.data)) {
				counter ++;
			}
		}

		return counter;
	}

	@Override
	public boolean contains(T anEntry) {
		/*boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data)) found = true;
			else currentNode = currentNode.next;
		}

			return found; */

		for (Node current = firstNode ; current != null ; current = current.next) {
			if (anEntry.equals(current.data)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;

		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}

		return result;
	}
}