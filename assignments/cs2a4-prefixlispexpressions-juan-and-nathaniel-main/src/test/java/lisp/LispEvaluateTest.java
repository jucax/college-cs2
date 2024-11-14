package lisp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This file is meant to test the lispCalculate method              
 * and nothing else. The one test method contains three
 * test cases, but you must provide more.             
 * 
 * @author Jacob Schrum
 */
class LispEvaluateTest {

	/**
	 * 10 points for quality of tests. Test a variety of unusual/tricky situations.
	 */
	@Test
	void testLispCalculate() {
		assertEquals(2465.244, LispEvaluate.lispCalculate("(+ 4 3 4.324 (- 1 5) 56 (* 9 (/ 8.34 3) 32 3))"), 0);
		assertEquals(16.5, LispEvaluate.lispCalculate("(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))"), 0);
		assertEquals(-2302.733333333333, LispEvaluate.lispCalculate("(- 4 6.7 (* 23 100) (+) (/ 4 (+ 2 (- 34 (* 3 2) (- 2 (+ 92))))))"), 0);
		assertEquals(-23.25, LispEvaluate.lispCalculate("(- 9 10 1 (*) (+ 4 16 ) (/ (* 1 4)))"), 0);
		assertEquals(15, LispEvaluate.lispCalculate("(+ 1 2 (* 3 5) (- 4 7))"), 0);
		assertEquals(-237600, LispEvaluate.lispCalculate("(* 1 2 (* 10 4 2) (+ 6 5 (- 1 2 307 )) (+ 2 3 ))"), 0);
		assertEquals(14, LispEvaluate.lispCalculate("(+ (- 18) (+ 3 2 1) (/ 10 5) (* 2 3 4))"), 0);
		assertEquals(13.2, LispEvaluate.lispCalculate("(/ (+ (* 12 3) (- 45 15)) (- (* 4 2) 3))"), 0);
		assertEquals(-21, LispEvaluate.lispCalculate("(- 9 1 (*) 7 (- 2 1 ) (* (/ 80 4)))"), 0);
		assertEquals(65, LispEvaluate.lispCalculate("(+ (* 4 (- 20 5)) (/ (- 50 10) (+ 6 2)))"), 0);
		assertEquals(5, LispEvaluate.lispCalculate("(+ (* 2.2 (- 5 (/ 10 2))) (/ (- 20 5) 3))"), 0);
		assertEquals(7634, LispEvaluate.lispCalculate("(- (+ (* 123 45) 6789) (* 2345 2))"), 0);
		assertEquals(30, LispEvaluate.lispCalculate("(* (/ 3 (- (* 6 2) 10)) (+ (* 4 3) (- 16 (/ 32 4))))"), 0);
		assertThrows(ArithmeticException.class, () -> {
			LispEvaluate.lispCalculate("(/ 0)");
		});
		

		// TODO: Add at least 10 more test cases. Make sure you cover a variety of
		//       interesting cases. Explain the interesting cases in comments.
		//       Note that for some tests, a larger epsilon error margin may be
		//       warranted, but you must explain why.
	}

}