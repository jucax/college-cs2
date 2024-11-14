package bio;

import java.util.*;


/**
 * This class contains both slow and fast algorithms
 * for computing Fibonacci numbers. These algorithms
 * are both recursive, but the fast version uses memoization
 * to avoid duplicating computation efforts. There are
 * less memory-intensive ways for quickly computing
 * Fibonacci numbers, but this approach serves as a good
 * example of how you should create memoized versions    
 * of the bioinformatics algorithms that are the main
 * focus of this assignment. There are code stubs for these
 * methods, and you must provide the code in accordance
 * with the program description.                   
 *
 * @author Jacob Schrum
 */
public class Bioinformatics {

	// Call code that you want to debug here.
	public static void main(String[] args) {
		System.out.println("LCS for ATCTGAT and TGCATA is " + slowDNAScore("ATCTGAT","TGCATA"));
	}

	/** 
	 * Simple recursive method for defining the Fibonacci sequence,
	 * but very inefficient.
	 * 
	 * @param n Fibonacci number to determine
	 * @return n-th Fibonacci number
	 */
	public static int slowFib(int n) {                
		if(n == 0 || n == 1) return 1;
		else return slowFib(n - 1) + slowFib(n - 2);
	}

	/**
	 * A faster method for defining the Fibonacci sequence
	 * that saves and remembers every value ever calculated
	 * in an array, so that each value is only ever calculated
	 * once. This technique is known as "memoization" and is
	 * associated with a technique known as Dynamic Programming
	 * which you will learn more about in your Algorithms class.
	 * 
	 * This particular method is merely a kick-off method for the
	 * actual recursive method.
	 * 
	 * @param n Fibonacci number to determine
	 * @return n-th Fibonacci number
	 */
	public static int fastFib(int n) {
		// First create an array that will store all Fibonacci numbers
		int[] known = new int[n+1];
		// Fill it with -1 to indicate values that are not known yet
		Arrays.fill(known, -1);
		// Compute the numbers
		return fastFib(known, n);
	}

	/**
	 * This method behaves in essentially the same
	 * way as the standard Fibonacci definition, but
	 * a reference to an array is passed to each method
	 * call. Because the array parameter is merely a 
	 * reference, it functions like a global variable
	 * visible to all recursive calls. When a known
	 * Fibonacci number is to be calculated, it is
	 * immediately returned from the array. If the value
	 * is not know, then it is calculated and stored in
	 * the array before being returned.
	 * 
	 * Note: Although this approach is fast, it is inefficient
	 * in terms of memory usage. There are fast ways to compute
	 * any Fibonacci number using much less memory, but this
	 * example provides a useful template for the harder problems
	 * you must solve below.
	 * 
	 * @param known Array that stores known Fibonacci
	 * 				numbers. Unknown values are represented
	 * 				with the value -1.
	 * @param n Fibonacci number to determine
	 * @return n-th Fibonacci number
	 */
	private static int fastFib(int[] known, int n) {
		// Only compute the value if it is not known
		if(known[n] == -1) { 
			if(n == 0 || n == 1) { // Base Case
				known[n] = 1;
			} else { // Recursive Case
				known[n] = fastFib(known, n-1) + fastFib(known, n-2);
			}
		}
		return known[n]; // The answer must be in the array
	}

	/**
	 * Determines the length of the longest common subsequence
	 * between two DNA strands. Note that valid DNA strings can
	 * only contain the letters A, T, C, and G. This slow
	 * version of the method simply uses the recursive score
	 * calculation, which makes it very inefficient.
	 * 
	 * Note: This method is simply the kick-off
	 *       method for your actual recursive algorithm. 
	 *       Also, do NOT use the substring method.
	 * 
	 * @param dna1 A DNA string containing only the letters A, T, C, and G.
	 * @param dna2 Another DNA string containing only the letters A, T, C, and G.
	 * @return Length of the longest common subsequence in a global alignment
	 *         of the two DNA strands.
	 */
	public static int slowDNAScore(String dna1, String dna2) {
		// The kick-off specifies that last indexes of each string so that both complete strings are checked
		return slowDNAScore(dna1, dna2, dna1.length() - 1, dna2.length() - 1);
	}

