package heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {

	MinHeap<Integer> intHeap;
	MinHeap<Double> doubleHeap;
	MinHeap<String> emptyHeap;

	@BeforeEach
	public void setUp() throws Exception {
		intHeap = new MinHeap<Integer>();
		intHeap.add(1);
		intHeap.add(2);
		intHeap.add(3);
		intHeap.add(4);
		intHeap.add(5);
		intHeap.add(6);
		intHeap.add(7);
		intHeap.add(8);
		intHeap.add(9);
		intHeap.add(10);
		intHeap.add(11);

		doubleHeap = new MinHeap<Double>();
		doubleHeap.add(100.0);
		doubleHeap.add(-100.0);
		doubleHeap.add(0.34);
		doubleHeap.add(20023.3);
		doubleHeap.add(-0.123);
		doubleHeap.add(Double.POSITIVE_INFINITY);
		doubleHeap.add(1000.0000213);
		doubleHeap.add(0.34);
		doubleHeap.add(100.03);
		doubleHeap.add(-100.0);
		doubleHeap.add(0.0);
		doubleHeap.add(-0.123);

		emptyHeap = new MinHeap<String>();
	}

	@Test
	public void testAdd() {
		intHeap.add(20);
		assertEquals(Integer.valueOf(1), intHeap.removeMin());
		intHeap.add(0);
		assertEquals(Integer.valueOf(0), intHeap.removeMin());

		doubleHeap.add(234.3);
		assertEquals(Double.valueOf(-100), doubleHeap.removeMin());
		doubleHeap.add(Double.NEGATIVE_INFINITY);
		assertEquals(Double.valueOf(Double.NEGATIVE_INFINITY), doubleHeap.removeMin());

		emptyHeap.add("test");
		assertEquals("test", emptyHeap.removeMin());
	}

	@Test
	public void testRemoveMin() {
		assertEquals(Integer.valueOf(1), intHeap.removeMin());
		assertEquals(Integer.valueOf(2), intHeap.removeMin());
		assertEquals(Integer.valueOf(3), intHeap.removeMin());
		assertEquals(Integer.valueOf(4), intHeap.removeMin());
		assertEquals(Integer.valueOf(5), intHeap.removeMin());
		assertEquals(Integer.valueOf(6), intHeap.removeMin());
		assertEquals(Integer.valueOf(7), intHeap.removeMin());
		assertEquals(Integer.valueOf(8), intHeap.removeMin());
		assertEquals(Integer.valueOf(9), intHeap.removeMin());
		assertEquals(Integer.valueOf(10), intHeap.removeMin());
		assertEquals(Integer.valueOf(11), intHeap.removeMin());
		assertTrue(intHeap.isEmpty());

		assertEquals(Double.valueOf(-100), doubleHeap.removeMin());
		assertEquals(Double.valueOf(-100), doubleHeap.removeMin());
		assertEquals(Double.valueOf(-0.123), doubleHeap.removeMin());
		assertEquals(Double.valueOf(-0.123), doubleHeap.removeMin());
		assertEquals(Double.valueOf(0), doubleHeap.removeMin());
		assertEquals(Double.valueOf(0.34), doubleHeap.removeMin());
		assertEquals(Double.valueOf(0.34), doubleHeap.removeMin());
		assertEquals(Double.valueOf(100), doubleHeap.removeMin());
		assertEquals(Double.valueOf(100.03), doubleHeap.removeMin());
		assertEquals(Double.valueOf(1000.0000213), doubleHeap.removeMin());
		assertEquals(Double.valueOf(20023.3), doubleHeap.removeMin());
		assertEquals(Double.valueOf(Double.POSITIVE_INFINITY), doubleHeap.removeMin());
		assertTrue(doubleHeap.isEmpty());
	}

	@Test
	public void testGetMin() {
		assertEquals(Integer.valueOf(1), intHeap.getMin());
		assertEquals(Integer.valueOf(1), intHeap.getMin());

		assertEquals(Double.valueOf(-100), doubleHeap.getMin());
		assertEquals(Double.valueOf(-100), doubleHeap.getMin());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(intHeap.isEmpty());
		assertFalse(doubleHeap.isEmpty());
		assertTrue(emptyHeap.isEmpty());
	}

	@Test
	public void testGetSize() {
		assertEquals(11, intHeap.getSize());
		assertEquals(12, doubleHeap.getSize());
		assertEquals(0, emptyHeap.getSize());
	}

	@Test
	public void testClear() {
		intHeap.clear();
		assertEquals(0, intHeap.getSize());
		doubleHeap.clear();
		assertEquals(0, doubleHeap.getSize());
		emptyHeap.clear();
		assertEquals(0, emptyHeap.getSize());
	}

}
