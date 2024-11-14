package list;
import java.util.ListIterator;

/**
 * For a list that also supports a ListIterator
 * 
 * @author Frank M. Carrano
 */
public interface ListWithListIteratorInterface<T> extends Iterable<T>, ListInterface<T> {
	/**
	 * Returns ListIterator across the list.
	 * @return a ListIterator for this list.
	 */
	public ListIterator<T> getIterator();
}
