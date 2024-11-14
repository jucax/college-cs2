
package sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This file has some basic tests to verify the
 * correct functioning of your sorting algorithm
 * implementations. You do not need to add or modify
 * any tests, but your sorting function implementations
 * must pass all of these tests. However, note that
 * simply passing these tests does not mean your                 
 * implementation is correct. There are many ways to
 * accidentally cheat in your implementations which
 * will lead to correct, but inefficient, answers.
 * However, an attempt has been made to at least verify
 * comparative runtimes of certain sorting algorithms
 * make sense.
 * 
 * @author Jacob Schrum
 */
class SortingTest {            
              
	// Arrays that are used for testing sorting functions
	Integer[] intArray1;
	Integer[] intArray1Sorted;
	Integer[] intArray2; 
	Integer[] intArray2Sorted; 
	Integer[] intArray3; 
	Integer[] intArray3Sorted; 
	Integer[] intArray4; 
	Integer[] intArray4Sorted; 
	Integer[] intArray5;
	Integer[] intArray5Sorted;
	Integer[] intArray6;
	Integer[] intArray6Sorted;
	Integer[] intArray7;
	Integer[] intArray7Sorted;

	String[] stringArray1; 
	String[] stringArray1Sorted; 
	String[] stringArray2;
	String[] stringArray2Sorted;
	String[] stringArray3;
	String[] stringArray3Sorted;
	String[] stringArray4;
	String[] stringArray4Sorted;

	Double[] doubleArray1;
	Double[] doubleArray1Sorted;
	Double[] doubleArray2;
	Double[] doubleArray2Sorted;
	Double[] doubleArray3;
	Double[] doubleArray3Sorted;
	Double[] doubleArray4;
	Double[] doubleArray4Sorted;	

	Integer[] bigArray;

