package deque;
/**
 * Simple exception used in queue/deque implementations
 * @author Jacob Schrum
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {

	/**
	 * Indicates that the queue/deque is empty
	 */
	public EmptyQueueException() {
		super("Queue is empty");
	}
}