	/**
	 * Use an inneficient recursively calls to calculate the length of the 
	 * longest common subsequence between two valid DNA strands. Calculate 
	 * all possible alignments cases to determine the longest common subsequence.
	 * 
	 * @param dna1 A DNA string containing only the letters A, T, C, and G.
	 * @param dna2 Another DNA string containing only the letters A, T, C, and G.
	 * @param i    An int that represent the index in the first DNA string being compared.
	 * @param j    An int that represent the index in the second DNA string being compared.
	 * @return     The length of the longest common subsequence between the two DNA strands.
	 */
	private static int slowDNAScore(String dna1, String dna2, int i, int j) {
		if(i == -1 || j == -1) {
			return 0; // Base Case
		} else {
			// Recursive case
			// dna1 gets shorter
			int case1 = slowDNAScore(dna1, dna2, i - 1, j); 
			// dna2 gets shorter
			int case2 = slowDNAScore(dna1, dna2, i, j - 1); 
			// found a match
			int case3 = -1; // -1 will not be the max
			if(dna1.charAt(i) == dna2.charAt(j)) {
				case3 = 1 + slowDNAScore(dna1, dna2, i -1 , j - 1);
			}
			return Math.max(Math.max(case1, case2), case3); // TODO: Change: return MAX of the up to three cases above
		}
	}	

	/**
	 * This method should return the exact same answers as your
	 * slowDNAScore method. However, it must use memoization to
	 * perform faster. This means that previously calculated
	 * results will be saved for reuse later. You should save
	 * your previously calculated results in a 2D array that
	 * is passed between all recursive method calls. Otherwise,
	 * the code is very similar to the slowDNAScore method.
	 * 
	 * Note: This method is simply the kick-off
	 *       method for your actual recursive algorithm. 
	 *       Also, do NOT use the substring method.
	 * 
	 * @param dna1 A DNA string containing only the letters A, T, C, and G.
	 * @param dna2 Another DNA string containing only the letters A, T, C, and G.
	 * @return Length of the longest common subsequence in a global alignment
	 *         of the two DNA strands.
	 */
	public static int fastDNAScore(String dna1, String dna2) {
		// known[i][j] will store results of fastDNAScore(known, dna1, dna2, i, j)
		int[][] known = new int[dna1.length()][dna2.length()];
		for(int i = 0; i < known.length; i++) {
			Arrays.fill(known[i], -1);
		}
		return fastDNAScore(known, dna1, dna2, dna1.length() - 1, dna2.length() - 1);
	}

	/**
	 * Use recursive calls with memoization to effectively calculate 
	 * the length of the longest common subsequence between two valid 
	 * DNA strands. Calculate, storage and re use all possible alignments 
	 * cases to determine the longest common subsequence.
	 * 
	 * @param known 2D array storing previously calculated results of subproblems.
	 * @param dna1  A DNA string containing only the letters A, T, C, and G.
	 * @param dna2  Another DNA string containing only the letters A, T, C, and G.
	 * @param i     An int that represent the index in the first DNA string being compared.
	 * @param j     An int that represent the index in the second DNA string being compared.
	 * @return      The length of the longest common subsequence between the two DNA strands.
	 */
	private static int fastDNAScore(int[][] known, String dna1, String dna2, int i, int j) {
		// TODO: Replace return below with actual algorithm
		if(i == -1 || j == -1) {
			return 0; // Base Case
		} else if(known[i][j] == -1) {
			// Recursive case
			// dna1 gets shorter
			int case1 = fastDNAScore(known, dna1, dna2, i - 1, j); 
			// dna2 gets shorter
			int case2 = fastDNAScore(known, dna1, dna2, i, j - 1); 
			// found a match
			int case3 = -1; // -1 will not be the max
			if(dna1.charAt(i) == dna2.charAt(j)) {
				case3 = 1 + fastDNAScore(known, dna1, dna2, i -1 , j - 1);
			}
			known[i][j] = Math.max(Math.max(case1, case2), case3); // TODO: Change: return MAX of the up to three cases above
		}
		return known[i][j]; // Return the answer we know
	}	

	/**
	 * Method determines the maximum number of base pair matches 
	 * in a folded RNA strand with no pseudo-knots (bases that
	 * are part of different loops cannot pair up). This slow
	 * version of the method simply uses the recursive score
	 * calculation, which makes it very inefficient.
	 * 
	 * Note: This method is simply the kick-off
	 *       method for your actual recursive algorithm. 
	 *       Also, do NOT use the substring method.
	 * 
	 * @param rna String representing RNA strand. Can only contain
	 *            the letters A, U, C, and G.
	 * @return Maximum number of base pairings in folded strand
	 *         with no pseudo-knots.
	 */
	public static int slowRNAScore(String rna) {
		// Initial start and end indexes comprise the entire String
		return slowRNAScore(rna, 0, rna.length() - 1);
	}	

