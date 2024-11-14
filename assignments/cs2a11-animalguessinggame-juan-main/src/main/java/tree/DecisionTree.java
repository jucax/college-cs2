
package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class is a binary tree in which each internal
 * node is a question and each leaf node is an answer.
 * When traversing the tree, going left indicates a
 * response of No to the question in that node, and
 * going right indicates a response of Yes. In addition
 * to maintaining the tree, there is also a current node
 * used for traversing the tree.
 *                
 * Implement and comment all methods with a TODO directive. 
 * 
 * @author Jacob Schrum
 */
public class DecisionTree extends BinaryTree<String> implements DecisionTreeInterface<String> {

	// Represents current point in the decision process
	private BinaryNode<String> current;

	/**
	 * Create new tree with root node containing specified text with no children.
	 * @param text Contents of node.
	 */
	public DecisionTree(String text) {
		super(text); 
		// Current node starts at root of tree
		current = this.getRootNode();
	}

	/**
	 * Create new tree with given question contained in root node, and
	 * provided left (no) and right (yes) subtrees.
	 * @param question String data in root node  
	 * @param no Left subtree to traverse if answer to question is no
	 * @param yes Right subtree to traverse if answer to question is yes
	 */
	public DecisionTree(String question, DecisionTree no, DecisionTree yes) {
		super(question, no, yes);
		// Current node starts at root of tree
		current = this.getRootNode();
	}

	@Override
	public String getCurrentData() { 
		if(current != null) // If the current node exists
			return current.getData(); // Return data
		return null; // Otherwise return null
	}

	@Override
	public void setCurrentData(String newData) { 
		// The precondition is that current is not null, so we don't need to check it
		current.setData(newData); 
	}

	@Override
	public void setAnswers(String answerForNo, String answerForYes) {
		// The precondition is that current is not null, so we don't need to check it
		current.setLeftChild(new BinaryNode<String>(answerForNo)); // Create and add the left node
		current.setRightChild(new BinaryNode<String>(answerForYes)); // Create and add the right node
	} 

	@Override
	public boolean isAnswer() {
		// We know if it Answer if it is leaf
		return current != null && current.isLeaf();
	} 

	@Override
	public void advanceToNo() {
		if (!current.hasLeftChild()) // If there is not left node, current null
			current = null;
		else 
			current = current.getLeftChild(); // Otherwise go to the left node
	}

	@Override
	public void advanceToYes() {
		if (!current.hasRightChild()) // If there is not right node, current null
			current = null;
		else 
			current = current.getRightChild(); // Otherwise go to the right node
	}

	@Override 
	public void reset() {
		// Go back to the start of the tree
		current = getRootNode();
	} 

	/**
	 * Method saves the tree in a file with the specified filename.
	 * @param filename Name of file to save tree to 
	 */
	public void saveTree(String filename) {
		try { // Try saving tree
			saveTree(new File(filename));
		} catch (FileNotFoundException e) {
			// Exit if there is an exception
			System.err.println("Could not save to file: " + filename);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Kick-off for the recursive method that actually saves the tree.
	 * The root node of the tree is sent to the recursive method so that
	 * the tree can be output to file with a pre-order traversal.
	 * 
	 * @param saveFile An instance of File to save the tree to
	 * @throws FileNotFoundException If file cannot be created
	 */
	private void saveTree(File saveFile) throws FileNotFoundException {
		PrintStream ps = new PrintStream(saveFile); // Prepare to output to save file
		saveTree(ps, getRootNode());
		ps.close(); // Close the save file
	}

	/**
	 * This method takes in a binary node and writes its contents,
	 * along with the contents of all descendant nodes, to a file
	 * (represented by a print stream) in pre-order. In other words,
	 * the contents of this node are written to one line of the file,
	 * then the contents of the left subtree are recursively written,
	 * followed by the contents of the right subtree being recursively 
	 * written. Whenever the binary node is null, the word "NULL"
	 * should be written to the file. This means that two lines of "NULL"
	 * will appear in the file whenever a leaf is reached, which will 
	 * allow the data to be parsed when reading it back in from file.
	 * 
	 * @param saveStream A PrintStream linked to a save file.
	 * @param current Node in the binary tree.
	 */
	private void saveTree(PrintStream saveStream, BinaryNode<String> current) {
		if(current == null)
			saveStream.println("NULL"); // This to indicate no Node and write NULL in the text
		else {
			saveStream.println(current.getData()); // The data of the node
			saveTree(saveStream, current.getLeftChild()); // Saving left child
			saveTree(saveStream, current.getRightChild()); // Saving right child
		}
	}

	/**
	 * Static method that creates a new instance of DecisionTree filled with
	 * data from the specified input file.
	 * 
	 * @param filename Name of file containing saved DecisionTree output.
	 * @return DecisionTree filled with data from file.
	 * @throws FileNotFoundException File with saved tree could not be found.
	 */
	public static DecisionTree loadTree(String filename) throws FileNotFoundException {
		return loadTree(new File(filename));
	}

	/**
	 * Kick-off method for the recursive method that actually fills the decision
	 * tree with data from the file.
	 * 
	 * @param file Instance of File containing saved DecisionTree
	 * @return DecisionTree constructed from file  
	 * @throws FileNotFoundException File with saved tree could not be found.
	 */
	private static DecisionTree loadTree(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(file); // Read from file
		// First line of file is question at root node
		DecisionTree dt = new DecisionTree(scan.nextLine());
		BinaryNode<String> root = dt.getRootNode();
		fillTree(Branch.LEFT, scan, root); // Fill left subtree using Scanner
		fillTree(Branch.RIGHT, scan, root); // Fill right subtree using Scanner
		scan.close(); // Close the file loaded from
		return dt;
	}

	/**
	 * Used by fillTree to determine if the LEFT or RIGHT subtree is currently
	 * being filled from the file.  
	 */
	private enum Branch {LEFT, RIGHT};

	/**
	 * Recursively fill the decision tree with the file contents by creating
	 * new child nodes beneath the incoming parent. When the side is LEFT, then
	 * the next line read from the Scanner should be the left child of the
	 * parent. When the side is RIGHT, then the next line read from the Scanner 
	 * should be the right child of the parent.  
	 * 
	 * @param side Which side of the parent node the next line should be the child of.
	 * @param scanner Scans the input file containing the decision tree.
	 * @param parent Node that read file contents should be attached to.  
	 */
	private static void fillTree(Branch side, Scanner scanner, BinaryNode<String> parent) {
		if(scanner.hasNextLine()) {
			String data = scanner.nextLine(); // Read the line and sabe it
			if(!data.equals("NULL")) {
				BinaryNode<String> childNode = new BinaryNode<>(data);

				// Attaching child to the parent
				if(side == Branch.LEFT) 
					parent.setLeftChild(childNode);
				else if(side == Branch.RIGHT) 
					parent.setRightChild(childNode);
					
				// Filling tree using recursion
				fillTree(Branch.LEFT, scanner, childNode);
				fillTree(Branch.RIGHT, scanner, childNode);
			}
		}
	}
}
