
package tree;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tree.TwoDimensionTree.Point;

/**
 * This class should test the methods of your TwoDimensionTree
 * specified below. Provide code where there are TODO labels
 * in order to thoroughly test your implementation.  
 * 
 * @author Jacob Schrum
 */
class TwoDimensionTreeTest {
	// Empty tree
	TwoDimensionTree<Point> emptyTree;
	// Example tree from page 763 of book
	TwoDimensionTree<Point> bookTree;
	// You must fill this tree. Make it larger and more interesting than the book tree
	TwoDimensionTree<Point> interestingTree;
	// Simple labelled tree
	TwoDimensionTree<LabeledPoint> simpleLabelledTree;
	// Make the coordinates in this tree identical to the interestingTree, but use LabelledPoints
	TwoDimensionTree<LabeledPoint> labelledTree;

	@BeforeEach
	void setUp() throws Exception {
		// Do not add any Points
		emptyTree = new TwoDimensionTree<>();

		// This tree is filled in such a way that it creates the 
		// 2d-tree shown on page 749.
		bookTree = new TwoDimensionTree<>();
		bookTree.add(new Point(50,40));
		bookTree.add(new Point(40,70));  
		bookTree.add(new Point(80,20));
		bookTree.add(new Point(90,10));
		bookTree.add(new Point(60,30));

		// 2 points
		// TODO: Fill interestingTree so it is larger than bookTree and
		//       allows for testing of a variety of corner cases.
		interestingTree = new TwoDimensionTree<>();
		interestingTree.add(new Point(27, 89));
		interestingTree.add(new Point(91, 15));
		interestingTree.add(new Point(32, 78));
		interestingTree.add(new Point(83, 24));
		interestingTree.add(new Point(45, 67));
		interestingTree.add(new Point(70, 32));
		interestingTree.add(new Point(40, 61));
		interestingTree.add(new Point(59, 43));
		interestingTree.add(new Point(55, 52));
		interestingTree.add(new Point(88, 95));

		// This simple tree has just a few labelled points
		simpleLabelledTree = new TwoDimensionTree<>();
		simpleLabelledTree.add(new LabeledPoint("A", 5, 6));
		simpleLabelledTree.add(new LabeledPoint("B", 10, 3)); 

		// 2 points
		// TODO: Fill labelledTree so that it has the exact same coordinates
		//       and structure as interestingTree, but uses LabelledPoints.
		labelledTree = new TwoDimensionTree<>();
		labelledTree.add(new LabeledPoint("New York", 27, 89));
		labelledTree.add(new LabeledPoint("Los Angeles", 91, 15));
		labelledTree.add(new LabeledPoint("Chicago", 32, 78));
		labelledTree.add(new LabeledPoint("Houston", 83, 24));
		labelledTree.add(new LabeledPoint("Miami", 45, 67));
		labelledTree.add(new LabeledPoint("Seattle", 70, 32));
		labelledTree.add(new LabeledPoint("Denver", 40, 61));
		labelledTree.add(new LabeledPoint("Atlanta", 59, 43));
		labelledTree.add(new LabeledPoint("Dallas", 55, 52));
		labelledTree.add(new LabeledPoint("Boston", 88, 95));
	}

	// No extra tests needed
	@Test 
	void testSetTreeT() {
		assertThrows(UnsupportedOperationException.class, () -> {
			emptyTree.setTree(new Point(0,0));
		});

		assertThrows(UnsupportedOperationException.class, () -> {
			bookTree.setTree(new Point(5,7.8));
		});

		assertThrows(UnsupportedOperationException.class, () -> {
			simpleLabelledTree.setTree(new LabeledPoint("Fail",500,7.5));
		});
	}

	// No extra tests needed
	@Test
	void testSetTreeTBinaryTreeInterfaceOfTBinaryTreeInterfaceOfT() {
		assertThrows(UnsupportedOperationException.class, () -> {
			emptyTree.setTree(new Point(0,0),bookTree,bookTree);
		});

		assertThrows(UnsupportedOperationException.class, () -> {
			bookTree.setTree(new Point(5,7.8),emptyTree,emptyTree);
		});

		assertThrows(UnsupportedOperationException.class, () -> {
			simpleLabelledTree.setTree(new LabeledPoint("Fail",500,7.5), new TwoDimensionTree<>(), new TwoDimensionTree<>());
		});
	}

