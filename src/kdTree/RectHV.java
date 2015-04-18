package kdTree;

import edu.princeton.cs.introcs.StdDraw;

	/**
	 * @author JHardesty
	 * @author DWeber
	 * Assignment: A05 Kd-Tree
	 * Created: 03/30/2015
	 * Modified: 03/30/2015
	 * 
	 * Implementation of 2D axis-aligned rectangle
	 * Subset lifted from http://algs4.cs.princeton.edu/code/RectHV.java.html
	 */
public class RectHV {
	
	private final double xmin, ymin;   // minimum x- and y-coordinates
    private final double xmax, ymax;   // maximum x- and y-coordinates
    
    /**
     *  construct the axis-aligned rectangle [xmin, xmax] x [ymin, ymax]
     * @param xmin
     * @param ymin
     * @param xmax
     * @param ymax
     */
	public RectHV(double xmin, double ymin, double xmax, double ymax) {
		if (xmax < xmin || ymax < ymin) {
            throw new IllegalArgumentException("Invalid rectangle");
        }
		
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
	}
	
	/**
	 * getters for 4 coordinates
	 * @return
	 */
    public  double xmin() { return xmin; }
    public  double ymin() { return ymin; }
    public  double xmax() { return xmax; }
    public  double ymax() { return ymax; }
    
    /**
     *  does this rectangle contain the point p (either inside or on boundary)?
     * @param p
     * @return
     */
    public boolean contains(Point2D p) { 
	    return (p.x() >= xmin) && (p.x() <= xmax)
	    && (p.y() >= ymin) && (p.y() <= ymax);
    }
    
    /**
     *  does this rectangle intersect that rectangle (at one or more points)?
     * @param that
     * @return
     */
    public boolean intersects(RectHV that) { 
    return this.xmax >= that.xmin && this.ymax >= that.ymin
                && that.xmax >= this.xmin && that.ymax >= this.ymin;
    }
    
    /**
     *  square of Euclidean distance from point p to closest point in rectangle
     * @param p
     * @return
     */
    public  double distanceSquaredTo(Point2D p) { 
    double dx = 0.0, dy = 0.0;
        if      (p.x() < xmin) dx = p.x() - xmin;
        else if (p.x() > xmax) dx = p.x() - xmax;
        if      (p.y() < ymin) dy = p.y() - ymin;
        else if (p.y() > ymax) dy = p.y() - ymax;
        return dx*dx + dy*dy;
    }
    
    /**
     *  does this rectangle equal that object?
     */
    public boolean equals(Object y) {
    	if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        RectHV that = (RectHV) y;
        if (this.xmin != that.xmin) return false;
        if (this.ymin != that.ymin) return false;
        if (this.xmax != that.xmax) return false;
        if (this.ymax != that.ymax) return false;
        return true;
    }
    
    public void draw() {
        StdDraw.line(xmin, ymin, xmax, ymin);
        StdDraw.line(xmax, ymin, xmax, ymax);
        StdDraw.line(xmax, ymax, xmin, ymax);
        StdDraw.line(xmin, ymax, xmin, ymin);
    }
    
    /**
     *  return a string representation of this axis-aligned rectangle
     */
    public  String toString() {
    	return "[" + xmin + ", " + xmax + "] x [" + ymin + ", " + ymax + "]";
    }
}
