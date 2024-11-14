package tree;

// The custom Point class that is part of the TwoDimensionTree
import tree.TwoDimensionTree.Point;

/**
 * A Point with a label associated. Could represent any object with
 * coordinates, such as a city, and object drawn on a computer screen,
 * or something else.
 * 
 * This class should be used in your testing of the TwoDimensionTree,
 * since it is an example of a class where two distinct instances can
 * be located at the same location.
 * 
 * @author Jacob Schrum
 */
public class LabeledPoint extends Point {
	// Label associated with this Point
	private String label;

	/**
	 * Create instance with the given label and x/y coordinates
	 * @param label String label
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public LabeledPoint(String label, double x, double y) {
		super(x, y);
		this.label = label;
	}

	/**
	 * Get the label for the Point
	 * @return String label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * LabelledPoints are only equal if they are at the same location
	 * and have the same label.
	 */
	@Override
	public boolean equals(Object obj) {
		if(this.getClass() == obj.getClass()) {
			LabeledPoint other = (LabeledPoint) obj;
			return super.equals(obj) && label.equals(other.label);
		}
		return false;
	}
	
	/**
	 * Print contents of point
	 */
	@Override
	public String toString() {
		return label + ":" + super.toString();
	}
}
