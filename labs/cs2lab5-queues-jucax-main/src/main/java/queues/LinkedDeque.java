package queues;

public class LinkedDeque<T> implements DequeInterface<T> {

	private class Node {
		private T data;
		private Node previous;
		private Node next;

		private Node(T theData, Node previousNode, Node nextNode) {
			data = theData;
			previous = previousNode;
			next = nextNode;
		}
	}

	private Node firstNode;
	private Node lastNode;

	public LinkedDeque() {
		firstNode = null;
		lastNode = null;
	}

	@Override
	public void addToFront(T element) {
		Node newNode = new Node(element, null, firstNode);
		
		if (isEmpty())
			lastNode = newNode;
		else
			firstNode.previous = newNode;

		firstNode = newNode;
	}

	@Override
	public void addToBack(T element) {
		Node newNode = new Node(element, lastNode, null);
		
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.next = newNode;

		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T front = getFront();
		firstNode = firstNode.next;

		if (firstNode == null)
			lastNode = null;
		else
			firstNode.previous = null;

		return front;
	}

	@Override
	public T removeBack() {
		T back = getBack();
		lastNode = lastNode.previous;

		if (lastNode == null)
			firstNode = null;
		else
			lastNode.next = null;
			
		return back;
	}

	@Override
	public T getFront() {
        if (isEmpty()) 
            throw new EmptyQueueException();
        else 
            return firstNode.data;
	}

	@Override
	public T getBack() {
        if (isEmpty()) 
            throw new EmptyQueueException();
        else 
            return lastNode.data;
	}

	@Override
	public void clear() {
        firstNode = null;
        lastNode = null;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null && lastNode == null; // TODO
	}
}