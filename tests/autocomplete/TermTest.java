package autocomplete;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class TermTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		List<Term> queryList = new ArrayList<Term>();
		
        try {Scanner scanner = new Scanner(TermTest.class.getResourceAsStream
        		("/autocompleteTests/fortune1000-randomly-ordered.txt"));
        	scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String vals[] = line.split("\t");
                queryList.add(new Term(vals[1],Double.parseDouble(vals[0])));
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Term[] queries = queryList.toArray(new Term[queryList.size()-1]);
        StdOut.println("done");
        
    	StdOut.println("\nsorted by query comparator:");
    	Arrays.sort(queries, Term.byPrefixOrder(1));
    	for (Term el: queries) StdOut.println(el.toString());
    	
//    	StdOut.println("\nsorted by rev weight comparator:");
//    	Arrays.sort(queries, Term.byReverseWeightOrder());
//    	for (Term el: queries) StdOut.println(el.toString());
        
	}
	

	@Test
	public void testByReverseWeightOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testByPrefixOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
