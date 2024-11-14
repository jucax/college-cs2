package list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class tests both the methods of the
 * DoublyLinkedList class and the methods of
 * the internal DoublyLinkedListIterator class.
 * Follow all instructions specified with a 
 * TODO in order to thoroughly test these
 * methods.                
 * 
 * Note that although you do not need to write
 * any additional tests for the ListIterator
 * (I will not grade them), you should be aware
 * that the existing tests are insufficient        
 * to fully test the iterator. In other words,
 * you could pass all of the iterator tests below,
 * but still have many errors in your iterator
 * implementation.                        
 * 
 * @author Jacob Schrum
 */

class DoublyLinkedListTest {

	// Lists to perform tests on
	DoublyLinkedList<Character> charList; // A list of Characters
	DoublyLinkedList<Integer> intList; // A list of Integers
	DoublyLinkedList<Integer> emptyList; // Leave this list empty
	DoublyLinkedList<String> stringList; // A list of Strings

	/**
	 * Set up lists at the start of each test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// A list of characters: 
		// This test example is very simple.
		// Your examples below should be more complex.
		// DO NOT CHANGE
		charList = new DoublyLinkedList<Character>();
		charList.add('a');
		charList.add('b');
		charList.add('c');

		// A list of integers
		// DO NOT CHANGE
		intList = new DoublyLinkedList<Integer>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(-100);
		intList.add(20);
		intList.add(0);
		intList.add(3);		

		// An empty list.
		// DO NOT CHANGE
		emptyList = new DoublyLinkedList<Integer>();

		// A list of strings
		stringList = new DoublyLinkedList<String>();
		stringList.add("Dog");
		stringList.add("Lion");
		stringList.add("Cat");
		stringList.add("Tiger");
		stringList.add("Rabbit");
		stringList.add("Pig");
	}

	@Test
	void testDoublyLinkedList() {
		DoublyLinkedList<Integer> temp = new DoublyLinkedList<Integer>();
		assertTrue(temp.isEmpty());
		assertEquals(0, temp.getLength());
	}

	/**
	 * Test adding items to the end of the list.
	 * Specifically, test the add(T newEntry) method.
	 */
	@Test
	public void testAddT() {
		intList.add(20);
		assertEquals(11, intList.getLength());
		assertEquals(Integer.valueOf(20), intList.getEntry(10));

		charList.add('d');
		assertEquals(4, charList.getLength());
		assertEquals('d', charList.getEntry(3));

		stringList.add("Cow");
		assertEquals(7, stringList.getLength());
		assertEquals("Cow", stringList.getEntry(6));
	}

