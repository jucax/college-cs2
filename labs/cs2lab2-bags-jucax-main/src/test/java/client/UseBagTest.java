package client;

import static org.junit.jupiter.api.Assertions.*;

import bag.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class UseBagTest {

	BagInterface<Integer> intBag1;
	BagInterface<Integer> intBag2;
	BagInterface<String> stringBag1;
	BagInterface<String> stringBag2;
	BagInterface<Double> doubleBag1;
	BagInterface<Double> doubleBag2;

	@BeforeEach
	void setUp() {
		intBag1 = new MysteryBag<>();
		intBag1.add(10);
		intBag1.add(10);
		intBag1.add(10);
		intBag1.add(10);
		intBag1.add(34);
		intBag1.add(200);
		intBag1.add(200);
		intBag1.add(34);
		intBag1.add(34);
		intBag1.add(34);
		intBag2 = new MysteryBag<>();
		intBag2.add(340);
		intBag2.add(30);
		intBag2.add(200);
		intBag2.add(34);
		intBag2.add(34);

		stringBag1 = new MysteryBag<>();
		stringBag1.add("Hello");
		stringBag1.add("Test");
		stringBag1.add("Test");
		stringBag1.add("Test");
		stringBag1.add("!@#$%^&*()");
		stringBag1.add("!@#$%^&*()");
		stringBag1.add("This one is a sentence!");
		stringBag2 = new MysteryBag<>();
		stringBag2.add("Hello");
		stringBag2.add("Hello");
		stringBag2.add("Bye");
		stringBag2.add("Hello");
		stringBag2.add("Test");
		stringBag2.add("!@#$%^&*()");
		stringBag2.add("This one is a sentence!");

		doubleBag1 = new MysteryBag<>();
		doubleBag1.add(1.0);
		doubleBag1.add(123.357);
		doubleBag1.add(500.0);
		doubleBag1.add(0.00000023);
		doubleBag2 = new MysteryBag<>();
		doubleBag2.add(1.0);
		doubleBag2.add(1.0);
		doubleBag2.add(1.0);
		doubleBag2.add(500.0);
		doubleBag2.add(500.0);
		doubleBag2.add(500.0);
		doubleBag2.add(500.0);
		doubleBag2.add(500.0);
		doubleBag2.add(500.01);
		doubleBag2.add(500.01);
		doubleBag2.add(0.00000023);

	}

	/**
	 * Verify that two bags are equal
	 * 
	 * @param <T> Type of elements in both bags
	 * @param bag1 First bag
	 * @param bag2 Second bag
	 * @return true if bags contain all the same elements and false otherwise
	 */
	static <T> boolean bagEquals(BagInterface<T> bag1, BagInterface<T> bag2) {
		// Bags have to have same size in order to be equal
		if(bag1.getCurrentSize() != bag2.getCurrentSize()) return false;
		T[] bag1Contents = bag1.toArray();
		T[] bag2Contents = bag2.toArray();
		Arrays.sort(bag1Contents);
		Arrays.sort(bag2Contents);
		for(int i = 0; i < bag1Contents.length; i++) {
			if(!bag1Contents[i].equals(bag2Contents[i])) {
				return false;
			}
		}
		return true;
	}

	@Test
	void testBiggerBag() {
		assertEquals(intBag1,UseBag.biggerBag(intBag1,intBag2));
		assertEquals(stringBag1,UseBag.biggerBag(stringBag1,stringBag2));
		assertEquals(doubleBag2,UseBag.biggerBag(doubleBag1,doubleBag2));
	}

	@Test
	void testBagWithXOfY() {
		BagInterface<Integer> fiveOnes = UseBag.bagWithXOfY(5, 1);
		assertEquals(5,fiveOnes.getFrequencyOf(1));
		assertEquals(5,fiveOnes.getCurrentSize());

		BagInterface<Double> tenInfinities = UseBag.bagWithXOfY(10, Double.POSITIVE_INFINITY);
		assertEquals(10,tenInfinities.getFrequencyOf(Double.POSITIVE_INFINITY));
		assertEquals(10,tenInfinities.getCurrentSize());

		BagInterface<String> zeroWords = UseBag.bagWithXOfY(0, "Doesn't matter");
		assertEquals(0,zeroWords.getFrequencyOf("Doesn't matter"));
		assertEquals(0,zeroWords.getCurrentSize());

	}

	@Test
	void testRemoveAllFromBag() {
		UseBag.removeAllFromBag(intBag1, 10);
		assertFalse(intBag1.contains(10));
		UseBag.removeAllFromBag(intBag1, 30);
		assertFalse(intBag1.contains(30));
		UseBag.removeAllFromBag(intBag1, 34);
		assertFalse(intBag1.contains(34));
		UseBag.removeAllFromBag(intBag1, 340);
		assertFalse(intBag1.contains(340));
		UseBag.removeAllFromBag(intBag1, 200);
		assertFalse(intBag1.contains(200));
		assertTrue(intBag1.isEmpty());

		UseBag.removeAllFromBag(intBag2, 10);
		assertFalse(intBag2.contains(10));
		UseBag.removeAllFromBag(intBag2, 30);
		assertFalse(intBag2.contains(30));
		UseBag.removeAllFromBag(intBag2, 34);
		assertFalse(intBag2.contains(34));
		UseBag.removeAllFromBag(intBag2, 340);
		assertFalse(intBag2.contains(340));
		UseBag.removeAllFromBag(intBag2, 200);
		assertFalse(intBag2.contains(200));
		assertTrue(intBag2.isEmpty());

		UseBag.removeAllFromBag(stringBag1, "Hello");
		assertFalse(stringBag1.contains("Hello"));
		UseBag.removeAllFromBag(stringBag1, "Test");
		assertFalse(stringBag1.contains("Test"));
		UseBag.removeAllFromBag(stringBag1, "!@#$%^&*()");
		assertFalse(stringBag1.contains("!@#$%^&*()"));
		UseBag.removeAllFromBag(stringBag1, "This one is a sentence!");
		assertFalse(stringBag1.contains("This one is a sentence!"));
		assertTrue(stringBag1.isEmpty());

		UseBag.removeAllFromBag(stringBag2, "Hello");
		assertFalse(stringBag2.contains("Hello"));
		UseBag.removeAllFromBag(stringBag2, "Bye");
		assertFalse(stringBag2.contains("Bye"));
		UseBag.removeAllFromBag(stringBag2, "Test");
		assertFalse(stringBag2.contains("Test"));
		UseBag.removeAllFromBag(stringBag2, "!@#$%^&*()");
		assertFalse(stringBag2.contains("!@#$%^&*()"));
		UseBag.removeAllFromBag(stringBag2, "This one is a sentence!");
		assertFalse(stringBag2.contains("This one is a sentence!"));
		assertTrue(stringBag2.isEmpty());

		UseBag.removeAllFromBag(doubleBag1, 1.0);
		assertFalse(doubleBag1.contains(1.0));
		UseBag.removeAllFromBag(doubleBag1, 123.357);
		assertFalse(doubleBag1.contains(123.357));
		UseBag.removeAllFromBag(doubleBag1, 500.0);
		assertFalse(doubleBag1.contains(500.0));
		UseBag.removeAllFromBag(doubleBag1, 0.00000023);
		assertFalse(doubleBag1.contains(0.00000023));
		assertTrue(doubleBag1.isEmpty());

		UseBag.removeAllFromBag(doubleBag2, 1.0);
		assertFalse(doubleBag2.contains(1.0));
		UseBag.removeAllFromBag(doubleBag2, 123.357);
		assertFalse(doubleBag2.contains(123.357));
		UseBag.removeAllFromBag(doubleBag2, 500.0);
		assertFalse(doubleBag2.contains(500.0));
		UseBag.removeAllFromBag(doubleBag2, 500.01);
		assertFalse(doubleBag2.contains(500.01));
		UseBag.removeAllFromBag(doubleBag2, 0.00000023);
		assertFalse(doubleBag2.contains(0.00000023));
		assertTrue(doubleBag1.isEmpty());

	}

	@Test
	void testDifferenceInFrequency() {
		assertEquals(4, UseBag.differenceInFrequency(intBag1, intBag2, 10));
		assertEquals(2, UseBag.differenceInFrequency(intBag1, intBag2, 34));
		assertEquals(1, UseBag.differenceInFrequency(intBag1, intBag2, 200));
		assertEquals(1, UseBag.differenceInFrequency(intBag1, intBag2, 340));
		assertEquals(1, UseBag.differenceInFrequency(intBag1, intBag2, 30));
		assertEquals(0, UseBag.differenceInFrequency(intBag1, intBag2, 400));

		assertEquals(4, UseBag.differenceInFrequency(intBag2, intBag1, 10));
		assertEquals(2, UseBag.differenceInFrequency(intBag2, intBag1, 34));
		assertEquals(1, UseBag.differenceInFrequency(intBag2, intBag1, 200));
		assertEquals(1, UseBag.differenceInFrequency(intBag2, intBag1, 340));
		assertEquals(1, UseBag.differenceInFrequency(intBag2, intBag1, 30));
		assertEquals(0, UseBag.differenceInFrequency(intBag2, intBag1, 400));

		assertEquals(2, UseBag.differenceInFrequency(stringBag1, stringBag2, "Hello"));
		assertEquals(2, UseBag.differenceInFrequency(stringBag1, stringBag2, "Test"));
		assertEquals(1, UseBag.differenceInFrequency(stringBag1, stringBag2, "!@#$%^&*()"));
		assertEquals(1, UseBag.differenceInFrequency(stringBag1, stringBag2, "Bye"));
		assertEquals(0, UseBag.differenceInFrequency(stringBag1, stringBag2, "This one is a sentence!"));
		assertEquals(0, UseBag.differenceInFrequency(stringBag1, stringBag2, "Exit"));

		assertEquals(2, UseBag.differenceInFrequency(stringBag2, stringBag1, "Hello"));
		assertEquals(2, UseBag.differenceInFrequency(stringBag2, stringBag1, "Test"));
		assertEquals(1, UseBag.differenceInFrequency(stringBag2, stringBag1, "!@#$%^&*()"));
		assertEquals(1, UseBag.differenceInFrequency(stringBag2, stringBag1, "Bye"));
		assertEquals(0, UseBag.differenceInFrequency(stringBag2, stringBag1, "This one is a sentence!"));
		assertEquals(0, UseBag.differenceInFrequency(stringBag2, stringBag1, "Exit"));

		assertEquals(2, UseBag.differenceInFrequency(doubleBag1, doubleBag2, 1.0));
		assertEquals(1, UseBag.differenceInFrequency(doubleBag1, doubleBag2, 123.357));
		assertEquals(4, UseBag.differenceInFrequency(doubleBag1, doubleBag2, 500.0));
		assertEquals(2, UseBag.differenceInFrequency(doubleBag1, doubleBag2, 500.01));
		assertEquals(0, UseBag.differenceInFrequency(doubleBag1, doubleBag2, 0.00000023));
		assertEquals(0, UseBag.differenceInFrequency(doubleBag1, doubleBag2, 0.000000232));

		assertEquals(2, UseBag.differenceInFrequency(doubleBag2, doubleBag1, 1.0));
		assertEquals(1, UseBag.differenceInFrequency(doubleBag2, doubleBag1, 123.357));
		assertEquals(4, UseBag.differenceInFrequency(doubleBag2, doubleBag1, 500.0));
		assertEquals(2, UseBag.differenceInFrequency(doubleBag2, doubleBag1, 500.01));
		assertEquals(0, UseBag.differenceInFrequency(doubleBag2, doubleBag1, 0.00000023));
		assertEquals(0, UseBag.differenceInFrequency(doubleBag2, doubleBag1, 0.000000232));
	}
}