	// No extra tests needed
	@Test
	void testTwoDimensionTree() {
		TwoDimensionTree<Point> tree = new TwoDimensionTree<>();
		assertTrue(tree.isEmpty());
		assertNull(tree.getRootNode());
	}

	@Test
	public void testContainsLocation() {
		assertFalse(emptyTree.containsLocation(new Point(1,1)));

		assertTrue(bookTree.containsLocation(new Point(50,40)));
		assertFalse(bookTree.containsLocation(new Point(20,55)));
		assertTrue(bookTree.containsLocation(new Point(40,70)));
		assertFalse(bookTree.containsLocation(new Point(82,100)));
		assertTrue(bookTree.containsLocation(new Point(80,20)));
		assertFalse(bookTree.containsLocation(new Point(80,10)));
		assertTrue(bookTree.containsLocation(new Point(90,10)));
		assertFalse(bookTree.containsLocation(new Point(10,90)));
		assertTrue(bookTree.containsLocation(new Point(60,30)));
		assertFalse(bookTree.containsLocation(new Point(40,30)));

        assertTrue(interestingTree.containsLocation(new Point(27,89))); 
        assertFalse(interestingTree.containsLocation(new Point(1,1)));
        assertTrue(interestingTree.containsLocation(new Point(91,15))); 
        assertFalse(interestingTree.containsLocation(new Point(100,100)));
        assertTrue(interestingTree.containsLocation(new Point(32,78)));
        assertFalse(interestingTree.containsLocation(new Point(50,50)));
        assertTrue(interestingTree.containsLocation(new Point(83,24))); 
        assertFalse(interestingTree.containsLocation(new Point(75,75)));
        assertTrue(interestingTree.containsLocation(new Point(45,67)));
        assertFalse(interestingTree.containsLocation(new Point(20,20)));
        assertTrue(interestingTree.containsLocation(new Point(70,32))); 
        assertFalse(interestingTree.containsLocation(new Point(90,50))); 
        assertTrue(interestingTree.containsLocation(new Point(40,61)));
        assertFalse(interestingTree.containsLocation(new Point(60,60)));
        assertTrue(interestingTree.containsLocation(new Point(59,43)));
        assertFalse(interestingTree.containsLocation(new Point(35,35))); 
        assertTrue(interestingTree.containsLocation(new Point(55,52))); 
        assertFalse(interestingTree.containsLocation(new Point(80,50)));
        assertTrue(interestingTree.containsLocation(new Point(88,95))); 
        assertFalse(interestingTree.containsLocation(new Point(10,10)));
		
		assertTrue(simpleLabelledTree.containsLocation(new Point(5,6))); 
		assertFalse(simpleLabelledTree.containsLocation(new Point(5,3)));
		assertTrue(simpleLabelledTree.containsLocation(new Point(10,3)));
		assertFalse(simpleLabelledTree.containsLocation(new Point(4,7)));

		assertTrue(labelledTree.containsLocation(new Point(27,89))); 
        assertFalse(labelledTree.containsLocation(new Point(80,40)));
        assertTrue(labelledTree.containsLocation(new Point(91,15)));
        assertFalse(labelledTree.containsLocation(new Point(40,60)));
        assertTrue(labelledTree.containsLocation(new Point(32,78)));
        assertFalse(labelledTree.containsLocation(new Point(75,35)));
        assertTrue(labelledTree.containsLocation(new Point(83,24)));
        assertFalse(labelledTree.containsLocation(new Point(50,50)));
        assertTrue(labelledTree.containsLocation(new Point(45,67)));
        assertFalse(labelledTree.containsLocation(new Point(60,40)));
        assertTrue(labelledTree.containsLocation(new Point(70,32)));
        assertFalse(labelledTree.containsLocation(new Point(85,25)));
        assertTrue(labelledTree.containsLocation(new Point(40,61)));
        assertFalse(labelledTree.containsLocation(new Point(55,60)));
        assertTrue(labelledTree.containsLocation(new Point(59,43)));
        assertFalse(labelledTree.containsLocation(new Point(70,30)));
		assertTrue(labelledTree.containsLocation(new Point(55,52)));
        assertFalse(labelledTree.containsLocation(new Point(34,78)));
		assertTrue(labelledTree.containsLocation(new Point(88,95)));
        assertFalse(labelledTree.containsLocation(new Point(23,36)));
	}

