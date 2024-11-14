package tree;
import java.util.Iterator;
import java.util.Stack;

import java.util.Iterator;

/**
 * The 2d-tree or 2-Dimensional kd-tree is a generalized form of
 * binary search tree that stores objects with 2D coordinates. 
 * An inner class called Point allows you to look up objects based 
 * on such coordinates, but the actual items in the tree implement
 * the Located2D class. 
 * 
 * Even though the TwoDimensionTree is a binary search tree, it
 * cannot implement the SearchTreeInterface without making some
 * changes to that interface. For related reasons, we       
 * cannot simply extend the BinarySearchTree class from the book.
 * However, some of the methods you must implement require only
 * slight changes to the BinarySearchTree class from the book,
 * so use that code as a starting point.      
 * 
 * Fortunately, this class can safely extend the BinaryTree class,
 * so there is no need to re-implement methods from that class. 
 * However, there is a need to disable some of those methods.
 *
 * @author Jacob Schrum
 * 
 * @param <T> An object with 2D coordinates
 */
public class TwoDimensionTree<T extends Located2D> extends BinaryTree<T> {

	// Add code to this main method to help debug your project
	public static void main(String[] args) {
		TwoDimensionTree<Point> bookTree = new TwoDimensionTree<>();
		bookTree.add(new Point(50,40));
		bookTree.add(new Point(40,70));  
		bookTree.add(new Point(80,20));
		bookTree.add(new Point(90,10));
		bookTree.add(new Point(60,30));

		Point p = new Point(80,20);
		System.out.println("Contains "+p+": " +bookTree.containsEntry(p));
	}

	/**
	 * Inner class that allows reference to a location in 2D space.
	 * Like the built-in Java Point class, but implements Located2D
	 * and does not allow modification of coordinates after construction.
	 * 
	 * DO NOT CHANGE
	 * 
	 * @author Jacob Schrum
	 */
	public static class Point implements Located2D {
		// Coordinate values cannot be modified after construction
		private final double x;
		private final double y;

		/**
		 * Create new Point with specified x/y coordinates
		 * @param x x-coordinate
		 * @param y y-coordinate
		 */
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * retrieve the x-coordinate (from Located2D)
		 */
		@Override
		public double getX() {
			return x;
		}

		/**
		 * retrieve the y-coordinate (from Located2D)
		 */
		@Override
		public double getY() {
			return y;
		}

		/**
		 * Points are equal if they have the same x and y coordinates
		 */
		@Override
		public boolean equals(Object obj) {
			if(this.getClass() == obj.getClass()) {
				Point other = (Point) obj;
				return x == other.x && y == other.y;
			}
			return false;
		}

