package client;

import queues.*;

public class UseQueue {

	// Call methods from here to test/debug
	public static void main(String[] args) {
		
	}

	/**
	 * Dequeue elements from the queue, printing each on its own line
	 * to the console, until the target element is found. After printing
	 * the first occurrence of the target element, print FOUND on the 
	 * following line. If the queue is emptied and the target is never
	 * found, then print NOT FOUND on the final line.
	 * 
	 * @param <T> type of elements in the queue
	 * @param queue A queue to search
	 * @param target Element being searched for
	 */
	public static <T> void printUntil(QueueInterface<T> queue, T target) {
		boolean found = false;

		while (!queue.isEmpty() && !found){
			T element = queue.dequeue();
			System.out.println(element);

			if(element.equals(target)) found = true;
		}

		if (found) System.out.println("FOUND");
		else System.out.println("NOT FOUND");
	}

	/**
	 * Create a new queue with nothing but a certain number of copies
	 * of a given element enqueued.
	 * 
	 * @param <T> type of element
	 * @param count number of element to add to queue
	 * @param element the element to add
	 * @return queue with count copies of the element
	 */
	public static <T> QueueInterface<T> queueWithXOfY(int count, T element) {
		QueueInterface<T> newQueue = new MysteryQueue<>();

		for (int i = 0 ; i < count ; i ++) newQueue.enqueue(element);
		return newQueue;
	}

	/**
	 * Transfer a certain number of items from the source queue to the target queue.
	 * Elements dequeued from the source are enqueued in the target. If the source
	 * runs out of elements before all are transferred, simply stop.
	 * 
	 * @param <T> Type of elements in both queues
	 * @param source Queue that elements are dequeued from
	 * @param target Queue that elements are enqueued into
	 * @param count max number of elements to transfer
	 */
	public static <T> void transfer(QueueInterface<T> source, QueueInterface<T> target, int count) {
		int i = 0; 
		while (!source.isEmpty() && i < count) {
			target.enqueue(source.dequeue());
			 i++;
		}
	}

	/**
	 * Remove all even numbers from the queue. At the completion
	 * of the method, the queue should contain only odd numbers,
	 * and they should be in the same relative order that they 
	 * were in at the start.
	 * 
	 * @param nums Queue of integers
	 */
	public static void filterEvens(QueueInterface<Integer> nums) {
		QueueInterface<Integer> tempQueue = new MysteryQueue<>();
		int count = 0;
		while (!nums.isEmpty()) {
			int element = nums.dequeue();
			if (element % 2 == 1) tempQueue.enqueue(element);
			count ++;
		}
		transfer(tempQueue, nums, count);
	}

	/**
	 * At the completion of the method, all elements of the given queue
	 * will be in the same order, but each individual element will be
	 * replaced with two copies of that given element.
	 * 
	 * @param <T> Type of the elements
	 * @param queue Queue of elements
	 */
	public static <T> void doubleElements(QueueInterface<T> queue) {
		QueueInterface<T> tempQueue = new MysteryQueue<>();
		int count = 0;
		while (!queue.isEmpty()) {
			T element = queue.dequeue();
			tempQueue.enqueue(element);
			tempQueue.enqueue(element);
			count += 2;
		}
		transfer(tempQueue, queue, count);
	}
}
