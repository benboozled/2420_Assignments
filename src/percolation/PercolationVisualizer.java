/****************************************************************************
 *  @author http://www.cs.princeton.edu/courses/archive/fall14/cos226/checklist/percolation.html
 * 
 *  Compilation:  javac PercolationVisualizer.java
 *  Execution:    java PercolationVisualizer input.txt
 *  Dependencies: Percolation.java StdDraw.java In.java
 *
 *  This program takes the name of a file as a command-line argument.
 *  From that file, it
 *
 *    - Reads the grid size N of the percolation system.
 *    - Creates an N-by-N grid of sites (initially all blocked)
 *    - Reads in a sequence of sites (row i, column j) to open.
 *
 *  After each site is opened, it draws full sites in light blue,
 *  open sites (that aren't full) in white, and blocked sites in black,
 *  with with site (0, 0) in the upper left-hand corner.
 *
 ****************************************************************************/
package percolation;

import java.awt.Font;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class PercolationVisualizer {

    // delay in milliseconds (controls animation speed)
    private final static int DELAY = 2;

    // draw N-by-N percolation system
    public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-.05*N, 1.05*N);
        StdDraw.setYscale(-.05*N, 1.05*N);   // leave a border to write text
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // draw N-by-N grid
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                StdDraw.filledSquare(col + 0.5, N - row - 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25*N, -N*.025, perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
        else                   StdDraw.text(.75*N, -N*.025, "does not percolate");

    }

    private static void simulateFromFile(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);

        // turn on animation mode
        StdDraw.show(0); 

        // repeatedly read in sites to open and draw resulting system
        draw(perc, N);
        StdDraw.show(DELAY);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            StdDraw.show(DELAY);
        }
        
    }

    /**
     * main string is primarily used for testing from PercolationTest, but it can also 
     * be used to run individual files from a small selection.
     */
    public static void main(String[] args) {
    	
    	if (args.length < 1){
    		
    		StdOut.println("Press key to run:\n\n1) input50.txt\n2) input20.txt\n3) input1.txt\n4) input2-no.txt");
    		int sel = StdIn.readInt();
    		if (sel == 1)	simulateFromFile("files/percolationTests/input50.txt");
    		else if (sel == 2)	simulateFromFile("files/percolationTests/input20.txt");
    		else if (sel == 3)	simulateFromFile("files/percolationTests/input1.txt");
    		else if (sel == 4)	simulateFromFile("files/percolationTests/input2-no.txt");
    		
    	}
    	else					
    		simulateFromFile(args[0]);
    	
    }
}
