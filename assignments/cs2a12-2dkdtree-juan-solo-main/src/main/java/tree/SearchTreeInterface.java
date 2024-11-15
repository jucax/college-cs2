package tree;
import java.util.Iterator;
/**
 * An interface for a search tree.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T> {
	/** Task: Searches for a specific entry in the tree.
	 *  @param entry  an object to be found
	 *  @return true if the object was found in the tree */
	public boolean contains(T entry);

	/** Task: Retrieves a specific entry in the tree.
	 *  @param entry  an object to be found
	 *  @return either the object that was found in the tree or
	 *          null if no such object exists */
	public T getEntry(T entry);

	/** Task: Adds a new entry to the tree.
	 *        If the entry matches an object that exists in the tree 
	 *        already, replaces the object with the new entry.
	 *  @param newEntry  an object to be added to the tree
	 *  @return either null if newEntry was not in the tree already, or
	 *          an existing entry that matched the parameter newEntry
	 *          and has been replaced in the tree */
	public T add(T newEntry);

	/** Task: Removes a specific entry from the tree.
	 *  @param entry  an object to be removed
	 *  @return either the object that was removed from the tree or
	 *          null if no such object exists */
	public T remove(T entry);

	/** Task: Creates an iterator that traverses all entries in the tree.
	 *  @return an iterator that provides sequential and ordered access to
	 *          the entries in the tree */
	public Iterator<T> getInorderIterator();
} // end SearchTreeInterface