	/**
	 * Use inneficient recursively calls to calculates the maximum 
	 * number of base pair matches in a folded RNA strand without pseudo-knots. 
	 * It calculate all possible combinations cases to determine the maximum 
	 * number of base pairings in the RNA.
	 * 
	 * @param rna A valid RNA strand to analyze, composed only of the letters A, U, C, and G.
	 * @param i   An int that represent the starting index of the current section of RNA being evaluated.
	 * @param j   An int that represent the ending index of the current section of RNA being evaluated.
	 * @return    The max number of base pairings that the folded RNA strand can contains.
	 */
	private static int slowRNAScore(String rna, int i, int j) {
		// Base case:
		if(i >= j) {
			return 0; 
		} else {
			// Recursive case
			// Case 1: ...
			int case1 = -1;
			if(canPair(rna.charAt(i), rna.charAt(j))) {
				// TODO
				case1 = 1 + slowRNAScore(rna, i + 1, j - 1);
			}
			// Case 2: ...
			// TODO
			int case2 = slowRNAScore(rna, i + 1, j);
			// Case 3: ...
			// TODO
			int case3 = slowRNAScore(rna, i, j - 1);
			// Case 4: ...
			// Use a for loop that makes a recursive call on each iteration
			// TODO: max across all the loop iterations
			int case4 = -1;
			for (int k = i + 1 ; k < j ; k++) {
				case4 = Math.max(case4, slowRNAScore(rna, i, k) + slowRNAScore(rna, k + 1, j));
			}
			// Compute max of the 4 cases
			return Math.max(Math.max(Math.max(case1, case2), case3), case4);
		}
	}	

	/**
	 * Determines if two RNA bases are a pair according to RNA base pairing rules.
	 * Verify there is a pair of denine (A) with uracil (U), or cytosine (C) with guanine (G).
	 * 
	 * @param base1 A valid RNA base to check.
	 * @param base2 Another valid RNA base to check.
	 * @return      True if the two bases can form a pair, otherwise false.
	 */
	private static boolean canPair(char base1, char base2) {
		return (base1 == 'A' && base2 == 'U')
			|| (base1 == 'U' && base2 == 'A')
			|| (base1 == 'C' && base2 == 'G')
			|| (base1 == 'G' && base2 == 'C');
	}

	/**
	 * This method should return the exact same answers as your
	 * slowRNAScore method. However, it must use memoization to
	 * perform faster. This means that previously calculated
	 * results will be saved for reuse later. You should save
	 * your previously calculated results in a 2D array that
	 * is passed between all recursive method calls. Otherwise,
	 * the code is very similar to the slowRNAScore method.
	 * 
	 * Note: This method is simply the kick-off
	 *       method for your actual recursive algorithm. 
	 *       Also, do NOT use the substring method.
	 * 
	 * @param rna String representing RNA strand. Can only contain
	 *            the letters A, U, C, and G.
	 * @return Maximum number of base pairings in folded strand
	 *         with no pseudo-knots.
	 */
	public static int fastRNAScore(String rna) {
		// known[i][j] will store results of fastRNAScore(known, rna, i, j)
		int[][] known = new int[rna.length()][rna.length()];
		for(int i = 0; i < known.length; i++) {
			Arrays.fill(known[i], -1);
		}
		return fastRNAScore(known, rna.toUpperCase(), 0, rna.length() - 1);
	}

	/**
	 * Use recursive calls with memoization to effectively calculate the maximum 
	 * number of base pair matches in a folded RNA strand without pseudo-knots. 
	 * It calculate all possible combinations cases to determine the maximum 
	 * number of base pairings in the RNA.
	 * 
	 * @param known A 2D array storing previously calculated results of subproblems.
	 * @param rna A valid RNA strand to analyze, composed only of the letters A, U, C, and G.
	 * @param i   An int that represent the starting index of the current section of RNA being evaluated.
	 * @param j   An int that represent the ending index of the current section of RNA being evaluated.
	 * @return    The max number of base pairings that the folded RNA strand can contains.
	 */
	private static int fastRNAScore(int[][] known, String rna, int i, int j) {
		// TODO: Replace return below with actual algorithm
		// Base case:
		if(i >= j) {
			return 0; 
		} else if (known[i][j] == -1) {
			// Recursive case
			// Case 1: ...
			int case1 = -1;
			if(canPair(rna.charAt(i), rna.charAt(j))) {
				// TODO
				case1 = 1 + fastRNAScore(known, rna, i + 1, j - 1);
			}
			// Case 2: ...
			// TODO
			int case2 = fastRNAScore(known, rna, i + 1, j);
			// Case 3: ...
			// TODO
			int case3 = fastRNAScore(known, rna, i, j - 1);
			// Case 4: ...
			// Use a for loop that makes a recursive call on each iteration
			// TODO: max across all the loop iterations
			int case4 = -1;
			for (int k = i + 1 ; k < j ; k++) {
				case4 = Math.max(case4, fastRNAScore(known, rna, i, k) + fastRNAScore(known, rna, k + 1, j));
			}
			// Compute max of the 4 cases
			known[i][j] = Math.max(Math.max(Math.max(case1, case2), case3), case4);
		}
		return known[i][j];
	}	
}                      