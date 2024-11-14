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

	// TODO: Declare some global stack instances to use in your tests.
	//       You must have multiple stacks, and they must have a variety
	//       of different data types: Integer, String, Double
	LinkedStack<Integer> intStack;
	LinkedStack<Integer> emptyStack;

	@BeforeEach
	void setUp() throws Exception {
		// TODO: Construct the stacks here and fill your stacks with initial values
		intStack = new LinkedStack<>();
		intStack.push(5);
		intStack.push(6);
		intStack.push(3);
		intStack.push(234);
		intStack.push(5);
		intStack.push(34);
		intStack.push(3);
		intStack.push(500);

		emptyStack = new LinkedStack<>();
	}

	// Done for you. Not much to test here.
	@Test
	void testLinkedStack() {
		LinkedStack<Integer> testStack = new LinkedStack<>();
		assertTrue(testStack.isEmpty());
	}

	@Test
	void testIsEmpty() {
		// TODO: Test each stack
		assertTrue(emptyStack.isEmpty());
		assertFalse(intStack.isEmpty());
	}

	@Test
	void testPush() {
		// TODO: Make sure the push operation changes the top of each stack.
		intStack.push(1000);
		assertEquals(Integer.valueOf(1000), intStack.peek());

	}

	@Test
	void testPop() {
		// TODO: Assure correct behavior as all elements are popped off of each stack.
		//       Also check what happens when an empty stack is popped, using assertThrows.
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
	}

	@Test
	void testClear() {
		// TODO: Assure that stack is emptied as a result of clear command.
		assertFalse(intStack.isEmpty());
		intStack.clear();
		assertTrue(intStack.isEmpty());
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
	}

}