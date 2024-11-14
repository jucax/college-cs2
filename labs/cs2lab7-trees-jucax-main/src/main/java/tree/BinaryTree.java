package tree;
/**
 * A class that implements the ADT binary tree.
 * @author Frank M. Carrano.
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {

	// Run this main method to help debug implementation problems
	public static void main(String[] args) {
		// An example tree
		BinaryTree<Integer> intTree = new BinaryTree<>(100,
				new BinaryTree<>(90,
						new BinaryTree<>(85,
								new BinaryTree<>(40,
										new BinaryTree<>(30),
										new BinaryTree<>(21)),
								new BinaryTree<>(37)),
						new BinaryTree<>(70,
								new BinaryTree<>(67),
								new BinaryTree<>(22))),
				new BinaryTree<>(80,
						new BinaryTree<>(64,
								new BinaryTree<>(10),
								new BinaryTree<>(44,
										new BinaryTree<>(43,
												new BinaryTree<>(5),
												null),
										null)),
						new BinaryTree<>(53,
								new BinaryTree<>(39),
								new BinaryTree<>(49,
										null,
										new BinaryTree<>(30,
												new BinaryTree<>(15),
												new BinaryTree<>(2))))));

		System.out.println("Pre-order traversal:");
		intTree.printPreOrder();
	}

	private BinaryNode<T> root;

	/**
	 * New empty tree
	 */
	public BinaryTree () {
		root = null;
	} // end default constructor

	/**
	 * New tree with data in root
	 * @param rootData Data for root
	 */
	public BinaryTree (T rootData) {
		root = new BinaryNode < T > (rootData);
	} // end constructor

	/**
	 * New tree with specified root data and subtrees
	 * @param rootData Data for root
	 * @param leftTree Left subtree
	 * @param rightTree Right subtree
	 */
	public BinaryTree (T rootData, BinaryTree < T > leftTree, BinaryTree < T > rightTree) {
		privateSetTree (rootData, leftTree, rightTree);
	} // end constructor

	/**
	 * Replace tree with new tree consisting only of a root with given data.
	 */
	public void setTree (T rootData) {
		root = new BinaryNode < T > (rootData);
	} // end setTree

	/**
	 * Replace tree with new tree consisting of root data and subtrees
	 */
	public void setTree (T rootData, BinaryTreeInterface < T > leftTree, BinaryTreeInterface < T > rightTree) {
		privateSetTree (rootData, (BinaryTree < T > ) leftTree, (BinaryTree < T > ) rightTree);
	} // end setTree

	/**
	 * Replace this tree with a new one using the given root data and subtrees, but
	 * make copies of subtrees if they are the same. Also destroy the source trees
	 * so that no lingering references to the internal nodes of this tree exist.
	 * 
	 * @param rootData New root data
	 * @param leftTree Left subtree
	 * @param rightTree Right subtree
	 */
	private void privateSetTree (T rootData, BinaryTree < T > leftTree, BinaryTree < T > rightTree) {
		root = new BinaryNode<T>(rootData);
		if(leftTree != null && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		if(rightTree != null && !rightTree.isEmpty()) {
			if(rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		}
		if(leftTree != null && leftTree != this)
			leftTree.clear();
		if(rightTree != null && rightTree != this)
			rightTree.clear();
	} // end privateSetTree

	/**
	 * Return data stored in root
	 */
	public T getRootData () {
		T rootData = null;
		if (root != null)
			rootData = root.getData ();
		return rootData;
	} // end getRootData

	/**
	 * Indicate whether tree is empty
	 */
	public boolean isEmpty () {
		return root == null;
	} // end isEmpty

	/**
	 * Empty the tree by setting root to null.
	 */
	public void clear () {
		root = null;
	} // end clear

	/**
	 * Change root data
	 * @param rootData New data
	 */
	protected void setRootData (T rootData) {
		root.setData (rootData);
	} // end setRootData

	/**
	 * Replace root node
	 * @param rootNode New node
	 */
	protected void setRootNode (BinaryNode < T > rootNode) {
		root = rootNode;
	} // end setRootNode

	/**
	 * Return node that is the root.
	 * @return Root node
	 */
	protected BinaryNode < T > getRootNode () {
		return root;
	} // end getRootNode

	/**
	 * Return height of tree
	 */
	public int getHeight() {
		return root.getHeight();
	} 

	/**
	 * Return number of nodes in tree
	 */
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	} 

	/**
	 * Do a pre-order traversal that prints
	 * each node value it visits on a separate
	 * line.
	 */
	public void printPreOrder() {
		root.printPreOrder();
	}

	/**
	 * Do a post-order traversal that prints
	 * each node value it visits on a separate
	 * line.
	 */
	public void printPostOrder() {
		root.printPostOrder();
	}

	/**
	 * Do an in-order traversal that prints
	 * each node value it visits on a separate
	 * line.
	 */
	public void printInOrder() {
		root.printInOrder();
	}

	/**
	 * Take an expression tree of strings where each leaf is a number
	 * and each internal node is an arithmetic operator, and evaluate
	 * it as an expression tree.
	 * 
	 * @param expressionTree A validly formatted expression tree
	 * @return result of evaluating tree
	 */
	public static double evaluateExpressionTree(BinaryTree<String> expressionTree) {
		return evaluateExpressionTree(expressionTree.getRootNode());
	}

	/**
	 * Actual recursive evaluation of the expression tree.
	 * 
	 * @param node A node from a validly formatted expression tree.
	 * @return result of evaluating the expression subtree that has
	 *         the given node as its root.
	 */
	public static double evaluateExpressionTree(BinaryNode<String> node) {
		String data = node.getData();

		switch (data) {
			case "+": return evaluateExpressionTree(node.getLeftChild()) + evaluateExpressionTree(node.getRightChild());
			case "-": return evaluateExpressionTree(node.getLeftChild()) - evaluateExpressionTree(node.getRightChild());
			case "/": return evaluateExpressionTree(node.getLeftChild()) / evaluateExpressionTree(node.getRightChild());
			case "*": return evaluateExpressionTree(node.getLeftChild()) * evaluateExpressionTree(node.getRightChild());

			default: return Double.parseDouble(data);
		}
	}
} // end BinaryTree