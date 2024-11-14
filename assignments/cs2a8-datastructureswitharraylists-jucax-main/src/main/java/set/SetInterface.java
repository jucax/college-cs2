package set;
/**
 * An interface that describes the operations of a set of objects
 * @author Frank M. Carrano
 */
public interface SetInterface<T> {
	/**
	 * Return size of set
	 * @return Number of elements in the set
	 */
	public int getCurrentSize();
	/**
	 * Determine whether the set is empty
	 * @return True if the set is empty, false otherwise
	 */
	public boolean isEmpty();
	/**
	 * Adds a new entry to this set, avoiding duplicates.
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if
	 *         the item is already in the set.
	 */
	public boolean add(T newEntry);
	/**
	 * Removes a specific entry from this set, if possible.
	 * @param anEntry The entry to be removed
	 * @return True if the removal was successful, or false if not
	 */
	public boolean remove(T anEntry);
	/**
	 * Remove an arbitrary element from the set.
	 * @return The element that is removed, or null if the
	 *         set is empty.
	 */
	public T remove();
	/**
	 * Remove all elements from the set.
	 */
	public void clear();
	/**
	 * Determine if an element is in the set.
	 * @param anEntry Element to search for in the set.
	 * @return True if the element is in the set, false otherwise.
	 */
	public boolean contains(T anEntry);
	/**
	 * Return all elements in the set within an array.
	 * @return Array of elements in the set.
	 */
	public T[] toArray();
}
