import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * This class has tests for the methods
 * in SimpleStaticMethods. Those methods
 * must pass the tests in this class, some
 * of which must be written by you. Base
 * your tests on the examples given, but
 * expand your tests to incorporate a more
 * diverse range of interesting values and
 * special cases.
 * 
 * @author Jacob Schrum
 */
class SimpleStaticMethodsTest {

	// Allowable error in floating-point calculations
	public static final double EPSILON = 0.000001;

	/**
	 * 1 point
	 */
	@Test
	void testSumStandardLoop() {
		assertEquals(45,      SimpleStaticMethods.sumStandardLoop(new int[]{1,2,3,4,5,6,7,8,9}));
		assertEquals(1116257, SimpleStaticMethods.sumStandardLoop(new int[]{11,3,20,-62,100,5023,-32,83,1111111}));
		assertEquals(72074,   SimpleStaticMethods.sumStandardLoop(new int[]{1341,23,-420,-6234,12400,53023,-3,833,11111}));

		assertEquals(300,     SimpleStaticMethods.sumStandardLoop(new int[]{60,-10,70,-20,80,-30,90,-40,100}));
	}

	/**
	 * 1 point
	 */
	@Test
	void testSumForEach() {
		assertEquals(45,      SimpleStaticMethods.sumForEach(new int[]{1,2,3,4,5,6,7,8,9}));
		assertEquals(1116257, SimpleStaticMethods.sumForEach(new int[]{11,3,20,-62,100,5023,-32,83,1111111}));
		assertEquals(72074,   SimpleStaticMethods.sumForEach(new int[]{1341,23,-420,-6234,12400,53023,-3,833,11111}));

        assertEquals(724, SimpleStaticMethods.sumForEach(new int[]{200, -150, 300, 50, 153, 250, 21, -100}));
	}

	/**
	 * 3 points
	 */
	@Test
	void testProduct() {
		assertEquals(120,                 SimpleStaticMethods.product(new double[] {1,2,3,4,5}), EPSILON);
		assertEquals(0.25533999999999996, SimpleStaticMethods.product(new double[] {0.5, 150.2, 0.0034}), EPSILON);
		
		assertEquals(-10080.0, SimpleStaticMethods.product(new double[]{2, 5, -3, 8, 7, 6}), EPSILON);
        assertEquals(24.61895402, SimpleStaticMethods.product(new double[]{0.1234, 10.0, 9.8765, 2.0, 1.01}), EPSILON);
        assertEquals(1048.9248, SimpleStaticMethods.product(new double[]{-2.1, 3.2, -4.3, 5.5, 6.6}), EPSILON);
		// TODO: At least 3 more tests. Need one test for empty array, and two for long arrays with many interesting values (big, small, negative, positive)
	}

	/**
	 * 4 points
	 */
	@Test
	void testZipMultiply() {
		double[] result1and2 = SimpleStaticMethods.zipMultiply(new double[] {1, 2, 0.5, 100, 12.56}, new double[] {77, 3, 100, 34.5311, 10.23, 7});
		assertArrayEquals(new double[] {77, 6, 50, 3453.11, 128.4888}, result1and2, EPSILON);


		double[] resultEmptyArrays = SimpleStaticMethods.zipMultiply(new double[]{1, 2, 0.5, 100, 12.56}, new double[]{77, 3, 100, 34.5311, 10.23, 7});
        assertArrayEquals(new double[]{77, 6, 50, 3453.11, 128.4888}, resultEmptyArrays, EPSILON);

        double[] resultUnequalLength = SimpleStaticMethods.zipMultiply(new double[]{2.5, -3.4, 1.2, 5.6}, new double[]{-1.5, 2.7, -0.8, 3.2});
        assertArrayEquals(new double[]{-3.75, -9.18, -0.96, 17.92}, resultUnequalLength, EPSILON);

        double[] resultNegativeNumbers = SimpleStaticMethods.zipMultiply(new double[]{-2, 3, -4, 5, 6.6}, new double[]{2.1, 3.2, 4.3, 5.5, 6.6});
        assertArrayEquals(new double[]{-4.2, 9.6, -17.2, 27.5, 43.56}, resultNegativeNumbers, EPSILON);

        double[] resultZeroes = SimpleStaticMethods.zipMultiply(new double[]{0, 0, 0}, new double[]{1, 2, 3});
        assertArrayEquals(new double[]{0, 0, 0}, resultZeroes, EPSILON);
		// TODO: At least 4 more tests. Be sure to cover a broad range of input/output possibilities
	}

