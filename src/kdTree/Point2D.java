package kdTree;

import edu.princeton.cs.introcs.StdDraw;


/**
 * 
 * @author JHardesty
 * @author DWeber
 * Assignment: A05 Kd-Tree
 * Created: 03/30/2015
 * Modified: 03/30/2015
 * 
 * Point2D subset was lifted from the Point2D.java as a part of algs4.jar
 *
 */
public class Point2D implements Comparable<Point2D> {
private final double x;    // x coordinate
    private final double y;    // y coordinate   
    
    /**
     * Initializes a new point (x, y).
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @throws IllegalArgumentException if either <tt>x</tt> or <tt>y</tt>
     *    is <tt>Double.NaN</tt>, <tt>Double.POSITIVE_INFINITY</tt> or
     *    <tt>Double.NEGATIVE_INFINITY</tt>
     */
public Point2D(double x, double y) {
if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) x = 0.0;  // convert -0.0 to +0.0
        if (y == 0.0) y = 0.0;  // convert -0.0 to +0.0
        this.x = x;
        this.y = y;
}
  
/**
* Returns the x-coordinate.
*  @return the x-coordinate
*/
public  double x() {
return x;
}
/**
* Returns the y-coordinate.
* @return the y-coordinate
*/
public  double y() {
return y;
}
/**
     * Returns the square of the Euclidean distance between this point and that point.
     * @param that the other point
     * @return the square of the Euclidean distance between this point and that point
     */
public  double distanceSquaredTo(Point2D that) {
double dx = this.x - that.x;
        double dy = this.y - that.y;
        return dx*dx + dy*dy;
}
/**
     * Compares this point to that point by y-coordinate, breaking ties by x-coordinate.
     * @param that the other point
     * @return { a negative integer, zero, a positive integer } if this point is
     *    { less than, equal to, greater than } that point
     */
public int compareTo(Point2D that) {
		if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
}
/**
     * Does this point equal y?
     * @param other the other point
     * @return true if this point equals the other point; false otherwise
     */
public boolean equals(Object other) {
if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Point2D that = (Point2D) other;
        return this.x == that.x && this.y == that.y;
}
/**
     * Return a string representation of this point.
     * @return a string representation of this point in the format (x, y)
     */
public  String toString() {
return "(" + x + ", " + y + ")";
}

//TODO: delete this! Not allows by assignment specifications
//but necessary to make visualizers work
public void draw() {
    StdDraw.point(x, y);
}


}
