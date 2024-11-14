package list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import java.util.Arrays;

/**
 * This is a linked list class in which all nodes
 * have two links: one in each direction. Each node
 * has a link to its preceding node and another link
 * to its following node. A good procedure for writing
 * this code is to start with the standard linked list
 * code from the book, and then modify it to have           
 * doubly linked nodes. Also, keep in mind that unlike
 * the code described in the book, this list should be            
 * 0-indexed (the book code has 1 as the first list index).
 *
 * @author Jacob Schrum
 */
public class DoublyLinkedList<T> implements ListWithListIteratorInterface<T> {

	// You can construct instances of lists in this main method 
	// and test out the methods. This could be easier than using
	// the unit tests for certain types of debugging.
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.add(5);
		System.out.println(Arrays.toString(list.toArray()));
	}

	/**
	 * This internal class represents a doubly-linked node,
	 * meaning that each node has a reference to the preceding
	 * node, and another reference to the following node.
	 */
	private class DoublyLinkedNode {
		private T data; // data in node
		private DoublyLinkedNode prev; // previous node
		private DoublyLinkedNode next; // next node

		/**
		 * Creates new node.
		 * @param prev Reference/link to previous node in chain. Null for first node.
		 * @param data Data/value in the node.
		 * @param next Reference/link to next node in chain. Null for last node.
		 */
		public DoublyLinkedNode(DoublyLinkedNode prev, T data, DoublyLinkedNode next) {
			this.prev = prev;
			this.data = data;              
			this.next = next;
		}

		/**
		 * Getter for previous node
		 * @return previous node
		 */
		public DoublyLinkedNode getPrevious() { return prev; }
		/**
		 * Getter for next node
		 * @return next node
		 */
		public DoublyLinkedNode getNext() { return next; }
		/**
		 * Getter for data
		 * @return data
		 */
		public T getData() { return data; }
		/**
		 * Setter for next node
		 * @param newNext New value of next node
		 */
		public void setNext(DoublyLinkedNode newNext) {
			this.next = newNext;
		}
		/**
		 * Setter for previous node
		 * @param newPrev New value of previous node
		 */
		public void setPrevious(DoublyLinkedNode newPrev) {
			this.prev = newPrev;
		}
		/**
		 * Setter for data
		 * @param newData New value of data
		 */
		public void setData(T newData) {
			this.data = newData;
		}
	}

	private DoublyLinkedNode firstNode; // Reference to start of list
	private DoublyLinkedNode lastNode; // Reference to end of list
	private int numberOfEntries; // Remember the number of elements in the list

	/**
	 * Creates a new empty list.
	 */
	public DoublyLinkedList() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}

	// O(1) for all the cases
		// Add an element to the end of an doublyLinkedList is a constant-time operation.
	@Override
	public void add(T newEntry) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(null, newEntry, null);

		if (lastNode == null) {
			firstNode = newNode;
		} else {
			lastNode.setNext(newNode);
			newNode.setPrevious(lastNode);
		}

		lastNode = newNode;
		numberOfEntries++;
	}

	// Best case: O(1)
		// Adding an element to the start or end of an doublyLinkedList is a constant-time operation
	// Average and worst case: O(n)
		// If the position to add is somewhere in the middle of the list, it requires 
		// traversing through the list to find the node before the new position
	@Override
	public void add(int newPosition, T newEntry) {
		if (0 > newPosition || newPosition > numberOfEntries)
			throw new IndexOutOfBoundsException(newPosition + "out of bounds");

		if (newPosition == numberOfEntries) //Add at the end
			add(newEntry);
		else {
			DoublyLinkedNode newNode = new DoublyLinkedNode(null, newEntry, null);
			if (isEmpty()) {
				firstNode = newNode;
				lastNode = newNode;
			} else if (newPosition == 0){ //Add at the beginning
				newNode.setNext(firstNode);
				firstNode.setPrevious(newNode);
				firstNode = newNode;
			} else { //Add at the middle
				DoublyLinkedNode nodeBefore = getNodeAt(newPosition - 1);
				DoublyLinkedNode nodeAfter = nodeBefore.getNext();
				newNode.setNext(nodeAfter);
				nodeAfter.setPrevious(newNode);
				newNode.setPrevious(nodeBefore);
				nodeBefore.setNext(newNode);
			}

			numberOfEntries++;
		}
	}

	// Best case: O(1)
		// When the element is at the start or the end of the doublyLinkedList is a constant-time operation
	// Average and worst case: O(n)
		// If the position to remove is somewhere in the middle of the list it requires traversing the 
		// list to find the appropriate position for removal
	@Override
	public T remove(int givenPosition) {
		T result = null;
		if (0 > givenPosition || givenPosition >= numberOfEntries)
			throw new IndexOutOfBoundsException(givenPosition + "out of bounds");

		if (givenPosition == 0) { //Remove first element
			result = firstNode.getData();
			if (numberOfEntries == 1) //Solitary entry
				lastNode = null;
			else {
				firstNode = firstNode.getNext();
				firstNode.setPrevious(null);
			}
		} else { //Not first entry
			DoublyLinkedNode nodeBefore = getNodeAt(givenPosition - 1);
			DoublyLinkedNode nodeToRemove = nodeBefore.getNext();
			DoublyLinkedNode nodeAfter = nodeToRemove.getNext();
			nodeBefore.setNext(nodeAfter);
			if (givenPosition == numberOfEntries - 1) //Last element 
				lastNode = nodeBefore;
			else {
				nodeAfter.setPrevious(nodeBefore);
			}
			result = nodeToRemove.getData();
		}
		numberOfEntries--;
		return result;
	}

	// O(1) for all the cases
		// Clear all the elements from the doublyLinkedList is a constant-time operation
		// due to garbage collection
	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}

	// Best case: O(1)
		// When the element is at the start or the end of the doublyLinkedList is a constant-time operation
	// Average and worst case: O(n)
		// If the position to replace is somewhere in the middle of the list it requires traversing the 
		// list to find the appropriate position to replace
	@Override
	public T replace(int givenPosition, T newEntry) {
		if (0 > givenPosition || givenPosition > numberOfEntries)
			throw new IndexOutOfBoundsException(givenPosition + "out of bounds");

		DoublyLinkedNode desiredNode = getNodeAt(givenPosition);
		T originalEntry = desiredNode.getData();
		desiredNode.setData(newEntry);
		return originalEntry;
	}

	// Best case: O(1)
		// When the element is at the start or the end of the doublyLinkedList is a constant-time operation
	// Average and worst case: O(n)
		// If the position of the entry is somewhere in the middle of the list it requires traversing the 
		// list to find the appropriate position to get the entry
	@Override
	public T getEntry(int givenPosition) {
		if (0 > givenPosition || givenPosition > numberOfEntries)
			throw new IndexOutOfBoundsException(givenPosition + "out of bounds");

		return getNodeAt(givenPosition).getData();
	}

	// Best case: O(1)
		// When the element is at the start or the end of the doublyLinkedList is a constant-time operation
	// Average and worst case: O(n)
		// If the position of the entry is somewhere in the middle of the list it requires traversing the 
		// list to find the appropriate position to get the node,  the traversal may start from either the 
		// beginning or the end of the list, depending on the position. This is the extra efficiency that 
		// the DoublyLinkedNode provide.
	/**
	 * Return the Node at the given index in the list
	 * @param position Index in the list
	 * @return Node at that position (0-based indexing)
	 */
	private DoublyLinkedNode getNodeAt(int position) {
		if(0 > position || position >= numberOfEntries)
			throw new IndexOutOfBoundsException(position + " out of bounds");

		DoublyLinkedNode current = null;
		if (position < numberOfEntries / 2) {
			current = firstNode; // index 0
			for(int i = 0; i < position; i++) {
				current = current.getNext();
			}
		} else {
			current = lastNode; // index numberOfEntries - 1
			for(int i = numberOfEntries - 1; i > position; i--) {
				current = current.getPrevious();
			}
		}
		return current;
	}

	// O(n) for all the cases
		// Convert the doublyLinkedList to an array involves traverse and copying each element 
		// to a new array
	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		DoublyLinkedNode current = firstNode;
		for (int i = 0 ; i < numberOfEntries ; i++) {
			result[i] = current.getData();
			current = current.getNext();
		}
		return result;
	}

	// Best case: O(1)
		// When the element is at the start of the doublyLinkedList is a constant-time operation
	// Average and worst case: O(n)
		// When the element is at the beginning or middle of the doublyLinkedList, or when it 
		// is not in the arrayList, it needs to traverse the list and check each element. 
		// It uses the doublyLinkedNodes to traverse both forward and backward simultaneously and
		// improve the efficiency a little.
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		DoublyLinkedNode currentNodeForward = firstNode;
		DoublyLinkedNode currentNodeBackward = lastNode;
		while (!found && (currentNodeForward != null) && (currentNodeBackward != null)) {
			if (anEntry.equals(currentNodeForward.getData()))
				found = true;
			else 
				currentNodeForward = currentNodeForward.getNext(); //Go forward

			if (anEntry.equals(currentNodeBackward.getData()))
				found = true;
			else 
				currentNodeBackward = currentNodeBackward.getPrevious(); //Go backward
		}
		return found;
	}

	// O(1) for all the cases
		// Return the variable numberOfEntries is a constant-time operation
	@Override
	public int getLength() {
		return numberOfEntries;
	}

	// O(1) for all the cases
		// Comparison of the size of the doublyLinkedList to zero is a constant-time operation
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	// This enumeration is used inside the DoublyLinkedListIterator to track
	// what the last iterator action was. Remembering this action is important
	// for several methods in the ListIterator.
	private enum Move {NEXT, PREVIOUS};

	/**
	 * This internal class is a ListIterator for the DoublyLinkedList.
	 * All methods must be implemented, thus enabling traversal of the
	 * list in both directions, as well as additions, removals, and
	 * checking of list indices. The textbook provides a ListIterator
	 * for an array-based list. The implementation details for this             
	 * doubly-linked list are very different, but looking at that code 
	 * can help guide you in writing this class.           
	 *              
	 * WARNING! Do not access any methods of the DoublyLinkedList by
	 * using DoublyLinkedList.this or any other means. Although this 
	 * technique is used in the book's implementation of the array-based 
	 * list, that approach would be inefficient for the DoublyLinkedList.
	 * You can and must access the instance variables from the 
	 * DoublyLinkedList class, but do not call any of its methods!
	 * 
	 * The exact requirements of the ListIterator are part of the Java API:
	 * https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
	 */
	private class DoublyLinkedListIterator implements ListIterator<T> {

		// DO NOT ADD ANY ADDITIONAL GLOBAL INSTANCE VARIABLES!

		// When next is called, the value from this node will be returned
		private DoublyLinkedNode nextNode;
		// Index in the list of the nextNode
		private int nextIndex;
		// Determines whether set or remove throw exceptions. Compare with
		// the ListIteratorForArrayList from the book.
		private boolean isRemoveOrSetLegal;
		// Track the last move made (next or previous) so that 
		// set and remove methods target the correct list elements.
		private Move lastMove;

		/**
		 * Initialize the iterator to begin at the front of the list.
		 */
		public DoublyLinkedListIterator(){
			nextNode = firstNode;
			nextIndex = 0;
			isRemoveOrSetLegal = false;
			lastMove = null;
		}

		@Override
		public void add(T data) {
			// TODO: 4 points
			isRemoveOrSetLegal = false;
			DoublyLinkedNode newNode = new DoublyLinkedNode(null, data, null);
			if (nextIndex == numberOfEntries) { //Add at the end
				if (lastNode == null) //Only element
					firstNode = newNode;
				else {
					lastNode.setNext(newNode);
					newNode.setPrevious(lastNode);
				}
				lastNode = newNode;
			} else if (nextIndex == 0) { //Add at the beginning
				newNode.setNext(firstNode);
				firstNode.setPrevious(newNode);
				firstNode = newNode;
			} else {
				DoublyLinkedNode nodeBefore = nextNode.getPrevious();
				nodeBefore.setNext(newNode);
				newNode.setPrevious(nodeBefore);
				newNode.setNext(nextNode);
				nextNode.setPrevious(newNode);
			}
			numberOfEntries++;
			nextIndex++;
		}

		@Override
		public boolean hasNext() {
			// TODO: 2 points
			return nextNode != null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO: 2 points
			return (nextIndex > 0);
		}

		@Override
		public T next() {
			// TODO: 3 points
			if(!hasNext()) throw new NoSuchElementException();

			T result = nextNode.getData();
			nextNode = nextNode.getNext();
			lastMove = Move.NEXT;
			isRemoveOrSetLegal = true;
			nextIndex++;

			return result;
		}

		@Override
		public int nextIndex() {
			// TODO: 3 points
			int result;
			if (hasNext())
				result = nextIndex;
			else 
				result = numberOfEntries;
			return result;
		}

		@Override
		public T previous() {
			// TODO: 3 points
			if(!hasPrevious()) throw new NoSuchElementException();

			lastMove = Move.PREVIOUS;
			isRemoveOrSetLegal = true;
			T result;
			if (nextNode != null) {
				nextNode = nextNode.getPrevious();
				result = nextNode.getData();
			} else {
				nextNode = lastNode;
				result = lastNode.getData();
			}
			
			nextIndex--;

			return result;
		}

		@Override
		public int previousIndex() {
			// TODO: 3 points
			int result;
			if (hasPrevious())
				result = nextIndex - 1;
			else 
				result = -1;
			return result;
		}

		@Override
		public void remove() {
			// TODO: 5 points
			if(!isRemoveOrSetLegal) throw new IllegalStateException();

			isRemoveOrSetLegal = false;
			DoublyLinkedNode nodeToRemove = null;

			if (lastMove.equals(Move.NEXT)) {
				if (nextNode != null) nodeToRemove = nextNode.getPrevious();
				else nodeToRemove = lastNode;

					DoublyLinkedNode nodeBefore = nodeToRemove.getPrevious();
					DoublyLinkedNode nodeAfter = nodeToRemove.getNext();

				if (nodeBefore != null) 
					nodeBefore.setNext(nodeAfter);
				else 
					firstNode = nodeAfter;
				if (nodeAfter != null) 
					nodeAfter.setPrevious(nodeBefore);
				else 
					lastNode = nodeBefore;

				nextIndex--;
			} else {
				nodeToRemove = nextNode;
				DoublyLinkedNode nodeBefore = nodeToRemove.getPrevious();
				DoublyLinkedNode nodeAfter = nodeToRemove.getNext();

				if (nodeBefore != null) 
					nodeBefore.setNext(nodeAfter);
				else 
					firstNode = nodeAfter;
				if (nodeAfter != null) 
					nodeAfter.setPrevious(nodeBefore);
				else 
					lastNode = nodeBefore;
				
				nextNode = nodeAfter; // Update nextNode reference
			}

			numberOfEntries--;
		}
	

		@Override
		public void set(T data) {
			// TODO: 5 points
			if(!isRemoveOrSetLegal) throw new IllegalStateException();

			DoublyLinkedNode nodeToChange = null;
			if (lastMove.equals(Move.NEXT)) {
				if (nextNode != null) 
					nodeToChange = nextNode.getPrevious();
				else
					nodeToChange = lastNode;
				nodeToChange.setData(data);
			} else {
				nextNode.setData(data);
			}
		}
	}

	/**
	 * This method comes from the Iterable interface,
	 * but it simply calls getIterator.
	 */
	@Override
	public Iterator<T> iterator() {
		return getIterator();
	}

	/**
	 * This is from the ListWithListIteratorInterface
	 * interface, and it is needed because it directly
	 * returns a ListIterator instead of a plain Iterator.
	 */
	@Override
	public ListIterator<T> getIterator() {
		return new DoublyLinkedListIterator();
	}	
}            