	/**
	 * 5 points
	 */
	@Test
	void testSubStringAfter() {
		assertEquals("tion", SimpleStaticMethods.subStringAfter('c', "action"));
		// TODO: At least 10 more tests. Be sure to cover a broad range of input/output possibilities, including cases where the character is not in the string
		assertEquals("olo", SimpleStaticMethods.subStringAfter('S', "Han Solo"));
        assertEquals("ython", SimpleStaticMethods.subStringAfter('P', "Python"));
        assertEquals("", SimpleStaticMethods.subStringAfter('S', "Java"));
        assertEquals("#", SimpleStaticMethods.subStringAfter('C', "C#"));
        assertEquals("avaScript", SimpleStaticMethods.subStringAfter('J', "JavaScript"));
        assertEquals("ith Lord Darth Vader", SimpleStaticMethods.subStringAfter('S', "Sith Lord Darth Vader"));
        assertEquals("JavaScript", SimpleStaticMethods.subStringAfter('t', "TypeScriptJavaScript"));
        assertEquals("ommon Lisp", SimpleStaticMethods.subStringAfter('C', "Common Lisp"));
        assertEquals("", SimpleStaticMethods.subStringAfter('P', "Ruby"));
        assertEquals("ord Sith", SimpleStaticMethods.subStringAfter('L', "Lord Sith"));
	}

	/**
	 * 4 points
	 */
	@Test
	void testSameStart() {
		// You can directly fill these lists with values to conduct your tests
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(6);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(6);
		list2.add(7);
		// [5,6]
		// [5,6,7]
		// Result is true because both start with [5,6], which is the entirety of the shorter list
		assertTrue(SimpleStaticMethods.sameStart(list1, list2));

		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(6);
		list3.add(8);
		// [5,6,7]
		// [5,6,8]
		// Result is false because both differ at the third position (index 2)
		assertFalse(SimpleStaticMethods.sameStart(list2, list3));

		// TODO: At least 4 more tests. Be sure to cover a broad range of input/output possibilities
		//       Each test should create new ArrayLists from scratch and add elements to them before
		//       using either assertTrue or assertFalse to check. Have two assertTrue checks and two
		//       assertFalse checks.

		ArrayList<Integer> list4 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        assertTrue(SimpleStaticMethods.sameStart(list4, list5));

		ArrayList<Integer> list6 = new ArrayList<>();
        list6.add(10);
        list6.add(5);
        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(5);
        list7.add(10);
        assertFalse(SimpleStaticMethods.sameStart(list6, list7));

		ArrayList<Integer> list8 = new ArrayList<>();
        list8.add(99);
		list8.add(3);
		list8.add(252);
        ArrayList<Integer> list9 = new ArrayList<>();
        list9.add(99);
		list9.add(3);
		list8.add(252);
		list8.add(1212);
        assertTrue(SimpleStaticMethods.sameStart(list8, list9));

		ArrayList<Integer> list10 = new ArrayList<>();
        list10.add(42);
        ArrayList<Integer> list11 = new ArrayList<>();
        list11.add(77);
        assertFalse(SimpleStaticMethods.sameStart(list10, list11));
	}

	/**
	 * 6 points
	 */
	@Test
	void testAverages() {
		double[][] case1 = new double[][]{new double[] {1,2,3,4,5}, new double[] {100,35.324,-342.7}};
		assertArrayEquals(new double[] {3, -69.12533333333333}, SimpleStaticMethods.averages(case1), EPSILON);

		// TODO: Write two additional tests for the averages method. 
		//       Be sure to cover a broad range of input/output possibilities.
		//       Each test consists of the declaration and initialization of
		//       a 2D array of expected results, followed by assertArrayEquals.
		//       Note that your additional test arrays should not all be the same size.

		double[][] case2 = new double[][]{new double[]{2, 4, 6, 8, 10}, new double[]{75, 30.5, -250.5}};
        assertArrayEquals(new double[]{6, -48.333333}, SimpleStaticMethods.averages(case2), EPSILON);

		double[][] case3 = new double[][]{new double[]{15}, new double[]{7, -8, 22, 35}};
        assertArrayEquals(new double[]{15, 14}, SimpleStaticMethods.averages(case3), EPSILON);
	}

}
