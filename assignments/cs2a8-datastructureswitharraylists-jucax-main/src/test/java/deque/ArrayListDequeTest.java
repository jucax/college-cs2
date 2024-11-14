package deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListDequeTest {

	// Array list has this initial capacity 
	private static final int ARRAYLISTDEQUE_DEFAULT_CAPACITY = 10;

	ArrayListDeque<Integer> intDeque;
	ArrayListDeque<Double> doubleDeque;

	@BeforeEach
	void setUp() throws Exception {
		intDeque = new ArrayListDeque<>();
		intDeque.addToFront(9);
		intDeque.addToFront(923);
		intDeque.addToFront(7802);

		doubleDeque = new ArrayListDeque<>();
		doubleDeque.addToBack(0.0);
		doubleDeque.addToBack(-23.0);
		doubleDeque.addToBack(56.827);
		doubleDeque.addToBack(-0.82);
	}

	@Test
	void testArrayListDeque() {
		ArrayListDeque<Integer> defaultDeque = new ArrayListDeque<>(); // Capacity should be 10
		for(int i = 0; i < ARRAYLISTDEQUE_DEFAULT_CAPACITY; i++) {
			defaultDeque.addToBack(i);
			assertEquals(Integer.valueOf(i),defaultDeque.getBack());
		}
		defaultDeque.addToBack(10); // Set is full, but resize automatically
		assertEquals(Integer.valueOf(10),defaultDeque.getBack());
	}

	@Test
	void testArrayListDequeInt() {
		int capacity = 46;
		ArrayListDeque<Integer> defaultDeque = new ArrayListDeque<>(capacity); 
		for(int i = 0; i < capacity; i++) {
			defaultDeque.addToBack(i);
			assertEquals(Integer.valueOf(i),defaultDeque.getBack());
		}
		defaultDeque.addToBack(100); // Set is full, but resize automatically
		assertEquals(Integer.valueOf(100),defaultDeque.getBack());
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
		doubleDeque.addToFront(Double.valueOf(223.8543));
		assertEquals(Double.valueOf(223.8543),doubleDeque.getFront());
		assertEquals(Double.valueOf(223.8543),doubleDeque.removeFront());

		doubleDeque.addToFront(98.87462);
		doubleDeque.removeBack();		
		doubleDeque.removeBack();		
		doubleDeque.removeBack();		
		doubleDeque.removeBack();	
		assertEquals(Double.valueOf(98.87462),doubleDeque.getBack());
		assertEquals(Double.valueOf(98.87462),doubleDeque.removeBack());
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

		doubleDeque.addToBack(Double.valueOf(223.8543));
		assertEquals(Double.valueOf(223.8543),doubleDeque.getBack());
		assertEquals(Double.valueOf(223.8543),doubleDeque.removeBack());

		doubleDeque.addToBack(98.87462);
		doubleDeque.removeFront();		
		doubleDeque.removeFront();		
		doubleDeque.removeFront();		
		doubleDeque.removeFront();	
		assertEquals(Double.valueOf(98.87462),doubleDeque.getFront());
		assertEquals(Double.valueOf(98.87462),doubleDeque.removeFront());
	}

	@Test
	void testRemoveFront() {

		assertEquals(Integer.valueOf(7802), intDeque.removeFront());
		assertEquals(Integer.valueOf(923), intDeque.removeFront());
		assertEquals(Integer.valueOf(9), intDeque.removeFront());

		assertThrows(EmptyQueueException.class, () -> {
			intDeque.removeFront();
		});

		assertEquals(Double.valueOf(0.0), doubleDeque.removeFront());
		assertEquals(Double.valueOf(-23.0), doubleDeque.removeFront());
		assertEquals(Double.valueOf(56.827), doubleDeque.removeFront());
		assertEquals(Double.valueOf(-0.82), doubleDeque.removeFront());

		assertThrows(EmptyQueueException.class, () -> {
			doubleDeque.removeFront();
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

		assertEquals(Double.valueOf(-0.82), doubleDeque.removeBack());
		assertEquals(Double.valueOf(56.827), doubleDeque.removeBack());
		assertEquals(Double.valueOf(-23.0), doubleDeque.removeBack());
		assertEquals(Double.valueOf(0.0), doubleDeque.removeBack());

		assertThrows(EmptyQueueException.class, () -> {
			doubleDeque.removeBack();
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

		assertEquals(Double.valueOf(0.0), doubleDeque.getFront());
		assertEquals(Double.valueOf(0.0), doubleDeque.removeFront());
		assertEquals(Double.valueOf(-23.0), doubleDeque.getFront());
		assertEquals(Double.valueOf(-23.0), doubleDeque.removeFront());
		assertEquals(Double.valueOf(56.827), doubleDeque.getFront());
		assertEquals(Double.valueOf(56.827), doubleDeque.removeFront());
		assertEquals(Double.valueOf(-0.82), doubleDeque.getFront());
		assertEquals(Double.valueOf(-0.82), doubleDeque.removeFront());

		assertThrows(EmptyQueueException.class, () -> {
			doubleDeque.getFront();
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

		assertEquals(Double.valueOf(-0.82), doubleDeque.getBack());
		assertEquals(Double.valueOf(-0.82), doubleDeque.removeBack());
		assertEquals(Double.valueOf(56.827), doubleDeque.getBack());
		assertEquals(Double.valueOf(56.827), doubleDeque.removeBack());
		assertEquals(Double.valueOf(-23.0), doubleDeque.getBack());
		assertEquals(Double.valueOf(-23.0), doubleDeque.removeBack());
		assertEquals(Double.valueOf(0.0), doubleDeque.getBack());
		assertEquals(Double.valueOf(0.0), doubleDeque.removeBack());

		assertThrows(EmptyQueueException.class, () -> {
			doubleDeque.getBack();
		});
	}

	@Test
	void testClear() {
		// TODO
		assertFalse(intDeque.isEmpty());
		intDeque.clear();
		assertTrue(intDeque.isEmpty());

		assertFalse(doubleDeque.isEmpty());
		doubleDeque.clear();
		assertTrue(doubleDeque.isEmpty());
	}

	@Test
	void testIsEmpty() {
		// TODO
		assertFalse(intDeque.isEmpty());
		intDeque.removeFront();
		intDeque.removeFront();
		intDeque.removeFront();
		assertTrue(intDeque.isEmpty());

		assertFalse(doubleDeque.isEmpty());
		doubleDeque.removeFront();
		doubleDeque.removeFront();
		doubleDeque.removeFront();
		doubleDeque.removeFront();
		assertTrue(doubleDeque.isEmpty());

	}   

}