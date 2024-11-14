package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;               

/**
 * This file will test the stack operations for the
 * LinkedStack. You must provide all tests to verify              
 * correct operation of your stack.             
 * 
 * @author Jacob Schrum
 */
class LinkedStackTest {

	/**
	 * 2 points
	 */
	// TODO: Declare some global stack instances to use in your tests.
	//       You must have multiple stacks, and they must have a variety
	//       of different data types: Integer, String, Double
		LinkedStack<Integer> intStack;
		LinkedStack<String> strStack;
		LinkedStack<Double> douStack;
		LinkedStack<Integer> emptyStack;



	/**
	 * 2 points
	 */
	@BeforeEach
	void setUp() throws Exception {
		intStack = new LinkedStack<>();
		intStack.push(1);
		intStack.push(200);
		intStack.push(180);
		intStack.push(999);
		strStack = new LinkedStack<>();
		strStack.push("one");
		strStack.push("two hundred");
		strStack.push("one hundred eighty");
		strStack.push("nine hundred ninety nine");
		douStack = new LinkedStack<>();
		douStack.push(1.1);
		douStack.push(200.2);
		douStack.push(180.18);
		douStack.push(999.999);
		emptyStack = new LinkedStack<>();
		// TODO: Construct the stacks here and fill your stacks with initial values
	}

	// Done for you. Not much to test here.
	@Test
	void testLinkedStack() {
		LinkedStack<Integer> testStack = new LinkedStack<>();
		assertTrue(testStack.isEmpty());
	}

	/**
	 * 2 points
	 */
	@Test
	void testIsEmpty() {
		assertFalse(intStack.isEmpty());
		assertFalse(strStack.isEmpty());
		assertFalse(douStack.isEmpty());
		assertTrue(emptyStack.isEmpty());
	}

	/**
	 * 2 points
	 */
	@Test
	void testPush() {
		intStack.push(4);
		assertEquals(Integer.valueOf(4), intStack.peek());
		strStack.push("four");
		assertEquals(String.valueOf("four"), strStack.peek());
		douStack.push(4.4);
		assertEquals(Double.valueOf(4.4), douStack.peek());
		// TODO: Make sure the push operation changes the top of each stack.
	}

	/**
	 * 3 points
	 */
	@Test
	void testPop() {
		assertEquals(Integer.valueOf(999),intStack.pop());
		assertEquals(Integer.valueOf(180),intStack.pop());
		assertEquals(Integer.valueOf(200),intStack.pop());
		assertEquals(Integer.valueOf(1),intStack.pop());
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
		assertEquals(Double.valueOf(999.999),douStack.pop());
		assertEquals(Double.valueOf(180.18),douStack.pop());
		assertEquals(Double.valueOf(200.2),douStack.pop());
		assertEquals(Double.valueOf(1.1),douStack.pop());
		assertThrows(EmptyStackException.class, () -> {
			douStack.pop();
		});
		// TODO: Assure correct behavior as all elements are popped off of each stack.
		//       Also check what happens when an empty stack is popped, using assertThrows.
	}

	/**
	 * 2 points
	 */
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
		// TODO: Assure that stack is emptied as a result of clear command.
	}

	/**
	 * 2 points
	 */
	@Test
	void testPeek() {
		assertEquals(Integer.valueOf(999),intStack.peek());
		assertEquals(Integer.valueOf(999),intStack.pop());
		assertEquals(Integer.valueOf(180),intStack.peek());
		assertEquals(Integer.valueOf(180),intStack.pop());
		assertEquals(Integer.valueOf(200),intStack.peek());
		assertEquals(Integer.valueOf(200),intStack.pop());
		assertEquals(Integer.valueOf(1),intStack.peek());
		assertEquals(Integer.valueOf(1),intStack.pop());
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
		// TODO: Assure correct results from peek, as well as lack
		//       of modification to stack. Assure correct response when
		//       peeking on an empty stack as well.
	}

}