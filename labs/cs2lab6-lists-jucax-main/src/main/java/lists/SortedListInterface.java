package lists;

/** An interface for the ADT sorted list.
 * However, unlike in the book, your list must have 0
 * as the first index instead of 1.
 * I have also simplified the getPosition specification
 * so that you simply return -1 when an item is not present.
 */
public interface SortedListInterface < T extends Comparable < ?super T >>
{
	/** Task: Adds a new entry to the sorted list in its proper order.
	 * @param newEntry the object to be added as a new entry */
	public void add (T newEntry);

	/** Task: Removes a specified entry from the sorted list.
	 * @param anEntry the object to be removed
	 * @return true if anEntry was located and removed */
	public boolean remove (T anEntry);

	/** Task: Gets the position of an entry in the sorted list.
	 * @param anEntry the object to be found
	 * @return the position of the first or only occurrence of anEntry
	 * if it occurs in the list; otherwise returns -1 */
	public int getPosition (T anEntry);

	/** Retrieves the entry at a given position in this list.
    @param givenPosition  An integer that indicates the position of
                          the desired entry.
    @return  A reference to the indicated entry.
    @throws  IndexOutOfBoundsException if either
             givenPosition < 0 or givenPosition >= getLength(). */
	public T getEntry (int givenPosition);

	/** Sees whether this list contains a given entry.
    @param anEntry  The object that is the desired entry.
    @return  True if the list contains anEntry, or false if not. */
	public boolean contains (T anEntry);

	/** Removes the entry at a given position from this list.
    Entries originally at positions higher than the given
    position are at the next lower position within the list,
    and the list's size is decreased by 1.
    @param givenPosition  An integer that indicates the position of
                          the entry to be removed.
    @return  A reference to the removed entry.
    @throws  IndexOutOfBoundsException if either 
             givenPosition < 0 or givenPosition >= getLength(). */
	public T remove (int givenPosition);

	/** Removes all entries from this list. */
	public void clear ();

	/** Gets the length of this list.
    @return  The integer number of entries currently in the list. */
	public int getLength ();

	/** Sees whether this list is empty.
    @return  True if the list is empty, or false if not. */
	public boolean isEmpty ();

} // end SortedListInterface