	/**
	 * Resets array contents before testing each sorting method.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		intArray1 = new Integer[]{5, 20, -324, 54, 100, 3, 0, 2040, 3, 3532, -2411, 545, 0, 22};
		intArray1Sorted = new Integer[] {-2411, -324, 0, 0, 3, 3, 5, 20, 22, 54, 100, 545, 2040, 3532};
		intArray2 = new Integer[] {Integer.MAX_VALUE, -100, 100, 0, Integer.MIN_VALUE};
		intArray2Sorted = new Integer[] {Integer.MIN_VALUE, -100, 0, 100, Integer.MAX_VALUE};
		intArray3 = new Integer[] {2, 1, 0, -1, -2};
		intArray3Sorted = new Integer[] {-2, -1, 0, 1, 2};
		intArray4 = new Integer[] {2, 1};
		intArray4Sorted = new Integer[] {1, 2};
		intArray5 = new Integer[] {2145532681, 402649739, -1809746839, 1694544504, 1370744856, -698484645, 1853196068, -484575001, -1073505865, -406253864};
		intArray5Sorted = new Integer[] {-1809746839, -1073505865, -698484645, -484575001, -406253864, 402649739, 1370744856, 1694544504, 1853196068, 2145532681};
		intArray6 = new Integer[] {-682990671, -442027205, 1281038551, -1590472228, -1599463858, 870383254, 2050796607, 1545392194, 456980604, -356663711, 1602494644, -1272589283, -945501112, 376715188, -1550098788, -165247328, -145146944, -1337258977, 508502643, 1074536661};
		intArray6Sorted = new Integer[] {-1599463858, -1590472228, -1550098788, -1337258977, -1272589283, -945501112, -682990671, -442027205, -356663711, -165247328, -145146944, 376715188, 456980604, 508502643, 870383254, 1074536661, 1281038551, 1545392194, 1602494644, 2050796607};
		intArray7 = new Integer[] {-178005022, -1535170499, -262986660, -1516784683, -465045862, 2137737319, 1376366324, 1178965860, -1772965025, 331588207, 1935446936, 24863036, 1166337944, 735386017, 781905992, 1176713313, 1258134828, -2084047590, 408192999, 1052914419, -1864687929, -56391926, -424334543, 150860625, 337166538, -481761814, 2079168563, -1545796093, -165145301, 421283941};
		intArray7Sorted = new Integer[] {-2084047590, -1864687929, -1772965025, -1545796093, -1535170499, -1516784683, -481761814, -465045862, -424334543, -262986660, -178005022, -165145301, -56391926, 24863036, 150860625, 331588207, 337166538, 408192999, 421283941, 735386017, 781905992, 1052914419, 1166337944, 1176713313, 1178965860, 1258134828, 1376366324, 1935446936, 2079168563, 2137737319};		

		stringArray1 = new String[]{"Hello", "Goodbye", "up", "down", "left", "right", "yes", "NO", "A", "a", "This is a sentence", "jaskl sadkl asdkl"};
		stringArray1Sorted = new String[] {"A", "Goodbye", "Hello", "NO", "This is a sentence", "a", "down", "jaskl sadkl asdkl", "left", "right", "up", "yes"};
		stringArray2 = new String[]{"pretexting","comporting","Mowgli","corroborations","tracksuits","antiviral","bedrooms","negates","goal","raises"};
		stringArray2Sorted = new String[]{"Mowgli","antiviral","bedrooms","comporting","corroborations","goal","negates","pretexting","raises","tracksuits"};
		stringArray3 = new String[]{"biking","yokels","overcompensate","mineralogy","delirious","soothsayers","headstrong","vindaloos","lavishest","ringingly","elbowing","polarization","bureaucrat","blah","teacupful","installation","workaholic","sketched","suspicious"};
		stringArray3Sorted = new String[]{"biking","blah","bureaucrat","delirious","elbowing","headstrong","installation","lavishest","mineralogy","overcompensate","polarization","ringingly","sketched","soothsayers","suspicious","teacupful","vindaloos","workaholic","yokels"};
		stringArray4 = new String[]{"Linux","semisolid","leaven","ladybugs","preppier","waltzers","distressed","rewove","waver","overdraws","humanism","conflagration","serialize","leasers","�clairs","allusions","Chan","friedcakes","quicken","portico","gradualness","withering","renegotiates","via","unattractive","deceiving","sterning","gleaner","wedder","gerrymander"};
		stringArray4Sorted = new String[]{"Chan","Linux","allusions","conflagration","deceiving","distressed","friedcakes","gerrymander","gleaner","gradualness","humanism","ladybugs","leasers","leaven","overdraws","portico","preppier","quicken","renegotiates","rewove","semisolid","serialize","sterning","unattractive","via","waltzers","waver","wedder","withering","�clairs"};


		doubleArray1 = new Double[]{0.0, 345.0, 423423534636345.0, 0.00320420404, -23423154234234.0, Double.NEGATIVE_INFINITY, -325423.423423, 100000000.00001, Double.POSITIVE_INFINITY, -0.0000000000002, 1435.0, 3.2, 0.5};
		doubleArray1Sorted = new Double[] {Double.NEGATIVE_INFINITY, -23423154234234.0, -325423.423423, -0.0000000000002, 0.0, 0.00320420404, 0.5, 3.2, 345.0, 1435.0, 100000000.00001, 423423534636345.0, Double.POSITIVE_INFINITY};		
		doubleArray2 = new Double[]{239.204,249.985,235.048,34.5103,-195.601,-120.716,33.6581,-173.733,57.9409,167.469};
		doubleArray2Sorted = new Double[]{-195.601,-173.733,-120.716,33.6581,34.5103,57.9409,167.469,235.048,239.204,249.985};
		doubleArray3 = new Double[]{-50.3876,-170.812,-112.429,-42.7326,29.0751,203.575,64.1843,-192.614,30.7817,-80.0339,185.808,-41.8006,-22.121,-84.8587,84.7194,129.855,159.955,90.0116,-39.0494,234.66};
		doubleArray3Sorted = new Double[]{-192.614,-170.812,-112.429,-84.8587,-80.0339,-50.3876,-42.7326,-41.8006,-39.0494,-22.121,29.0751,30.7817,64.1843,84.7194,90.0116,129.855,159.955,185.808,203.575,234.66};
		doubleArray4 = new Double[]{79.436,225.822,-222.627,8.69546,-67.9973,-43.0985,-10.4393,-171.354,-71.1476,-98.1996,-176.732,181.873,126.385,116.733,1.32689,189.23,13.3711,29.8939,-139.51,-74.3213,236.784,110.151,-246.257,242.613,183.057,45.318,99.1059,-175.281,-192.29,-41.6985};
		doubleArray4Sorted = new Double[]{-246.257,-222.627,-192.29,-176.732,-175.281,-171.354,-139.51,-98.1996,-74.3213,-71.1476,-67.9973,-43.0985,-41.6985,-10.4393,1.32689,8.69546,13.3711,29.8939,45.318,79.436,99.1059,110.151,116.733,126.385,181.873,183.057,189.23,225.822,236.784,242.613};
	}

	/**
	 * Verify correct size and ordering of the Integer array
	 */
	public void checkIntArrays(){
		assertArrayEquals(intArray1Sorted, intArray1);
		assertArrayEquals(intArray2Sorted, intArray2);
		assertArrayEquals(intArray3Sorted, intArray3);
		assertArrayEquals(intArray4Sorted, intArray4);
		assertArrayEquals(intArray5Sorted, intArray5);
		assertArrayEquals(intArray6Sorted, intArray6);
		assertArrayEquals(intArray7Sorted, intArray7);
	}

	/**
	 * Verify correct size and ordering of the String array
	 */
	public void checkStringArrays() {
		assertArrayEquals(stringArray1Sorted, stringArray1);
		assertArrayEquals(stringArray2Sorted, stringArray2);
		assertArrayEquals(stringArray3Sorted, stringArray3);
		assertArrayEquals(stringArray4Sorted, stringArray4);
	}

	/**
	 * Verify correct size and ordering of the Double array
	 */
	public void checkDoubleArrays() {
		assertArrayEquals(doubleArray1Sorted, doubleArray1);
		assertArrayEquals(doubleArray2Sorted, doubleArray2);
		assertArrayEquals(doubleArray3Sorted, doubleArray3);
		assertArrayEquals(doubleArray4Sorted, doubleArray4);
	}

