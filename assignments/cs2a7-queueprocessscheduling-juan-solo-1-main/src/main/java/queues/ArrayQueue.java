package queues;

public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        integrityOK = false;
        checkCapacity(capacity);

        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity+1];
        queue = temp;
        frontIndex = 0;
        backIndex = capacity;
        integrityOK = true;
    }

    private void checkCapacity(int capacity) {
        if(capacity <= 0 || capacity > MAX_CAPACITY)
            throw new IllegalStateException("Bad capacity: "+capacity);
    }

    private void checkIntegrity() {
        if(!integrityOK)
            throw new SecurityException("Queue not properly initialized");
    }


	/**
	 * Adds new entry to back of this queue
	 * @param newEntry An object to be added
	 */
	public void enqueue(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize - 1);
            integrityOK = false;

             @SuppressWarnings("unchecked")
             T[] tempQueue = (T[]) new Object[newSize];
             queue = tempQueue;

             for (int index = 0 ; index < oldSize - 1 ; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
             }
            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOK = true;
        }
    }

	/**
	 * Removes and returns the entry at the front of this queue
	 * @return The object at the front of the queue
	 * @throws EmptyQueueException if queue is empty
	 */
	public T dequeue() {
        checkIntegrity();
        if(isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T result = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return result;
        }
    }
	
	/**
	 * Returns entry at front of this queue without modifying it
	 * @return The object at the front of the queue
	 * @throws EmptyQueueException if queue is empty
	 */
	public T getFront() {
        checkIntegrity();
        if (isEmpty()) 
            throw new EmptyQueueException();
        else 
            return queue[frontIndex];
    }
	
	/**
	 * Detects whether the queue is empty
	 * @return True if the queue is empty, false otherwise
	 */
	public boolean isEmpty() {
        checkIntegrity();
        return frontIndex == (backIndex + 1) % queue.length;
    }
	
	/**
	 * Removes all entries from this queue
	 */
	public void clear() {
        checkIntegrity();
        while (!isEmpty()) dequeue();
    }
}