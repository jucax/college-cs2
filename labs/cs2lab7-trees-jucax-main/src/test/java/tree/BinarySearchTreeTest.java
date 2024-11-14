package tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class BinarySearchTreeTest {

	/**
	 * This private inner class is used as an example of how
	 * values that have the same sort order may not be equal,
	 * which explains why the Binary Search Tree returns any
	 * value that is replaced by an add operation.
	 */
	private static class LabeledInt implements Comparable<LabeledInt> {
		Integer x;
		String s;
		/**
		 * A LabeledInt is sorted based only on the integer,
		 * but also contains a string.
		 * 
		 * @param x Int value to sort on
		 * @param s String value
		 */
		private LabeledInt(int x, String s) {
			this.x = x;
			this.s = s;
		}
		// Just use the compareTo method of the Integer
		@Override
		public int compareTo(LabeledInt o) {
			return x.compareTo(o.x);
		}
		// Equality depends on the String AND the Integer
		@Override
		public boolean equals(Object other) {
			if(this.getClass() == other.getClass()) {
				LabeledInt li = (LabeledInt) other;
				return x.equals(li.x) && s.equals(li.s);
			}
			return false;
		}

		/**
		 * How to display the LabeledInt
		 */
		@Override
		public String toString() {
			return s + ":" + x;
		}
	}

	BinarySearchTree<Integer> intBST;
	BinarySearchTree<LabeledInt> lintBST;

	@BeforeEach
	void setUp() throws Exception {
		intBST = new BinarySearchTree<Integer>();
		intBST.add(5);
		intBST.add(10);
		intBST.add(0);
		intBST.add(-23);
		intBST.add(45);
		intBST.add(23423);
		intBST.add(-4353);

		lintBST = new BinarySearchTree<LabeledInt>();
		lintBST.add(new LabeledInt(5,"A"));
		lintBST.add(new LabeledInt(500,"A"));
		lintBST.add(new LabeledInt(-500,"You found me!"));
		lintBST.add(new LabeledInt(-50,"negative"));
		lintBST.add(new LabeledInt(2340,"B"));
		lintBST.add(new LabeledInt(20,"B"));
		lintBST.add(new LabeledInt(0,"C"));
		lintBST.add(new LabeledInt(-23370,"D"));
		lintBST.add(new LabeledInt(90,"Last"));
	}

	@Test
	void testSetTreeT() {
		assertThrows(UnsupportedOperationException.class, () -> {
			intBST.setTree(5);
		});
	}

	@Test
	void testSetTreeTBinaryTreeInterfaceOfTBinaryTreeInterfaceOfT() {
		assertThrows(UnsupportedOperationException.class, () -> {
			intBST.setTree(5, new BinarySearchTree<Integer>(), new BinarySearchTree<Integer>());
		});
	}

	@Test
	void testContains() {
		assertTrue(lintBST.contains(new LabeledInt(5,"A")));
		assertTrue(lintBST.contains(new LabeledInt(500,"A")));
		assertTrue(lintBST.contains(new LabeledInt(-500,"You found me!")));
		assertTrue(lintBST.contains(new LabeledInt(-50,"negative")));
		assertTrue(lintBST.contains(new LabeledInt(2340,"B")));
		assertTrue(lintBST.contains(new LabeledInt(20,"B")));
		assertTrue(lintBST.contains(new LabeledInt(0,"C")));
		assertTrue(lintBST.contains(new LabeledInt(-23370,"D")));
		assertTrue(lintBST.contains(new LabeledInt(90,"Last")));

		assertFalse(lintBST.contains(new LabeledInt(5,"Ab")));
		assertFalse(lintBST.contains(new LabeledInt(500,"bA")));
		assertFalse(lintBST.contains(new LabeledInt(-500,"No You found me!")));
		assertFalse(lintBST.contains(new LabeledInt(-50,"negdasative")));
		assertFalse(lintBST.contains(new LabeledInt(2340,"Basd")));
		assertFalse(lintBST.contains(new LabeledInt(20,"Bfwe")));
		assertFalse(lintBST.contains(new LabeledInt(0,"qqqC")));
		assertFalse(lintBST.contains(new LabeledInt(-23370,"wadD")));
		assertFalse(lintBST.contains(new LabeledInt(90,"Lastsdf")));

		assertFalse(lintBST.contains(new LabeledInt(-233,"wadD")));
		assertFalse(lintBST.contains(new LabeledInt(95,"Lastsdf")));
	}

	@Test
	void testGetEntry() {
		assertEquals(Integer.valueOf(5),intBST.getEntry(5));
		assertEquals(Integer.valueOf(10),intBST.getEntry(10));
		assertEquals(Integer.valueOf(0),intBST.getEntry(0));
		assertEquals(Integer.valueOf(-23),intBST.getEntry(-23));
		assertEquals(Integer.valueOf(45),intBST.getEntry(45));
		assertEquals(Integer.valueOf(23423),intBST.getEntry(23423));
		assertEquals(Integer.valueOf(-4353),intBST.getEntry(-4353));

		assertNull(intBST.getEntry(-9999));
		assertNull(intBST.getEntry(999999));
		assertNull(intBST.getEntry(1));
		assertNull(intBST.getEntry(-1));
		assertNull(intBST.getEntry(40));
		assertNull(intBST.getEntry(50));
		assertNull(intBST.getEntry(11));
		assertNull(intBST.getEntry(9));

		assertEquals(new LabeledInt(5,"A"),lintBST.getEntry(new LabeledInt(5,"A")));
		assertEquals(new LabeledInt(5,"A"),lintBST.getEntry(new LabeledInt(5,"Different label")));
		assertEquals(new LabeledInt(500,"A"),lintBST.getEntry(new LabeledInt(500,"A")));
		assertEquals(new LabeledInt(500,"A"),lintBST.getEntry(new LabeledInt(500,"B")));
		assertEquals(new LabeledInt(-500,"You found me!"),lintBST.getEntry(new LabeledInt(-500,"You found me!")));
		assertEquals(new LabeledInt(-500,"You found me!"),lintBST.getEntry(new LabeledInt(-500,"You found me")));
		assertEquals(new LabeledInt(-50,"negative"),lintBST.getEntry(new LabeledInt(-50,"negative")));
		assertEquals(new LabeledInt(-50,"negative"),lintBST.getEntry(new LabeledInt(-50,"positive")));
		assertEquals(new LabeledInt(2340,"B"),lintBST.getEntry(new LabeledInt(2340,"B")));
		assertEquals(new LabeledInt(2340,"B"),lintBST.getEntry(new LabeledInt(2340,"C")));
		assertEquals(new LabeledInt(20,"B"),lintBST.getEntry(new LabeledInt(20,"B")));
		assertEquals(new LabeledInt(20,"B"),lintBST.getEntry(new LabeledInt(20,"b")));
		assertEquals(new LabeledInt(0,"C"),lintBST.getEntry(new LabeledInt(0,"C")));
		assertEquals(new LabeledInt(0,"C"),lintBST.getEntry(new LabeledInt(0,"see")));
		assertEquals(new LabeledInt(-23370,"D"),lintBST.getEntry(new LabeledInt(-23370,"D")));
		assertEquals(new LabeledInt(-23370,"D"),lintBST.getEntry(new LabeledInt(-23370,"Dee")));
		assertEquals(new LabeledInt(90,"Last"),lintBST.getEntry(new LabeledInt(90,"Last")));
		assertEquals(new LabeledInt(90,"Last"),lintBST.getEntry(new LabeledInt(90,"first")));

		assertNull(lintBST.getEntry(new LabeledInt(91,"Last")));
		assertNull(lintBST.getEntry(new LabeledInt(4,"A")));
	}

	@Test
	void testAdd() {
		assertEquals(new LabeledInt(5,"A"),lintBST.add(new LabeledInt(5,"A")));
		assertEquals(new LabeledInt(5,"A"),lintBST.add(new LabeledInt(5,"Different label")));
		assertEquals(new LabeledInt(500,"A"),lintBST.add(new LabeledInt(500,"A")));
		assertEquals(new LabeledInt(500,"A"),lintBST.add(new LabeledInt(500,"B")));
		assertEquals(new LabeledInt(-500,"You found me!"),lintBST.add(new LabeledInt(-500,"You found me!")));
		assertEquals(new LabeledInt(-500,"You found me!"),lintBST.add(new LabeledInt(-500,"You found me")));
		assertEquals(new LabeledInt(-50,"negative"),lintBST.add(new LabeledInt(-50,"negative")));
		assertEquals(new LabeledInt(-50,"negative"),lintBST.add(new LabeledInt(-50,"positive")));
		assertEquals(new LabeledInt(2340,"B"),lintBST.add(new LabeledInt(2340,"B")));
		assertEquals(new LabeledInt(2340,"B"),lintBST.add(new LabeledInt(2340,"C")));
		assertEquals(new LabeledInt(20,"B"),lintBST.add(new LabeledInt(20,"B")));
		assertEquals(new LabeledInt(20,"B"),lintBST.add(new LabeledInt(20,"b")));
		assertEquals(new LabeledInt(0,"C"),lintBST.add(new LabeledInt(0,"C")));
		assertEquals(new LabeledInt(0,"C"),lintBST.add(new LabeledInt(0,"see")));
		assertEquals(new LabeledInt(-23370,"D"),lintBST.add(new LabeledInt(-23370,"D")));
		assertEquals(new LabeledInt(-23370,"D"),lintBST.add(new LabeledInt(-23370,"Dee")));
		assertEquals(new LabeledInt(90,"Last"),lintBST.add(new LabeledInt(90,"Last")));
		assertEquals(new LabeledInt(90,"Last"),lintBST.add(new LabeledInt(90,"first")));

		assertNull(lintBST.add(new LabeledInt(91,"Last")));
		assertNull(lintBST.add(new LabeledInt(4,"A")));

		assertFalse(lintBST.contains(new LabeledInt(5,"A")));
		assertTrue(lintBST.contains(new LabeledInt(5,"Different label")));
		assertFalse(lintBST.contains(new LabeledInt(500,"A")));
		assertTrue(lintBST.contains(new LabeledInt(500,"B")));
		assertFalse(lintBST.contains(new LabeledInt(-500,"You found me!")));
		assertTrue(lintBST.contains(new LabeledInt(-500,"You found me")));
		assertFalse(lintBST.contains(new LabeledInt(-50,"negative")));
		assertTrue(lintBST.contains(new LabeledInt(-50,"positive")));
		assertFalse(lintBST.contains(new LabeledInt(2340,"B")));
		assertTrue(lintBST.contains(new LabeledInt(2340,"C")));
		assertFalse(lintBST.contains(new LabeledInt(20,"B")));
		assertTrue(lintBST.contains(new LabeledInt(20,"b")));
		assertFalse(lintBST.contains(new LabeledInt(0,"C")));
		assertTrue(lintBST.contains(new LabeledInt(0,"see")));
		assertFalse(lintBST.contains(new LabeledInt(-23370,"D")));
		assertTrue(lintBST.contains(new LabeledInt(-23370,"Dee")));
		assertFalse(lintBST.contains(new LabeledInt(90,"Last")));
		assertTrue(lintBST.contains(new LabeledInt(90,"first")));


	}

	@Test
	void testRemove() {
		// TODO, but implementation not required for completion of assignment
	}

	@Test
	void testGetInorderIterator() {
		Iterator<Integer> itr = intBST.getInorderIterator();
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(-4353), itr.next());
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(-23), itr.next());
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(0), itr.next());
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(5), itr.next());
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(10), itr.next());
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(45), itr.next());
		assertTrue(itr.hasNext()); 
		assertEquals(Integer.valueOf(23423), itr.next());
		assertFalse(itr.hasNext()); 

		Iterator<LabeledInt> itr2 = lintBST.getInorderIterator();
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(-23370,"D"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(-500,"You found me!"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(-50,"negative"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(0,"C"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(5,"A"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(20,"B"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(90,"Last"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(500,"A"), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new LabeledInt(2340,"B"), itr2.next());
		assertFalse(itr2.hasNext());

	}

}
