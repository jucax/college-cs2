package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

/**
 * This can contain essentially the same tests
 * as the LinkedStackTest
 * 
 * @author Jacob Schrum
 */
class ArrayListStackTest {

	// Array list has this initial capacity 
	private static final int ARRAYLISTSTACK_DEFAULT_CAPACITY = 10;

	ArrayListStack<Integer> intStack;
	ArrayListStack<String> strStack;
	ArrayListStack<Double> douStack;
	ArrayListStack<Integer> emptyStack;

	@BeforeEach
	void setUp() throws Exception {
		intStack = new ArrayListStack<>();
		intStack.push(5);
		intStack.push(6);
		intStack.push(3);
		intStack.push(234);
		intStack.push(5);
		intStack.push(34);
		intStack.push(3);
		intStack.push(500);

		strStack = new ArrayListStack<>();
		strStack.push("one");
		strStack.push("two hundred");
		strStack.push("one hundred eighty");
		strStack.push("nine hundred ninety nine");

		douStack = new ArrayListStack<>();
		douStack.push(1.1);
		douStack.push(200.2);
		douStack.push(180.18);
		douStack.push(999.999);
		douStack.push(85.9);
		douStack.push(100.02);
		
		emptyStack = new ArrayListStack<>();
	}

	// Done for you. Not much to test here.
	@Test
	void testArrayListStack() {
		ArrayListStack<Integer> defaultStack = new ArrayListStack<>();
		for(int i = 0; i < ARRAYLISTSTACK_DEFAULT_CAPACITY; i++) {
			defaultStack.push(i);
			assertEquals(Integer.valueOf(i), defaultStack.peek());
		}
		defaultStack.push(10); // Set is full, but resize automatically
		assertEquals(Integer.valueOf(10), defaultStack.peek());
	}

	@Test
	void testArrayListStackInt() {
		int capacity = 46;
		ArrayListStack<Integer> defaultStack = new ArrayListStack<>(capacity); 
		for(int i = 0; i < capacity; i++) {
			defaultStack.push(i);
			assertEquals(Integer.valueOf(i), defaultStack.peek());
		}
		defaultStack.push(100); // Set is full, but resize automatically
		assertEquals(Integer.valueOf(100), defaultStack.peek());
	}

	@Test
	void testIsEmpty() {
		assertFalse(intStack.isEmpty());
		assertFalse(strStack.isEmpty());
		assertFalse(douStack.isEmpty());
		assertTrue(emptyStack.isEmpty());
	}

	@Test
	void testPush() {
		intStack.push(4);
		assertEquals(Integer.valueOf(4), intStack.peek());
		strStack.push("four");
		assertEquals(String.valueOf("four"), strStack.peek());
		douStack.push(4.4);
		assertEquals(Double.valueOf(4.4), douStack.peek());
	}

	@Test
	void testPop() {
		assertEquals(Integer.valueOf(500),intStack.pop());
		assertEquals(Integer.valueOf(3),intStack.pop());
		assertEquals(Integer.valueOf(34),intStack.pop());
		assertEquals(Integer.valueOf(5),intStack.pop());
		assertEquals(Integer.valueOf(234),intStack.pop());
		assertEquals(Integer.valueOf(3),intStack.pop());
		assertEquals(Integer.valueOf(6),intStack.pop());
		assertEquals(Integer.valueOf(5),intStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			intStack.pop();
		});

		assertEquals(String.valueOf("nine hundred ninety nine"),strStack.pop());
		assertEquals(String.valueOf("one hundred eighty"),strStack.pop());
		assertEquals(String.valueOf("two hundred"),strStack.pop());
		assertEquals(String.valueOf("one"),strStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			strStack.pop();
		});

		assertEquals(Double.valueOf(100.02),douStack.pop());
		assertEquals(Double.valueOf(85.9),douStack.pop());
		assertEquals(Double.valueOf(999.999),douStack.pop());
		assertEquals(Double.valueOf(180.18),douStack.pop());
		assertEquals(Double.valueOf(200.2),douStack.pop());
		assertEquals(Double.valueOf(1.1),douStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			douStack.pop();
		});
	}

	@Test
	void testClear() {
		assertFalse(intStack.isEmpty());
		intStack.clear();
		assertTrue(intStack.isEmpty());
		assertFalse(strStack.isEmpty());
		strStack.clear();
		assertTrue(strStack.isEmpty());
		assertFalse(douStack.isEmpty());
		douStack.clear();
		assertTrue(douStack.isEmpty());
	}

	@Test
	void testPeek() {
		// TODO: Assure correct results from peek, as well as lack
		//       of modification to stack. Assure correct response when
		//       peeking on an empty stack as well.
		assertEquals(Integer.valueOf(500),intStack.peek());
		assertEquals(Integer.valueOf(500),intStack.pop());
		assertEquals(Integer.valueOf(3),intStack.peek());
		assertEquals(Integer.valueOf(3),intStack.pop());
		assertEquals(Integer.valueOf(34),intStack.peek());
		assertEquals(Integer.valueOf(34),intStack.pop());
		assertEquals(Integer.valueOf(5),intStack.peek());
		assertEquals(Integer.valueOf(5),intStack.pop());
		assertEquals(Integer.valueOf(234),intStack.peek());
		assertEquals(Integer.valueOf(234),intStack.pop());
		assertEquals(Integer.valueOf(3),intStack.peek());
		assertEquals(Integer.valueOf(3),intStack.pop());
		assertEquals(Integer.valueOf(6),intStack.peek());
		assertEquals(Integer.valueOf(6),intStack.pop());
		assertEquals(Integer.valueOf(5),intStack.peek());
		assertEquals(Integer.valueOf(5),intStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			intStack.peek();
		});

		assertEquals(String.valueOf("nine hundred ninety nine"),strStack.peek());
		assertEquals(String.valueOf("nine hundred ninety nine"),strStack.pop());
		assertEquals(String.valueOf("one hundred eighty"),strStack.peek());
		assertEquals(String.valueOf("one hundred eighty"),strStack.pop());
		assertEquals(String.valueOf("two hundred"),strStack.peek());
		assertEquals(String.valueOf("two hundred"),strStack.pop());
		assertEquals(String.valueOf("one"),strStack.peek());
		assertEquals(String.valueOf("one"),strStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			strStack.pop();
		});

		assertEquals(Double.valueOf(100.02),douStack.peek());
		assertEquals(Double.valueOf(100.02),douStack.pop());
		assertEquals(Double.valueOf(85.9),douStack.peek());
		assertEquals(Double.valueOf(85.9),douStack.pop());
		assertEquals(Double.valueOf(999.999),douStack.peek());
		assertEquals(Double.valueOf(999.999),douStack.pop());
		assertEquals(Double.valueOf(180.18),douStack.peek());
		assertEquals(Double.valueOf(180.18),douStack.pop());
		assertEquals(Double.valueOf(200.2),douStack.peek());
		assertEquals(Double.valueOf(200.2),douStack.pop());
		assertEquals(Double.valueOf(1.1),douStack.peek());
		assertEquals(Double.valueOf(1.1),douStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			douStack.pop();
		});
	}

}