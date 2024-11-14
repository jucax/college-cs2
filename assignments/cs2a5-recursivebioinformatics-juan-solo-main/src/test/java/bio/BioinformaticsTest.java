package bio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class tests out both the slow and fast
 * versions of the different recursive algorithms
 * you must implement. Your code must pass all
 * included test cases, but you must also add            
 * test cases in accordance with the instructions
 * below.
 * 
 * @author Jacob Schrum
 */
class BioinformaticsTest {

	/**
	 * 3 points
	 */
	@Test
	void testSlowDNAScore() {
		assertEquals(4,Bioinformatics.slowDNAScore("ATCTGAT","TGCATA"));
		assertEquals(5,Bioinformatics.slowDNAScore("ATGTTAT","ATCGTAC"));
		assertEquals(7,Bioinformatics.slowDNAScore("ATATATAT","TATATATA"));

		// TODO: Add artificial test cases with scores of 8, 9, and 10. These
		//       cases should complete quickly with the slowDNAScore, but also
		//       be diverse.
		assertEquals(8, Bioinformatics.slowDNAScore("ATGACTGATAA", "TGCATGCTAAA"));
		assertEquals(9, Bioinformatics.slowDNAScore("ATCGATCGAA", "ATCGAGCGAA"));
		assertEquals(10, Bioinformatics.slowDNAScore("ATCGATCGAA", "ATCGATCGAA"));
	}

	/**
	 * 5 points
	 */
	@Test
	void testFastDNAScore() {
		assertEquals(4,Bioinformatics.fastDNAScore("ATCTGAT","TGCATA"));
		assertEquals(5,Bioinformatics.fastDNAScore("ATGTTAT","ATCGTAC"));
		assertEquals(7,Bioinformatics.fastDNAScore("ATATATAT","TATATATA"));
		assertEquals(23,Bioinformatics.fastDNAScore("TCCCAGTTATGTCAGGGGACACGAGAATGCAGAGAC","AATTGCCGCCGTCGTTTTCAGCAGTTATGTCAGATC"));
		assertEquals(75,Bioinformatics.fastDNAScore("GCGCGTGCGCGGAAGGAGCCAAGGTGAAGTTGTAGCAGTGTGTCAGAAGAGGTGCGTGGCACCATGCTGTCCCCCGAGGCGGAGCGGGTGCTGCGGTACCTGGTCGAAGTAGAGGAGTTG","GACTTGTGGAACCTACTTCCTGAAAATAACCTTCTGTCCTCCGAGCTCTCCGCACCCGTGGATGACCTGCTCCCGTACACAGATGTTGCCACCTGGCTGGATGAATGTCCGAATGAAGCG"));

		// TODO: Add the same artificial test cases that you tested
		//       the slowDNAScore method with. Additionally, add 3
		//       test cases that the fastDNAScore method can handle,
		//       but the slowDNAScore method takes too long to solve.
		//       Your test cases must be diverse to get full credit.
		assertEquals(8, Bioinformatics.slowDNAScore("ATGACTGATAA", "TGCATGCTAAA"));
		assertEquals(9, Bioinformatics.slowDNAScore("ATCGATCGAA", "ATCGAGCGAA"));
		assertEquals(10, Bioinformatics.slowDNAScore("ATCGATCGAA", "ATCGATCGAA"));

		assertEquals(39, Bioinformatics.fastDNAScore("AATAGCTCGATGTCAGTAGGGGACACGAGAATGCAGAGAC", "AATAGCCCGATGTCAGTAGGGGACACGAGAATGCAGAGAC"));
		assertEquals(57, Bioinformatics.fastDNAScore("TCCCAGTTATGTCAGGGGACACGAGAATGCAGAGACGGGACACGAGAATGCAGAGAC", "TCCCAGTTATGTCAGGGGACACGAGAATGCAGAGACGGGACACGAGAATGCAGAGAC"));
		assertEquals(120, Bioinformatics.fastDNAScore("GCGCGTGCGCGGAAGGAGCCAAGGTGAAGTTGTAGCAGTGTGTCAGAAGAGGTGCGTGGCACCATGCTGTCCCCCGAGGCGGAGCGGGTGCTGCGGTACCTGGTCGAAGTAGAGGAGTTG", "GCGCGTGCGCGGAAGGAGCCAAGGTGAAGTTGTAGCAGTGTGTCAGAAGAGGTGCGTGGCACCATGCTGTCCCCCGAGGCGGAGCGGGTGCTGCGGTACCTGGTCGAAGTAGAGGAGTTG"));

	}

	/**
	 * 3 points
	 */
	@Test
	void testSlowRNAScore() {
		assertEquals(1,Bioinformatics.slowRNAScore("ACCCCCU"));
		assertEquals(2,Bioinformatics.slowRNAScore("ACCCCGU"));
		assertEquals(3,Bioinformatics.slowRNAScore("ACUGAGCCCU"));
		assertEquals(4,Bioinformatics.slowRNAScore("AAUUGCGC"));
		// Slow, but will finish
		assertEquals(8,Bioinformatics.slowRNAScore("ACUGAGCCCUGUUAGCUAA"));

		// TODO: Create artificial test cases with scores of 5, 6, and 7
		//       that complete execution even with the slowRNAScore method.
		assertEquals(5, Bioinformatics.slowRNAScore("ACUCGAGCCCUGUU"));
		assertEquals(6, Bioinformatics.slowRNAScore("AACUCGAGCCCUGUU"));
		assertEquals(7, Bioinformatics.slowRNAScore("AAAACUCGAGCCCUGUUU"));
	}

	/**
	 * 3 points
	 */
	@Test
	void testFastRNAScore() {
		assertEquals(1,Bioinformatics.fastRNAScore("ACCCCCU"));
		assertEquals(2,Bioinformatics.fastRNAScore("ACCCCGU"));
		assertEquals(4,Bioinformatics.fastRNAScore("AAUUGCGC"));
		assertEquals(3,Bioinformatics.fastRNAScore("ACUGAGCCCU"));
		assertEquals(8,Bioinformatics.fastRNAScore("ACUGAGCCCUGUUAGCUAA"));
		assertEquals(52,Bioinformatics.fastRNAScore("GGAUACGGCCAUACUGCGCAGAAAGCACCGCUUCCCAUCCGAACAGCGAAGUUAAGCUGCGCCAGGCGGUGUUAGUACUGGGGUGGGCGACCACCCGGGAAUCCACCGUGCCGUAUCCU"));
		assertEquals(68,Bioinformatics.fastRNAScore("AAAGAUCGGGUGAGAUAGUAGAGAUAGUAUGUGUCUCUCAUCUACUAUCGGGUAGAUUUCAUCUACUAUCGGGUAUAUCGGGUAAAAUCGGGUAAGAUUCUCUCUCAUCUACUGUGUCUCUCAUCUACUAUCGGGUAUAUCGGGUAAAAUCGGGUAA"));

		// TODO: Test the same extra cases that you tested the slowRNAScore
		//       method with.
		assertEquals(5, Bioinformatics.slowRNAScore("ACUCGAGCCCUGUU"));
		assertEquals(6, Bioinformatics.slowRNAScore("AACUCGAGCCCUGUU"));
		assertEquals(7, Bioinformatics.slowRNAScore("AAAACUCGAGCCCUGUUU"));
	}

}                  
