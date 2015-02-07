package percolation;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class PercolationTest {

	Percolation perc = new Percolation(10);
	File myFile = new File("files/percolationTests/");
	
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
	
	/**
	 * Runs the PercolationVisualizer on every test file in the 
	 * "files/percolationTests" directory. 
	 */
	@Test
	public void functionalTests() {
		if ( myFile.isDirectory() ){
			String[] list = myFile.list();
			try {
				for (int i = 0; i < myFile.listFiles().length; i++){  
					list[i] = "files/percolationTests/"+list[i];
					PercolationVisualizer.main(new String[] {list[i]});
					Thread.sleep(3000); 
				}
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}	
		}
	}
	

}