	/**
	 * Verify correct functioning of selection sort
	 */
	@Test
	public void testSelectionSort() {
		Sorting.selectionSort(intArray1);
		Sorting.selectionSort(intArray2);
		Sorting.selectionSort(intArray3);
		Sorting.selectionSort(intArray4);
		Sorting.selectionSort(intArray5);
		Sorting.selectionSort(intArray6);
		Sorting.selectionSort(intArray7);
		checkIntArrays();
		Sorting.selectionSort(stringArray1);
		Sorting.selectionSort(stringArray2);
		Sorting.selectionSort(stringArray3);
		Sorting.selectionSort(stringArray4);
		checkStringArrays();
		Sorting.selectionSort(doubleArray1);
		Sorting.selectionSort(doubleArray2);
		Sorting.selectionSort(doubleArray3);
		Sorting.selectionSort(doubleArray4);
		checkDoubleArrays();
	}

	/**
	 * Verify correct functioning of insertion sort
	 */
	@Test
	public void testInsertionSort() {
		Sorting.insertionSort(intArray1);
		Sorting.insertionSort(intArray2);
		Sorting.insertionSort(intArray3);
		Sorting.insertionSort(intArray4);
		Sorting.insertionSort(intArray5);
		Sorting.insertionSort(intArray6);
		Sorting.insertionSort(intArray7);
		checkIntArrays();
		Sorting.insertionSort(stringArray1);
		Sorting.insertionSort(stringArray2);
		Sorting.insertionSort(stringArray3);
		Sorting.insertionSort(stringArray4);
		checkStringArrays();
		Sorting.insertionSort(doubleArray1);
		Sorting.insertionSort(doubleArray2);
		Sorting.insertionSort(doubleArray3);
		Sorting.insertionSort(doubleArray4);
		checkDoubleArrays();
	}

	/**
	 * Verify correct functioning of merge sort
	 */
	@Test
	public void testMergeSort() {
		Sorting.mergeSort(intArray1);
		Sorting.mergeSort(intArray2);
		Sorting.mergeSort(intArray3);
		Sorting.mergeSort(intArray4);
		Sorting.mergeSort(intArray5);
		Sorting.mergeSort(intArray6);
		Sorting.mergeSort(intArray7);
		checkIntArrays();
		Sorting.mergeSort(stringArray1);
		Sorting.mergeSort(stringArray2);
		Sorting.mergeSort(stringArray3);
		Sorting.mergeSort(stringArray4);
		checkStringArrays();
		Sorting.mergeSort(doubleArray1);
		Sorting.mergeSort(doubleArray2);
		Sorting.mergeSort(doubleArray3);
		Sorting.mergeSort(doubleArray4);
		checkDoubleArrays();
	}

	/**
	 * Verify correct functioning of quick sort
	 */
	@Test
	public void testQuickSort() {
		Sorting.quickSort(intArray1);
		Sorting.quickSort(intArray2);
		Sorting.quickSort(intArray3);
		Sorting.quickSort(intArray4);
		Sorting.quickSort(intArray5);
		Sorting.quickSort(intArray6);
		Sorting.quickSort(intArray7);
		checkIntArrays();
		Sorting.quickSort(stringArray1);
		Sorting.quickSort(stringArray2);
		Sorting.quickSort(stringArray3);
		Sorting.quickSort(stringArray4);
		checkStringArrays();
		Sorting.quickSort(doubleArray1);
		Sorting.quickSort(doubleArray2);
		Sorting.quickSort(doubleArray3);
		Sorting.quickSort(doubleArray4);
		checkDoubleArrays();
	}

	public void fillBigArray() {
		// A big array filled in a systematic way with out of order elements
		bigArray = new Integer[90000];
		for(int i = 0; i < bigArray.length; i++) {
			bigArray[i] = i*333 % 1000;
		}
	}

	/**
	 * Do some rudimentary verification of runtimes of different
	 * sorting algorithms.
	 */
	@Test
	public void testReasonableSpeeds() {
		fillBigArray();
		long startSelection = System.currentTimeMillis();
		Sorting.selectionSort(bigArray);
		long endSelection = System.currentTimeMillis();	
		long selectionTime = endSelection - startSelection;

		fillBigArray();
		long startInsertion = System.currentTimeMillis();
		Sorting.insertionSort(bigArray);
		long endInsertion = System.currentTimeMillis();
		long insertionTime = endInsertion - startInsertion;

		fillBigArray();
		long startMerge = System.currentTimeMillis();
		Sorting.mergeSort(bigArray);
		long endMerge = System.currentTimeMillis();
		long mergeTime = endMerge - startMerge;

		fillBigArray();
		long startQuick = System.currentTimeMillis();
		Sorting.quickSort(bigArray);
		long endQuick = System.currentTimeMillis();
		long quickTime = endQuick - startQuick;

		assertTrue(selectionTime > 4000); // Should be much slower
		assertTrue(insertionTime > 4000); // Should be much slower
		assertTrue(mergeTime < 200); // Should be much faster
		assertTrue(quickTime < 200); // Should be much faster
	}
}
