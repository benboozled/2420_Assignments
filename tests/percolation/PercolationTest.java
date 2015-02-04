package percolation;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Scanner;
import java.util.Timer;

import org.junit.Test;

public class PercolationTest {

	Timer time = new Timer();
	Scanner scan = new Scanner(System.in);
	Percolation perc = new Percolation(10);
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIsFullOutOfBounds() {
		perc.isFull(-1,0);
		perc.isFull(0,-1);
		perc.isFull(10,10);
	}
	@Test
	public void testIsFull() {
		assertEquals(false,perc.isFull(0,0));
		assertEquals(false,perc.isFull(9,9));
	}
	
	
	@Test
	public void functionalTests() {
		
		File myFile = new File("files/percolationTests/");
		if ( myFile.isDirectory() ){
			String[] list = myFile.list();
			try {
				for (int i = 0; i < myFile.listFiles().length; i++){  
					list[i] = "files/percolationTests/"+list[i];
					PercolationVisualizer.main(new String[] {list[i]});
					Thread.sleep(2000); 
				}
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
				
		}

	}
	
	/*
	@Test
	public void testNumberOfOpenSites() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIsOpen() {
		fail("Not yet implemented");
	}

	@Test
	public void testPercolates() {
		fail("Not yet implemented");
	}

	@Test
	public void testOpen() {
		fail("Not yet implemented");
	}
	*/
}