	@Test
	public void testContainsEntry() {
		assertFalse(emptyTree.containsEntry(new Point(1,1)));

		assertTrue(bookTree.containsEntry(new Point(50,40)));
		assertFalse(bookTree.containsEntry(new Point(20,55)));
		assertTrue(bookTree.containsEntry(new Point(40,70)));
		assertFalse(bookTree.containsEntry(new Point(82,100)));
		assertTrue(bookTree.containsEntry(new Point(80,20)));
		assertFalse(bookTree.containsEntry(new Point(80,10)));
		assertTrue(bookTree.containsEntry(new Point(60,30)));
		assertFalse(bookTree.containsEntry(new Point(40,30)));

		assertTrue(interestingTree.containsEntry(new Point(27,89))); 
        assertFalse(interestingTree.containsEntry(new Point(1,1)));
        assertTrue(interestingTree.containsEntry(new Point(91,15))); 
        assertFalse(interestingTree.containsEntry(new Point(100,100)));
        assertTrue(interestingTree.containsEntry(new Point(32,78)));
        assertFalse(interestingTree.containsEntry(new Point(50,50)));
        assertTrue(interestingTree.containsEntry(new Point(83,24))); 
        assertFalse(interestingTree.containsEntry(new Point(75,75)));
        assertTrue(interestingTree.containsEntry(new Point(45,67)));
        assertFalse(interestingTree.containsEntry(new Point(20,20)));
        assertTrue(interestingTree.containsEntry(new Point(70,32))); 
        assertFalse(interestingTree.containsEntry(new Point(90,50))); 
        assertTrue(interestingTree.containsEntry(new Point(40,61)));
        assertFalse(interestingTree.containsEntry(new Point(60,60)));
        assertTrue(interestingTree.containsEntry(new Point(59,43)));
        assertFalse(interestingTree.containsEntry(new Point(35,35))); 
        assertTrue(interestingTree.containsEntry(new Point(55,52))); 
        assertFalse(interestingTree.containsEntry(new Point(80,50)));
        assertTrue(interestingTree.containsEntry(new Point(88,95))); 
        assertFalse(interestingTree.containsEntry(new Point(10,10)));

		assertTrue(simpleLabelledTree.containsEntry(new LabeledPoint("A",5,6)));
		assertTrue(simpleLabelledTree.containsEntry(new LabeledPoint("B",10,3)));
		assertFalse(simpleLabelledTree.containsEntry(new LabeledPoint("B",4,7)));
		assertFalse(simpleLabelledTree.containsEntry(new LabeledPoint("C",5,6)));

		assertTrue(labelledTree.containsEntry(new LabeledPoint("New York", 27, 89)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Los Angeles", 80, 40)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Los Angeles", 91, 15)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("San Francisco", 40, 60)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Chicago", 32, 78)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Austin", 83, 24)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Houston", 83, 24)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Portland", 50, 50)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Miami", 45, 67)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Orlando", 45, 67)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Seattle", 70, 32)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Phoenix", 85, 25)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Denver", 40, 61)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Boulder", 55, 60)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Atlanta", 59, 43)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Miami", 70, 30)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Dallas", 55, 52)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Tampa", 34, 78)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Boston", 88, 95)));
		assertFalse(labelledTree.containsEntry(new LabeledPoint("Philadelphia", 23, 36)));
	}	
    
	@Test
	public void testGetEntry() {
		assertNull(emptyTree.getEntry(new Point(10,25)));

		assertEquals(new Point(50,40), bookTree.getEntry(new Point(50,40)));
		assertEquals(new Point(40,70), bookTree.getEntry(new Point(40,70)));
		assertEquals(new Point(80,20), bookTree.getEntry(new Point(80,20)));
		assertEquals(new Point(90,10), bookTree.getEntry(new Point(90,10)));
		assertEquals(new Point(60,30), bookTree.getEntry(new Point(60,30)));
		assertNull(bookTree.getEntry(new Point(51,39)));
		assertNull(bookTree.getEntry(new Point(4,7)));
		assertNull(bookTree.getEntry(new Point(800,200)));
		assertNull(bookTree.getEntry(new Point(90,11)));
		assertNull(bookTree.getEntry(new Point(60,29)));

		assertEquals(new Point(27,89), interestingTree.getEntry(new Point(27,89)));
		assertEquals(new Point(91,15), interestingTree.getEntry(new Point(91,15)));
		assertEquals(new Point(32,78), interestingTree.getEntry(new Point(32,78)));
		assertEquals(new Point(83,24), interestingTree.getEntry(new Point(83,24)));
		assertEquals(new Point(45,67), interestingTree.getEntry(new Point(45,67)));
		assertEquals(new Point(70,32), interestingTree.getEntry(new Point(70,32)));
		assertEquals(new Point(40,61), interestingTree.getEntry(new Point(40,61)));
		assertEquals(new Point(59,43), interestingTree.getEntry(new Point(59,43)));
		assertEquals(new Point(55,52), interestingTree.getEntry(new Point(55,52)));
		assertEquals(new Point(88,95), interestingTree.getEntry(new Point(88,95)));
		assertNull(interestingTree.getEntry(new Point(1,1)));
		assertNull(interestingTree.getEntry(new Point(100,100)));
		assertNull(interestingTree.getEntry(new Point(50,50)));
		assertNull(interestingTree.getEntry(new Point(75,75)));
		assertNull(interestingTree.getEntry(new Point(20,20)));
		assertNull(interestingTree.getEntry(new Point(90,50)));
		assertNull(interestingTree.getEntry(new Point(60,60)));
		assertNull(interestingTree.getEntry(new Point(35,35)));
		assertNull(interestingTree.getEntry(new Point(80,50)));
		assertNull(interestingTree.getEntry(new Point(10,10)));

		assertEquals(new LabeledPoint("A", 5, 6),simpleLabelledTree.getEntry(new Point(5,6)));
		assertEquals(new LabeledPoint("B", 10, 3),simpleLabelledTree.getEntry(new Point(10,3)));
		assertNull(simpleLabelledTree.getEntry(new Point(4,8)));
		assertNull(simpleLabelledTree.getEntry(new Point(7,9)));

		assertEquals(new LabeledPoint("New York", 27, 89), labelledTree.getEntry(new Point(27,89)));
		assertEquals(new LabeledPoint("Los Angeles", 91, 15), labelledTree.getEntry(new Point(91,15)));
		assertEquals(new LabeledPoint("Chicago", 32, 78), labelledTree.getEntry(new Point(32,78)));
		assertEquals(new LabeledPoint("Houston", 83, 24), labelledTree.getEntry(new Point(83,24)));
		assertEquals(new LabeledPoint("Miami", 45, 67), labelledTree.getEntry(new Point(45,67)));
		assertEquals(new LabeledPoint("Seattle", 70, 32), labelledTree.getEntry(new Point(70,32)));
		assertEquals(new LabeledPoint("Denver", 40, 61), labelledTree.getEntry(new Point(40,61)));
		assertEquals(new LabeledPoint("Atlanta", 59, 43), labelledTree.getEntry(new Point(59,43)));
		assertEquals(new LabeledPoint("Dallas", 55, 52), labelledTree.getEntry(new Point(55,52)));
		assertEquals(new LabeledPoint("Boston", 88, 95), labelledTree.getEntry(new Point(88,95)));
		assertNull(labelledTree.getEntry(new Point(80,40)));
		assertNull(labelledTree.getEntry(new Point(40,60)));
		assertNull(labelledTree.getEntry(new Point(75,35)));
		assertNull(labelledTree.getEntry(new Point(50,50)));
		assertNull(labelledTree.getEntry(new Point(60,40)));
		assertNull(labelledTree.getEntry(new Point(85,25)));
		assertNull(labelledTree.getEntry(new Point(55,60)));
		assertNull(labelledTree.getEntry(new Point(70,30)));
		assertNull(labelledTree.getEntry(new Point(34,78)));
		assertNull(labelledTree.getEntry(new Point(23,36)));
	}

	@Test
	public void testAdd() {
		assertEquals(new Point(50,40), bookTree.add(new Point(50,40)));
		assertEquals(new Point(40,70), bookTree.add(new Point(40,70)));
		assertEquals(new Point(80,20), bookTree.add(new Point(80,20)));
		assertEquals(new Point(90,10), bookTree.add(new Point(90,10)));
		assertEquals(new Point(60,30), bookTree.add(new Point(60,30)));
		assertNull(bookTree.add(new Point(40,50)));
		assertNull(bookTree.add(new Point(80,21)));
		assertTrue(bookTree.containsEntry(new Point(50,40)));
		assertTrue(bookTree.containsEntry(new Point(40,70)));
		assertTrue(bookTree.containsEntry(new Point(80,20)));
		assertTrue(bookTree.containsEntry(new Point(90,10)));
		assertTrue(bookTree.containsEntry(new Point(60,30)));
		assertTrue(bookTree.containsEntry(new Point(40,50)));
		assertTrue(bookTree.containsEntry(new Point(80,21)));

		assertEquals(new Point(27,89), interestingTree.add(new Point(27,89)));
		assertEquals(new Point(91,15), interestingTree.add(new Point(91,15)));
		assertEquals(new Point(32,78), interestingTree.add(new Point(32,78)));
		assertEquals(new Point(83,24), interestingTree.add(new Point(83,24)));
		assertEquals(new Point(45,67), interestingTree.add(new Point(45,67)));
		assertEquals(new Point(70,32), interestingTree.add(new Point(70,32)));
		assertEquals(new Point(40,61), interestingTree.add(new Point(40,61)));
		assertEquals(new Point(59,43), interestingTree.add(new Point(59,43)));
		assertEquals(new Point(55,52), interestingTree.add(new Point(55,52)));
		assertEquals(new Point(88,95), interestingTree.add(new Point(88,95)));
		assertNull(interestingTree.add(new Point(40,50)));
		assertNull(interestingTree.add(new Point(80,21)));
		assertTrue(interestingTree.containsEntry(new Point(27,89)));
		assertTrue(interestingTree.containsEntry(new Point(91,15)));
		assertTrue(interestingTree.containsEntry(new Point(32,78)));
		assertTrue(interestingTree.containsEntry(new Point(83,24)));
		assertTrue(interestingTree.containsEntry(new Point(45,67)));
		assertTrue(interestingTree.containsEntry(new Point(70,32)));
		assertTrue(interestingTree.containsEntry(new Point(40,61)));
		assertTrue(interestingTree.containsEntry(new Point(59,43)));
		assertTrue(interestingTree.containsEntry(new Point(55,52)));
		assertTrue(interestingTree.containsEntry(new Point(88,95)));
		assertTrue(interestingTree.containsEntry(new Point(40,50)));
		assertTrue(interestingTree.containsEntry(new Point(80,21)));

		assertEquals(new LabeledPoint("A", 5, 6),simpleLabelledTree.add(new LabeledPoint("A", 5, 6)));
		assertEquals(new LabeledPoint("A", 5, 6),simpleLabelledTree.add(new LabeledPoint("B", 5, 6)));
		assertEquals(new LabeledPoint("B", 10, 3),simpleLabelledTree.add(new LabeledPoint("B", 10, 3)));
		assertEquals(new LabeledPoint("B", 10, 3),simpleLabelledTree.add(new LabeledPoint("Different label", 10, 3)));
		assertNull(simpleLabelledTree.add(new LabeledPoint("C",2,8)));
		assertNull(simpleLabelledTree.add(new LabeledPoint("D",13,5)));
		assertFalse(simpleLabelledTree.containsEntry(new LabeledPoint("A",5,6)));
		assertTrue(simpleLabelledTree.containsEntry(new LabeledPoint("B",5,6)));
		assertFalse(simpleLabelledTree.containsEntry(new LabeledPoint("B", 10, 3)));
		assertTrue(simpleLabelledTree.containsEntry(new LabeledPoint("Different label", 10, 3)));
		assertTrue(simpleLabelledTree.containsEntry(new LabeledPoint("C",2,8)));
		assertTrue(simpleLabelledTree.containsEntry(new LabeledPoint("D",13,5)));

		assertEquals(new LabeledPoint("New York", 27, 89), labelledTree.add(new LabeledPoint("Another City", 27, 89)));
		assertEquals(new LabeledPoint("Los Angeles", 91, 15), labelledTree.add(new LabeledPoint("Los Angeles", 91, 15)));
		assertEquals(new LabeledPoint("Chicago", 32, 78), labelledTree.add(new LabeledPoint("Chicago", 32, 78)));
		assertEquals(new LabeledPoint("Houston", 83, 24), labelledTree.add(new LabeledPoint("Houston", 83, 24)));
		assertEquals(new LabeledPoint("Miami", 45, 67), labelledTree.add(new LabeledPoint("Miami", 45, 67)));
		assertEquals(new LabeledPoint("Seattle", 70, 32), labelledTree.add(new LabeledPoint("Seattle", 70, 32)));
		assertEquals(new LabeledPoint("Denver", 40, 61), labelledTree.add(new LabeledPoint("Different City", 40, 61)));
		assertEquals(new LabeledPoint("Atlanta", 59, 43), labelledTree.add(new LabeledPoint("Atlanta", 59, 43)));
		assertEquals(new LabeledPoint("Dallas", 55, 52), labelledTree.add(new LabeledPoint("Dallas", 55, 52)));
		assertEquals(new LabeledPoint("Boston", 88, 95), labelledTree.add(new LabeledPoint("Boston", 88, 95)));
		assertNull(labelledTree.add(new LabeledPoint("Austin", 40, 50)));
		assertNull(labelledTree.add(new LabeledPoint("San Diego", 80, 21)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Another City", 27, 89)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Los Angeles", 91, 15)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Chicago", 32, 78)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Houston", 83, 24)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Miami", 45, 67)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Seattle", 70, 32)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Different City", 40, 61)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Atlanta", 59, 43)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Dallas", 55, 52)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Boston", 88, 95)));
		assertTrue(labelledTree.containsEntry(new LabeledPoint("Austin", 40, 50))); 
		assertTrue(labelledTree.containsEntry(new LabeledPoint("San Diego", 80, 21))); 
	}

	@Test
	public void testGetInorderIterator() {
		Iterator<Point> itr1 = emptyTree.getInorderIterator();
		assertFalse(itr1.hasNext()); // Empty tree

		Iterator<Point> itr2 = bookTree.getInorderIterator();
		assertTrue(itr2.hasNext());
		assertEquals(new Point(40,70), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new Point(50,40), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new Point(90,10), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new Point(80,20), itr2.next());
		assertTrue(itr2.hasNext());
		assertEquals(new Point(60,30), itr2.next());
		assertFalse(itr2.hasNext());

		Iterator<Point> itr3 = interestingTree.getInorderIterator();
		assertTrue(itr3.hasNext());
		assertEquals(new Point(27,89), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(91,15), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(32,78), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(83,24), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(40,61), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(45,67), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(70,32), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(55,52), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(59,43), itr3.next());
		assertTrue(itr3.hasNext());
		assertEquals(new Point(88,95), itr3.next());
		assertFalse(itr3.hasNext());

		Iterator<LabeledPoint> itr4 = simpleLabelledTree.getInorderIterator();
		assertTrue(itr4.hasNext());
		assertEquals(new LabeledPoint("A", 5, 6), itr4.next());
		assertTrue(itr4.hasNext());
		assertEquals(new LabeledPoint("B", 10, 3), itr4.next());
		assertFalse(itr4.hasNext()); // No more elements

		Iterator<LabeledPoint> itr5 = labelledTree.getInorderIterator();
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("New York", 27, 89), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Los Angeles", 91, 15), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Chicago", 32, 78), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Houston", 83, 24), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Denver", 40, 61), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Miami", 45, 67), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Seattle", 70, 32), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Dallas", 55, 52), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Atlanta", 59, 43), itr5.next());
		assertTrue(itr5.hasNext());
		assertEquals(new LabeledPoint("Boston", 88, 95), itr5.next());
		assertFalse(itr5.hasNext());
	}

	@Test
	public void testNearestNeighbor() {
		// Point (50,40) should be the closest to the query point (55,45) 
		assertEquals(new Point(50,40), bookTree.nearestNeighbor(new Point(55,45)));
        assertEquals(new Point(40, 70), bookTree.nearestNeighbor(new Point(30, 80)));
        assertEquals(new Point(60, 30), bookTree.nearestNeighbor(new Point(59, 35)));
        assertEquals(new Point(90, 10), bookTree.nearestNeighbor(new Point(85, 5)));
        assertEquals(new Point(80, 20), bookTree.nearestNeighbor(new Point(75, 25)));
		// Test queries far from any tree point
		assertEquals(new Point(90, 10), bookTree.nearestNeighbor(new Point(100, 0)));
		assertEquals(new Point(50, 40), bookTree.nearestNeighbor(new Point(0, 0)));
		// Test queries exactly matching tree points
		assertEquals(new Point(80, 20), bookTree.nearestNeighbor(new Point(80, 20)));
        assertEquals(new Point(60, 30), bookTree.nearestNeighbor(new Point(60, 30)));

		assertEquals(new Point(27, 89), interestingTree.nearestNeighbor(new Point(26, 88))); 
		assertEquals(new Point(91, 15), interestingTree.nearestNeighbor(new Point(92, 16))); 
		assertEquals(new Point(32, 78), interestingTree.nearestNeighbor(new Point(33, 79)));  
		assertEquals(new Point(83, 24), interestingTree.nearestNeighbor(new Point(82, 25))); 
		assertEquals(new Point(45, 67), interestingTree.nearestNeighbor(new Point(44, 68))); 
		assertEquals(new Point(70, 32), interestingTree.nearestNeighbor(new Point(71, 33))); 
		assertEquals(new Point(40, 61), interestingTree.nearestNeighbor(new Point(39, 60)));
		assertEquals(new Point(59, 43), interestingTree.nearestNeighbor(new Point(58, 42)));
		assertEquals(new Point(55, 52), interestingTree.nearestNeighbor(new Point(54, 51)));  
		assertEquals(new Point(88, 95), interestingTree.nearestNeighbor(new Point(89, 96)));  
		// Test queries far from any tree point
		assertEquals(new Point(91, 15), interestingTree.nearestNeighbor(new Point(100, 0)));  
		assertEquals(new Point(40, 61), interestingTree.nearestNeighbor(new Point(0, 0)));  
		// Test queries exactly matching tree points
		assertEquals(new Point(32, 78), interestingTree.nearestNeighbor(new Point(32, 78))); 
		assertEquals(new Point(55, 52), interestingTree.nearestNeighbor(new Point(55, 52))); 

		assertEquals(new LabeledPoint("A", 5, 6), simpleLabelledTree.nearestNeighbor(new Point(7,4)));
		assertEquals(new LabeledPoint("B", 10, 3), simpleLabelledTree.nearestNeighbor(new Point(20,1)));
		assertEquals(new LabeledPoint("B", 10, 3), simpleLabelledTree.nearestNeighbor(new Point(100,80)));
		assertEquals(new LabeledPoint("B", 10, 3), simpleLabelledTree.nearestNeighbor(new Point(10,3)));

		assertEquals(new LabeledPoint("New York", 27, 89), labelledTree.nearestNeighbor(new Point(26, 88))); 
		assertEquals(new LabeledPoint("Los Angeles", 91, 15), labelledTree.nearestNeighbor(new Point(92, 16))); 
		assertEquals(new LabeledPoint("Chicago", 32, 78), labelledTree.nearestNeighbor(new Point(33, 79)));  
		assertEquals(new LabeledPoint("Houston", 83, 24), labelledTree.nearestNeighbor(new Point(82, 25))); 
		assertEquals(new LabeledPoint("Miami", 45, 67), labelledTree.nearestNeighbor(new Point(44, 68))); 
		assertEquals(new LabeledPoint("Seattle", 70, 32), labelledTree.nearestNeighbor(new Point(71, 33))); 
		assertEquals(new LabeledPoint("Denver", 40, 61), labelledTree.nearestNeighbor(new Point(39, 60)));
		assertEquals(new LabeledPoint("Atlanta", 59, 43), labelledTree.nearestNeighbor(new Point(58, 42)));
		assertEquals(new LabeledPoint("Dallas", 55, 52), labelledTree.nearestNeighbor(new Point(54, 51)));  
		assertEquals(new LabeledPoint("Boston", 88, 95), labelledTree.nearestNeighbor(new Point(89, 96)));  
		// Test queries far from any tree point
		assertEquals(new LabeledPoint("Los Angeles", 91, 15), labelledTree.nearestNeighbor(new Point(100, 0)));  
		assertEquals(new LabeledPoint("Denver", 40, 61), labelledTree.nearestNeighbor(new Point(0, 0)));  
		// Test queries exactly matching tree points
		assertEquals(new LabeledPoint("New York", 27, 89), labelledTree.nearestNeighbor(new Point(27, 89))); 
		assertEquals(new LabeledPoint("Seattle", 70, 32), labelledTree.nearestNeighbor(new Point(70, 32))); 	
	}
}
