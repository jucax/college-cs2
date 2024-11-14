package recursion;

/**
 * Used in Day 1 of our coverage of recursion. Introduces the basics
 * of recursion. These are relatively simple recursive algorithms
 * that help demonstrate how the approach works. However, most of
 * the algorithms demonstrated here could honestly be accomplished
 * better with loops.
 */
public class Basic {

	public static void main(String[] args) {
		// Put code here to test out the methods
	}

	/**
	 * Recursively compute the sum of integers from 1 to n
	 * 
	 * @param n Last number of sum
	 * @return Sum from 1 to n
	 */
	public static int sumToN(int n) {
		if (n == 1) return 1;
		else return n + sumToN (n - 1);
	}

	/**
	 * Multiply non-negative integers x and y using recursion, and using only addition.
	 * You cannot use the * operator. 
	 * 
	 * @param x a non-negative integer
	 * @param y another non-negative integer
	 * @return x * y
	 */
	public static int multiply(int x, int y) {
		// Ex: 5 * 3
		// multiply(5,3)
		// return 5 + multiply(5,2)
		//			  return 5 + multiply(5,1)
		//						 return 5 + multiply(5,0)
		//									return 0
		// 						 return 5 + 0 = 5
		// 			  return 5 + 5 = 10
		// return 5 + 10 = 15

		if (x == 0 || y == 0) return 0;
		else return x + multiply(x, y - 1);
	}

	/**
	 * Compute x raised to the power of y using multiplication
	 * but without using exponentiation of any kind (cannot use Math class).
	 * y must be a non-negative integer power, and x cannot be 0.
	 * 
	 * @param x Base of the exponent
	 * @param y Power of the exponent
	 * @return x^y
	 */
	public static long power(long x, long y) {
		// Ex: 4^2
		// power(4, 2)
		// return 4 * power(4, 1)
		//			  return 4 * power(4, 0)
		//						 return 1;
		// 			  return 4 * 1 = 4
		// return 4 * 4 = 16
		
		if (y == 0) return 1;
		else return x * power (x, y - 1);
	}

	/**
	 * Compute the sum of all elements in the array
	 * with a recursive helper method. This method is
	 * the kick-off for the recursive method.
	 * 
	 * @param arr An array of integers
	 * @return sum of elements in arr
	 */
	public static int arraySum(int[] arr) {
		return arraySum(arr,0);
	}

	/**
	 * Return the sum of all elements in the array
	 * starting from the given index and carrying on
	 * to the end of the array. Elements before the
	 * starting index are not part of the sum. If the
	 * index is beyond the last index, then return 0.
	 * 
	 * @param arr An array of integers
	 * @param startIndex Non-negative array index (possibly out of bounds)
	 * @return Sum from arr[startIndex] up until the last element of the array
	 */
	private static int arraySum(int[] arr, int startIndex) {
		int sum = 0;
		if (startIndex >= arr.length) return 0;
		else if (startIndex == arr.length - 1) sum += arr[arr.length - 1];
		else sum += arr[startIndex] + arraySum(arr, startIndex + 1);
		return sum;
	}

	/**
	 * Inner class similar to a node inside a linked data structure,
	 * but this class is static because it is not associated with a
	 * specific instance of some data structure.
	 */
	public static class Node<T> {
		private T data;
		private Node<T> next;
		/**
		 * Create new node that contains the given data and
		 * points to the given next node.
		 * @param theData data in the node
		 * @param theNext link to next node in chain
		 */
		public Node(T theData, Node<T> theNext) {
			data = theData;
			next = theNext;
		}

		/**
		 * Create new node that contains the given data and
		 * does not have a next node because it is at the
		 * end of the chain.
		 * @param theData data in the node
		 */
		public Node(T theData) {
			data = theData;
			next = null;
		}

		/**
		 * Get data in node
		 * @return The data in the node
		 */
		public T getData() {
			return data;
		}

		/**
		 * Get next node
		 * @return the next node in the chain
		 */
		public Node<T> getNextNode() {
			return next;
		}
	}

	/**
	 * Compute the sum of the values within the nodes of a linked chain,
	 * recursively. If the node is null, then the result is 0.
	 * 
	 * @param firstNode Node in a linked chain, or null
	 * @return Sum of values in the linked chain
	 */
	public static int chainSum(Node<Integer> firstNode) {
		int sum = 0;
		if (firstNode == null) return 0;
		else sum += firstNode.getData() + chainSum(firstNode.getNextNode());
		return sum;
	}

	/**
	 * Print the elements of a linked chain of nodes with each element
	 * printed to its own line, starting with the last node of the chain
	 * and working backwards. If the node is null, do nothing.
	 * 
	 * @param <T> Type contained in each node
	 * @param firstNode First node of the chain, or null.
	 */
	public static <T> void printChainReverse(Node<T> firstNode) {
		if (firstNode != null) {
			printChainReverse(firstNode.getNextNode());
			System.out.println(firstNode.getData());
		}
	} 
}
