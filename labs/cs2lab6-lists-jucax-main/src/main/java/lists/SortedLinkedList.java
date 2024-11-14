package lists;

public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T>{

	private class Node {
		private T data;
		private Node next;
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node firstNode;
	private int numberOfElements;

	public SortedLinkedList() {
		firstNode = null;
		numberOfElements = 0;
	}

	@Override
	public void add(T newEntry) {
		Node newNode = new Node (newEntry, null);
		Node nodeBefore = getNodeBefore(newEntry);
		if (isEmpty() || (nodeBefore == null)) {
			newNode.next = firstNode;
			firstNode = newNode;
		} else {
			Node nodeAfter = nodeBefore.next;
			newNode.next = nodeAfter;
			nodeBefore.next = newNode;
		}
		numberOfElements++;
	}

	private Node getNodeBefore(T anEntry) {
		Node currentNode = firstNode;
		Node nodeBefore = null;
		while ((currentNode != null) && (anEntry.compareTo(currentNode.data) >= 0)) {
			nodeBefore = currentNode;
			currentNode = currentNode.next;
		}
		return nodeBefore;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getPosition(anEntry);
		if (position != -1) {
			remove(position);
			result = true;
		}
		return result;
	}

	@Override
	public int getPosition(T anEntry) {
		if (!contains(anEntry)) return -1;
		Node currentNode = firstNode; // index 0
		int position = 0;
		while ((currentNode != null) && (anEntry.compareTo(currentNode.data) != 0)) {
			currentNode = currentNode.next;
			position++;
		}
		return position;
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
	public T remove(int givenPosition) {
		if(0 > givenPosition || givenPosition >= numberOfElements)
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
		T result = null;
		if (givenPosition == 0) { // Remove first entry
			result = firstNode.data;
			firstNode = firstNode.next;
		} else { // Not first entry
			Node nodeBefore = getNodeAt(givenPosition - 1);
			Node nodeToRemove = nodeBefore.next;
			result = nodeToRemove.data;
			Node nodeAfter = nodeToRemove.next;
			nodeBefore.next = nodeAfter;
		}
		numberOfElements--;
		return result;
	}

	@Override
	public void clear() {
		firstNode = null;
		numberOfElements = 0;
	}

	@Override
	public int getLength() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
}