	/**
	 * Test adding items at specific indices throughout
	 * the list. Specifically, test the 
	 * add(int newPosition, T newEntry) method.
	 */
	@Test
	public void testAddIntT() {
		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.add(-1, 9);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.add(12, 213);
		});		

		intList.add(0,-10); // Add to start
		intList.add(7,999); // Add to end
		intList.add(4,1000); // Add to middle

		assertEquals(Integer.valueOf(-10), intList.getEntry(0));
		assertEquals(Integer.valueOf(0), intList.getEntry(1));
		assertEquals(Integer.valueOf(1), intList.getEntry(2));
		assertEquals(Integer.valueOf(2), intList.getEntry(3));
		assertEquals(Integer.valueOf(1000), intList.getEntry(4));
		assertEquals(Integer.valueOf(3), intList.getEntry(5));
		assertEquals(Integer.valueOf(4), intList.getEntry(6));
		assertEquals(Integer.valueOf(5), intList.getEntry(7));
		assertEquals(Integer.valueOf(999), intList.getEntry(8));
		assertEquals(Integer.valueOf(-100), intList.getEntry(9));
		assertEquals(Integer.valueOf(20), intList.getEntry(10));
		assertEquals(Integer.valueOf(0), intList.getEntry(11));
		assertEquals(Integer.valueOf(3), intList.getEntry(12));

		assertEquals(13, intList.getLength());

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.add(-1, 'y');
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.add(12, 'v');
		});		

		charList.add(0,'z'); // Add to start
		charList.add(3,'e'); // Add to end
		charList.add(5,'d'); // Add to middle

		assertEquals('z', charList.getEntry(0));
		assertEquals('a', charList.getEntry(1));
		assertEquals('b', charList.getEntry(2));
		assertEquals('e', charList.getEntry(3));
		assertEquals('c', charList.getEntry(4));
		assertEquals('d', charList.getEntry(5));

		assertEquals(6, charList.getLength());

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.add(-1, "Horse");
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.add(12, "Frog");
		});		

		stringList.add(0,"Bird"); // Add to start
		stringList.add(4,"Jaguar"); // Add to end
		stringList.add(8,"Rat"); // Add to middle

		assertEquals("Bird", stringList.getEntry(0));
		assertEquals("Dog", stringList.getEntry(1));
		assertEquals("Lion", stringList.getEntry(2));
		assertEquals("Cat", stringList.getEntry(3));
		assertEquals("Jaguar", stringList.getEntry(4));
		assertEquals("Tiger", stringList.getEntry(5));
		assertEquals("Rabbit", stringList.getEntry(6));
		assertEquals("Pig", stringList.getEntry(7));
		assertEquals("Rat", stringList.getEntry(8));

		assertEquals(9, stringList.getLength());
	}

	/**
	 * Test removing elements from specific indices throughout
	 * the list. Specifically, test the remove(int givenPosition)
	 * method.
	 */
	@Test
	public void testRemove() {
		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.remove(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.remove(12);
		});

		assertEquals(Integer.valueOf(0), intList.remove(0)); // Remove to start
		assertEquals(Integer.valueOf(3), intList.remove(8)); // Remove to end
		assertEquals(Integer.valueOf(5), intList.remove(4)); // Remove to middle

		assertEquals(Integer.valueOf(1), intList.getEntry(0));
		assertEquals(Integer.valueOf(4), intList.getEntry(3));
		assertEquals(Integer.valueOf(0), intList.getEntry(6));

		assertEquals(7, intList.getLength());

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.remove(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.remove(5);
		});

		assertEquals('a', charList.remove(0)); // Remove to start
		assertEquals('c', charList.remove(1)); // Remove to end

		assertEquals('b', charList.getEntry(0));

		assertEquals(1, charList.getLength());

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.remove(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.remove(10);
		});

		assertEquals("Dog", stringList.remove(0)); // Remove to start
		assertEquals("Pig", stringList.remove(4)); // Remove to end
		assertEquals("Tiger", stringList.remove(2)); // Remove to middle

		assertEquals("Lion", stringList.getEntry(0));
		assertEquals("Cat", stringList.getEntry(1));
		assertEquals("Rabbit", stringList.getEntry(2));

		assertEquals(3, stringList.getLength());
	}

	/**
	 * Test the clear() method of the list.
	 */
	@Test
	public void testClear() {
		assertFalse(intList.isEmpty());
		intList.clear();
		assertTrue(intList.isEmpty());

		assertFalse(charList.isEmpty());
		charList.clear();
		assertTrue(charList.isEmpty());

		assertFalse(stringList.isEmpty());
		stringList.clear();
		assertTrue(stringList.isEmpty());

		assertTrue(emptyList.isEmpty());
		stringList.clear();
		assertTrue(emptyList.isEmpty());
	}

	/**
	 * Test the replace method of the list.
	 */
	@Test
	public void testReplace() {
		assertEquals(Integer.valueOf(0), intList.replace(0, 20));
		assertEquals(Integer.valueOf(1), intList.replace(1, -12));
		assertEquals(Integer.valueOf(2), intList.replace(2, 3342));
		assertEquals(Integer.valueOf(3), intList.replace(3, -21));
		assertEquals(Integer.valueOf(4), intList.replace(4, 0));
		assertEquals(Integer.valueOf(5), intList.replace(5, 4232));

		// Make sure the values changed
		assertEquals(Integer.valueOf(20), intList.replace(0, 55));
		assertEquals(Integer.valueOf(-12), intList.replace(1, 55));
		assertEquals(Integer.valueOf(3342), intList.replace(2, 55));
		assertEquals(Integer.valueOf(-21), intList.replace(3, 55));
		assertEquals(Integer.valueOf(0), intList.replace(4, 55));
		assertEquals(Integer.valueOf(4232), intList.replace(5, 55));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.replace(-1, 9);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.replace(12, 213);
		});

		assertEquals('a', charList.replace(0, 'z'));
		assertEquals('b', charList.replace(1, 'y'));
		assertEquals('c', charList.replace(2, 'x'));

		// Make sure the values changed
		assertEquals('z', charList.replace(0, 'k'));
		assertEquals('y', charList.replace(1, 'k'));
		assertEquals('x', charList.replace(2, 'k'));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.replace(-1, 'f');
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.replace(5, 'h');
		});

		assertEquals("Dog", stringList.replace(0, "Frog"));
		assertEquals("Lion", stringList.replace(1, "Bird"));
		assertEquals("Cat", stringList.replace(2, "Jaguar"));
		assertEquals("Tiger", stringList.replace(3, "Rat"));
		assertEquals("Rabbit", stringList.replace(4, "Elephant"));
		assertEquals("Pig", stringList.replace(5, "Bee"));

		// Make sure the values changed
		assertEquals("Frog", stringList.replace(0, "Dog"));
		assertEquals("Bird", stringList.replace(1, "Dog"));
		assertEquals("Jaguar", stringList.replace(2, "Dog"));
		assertEquals("Rat", stringList.replace(3, "Dog"));
		assertEquals("Elephant", stringList.replace(4, "Dog"));
		assertEquals("Bee", stringList.replace(5, "Dog"));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.replace(-1, "Whale");
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.replace(12, "Fish");
		});
	}

	/**
	 * Test the getEntry method of the list.
	 */
	@Test
	public void testGetEntry() {

		assertEquals(Integer.valueOf(0), intList.getEntry(0));
		assertEquals(Integer.valueOf(2), intList.getEntry(2));
		assertEquals(Integer.valueOf(4), intList.getEntry(4));
		assertEquals(Integer.valueOf(-100), intList.getEntry(6));
		assertEquals(Integer.valueOf(0), intList.getEntry(8));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.getEntry(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			intList.getEntry(12);
		});

		assertEquals('a', charList.getEntry(0));
		assertEquals('b', charList.getEntry(1));
		assertEquals('c', charList.getEntry(2));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.getEntry(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			charList.getEntry(5);
		});

		assertEquals("Dog", stringList.getEntry(0));
		assertEquals("Lion", stringList.getEntry(1));
		assertEquals("Cat", stringList.getEntry(2));
		assertEquals("Tiger", stringList.getEntry(3));
		assertEquals("Rabbit", stringList.getEntry(4));
		assertEquals("Pig", stringList.getEntry(5));

		// Check lower edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.getEntry(-1);
		});
		// Check upper edge case
		assertThrows(IndexOutOfBoundsException.class, () -> {
			stringList.getEntry(8);
		});
	}

	/**
	 * Test the toArray method of each test list.
	 */
	@Test
	public void testToArray() {
		Object[] result1 = intList.toArray();
		assertEquals(10, result1.length);
		assertArrayEquals(new Integer[] {0,1,2,3,4,5,-100,20,0,3}, result1);

		Object[] result2 = charList.toArray();
		assertEquals(3, result2.length);
		assertArrayEquals(new Character[] {'a','b','c'}, result2);
		
		Object[] result3 = stringList.toArray();
		assertEquals(6, result3.length);
		assertArrayEquals(new String[] {"Dog","Lion","Cat","Tiger","Rabbit","Pig"}, result3);

		Object[] result4 = emptyList.toArray();
		assertEquals(0, result4.length);
		assertArrayEquals(new Integer[] {}, result4);
	}

	/**
	 * Test the contains method of the list.
	 */
	@Test
	public void testContains() {

		assertTrue(intList.contains(5));
		assertTrue(intList.contains(-100));
		assertTrue(intList.contains(0));
		assertTrue(intList.contains(3));
		assertTrue(intList.contains(4));
		assertTrue(intList.contains(1));

		assertFalse(intList.contains(10));

		assertTrue(charList.contains('a'));
		assertTrue(charList.contains('b'));
		assertTrue(charList.contains('c'));

		assertFalse(charList.contains('z'));

		assertTrue(stringList.contains("Dog"));
		assertTrue(stringList.contains("Lion"));
		assertTrue(stringList.contains("Cat"));
		assertTrue(stringList.contains("Tiger"));
		assertTrue(stringList.contains("Rabbit"));
		assertTrue(stringList.contains("Pig"));

		assertFalse(stringList.contains("Frog"));
		assertFalse(stringList.contains("Rat"));
	}

	/**
	 * Test getLength method of the list.
	 */
	@Test
	public void testGetLength() {
		assertEquals(10, intList.getLength());
		intList.remove(0);
		intList.remove(1);
		intList.remove(2);
		assertEquals(7, intList.getLength());

		assertEquals(3, charList.getLength());
		charList.remove(0);
		charList.remove(1);
		assertEquals(1, charList.getLength());

		assertEquals(6, stringList.getLength());
		stringList.remove(0);
		stringList.remove(2);
		stringList.remove(3);
		assertEquals(3, stringList.getLength());

		assertEquals(0, emptyList.getLength());
	}

	/**
	 * Test isEmpty method of the list.
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(intList.isEmpty());
		intList.clear();
		assertTrue(intList.isEmpty());

		assertFalse(charList.isEmpty());
		charList.clear();
		assertTrue(charList.isEmpty());

		assertFalse(stringList.isEmpty());
		stringList.clear();
		assertTrue(stringList.isEmpty());

		assertTrue(emptyList.isEmpty());
		charList.clear();
		assertTrue(emptyList.isEmpty());
	}

	/**
	 * Despite the simple name, this method 
	 * actually tests several methods of the internal
	 * DoublyLinkedListIterator class. You do not need
	 * to add any additional tests for the iterator, 
	 * but you can analyze these tests to figure out
	 * how to write your iterator methods.
	 * 
	 * NOTE: Although you do not need to add anything
	 * to this method, its tests are insufficient to fully
	 * test the ListIterator. You can add additional tests
	 * to help develop your implementation, but they will
	 * not be graded.
	 */
	@Test
	public void testGetIterator() {
		// Compare for-each to array of all values
		Object[] charArray = charList.toArray();
		int index = 0;
		for(Character x: charList) {
			assertEquals(charArray[index++], x);
		}

		ListIterator<Character> charItr = charList.getIterator();

		// Manually iterate forward through each element
		assertTrue(charItr.hasNext());
		assertFalse(charItr.hasPrevious()); // There is no element before the first
		assertEquals(0, charItr.nextIndex());
		assertEquals(-1, charItr.previousIndex()); // Index is out of bounds
		assertEquals(Character.valueOf('a'), charItr.next());

		assertTrue(charItr.hasNext());
		assertTrue(charItr.hasPrevious());
		assertEquals(1, charItr.nextIndex());
		assertEquals(0, charItr.previousIndex());
		assertEquals(Character.valueOf('b'), charItr.next());

		assertTrue(charItr.hasNext());
		assertTrue(charItr.hasPrevious());
		assertEquals(2, charItr.nextIndex());
		assertEquals(1, charItr.previousIndex());
		assertEquals(Character.valueOf('c'), charItr.next());

		assertFalse(charItr.hasNext()); // There is no index after last
		assertTrue(charItr.hasPrevious());
		assertEquals(3, charItr.nextIndex()); // Index is out of bounds
		assertEquals(2, charItr.previousIndex());

		assertThrows(NoSuchElementException.class, () -> {
			charItr.next(); // Cannot go off right edge of list
		});

		// Manually iterate backward through each element
		assertFalse(charItr.hasNext()); // There is no index after last
		assertTrue(charItr.hasPrevious());
		assertEquals(3, charItr.nextIndex()); // Index is out of bounds
		assertEquals(2, charItr.previousIndex());
		assertEquals(Character.valueOf('c'), charItr.previous());

		assertTrue(charItr.hasNext());
		assertTrue(charItr.hasPrevious());
		assertEquals(2, charItr.nextIndex());
		assertEquals(1, charItr.previousIndex());
		assertEquals(Character.valueOf('b'), charItr.previous());

		assertTrue(charItr.hasNext());
		assertTrue(charItr.hasPrevious());
		assertEquals(1, charItr.nextIndex());
		assertEquals(0, charItr.previousIndex());
		assertEquals(Character.valueOf('a'), charItr.previous());

		assertTrue(charItr.hasNext());
		assertFalse(charItr.hasPrevious()); // There is no index before first
		assertEquals(0, charItr.nextIndex());
		assertEquals(-1, charItr.previousIndex()); // Index is out of bounds

		assertThrows(NoSuchElementException.class, () -> {
			charItr.previous(); // Cannot go off left edge of list
		});

		// Get array of values for comparison
		Object[] intArray = intList.toArray();

		// Verify correct for-each functionality
		index = 0;
		for(Integer x: intList) {
			assertEquals(intArray[index++], x);
		}
		// Manually iterate forward with ListIterator
		ListIterator<Integer> intItr = intList.getIterator();
		index = 0;
		while(intItr.hasNext()) {
			assertEquals(index, intItr.nextIndex());
			assertEquals(index - 1, intItr.previousIndex());
			assertEquals(intArray[index++], intItr.next());
		}

		assertThrows(NoSuchElementException.class, () -> {
			intItr.next();
		});

		assertEquals(intItr.nextIndex(), intList.getLength());
		// Manually iterate backward
		while(intItr.hasPrevious()) {
			assertEquals(index, intItr.nextIndex());
			assertEquals(index - 1, intItr.previousIndex());
			assertEquals(intArray[--index], intItr.previous());
		}

		assertThrows(NoSuchElementException.class, () -> {
			intItr.previous();
		});
	}

	/**
	 * Tests the add method of the ListIterator on both
	 * the charList and intList.
	 * 
	 * NOTE: Although you do not need to add anything
	 * to this method, its tests are insufficient to fully
	 * test the ListIterator. You can add additional tests
	 * to help develop your implementation, but they will
	 * not be graded.
	 */
	@Test
	public void testIteratorAdd() {
		ListIterator<Character> charItr = charList.getIterator();

		// Some simple tests of the charItr
		assertEquals(Character.valueOf('a'), charItr.next());
		charItr.add('Z'); // iterator is positioned after the element that was added
		// Check correct list contents around point of insertion
		assertEquals(Character.valueOf('a'), charList.getEntry(0));
		assertEquals(Character.valueOf('Z'), charList.getEntry(1));
		assertEquals(Character.valueOf('b'), charList.getEntry(2));
		// Check correct configuration of iterator after insertion
		assertEquals(2, charItr.nextIndex()); 
		assertEquals(1, charItr.previousIndex());
		// Move back and forth
		assertEquals(Character.valueOf('Z'), charItr.previous()); // back up over the element that was just added
		assertEquals(Character.valueOf('Z'), charItr.next()); // proceed forward over the newly added element

		ListIterator<Integer> intItr = intList.getIterator();

		assertEquals(intItr.nextIndex(), 0);

		// Add to front
		intItr.add(898);
		assertEquals(intItr.nextIndex(), 1);
		assertEquals(Integer.valueOf(898), intList.getEntry(0));
		assertEquals(Integer.valueOf(0), intList.getEntry(1));

		assertEquals(Integer.valueOf(898), intItr.previous());
		assertEquals(Integer.valueOf(898), intItr.next());
		assertEquals(Integer.valueOf(0), intItr.next());
		assertEquals(2, intItr.nextIndex());
		assertEquals(Integer.valueOf(1), intItr.next());
		assertEquals(3, intItr.nextIndex());
		intItr.add(336);
		assertEquals(4, intItr.nextIndex());
		assertEquals(Integer.valueOf(2), intItr.next());
		assertEquals(5, intItr.nextIndex());

		assertEquals(Integer.valueOf(1), intList.getEntry(2));
		assertEquals(Integer.valueOf(336), intList.getEntry(3));
		assertEquals(Integer.valueOf(2), intList.getEntry(4));

		// Go to end
		int index = 5;
		while(intItr.hasNext()) {
			intItr.next();
			assertEquals(++index, intItr.nextIndex());
		}

		intItr.add(667);
		assertEquals(++index, intItr.nextIndex());
		assertEquals(Integer.valueOf(3), intList.getEntry(intList.getLength() - 2));
		assertEquals(Integer.valueOf(667), intList.getEntry(intList.getLength() - 1));

		assertEquals(index, intList.getLength());
		// go to start
		assertEquals(Integer.valueOf(667), intItr.previous());
		assertEquals(Integer.valueOf(3), intItr.previous());
		assertEquals(Integer.valueOf(0), intItr.previous());
		assertEquals(Integer.valueOf(20), intItr.previous());
		assertEquals(Integer.valueOf(-100), intItr.previous());
		assertEquals(Integer.valueOf(5), intItr.previous());
		assertEquals(Integer.valueOf(4), intItr.previous());
		assertEquals(Integer.valueOf(3), intItr.previous());
		assertEquals(Integer.valueOf(2), intItr.previous());
		assertEquals(Integer.valueOf(336), intItr.previous());
		assertEquals(Integer.valueOf(1), intItr.previous());
		assertEquals(Integer.valueOf(0), intItr.previous());
		assertEquals(Integer.valueOf(898), intItr.previous());

		intItr.add(999);
		assertEquals(Integer.valueOf(999), intList.getEntry(0));
		assertEquals(Integer.valueOf(898), intList.getEntry(1));

		// Forward
		while(intItr.hasNext()) {
			intItr.next();
		}
		// Then back
		while(intItr.hasPrevious()) {
			intItr.previous();
		}

		intItr.add(-23);
		assertEquals(Integer.valueOf(-23), intList.getEntry(0));

	}

	/**
	 * Tests the remove method of the ListIterator on both
	 * the charList and intList.
	 * 
	 * NOTE: Although you do not need to add anything
	 * to this method, its tests are insufficient to fully
	 * test the ListIterator. You can add additional tests
	 * to help develop your implementation, but they will
	 * not be graded.
	 */
	@Test
	public void testIteratorRemove() {
		ListIterator<Character> charItr = charList.getIterator();

		assertThrows(IllegalStateException.class, () -> {
			charItr.remove(); // Move forward first
		});

		assertEquals(Character.valueOf('a'), charItr.next()); // Go past first character
		charItr.remove(); // removes 'a' because it was just returned by next
		assertFalse(charItr.hasPrevious()); // Iterator is at front of list. No going back.
		assertEquals(-1, charItr.previousIndex());
		assertEquals(0, charItr.nextIndex());
		// Verify list structure and contents
		assertEquals(Character.valueOf('b'), charList.getEntry(0));
		assertEquals(Character.valueOf('c'), charList.getEntry(1));
		assertEquals(2, charList.getLength());

		assertEquals(Character.valueOf('b'), charItr.next());
		assertEquals(Character.valueOf('c'), charItr.next()); // Go past last item
		assertEquals(Character.valueOf('c'), charItr.previous()); // Reverse over last item
		charItr.remove(); // removes 'c' because it was just returned by previous
		assertFalse(charItr.hasNext()); // Iterator is at end of list. No going forward.
		assertEquals(0, charItr.previousIndex());
		assertEquals(1, charItr.nextIndex());
		// Verify list structure and contents
		assertEquals(Character.valueOf('b'), charList.getEntry(0));
		assertEquals(1, charList.getLength());


		ListIterator<Integer> intItr = intList.getIterator();
		intItr.next(); // 0
		intItr.next(); // 1
		assertEquals(Integer.valueOf(2), intItr.next()); 

		intItr.remove(); // 2
		assertEquals(Integer.valueOf(1), intList.getEntry(1));
		assertEquals(Integer.valueOf(3), intList.getEntry(2));

		assertEquals(Integer.valueOf(3), intItr.next()); 
		assertEquals(Integer.valueOf(4), intItr.next()); 

		intItr.remove(); // 4
		assertEquals(Integer.valueOf(3), intList.getEntry(2));
		assertEquals(Integer.valueOf(5), intList.getEntry(3));

		assertEquals(Integer.valueOf(3), intItr.previous()); 
		assertEquals(Integer.valueOf(1), intItr.previous()); 

		intItr.remove(); // 1
		assertEquals(Integer.valueOf(0), intList.getEntry(0));
		assertEquals(Integer.valueOf(3), intList.getEntry(1));

		assertEquals(Integer.valueOf(0), intItr.previous()); 
		intItr.remove(); // 0
		assertEquals(Integer.valueOf(3), intList.getEntry(0));
		assertEquals(Integer.valueOf(5), intList.getEntry(1));

		while(intItr.hasNext()) intItr.next();
		intItr.remove(); // 3
		assertEquals(Integer.valueOf(0), intList.getEntry(intList.getLength() - 1));

		assertEquals(Integer.valueOf(0), intItr.previous()); 
		intItr.remove();

		assertThrows(IllegalStateException.class, () -> {
			intItr.remove(); // Double remove
		});		
	}

	/**
	 * Tests the set method of the ListIterator on both
	 * the charList and intList.
	 * 
	 * NOTE: Although you do not need to add anything
	 * to this method, its tests are insufficient to fully
	 * test the ListIterator. You can add additional tests
	 * to help develop your implementation, but they will
	 * not be graded.
	 */
	@Test
	public void testIteratorSet() {
		// Example with charList
		ListIterator<Character> charItr = charList.getIterator();
		assertEquals(Character.valueOf('a'), charItr.next());
		assertEquals(Character.valueOf('b'), charItr.next());
		charItr.set('K'); // Replaced 'b' since it was last returned by next
		assertEquals(Character.valueOf('K'), charList.getEntry(1)); // Verify

		ListIterator<Integer> intItr = intList.getIterator();

		assertThrows(IllegalStateException.class, () -> {
			intItr.set(56); // Need to move forward first
		});

		assertEquals(Integer.valueOf(0), intItr.next());
		intItr.set(99);
		assertEquals(Integer.valueOf(99), intList.getEntry(0));
		assertEquals(Integer.valueOf(1), intItr.next());
		assertEquals(Integer.valueOf(2), intItr.next());
		intItr.set(22);
		assertEquals(Integer.valueOf(22), intList.getEntry(2));
		intItr.set(-34);
		assertEquals(Integer.valueOf(-34), intList.getEntry(2));

		while(intItr.hasNext()) intItr.next();

		intItr.set(77);
		assertEquals(Integer.valueOf(77), intList.getEntry(intList.getLength() - 1));

		assertEquals(Integer.valueOf(77), intItr.previous());
		assertEquals(Integer.valueOf(0), intItr.previous());
		assertEquals(Integer.valueOf(20), intItr.previous());
		intItr.set(12345);
		assertEquals(Integer.valueOf(12345), intList.getEntry(7));

		while(intItr.hasPrevious()) intItr.previous();
		intItr.set(-999);
		assertEquals(Integer.valueOf(-999), intList.getEntry(0));

	}
}
