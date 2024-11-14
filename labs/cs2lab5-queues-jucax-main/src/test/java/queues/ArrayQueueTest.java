package queues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	ArrayQueue<Integer> intQueue;

	ArrayQueue<Double> doubleQueue;

	@BeforeEach
	void setUp() throws Exception {
		intQueue = new ArrayQueue<>(); // capacity 25
		intQueue.enqueue(5);
		intQueue.enqueue(7);


		doubleQueue = new ArrayQueue<>(4);
		doubleQueue.enqueue(0.0);
		doubleQueue.enqueue(1.0);
		doubleQueue.enqueue(2.0);

	}

	@Test
	void testArrayQueue() {

	}

	@Test
	void testArrayQueueInt() {

	}

	@Test
	void testEnqueue() {
		intQueue.enqueue(9);
		assertEquals(Integer.valueOf(5), intQueue.dequeue());
		assertEquals(Integer.valueOf(7), intQueue.dequeue());
		assertEquals(Integer.valueOf(9), intQueue.dequeue());


		doubleQueue.enqueue(3.0);
		doubleQueue.enqueue(4.0);
		doubleQueue.enqueue(5.0);
		assertEquals(Double.valueOf(0.0), doubleQueue.dequeue());
		assertEquals(Double.valueOf(1.0), doubleQueue.dequeue());
		assertEquals(Double.valueOf(2.0), doubleQueue.dequeue());
		assertEquals(Double.valueOf(3.0), doubleQueue.dequeue());
		assertEquals(Double.valueOf(4.0), doubleQueue.dequeue());
		assertEquals(Double.valueOf(5.0), doubleQueue.dequeue());


	}

	@Test
	void testDequeue() {
		assertEquals(Integer.valueOf(5), intQueue.dequeue());
		assertEquals(Integer.valueOf(7), intQueue.dequeue());

		assertThrows(EmptyQueueException.class, () -> {
			intQueue.dequeue();
		});
	}

	@Test
	void testGetFront() {
		assertEquals(Integer.valueOf(5), intQueue.getFront());
		assertEquals(Integer.valueOf(5), intQueue.dequeue());
		assertEquals(Integer.valueOf(7), intQueue.getFront());
		assertEquals(Integer.valueOf(7), intQueue.dequeue());

		assertThrows(EmptyQueueException.class, () -> {
			intQueue.getFront();
		});

	}

	@Test
	void testIsEmpty() {
		assertFalse(intQueue.isEmpty());
		// TODO: Add assertTrue test
		intQueue.dequeue();
		intQueue.dequeue();
		assertTrue(intQueue.isEmpty());
	}

	@Test
	void testClear() {
		// TODO
		assertFalse(intQueue.isEmpty());
		intQueue.clear();
		assertTrue(intQueue.isEmpty());
	}
}