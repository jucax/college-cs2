package search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class tests the three forms of search on a 2D sorted array.        
 * Because these methods are challenging to write, you do not need
 * to write any additional tests ... the ones here are sufficient.         
 * However, keep in mind that these tests only verify correct results
 * from each of your methods. They do not verify that your implementations
 * are as efficient as they should be.
 *               
 * @author Jacob Schrum
 */
class Sorted2DArraySearchTest {

	// Test arrays that are sorted
	Integer[][] test1 = {
			{ 10,  20,  30,  40,  45},
			{ 50,  60,  70,  80,  85},
			{ 90, 100, 110, 120, 125},
			{130, 140, 150, 160, 165},
			{170, 180, 190, 200, 210},	
	};
	String[][] test2 = {
			{"A",   "A", "B", "BBB", "BBB"},
			{"B",   "B", "B",   "C",   "C"},
			{"C",   "D", "E",   "F",   "G"},
			{"X",   "X", "Y",   "Y",   "Y"},
			{"Y", "YES", "Z",  "ZZ", "ZZZ"}
	};
	Double[][] test3 = {
			{-5.0,-3.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
			{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
			{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
			{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
			{-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0},
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,19.0},
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,40.0},
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,20.0,30.0,40.0},
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,21.0,30.0,30.0,40.0},
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 9.0,10.0,10.0,30.0,30.0,30.0,30.0,30.0,30.0,30.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},         
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,52.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,57.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,54.0,58.0},
			{50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,50.0,51.0,52.0,53.0,54.0,54.0,54.0,58.0},
			{60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,70.0,70.0,70.0,70.0,70.0,70.0,70.0,71.0,80.0,80.0,80.0,80.0,80.0,80.0,80.0},
			{60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,70.0,70.0,70.0,70.0,70.0,70.0,70.0,71.0,80.0,80.0,80.0,80.0,80.0,80.0,80.0},
			{60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,60.0,70.0,70.0,70.0,70.0,70.0,70.0,70.0,71.0,80.0,80.0,80.0,80.0,80.0,80.0,80.0},
			{61.0,70.0,70.0,70.0,71.0,80.0,80.0,80.0,80.0,80.0,80.0,80.0,80.0,81.0,90.0,90.0,90.0,91.0,91.0,91.0,91.0,92.0,95.0,95.0,95.0},
			{99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0,99.0}
	};

	/**
	 * Verifies that each of the test arrays is a valid sorted array.
	 */
	@Test
	public void testVerifySorted() {
		assertTrue(Sorted2DArraySearch.verifySorted(test1));
		assertTrue(Sorted2DArraySearch.verifySorted(test2));
		assertTrue(Sorted2DArraySearch.verifySorted(test3));
	}

	/**
	 * Verify correct results from the threeQuadrantSubSearch method.
	 */
	@Test
	public void testThreeQuadrantSubSearch() {
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 10));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 20));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 30));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 40));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 45));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 50));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 60));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 70));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 80));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 85));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 90));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 100));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 110));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 120));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 125));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 130));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 140));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 150));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 160));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 165));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 170));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 180));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 190));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 200));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 210));

		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 11));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 21));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test1, -101));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 600));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 101));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test1, 111));

		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "A"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "B"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "BBB"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "C"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "D"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "E"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "F"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "G"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "X"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "Y"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "YES"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "Z"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "ZZ"));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "ZZZ"));

		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "a"));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "b"));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "AAa"));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "CBC"));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "ZZZZ"));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test2, "Za"));

		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, -5.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, -3.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, -1.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 0.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 9.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 10.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 19.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 20.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 21.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 30.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 40.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 50.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 51.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 52.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 53.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 54.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 57.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 58.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 60.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 61.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 70.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 71.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 80.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 81.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 90.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 91.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 92.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 95.0));
		assertTrue(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 99.0));

		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, -50.0));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, -30.0));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, -10.0));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 0.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 9.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 10.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 19.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 20.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 21.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 30.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 41.0));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 50.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 51.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 52.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 53.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 54.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 57.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 58.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 60.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 61.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 70.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 71.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 80.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 81.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 90.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 91.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 92.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 95.5));
		assertFalse(Sorted2DArraySearch.threeQuadrantSubSearch(test3, 1000.0));
	}

	/**
	 * Verify correct results from the zigzagSearch method.
	 */
	@Test
	public void testZigzagSearch() {
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 10));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 20));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 30));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 40));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 45));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 50));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 60));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 70));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 80));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 85));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 90));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 100));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 110));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 120));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 125));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 130));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 140));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 150));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 160));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 165));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 170));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 180));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 190));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 200));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test1, 210));

		assertFalse(Sorted2DArraySearch.zigzagSearch(test1, 11));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test1, 21));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test1, -101));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test1, 600));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test1, 101));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test1, 111));

		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "A"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "B"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "BBB"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "C"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "D"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "E"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "F"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "G"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "X"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "Y"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "YES"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "Z"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "ZZ"));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test2, "ZZZ"));

		assertFalse(Sorted2DArraySearch.zigzagSearch(test2, "a"));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test2, "b"));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test2, "AAa"));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test2, "CBC"));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test2, "ZZZZ"));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test2, "Za"));

		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, -5.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, -3.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, -1.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 0.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 9.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 10.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 19.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 20.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 21.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 30.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 40.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 50.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 51.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 52.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 53.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 54.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 57.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 58.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 60.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 61.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 70.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 71.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 80.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 81.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 90.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 91.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 92.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 95.0));
		assertTrue(Sorted2DArraySearch.zigzagSearch(test3, 99.0));

		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, -50.0));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, -30.0));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, -10.0));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 0.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 9.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 10.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 19.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 20.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 21.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 30.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 41.0));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 50.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 51.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 52.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 53.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 54.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 57.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 58.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 60.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 61.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 70.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 71.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 80.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 81.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 90.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 91.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 92.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 95.5));
		assertFalse(Sorted2DArraySearch.zigzagSearch(test3, 1000.0));
	}

	/**
	 * Verify correct results from the binarySearchDiagonalSearch method.
	 */
	@Test
	public void testBinarySearchDiagonalSearch() {

		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 10));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 20));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 30));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 40));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 45));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 50));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 60));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 70));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 80));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 85));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 90));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 100));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 110));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 120));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 125));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 130));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 140));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 150));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 160));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 165));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 170));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 180));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 190));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 200));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 210));

		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 11));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 21));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, -101));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 600));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 101));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test1, 111));

		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "A"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "B"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "BBB"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "C"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "D"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "E"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "F"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "G"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "X"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "Y"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "YES"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "Z"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "ZZ"));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "ZZZ"));

		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "a"));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "b"));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "AAa"));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "CBC"));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "ZZZZ"));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test2, "Za"));

		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, -5.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, -3.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, -1.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 0.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 9.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 10.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 19.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 20.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 21.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 30.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 40.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 50.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 51.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 52.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 53.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 54.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 57.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 58.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 60.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 61.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 70.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 71.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 80.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 81.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 90.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 91.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 92.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 95.0));
		assertTrue(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 99.0));

		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, -50.0));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, -30.0));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, -10.0));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 0.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 9.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 10.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 19.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 20.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 21.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 30.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 41.0));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 50.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 51.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 52.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 53.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 54.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 57.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 58.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 60.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 61.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 70.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 71.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 80.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 81.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 90.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 91.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 92.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 95.5));
		assertFalse(Sorted2DArraySearch.binarySearchDiagonalSearch(test3, 1000.0));
	}
}
