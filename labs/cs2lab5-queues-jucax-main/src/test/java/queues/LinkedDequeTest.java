package queues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedDequeTest {

	LinkedDeque<Integer> intDeque;
	LinkedDeque<Double> doubleDeque;

	@BeforeEach
	void setUp() throws Exception {
		intDeque = new LinkedDeque<>();
		intDeque.addToFront(9);
		intDeque.addToFront(923);
		intDeque.addToFront(7802);

		doubleDeque = new LinkedDeque<>();
		doubleDeque.addToBack(0.0);
		doubleDeque.addToBack(-23.0);
		doubleDeque.addToBack(56.827);
		doubleDeque.addToBack(-0.82);
	}

	@Test
	void testLinkedDeque() {
		intDeque = new LinkedDeque<>();
		assertTrue(intDeque.isEmpty());
	}

	@Test
	void testAddToFront() {
		intDeque.addToFront(Integer.valueOf(-1000));
		assertEquals(Integer.valueOf(-1000),intDeque.getFront());
		assertEquals(Integer.valueOf(-1000),intDeque.removeFront());

		intDeque.addToFront(99);
		intDeque.removeBack();		
		intDeque.removeBack();		
		intDeque.removeBack();		
		assertEquals(Integer.valueOf(99),intDeque.getBack());
		assertEquals(Integer.valueOf(99),intDeque.removeBack());

		// Similar tests with doubleDeque
	}

	@Test
	void testAddToBack() {
		intDeque.addToBack(Integer.valueOf(-1000));
		assertEquals(Integer.valueOf(-1000),intDeque.getBack());
		assertEquals(Integer.valueOf(-1000),intDeque.removeBack());

		intDeque.addToBack(99);
		intDeque.removeFront();		
		intDeque.removeFront();		
		intDeque.removeFront();		
		assertEquals(Integer.valueOf(99),intDeque.getFront());
		assertEquals(Integer.valueOf(99),intDeque.removeFront());
	}

	@Test
	void testRemoveFront() {

		assertEquals(Integer.valueOf(7802), intDeque.removeFront());
		assertEquals(Integer.valueOf(923), intDeque.removeFront());
		assertEquals(Integer.valueOf(9), intDeque.removeFront());

		assertThrows(EmptyQueueException.class, () -> {
			intDeque.removeFront();
		});
	}

	@Test
	void testRemoveBack() {
		// TODO: call removeBack until empty, check for exception
		assertEquals(Integer.valueOf(9), intDeque.removeBack());
		assertEquals(Integer.valueOf(923), intDeque.removeBack());
		assertEquals(Integer.valueOf(7802), intDeque.removeBack());

		assertThrows(EmptyQueueException.class, () -> {
			intDeque.removeBack();
		});
	}

	@Test
	void testGetFront() {
		assertEquals(Integer.valueOf(7802), intDeque.getFront());
		assertEquals(Integer.valueOf(7802), intDeque.removeFront());
		assertEquals(Integer.valueOf(923), intDeque.getFront());
		assertEquals(Integer.valueOf(923), intDeque.removeFront());
		assertEquals(Integer.valueOf(9), intDeque.getFront());
		assertEquals(Integer.valueOf(9), intDeque.removeFront());

		assertThrows(EmptyQueueException.class, () -> {
			intDeque.getFront();
		});
	}

	@Test
	void testGetBack() {
		// TODO: Similar to getFront above, but from back instead
		assertEquals(Integer.valueOf(9), intDeque.getBack());
		assertEquals(Integer.valueOf(9), intDeque.removeBack());
		assertEquals(Integer.valueOf(923), intDeque.getBack());
		assertEquals(Integer.valueOf(923), intDeque.removeBack());
		assertEquals(Integer.valueOf(7802), intDeque.getBack());
		assertEquals(Integer.valueOf(7802), intDeque.removeBack());

		assertThrows(EmptyQueueException.class, () -> {
			intDeque.getBack();
		});
	}

	@Test
	void testClear() {
		// TODO
		assertFalse(intDeque.isEmpty());
		intDeque.clear();
		assertTrue(intDeque.isEmpty());
	}

	@Test
	void testIsEmpty() {
		// TODO
		assertFalse(intDeque.isEmpty());
		intDeque.removeFront();
		intDeque.removeFront();
		intDeque.removeFront();
		assertTrue(intDeque.isEmpty());

	}   

}