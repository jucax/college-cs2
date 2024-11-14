package lists;

public class SortedArrayListFromArrayList<T extends Comparable<? super T>>
        extends ArrayList<T>
        implements SortedListInterface<T> {

    public SortedArrayListFromArrayList() {
        super();
    }

    public SortedArrayListFromArrayList(int capacity) {
        super(capacity);
    }
        
    public void add(int position, T entry) {
        throw new UnsupportedOperationException("Do not violate sort order");
    }

    public T replace(int position, T entry) {
        throw new UnsupportedOperationException("Do not violate sort order");
    }

    public void add(T entry) {
        // Could use binary search to find, but then we still have to shift to insert
        // So, just use the insert-in-order approach from insertion sort

        // Strange type error?
        // checkInitialized();
        // ensureCapacity();

        // int i = numberOfElements;
        // while(i > 0 && list[i - 1].compareTo(entry) > 0) {
        //     list[i] = list[i-1];
        //     i--;
        // }
        // list[i] = entry;
        // numberOfElements++;

        int position = binarySearch(entry, true);
        super.add(position, entry);
    }    

	/** Task: Removes a specified entry from the sorted list.
	 * @param anEntry the object to be removed
	 * @return true if anEntry was located and removed */
	public boolean remove(T anEntry) {
        int position = binarySearch(anEntry);
        if(position != -1) {
            super.remove(position);
            return true; // found and removed
        } else {
            return false; // not found
        }
    }

	/** Task: Gets the position of an entry in the sorted list.
	 * @param anEntry the object to be found
	 * @return the position of the first or only occurrence of anEntry
	 * if it occurs in the list; otherwise returns -1 */
	public int getPosition (T anEntry) {
        return binarySearch(anEntry);
    }            

    public boolean contains(T anEntry) {
        return binarySearch(anEntry) != -1;
    }

    private int binarySearch(T key) {
        return binarySearch(key, false);
    }

    // If ifNotFound is true, return the index of where the element would be, even if
    // it is not found
    private int binarySearch(T key, boolean ifNotFound) {
        return binarySearch(0, getLength() - 1, key, ifNotFound);
    }

    private int binarySearch(int lo, int hi, T key, boolean ifNotFound) {
        int result = ifNotFound ? lo : -1;
        if(lo <= hi) {
            int m = midpoint(lo,hi);
            if(key.compareTo(getEntry(m)) < 0) {
                result = binarySearch(lo, m-1,key,ifNotFound);
            } else if(key.compareTo(getEntry(m)) > 0) {
                result = binarySearch(m+1,hi,key, ifNotFound);
            } else {
                result = m;
            }
        }
        return result;
    }

    private int midpoint(int lo, int hi) {
        return lo + (hi - lo)/2;
    }
}