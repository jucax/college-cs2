package lists;

public abstract class BaseLinkedList<T> {

    protected class Node {
		T data;
		Node next;
		protected Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

    protected Node firstNode;
    protected int numberOfElements;

    protected BaseLinkedList() {
        firstNode = null;
        numberOfElements = 0;
    }

    public abstract void add(T newEntry);

    public T remove(int index) {
        if(index < 0 || index >= numberOfElements){
            throw new IndexOutOfBoundsException(index + " out of bounds");
        }
        Node removedNode;
        if(index == 0){
            removedNode = firstNode;
            firstNode = firstNode.next;
        }else{
            Node before = getNodeAt(index - 1);
            removedNode = before.next;
            before.next = removedNode.next;
        }
        numberOfElements--;
        return removedNode.data;
    }

	public void clear() {
		firstNode = null;
		numberOfElements = 0;
	}    

	public T getEntry(int givenPosition) {
		return getNodeAt(givenPosition).data;
	}

	/**
	 * Return the Node at the given index in the list
	 * @param position Index in the list
	 * @return Node at that position (0-based indexing)
	 */
	protected Node getNodeAt(int position) {
		if(0 > position || position >= numberOfElements)
			throw new IndexOutOfBoundsException(position + " out of bounds");
		Node current = firstNode; // index 0
		for(int i = 0; i < position; i++) {
			current = current.next;
		}
		return current;
	}

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

	public int getLength() {
		return numberOfElements;
	}

	public boolean isEmpty() {
		return numberOfElements == 0;
	}
}