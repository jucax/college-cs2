package tree;

import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * Implementation of a Binary Search Tree. The tree
 * must always maintain the property that all values in
 * the nodes of any left sub-tree are less than the
 * sub-tree's root value, and all values in the nodes of any
 * right sub-tree are greater than the sub-tree's root value.
 */
public class BinarySearchTree<T extends Comparable<? super T>>
				extends BinaryTree<T>
				implements SearchTreeInterface<T>{

	// Run this main method to help debug implementation problems
	public static void main(String[] args) {
		BinarySearchTree<Integer> intBST = new BinarySearchTree<Integer>();
		intBST.add(5);
		intBST.add(10);
		intBST.add(0);
		intBST.add(-23);
		intBST.add(45);
		intBST.add(23423);
		intBST.add(-4353);

		// Until getInorderIterator is implemented, this will create a NullPointerException
		Iterator<Integer> itr = intBST.getInorderIterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}

	@Override
	public void setTree (T rootData) {
		throw new UnsupportedOperationException("Do not allow setTree in BinarySearchTree");
	} 

	@Override
	public void setTree (T rootData, BinaryTreeInterface < T > leftTree, BinaryTreeInterface < T > rightTree) {
		throw new UnsupportedOperationException("Do not allow setTree in BinarySearchTree");
	} 

	@Override
	public T getEntry(T entry) {
		return findEntry(this.getRootNode(), entry);
	}

	/**
	 * Recursively find an entry within a sub-tree whose root is the given node.
	 * 
	 * @param node Root of a sub-tree of binary search tree
	 * @param entry Value to look for
	 * @return null if value is not found, or value from tree if found
	 */
	private T findEntry(BinaryNode<T> node, T entry) {
		T result = null;
		if(node != null ) {
			T rootEntry = node.getData();
			if (entry.equals(rootEntry))
				result = rootEntry;
			else if (entry.compareTo(rootEntry) < 0)
				result = findEntry(node.getLeftChild(), entry);
			else 
				result = findEntry(node.getRightChild(), entry);
		}
		return result;
	}

	@Override
	public boolean contains(T entry) {
		return getEntry(entry) != null;
	}

	@Override
	public T add(T newEntry) {
		T result = null;
		if(this.isEmpty()) {
			this.setRootNode(new BinaryNode<T>(newEntry));
		} else {
			result = addEntry(this.getRootNode(), newEntry);
		}
		return result;
	}

	/**
	 * Recursive helper method for adding a new value to the tree.
	 * Value is added in a way that maintains binary search tree order.
	 * Since no duplicates are allowed in the tree, the new value
	 * will replace a value with the same sort order. Otherwise,
	 * a new node must be constructed to store the new value in
	 * a leaf node.
	 * 
	 * @param node non-empty root of subtree to add the value to
	 * @param newEntry Value to add
	 * @return if a value is replaced, return that value, otherwise null
	 */
	private T addEntry(BinaryNode<T> node, T newEntry) {
		T result = null;
		int comparison = newEntry.compareTo(node.getData());
		if (comparison == 0) {
			result = node.getData();
			node.setData(newEntry);
		} else if (comparison < 0) {
			if (node.hasLeftChild())
				result = addEntry(node.getLeftChild(), newEntry);
			else
				node.setLeftChild(new BinaryNode<>(newEntry));
		} else {
			if (node.hasRightChild())
				result = addEntry(node.getRightChild(), newEntry);
			else
				node.setRightChild(new BinaryNode<>(newEntry));
		}
		return result;
	}

	@Override
	public T remove(T entry) {
		return null; // TODO, but implementation not required for completion of assignment
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	/**
	 * Iterator that processes tree elements in their natural order
	 */
	private class InorderIterator implements Iterator<T> {
		private Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
		private BinaryNode<T> currentNode;

		public InorderIterator() {
			nodeStack = new Stack<BinaryNode<T>>();
			currentNode = getRootNode();
		}
		
		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || currentNode != null;
		}

		@Override
		public T next() {
			while (currentNode != null || !nodeStack.isEmpty()) {

				while (currentNode != null) {
					nodeStack.push(currentNode);
					currentNode = currentNode.getLeftChild();
				}
				
				if (!nodeStack.isEmpty()) {
					currentNode = nodeStack.pop();
					T result = currentNode.getData();
					currentNode = currentNode.getRightChild();
					return result; 
				}
			}

			return null; // No more elements
		}
	}	

}