		/**
		 * Print contents of point
		 */
		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}		
	}	

	/**
	 * Create new empty 2d-tree
	 */
	public TwoDimensionTree() {
		super();
	}

	/**
	 * Disallow modification of data in the tree so that the sorted order is not lost.
	 * Overrides method from BinaryTree.
	 */
	@Override
	public void setTree(T rootData) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Disallow modification of data in the tree so that the sorted order is not lost.
	 * Overrides method from BinaryTree. 
	 */
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}

	/**
	 * This is a helper method that you should write. It is similar to a like-named method
	 * of the BinarySearchTree, but has a different type signature.  
	 * A RECURSIVE SOLUTION IS REQUIRED
	 *
	 * @param rootNode Node from the tree 
	 * @param entry Some sort of item with a location. It might be a simple Point, or have type T
	 * @param depth The depth that rootNode is at in the tree.
	 * @return A value of type T from the tree, or null if rootNode is null
	 */
	private <S extends Located2D> T findEntry(BinaryNode<T> rootNode, S entry, int depth) {
		T result = null;
		if (rootNode != null) { //If there is a tree
			T rootEntry = rootNode.getData();

			// Get coordinates of rootEntry and entry
			double rootX = rootEntry.getX();
			double rootY = rootEntry.getY();
			double entryX = entry.getX();
			double entryY = entry.getY();

			// Compare coordinates and label
			if (rootX == entryX && rootY == entryY) {
				// Check label equality if we are using LabeledPoint
				if (entry instanceof LabeledPoint) {
					String rootLabel = ((LabeledPoint) rootEntry).getLabel();
					String entryLabel = ((LabeledPoint) entry).getLabel();
					if (rootLabel.equals(entryLabel))
						result = rootEntry;
				} else
					result = rootEntry;
			} else {
				// Determine which coordinate x or y to compare based on depth
				double rootValue;
				double entryValue;
				if (depth % 2 == 0) {
					rootValue = rootX;
					entryValue = entryX;
				} else {
					rootValue = rootY;
					entryValue = entryY;
				}

				// Recursively search in the left or right subtree
				if (entryValue < rootValue)
					result = findEntry(rootNode.getLeftChild(), entry, depth + 1);
				else // We know entryValue > rootValue
					result = findEntry(rootNode.getRightChild(), entry, depth + 1);
			}
		}
		return result;
	}

	/**
	 * Indicate whether any object in this tree is located at the exact
	 * coordinates designated by a given Point.
	 * 
	 * Best case: O(1): object found at root of tree.
	 * Average case: O(log n): object found deep within roughly balanced tree
	 * Worst case: O(n): tree is completely unbalanced, and object is at bottom of tree  
	 * 
	 * @param location Coordinates to search for  
	 * @return True if an object in the tree has these exact coordinates, false otherwise
	 */
	public boolean containsLocation(Point location) {
    	return findEntry(getRootNode(), location, 0) != null;
	}

	/**
	 * Indicate whether a specific object of type T is located in this tree.
	 * Note that the presence of the specific object should depend on the
	 * equals method of the object. Furthermore, it is possible for two objects
	 * to have the same location (x/y coordinates) but not be equal.
	 * 
	 * Best case: O(1): object found at root of tree.
	 * Average case: O(log n): object found deep within roughly balanced tree
	 * Worst case: O(n): tree is completely unbalanced, and object is at bottom of tree  
	 * 
	 * @param entry Specific object to search for
	 * @return True if the object is in the tree, false otherwise
	 */
	public boolean containsEntry(T entry) {
	    return findEntry(getRootNode(), entry, 0) != null;
	}	

	/**
	 * Retrieve the object from the tree that has the coordinates
	 * designated by the provided Point, or return null if no object
	 * in the tree has the designated coordinates. 
	 * 
	 * Best case: O(1): object found at root of tree.
	 * Average case: O(log n): object found deep within roughly balanced tree
	 * Worst case: O(n): tree is completely unbalanced, and object is at bottom of tree  
	 * 
	 * @param location Coordinates to search for
	 * @return Object in tree that has these exact coordinates, or 
	 *         null if no object has these coordinates 
	 */
	public T getEntry(Point location) {
		return findEntry(getRootNode(), location, 0);
	}

	/**
	 * Add a new entry at the appropriate place in the tree, potentially
	 * replacing a previously inserted object with the same location coordinates.
	 * If such an object was present, it is returned by the method. Otherwise,
	 * null is returned.
	 * 
	 * Best case: O(1): object found at root of tree.
	 * Average case: O(log n): object found deep within roughly balanced tree
	 * Worst case: O(n): tree is completely unbalanced, and object is at bottom of tree  
	 * 
	 * A RECURSIVE SOLUTION IS REQUIRED
	 * However, this add method is just the kick-off for the actual recursive method.
	 * 
	 * @param newEntry Object to insert into the tree
	 * @return Object that was replaced by the new entry, or null 
	 *         if no such entry was replaced.  
	 */
	// 5 points
	public T add(T newEntry) {
		// No entry replaced, because tree is empty
		if (isEmpty()) { 
			setRootNode(new BinaryNode<>(newEntry)); // First entry in the tree
			return null;
		} else {
			return addEntry(getRootNode(), newEntry, 0); 
		}
	}

	/**
	 * This is a helper method used to add a new entry into the 2D tree.
	 * The method first compares the coordinates of the new entry with the coordinates 
	 * of the current node entry to know if they are in the same place, it calculates 
	 * this based on the depth of the tree traversal. If the coordinates match, the current 
	 * entry is replaced with the new entry. If the coordinates do not match, the method 
	 * recursively go to the left or right subtree depending if the coordinates are less or greater.
	 * 
	 * @param rootNode Node from the tree 
	 * @param entry Entry to be added. It might be a simple Point, or have type T
	 * @param depth The depth that rootNode is at in the tree.
	 * @return Object that was replaced by the new entry, or null if no such entry was replaced. 
	 */
	private T addEntry(BinaryNode<T> rootNode, T newEntry, int depth) {
		T result = null;

		if (rootNode != null) { // If there is a tree
			T rootEntry = rootNode.getData();

			// Get coordinates of rootEntry and newEntry
			double rootX = rootEntry.getX();
			double rootY = rootEntry.getY();
			double entryX = newEntry.getX();
			double entryY = newEntry.getY();

			// Compare coordinates directly
			if (rootX == entryX && rootY == entryY) {
				// Replace the current node's entry with the new entry
				rootNode.setData(newEntry);
				return rootEntry; // Return the replaced object
			}

			// Determine which coordinate x or y to compare based on depth
			double rootValue;
			double entryValue;
			if (depth % 2 == 0) {
				rootValue = rootX;
				entryValue = entryX;
			} else {
				rootValue = rootY;
				entryValue = entryY;
			}

			// Recursively insert the new entry into the left or right subtree
			if (entryValue < rootValue) {
				if (rootNode.getLeftChild() == null) // If there is not left child
					rootNode.setLeftChild(new BinaryNode<>(newEntry));
				else
					result = addEntry(rootNode.getLeftChild(), newEntry, depth + 1);
			} else { // We know entryValue > rootValue
				if (rootNode.getRightChild() == null) // If there is not right child
					rootNode.setRightChild(new BinaryNode<>(newEntry));
				else
					result = addEntry(rootNode.getRightChild(), newEntry, depth + 1);
			}
		}
		return result;
	}

	/**
	 * Returns an iterator for the elements in this tree in in-order traversal.
	 * The iterator processes the tree elements in their natural order based on their locations
	 * and it just implements the hasNext and next methods.
	 *
	 * @return In order iterator for the elements in this tree.
	 */
	// 10 points
	public Iterator<T> getInorderIterator() {
		return new InorderIterator(getRootNode());
	}

	/**
	 * Iterator that processes tree elements in their natural order
	 */
	private class InorderIterator implements Iterator<T> {
		private Stack<BinaryNode<T>> nodeStack;

		public InorderIterator(BinaryNode<T> rootNode) {
			nodeStack = new Stack<>();
			pushLeftChildren(rootNode); // Change the elements until the last left element
		}
		
		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}

		@Override
		public T next() {
			// Get the next node from the top of the stack
			BinaryNode<T> nextNode = nodeStack.pop();
			T result = nextNode.getData();

			// Move to the right child
			pushLeftChildren(nextNode.getRightChild());

			return result;
		}

		/**
		 * Helper method to push all left children of a node onto the stack
		 * @param node The node from where the push process will start
		 */
		private void pushLeftChildren(BinaryNode<T> node) {
			while (node != null) { //While the node is not a leaf
				nodeStack.push(node);
				node = node.getLeftChild();
			}
		}
	}


	/**
	 * Checking for the nearest neighbor of a given query point is one of the main
	 * uses of 2d-trees. This method returns the entry in the tree that is
	 * closest to the query Point in terms of distance. However, to get credit for
	 * this method, you must implement it efficiently in accordance with the 
	 * assignment description (simply comparing against all points is not allowed).
	 *
	 * Best case: O(1): object found at root of tree.
	 * Average case: O(log n): object found deep within roughly balanced tree
	 * Worst case: O(n): tree is completely unbalanced, and object is at bottom of tree   
	 *    
	 * A RECURSIVE SOLUTION IS REQUIRED
	 * However, this nearestNeighbor method is just the kick-off for the actual recursive method.
	 * 
	 * @param query Point whose nearest neighbor in tree is to be found.
	 * @return Entry from tree that is nearest to query Point, or null if tree is empty.
	 */
	public T nearestNeighbor(Point query) { // DO NOT CHANGE METHOD SIGNATURE
		if (isEmpty()) { // If tree is empty, return null
			return null; 
		}
	
		// Initialize the closest point and distance with the root of the tree
		BinaryNode<T> rootNode = getRootNode();
		T closestEntry = rootNode.getData();
		double closestDistance = distance(query, closestEntry);
	
		// Create return objects to store the closest point and distance and give it to the next method
		ReturnObject<T> closestPoint = new ReturnObject<>(closestEntry);
		ReturnObject<Double> minDistance = new ReturnObject<>(closestDistance);
	
		// Start recursive search for the nearest neighbor
		nearestNeighbor(query, rootNode, closestPoint, minDistance, 0);
	
		// Return the closest point found and storage during execution of the other method
		return closestPoint.getValue();
	}

	/**
     * Find the nearest neighbor to a given query point in the 2D tree.
     *
     * @param query The query point to look for.
     * @param node The node to examine during the search.
     * @param guessRef A return object with reference to the closest point found so far.
     * @param bestDistRef A return object with reference to the closest distance found so far.
	 * @param depth The depth that node is at in the tree.
     */
    public void nearestNeighbor(Point query, BinaryNode<T> node, ReturnObject<T> guessRef, ReturnObject<Double> bestDistRef, int depth) {
		if (node == null)
			return;
	
		// Calculate distance between query point and point in node
		double dist = distance(query, node.getData());
	
		// Update the closest point and distance if current node is closer
		if (dist < bestDistRef.getValue()) {
			bestDistRef.setValue(dist);
			guessRef.setValue(node.getData());
		}
	
		// Determine which coordinate x or y to compare based on depth
		double nodeCoord;
		double queryCoord;
		if (depth % 2 == 0) {
			nodeCoord = node.getData().getX();
			queryCoord = query.getX();
		} else {
			nodeCoord = node.getData().getY();
			queryCoord = query.getY();
		}
	
		// Calculate the absolute value of the difference between query point coordinate and node point coordinate
		double diff = Math.abs(queryCoord - nodeCoord);
	
		// Recursively search the appropriate side of the tree
		if (queryCoord < nodeCoord) {
			nearestNeighbor(query, node.getLeftChild(), guessRef, bestDistRef, depth + 1);
			if (diff < bestDistRef.getValue())
				nearestNeighbor(query, node.getRightChild(), guessRef, bestDistRef, depth + 1);
		} else {
			nearestNeighbor(query, node.getRightChild(), guessRef, bestDistRef, depth + 1);
			if (diff < bestDistRef.getValue())
				nearestNeighbor(query, node.getLeftChild(), guessRef, bestDistRef, depth + 1);
		}
    }

	/**
     * Inner class representing a return object to store reference values.
     */
    private static class ReturnObject<D> {
        private D value;

        public ReturnObject(D value) {
            this.value = value;
        }

        public D getValue() {
            return value;
        }

        public void setValue(D value) {
            this.value = value;
        }
    }

	/**
	 * Useful helper method that uses the Pythagorean Theorem
	 * to determine the (Euclidean) distance between two Located2D
	 * instances.
	 * 
	 * @param p1 A non-null object in 2D space
	 * @param p2 A non-null object in 2D space
	 * @return Euclidean distance between p1 and p2
	 */
	private static double distance(Located2D p1, Located2D p2) {
		double xDiff = (p1.getX() - p2.getX()); // leg length a
		double yDiff = (p1.getY() - p2.getY()); // leg length b
		// The leg lengths might be negative, but the multiplication below cancels that out
		return Math.sqrt(xDiff*xDiff + yDiff*yDiff); // Hypotenuse length c
	}
}

