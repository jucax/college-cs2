package lists;

public class SortedLinkedListFromLinkedList<T extends Comparable<? super T>> 
				extends LinkedList<T>
				implements SortedListInterface<T> {

	// Inheritance like this is NOT a good example
	public SortedLinkedListFromLinkedList() {
		super();
	}

	
	@Override
	public void add(T newEntry) {
		// SUPER INEFFICIENT!
		int i = 0; // index to add at
		while(i < getLength() && getEntry(i).compareTo(newEntry) < 0) {
			i++;
		}
		//System.out.println("Want to insert "+newEntry+ " at index "+i + " when length is "+getLength());

		// Calls the method defined in parent
		if(i == getLength()) {
			super.add(newEntry);
		} else {
			super.add(i, newEntry);
		}
	}

	@Override
	public void add(int newPosition, T newEntry) {
		throw new UnsupportedOperationException("Will not allow list to become unsorted");
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		throw new UnsupportedOperationException("Will not allow list to become unsorted");
	}

	@Override
	public boolean remove (T anEntry) {
		// DOING THINGS THE BAD WAY AGAIN
		int i = 0; // index to add at
		while(i < getLength() && !getEntry(i).equals(anEntry)) {
			i++;
		}

		if(i < getLength()) {
			super.remove(i);
			return true;
		} else {
			return false; 
		}
	}

	@Override
	public int getPosition (T anEntry) {
		boolean found = false;
		int position = -1;
		int i = 0; // index to add at
		while(i < getLength() && !found) {
			if (getEntry(i).equals(anEntry)) {
				found = true;
				position = i;
			}
			i++;
		}
		return position;
	}           
}