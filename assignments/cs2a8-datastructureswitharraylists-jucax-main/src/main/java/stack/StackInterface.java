package stack;
/**
 * Interface for stack abstract data type.
 * 
 * @author Frank M. Carrano
 */
public interface StackInterface<T> {
	/**
	 * Add element to top of stack.
	 * @param newEntry item to add to stack.
	 */
	public void push(T newEntry);
	/**
	 * Remove and return top element from stack.
	 * @return top element
	 * @throws EmptyStackException if stack is empty
	 */
	public T pop();
	/**
	 * Return top element from stack without modifying stack.
	 * @return Element on top of stack.
	 * @throws EmptyStackException if stack is empty
	 */
	public T peek();
	/**
	 * Whether stack is empty.
	 * @return True if stack is empty, false otherwise.
	 */
	public boolean isEmpty();
	/**
	 * Remove all elements from stack.
	 */
	public void clear();
}
