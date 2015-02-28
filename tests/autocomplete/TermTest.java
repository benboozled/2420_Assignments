package autocomplete;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class TermTest {
	
	private static List<Term> queryList = new ArrayList<Term>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
        try {Scanner scanner = new Scanner(TermTest.class.getResourceAsStream
        		("/autocompleteTests/2grams.txt"));
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
        //Term[] queries = queryList.toArray(new Term[queryList.size()]);
        StdOut.println("done");
	}
	
	@Test
	public void testFirstIndexOf(){
		Term[] queries = queryList.toArray(new Term[queryList.size()]);
		Arrays.sort(queries, Term.byReverseWeightOrder());
		//BinarySearchDeluxe.firstIndexOf(queries, "i", Term.byPrefixOrder(1));
	}
	
//	@Test
//	public void testByReverseWeightOrder() {
//		Term[] queries = queryList.toArray(new Term[queryList.size()]);
//    	StdOut.println("\nbyReverseWeightOrder:");
//    	Arrays.sort(queries, Term.byReverseWeightOrder());
//    	for (Term el: queries) StdOut.println(el.toString());
//	}
	
	
//	@Test
//	public void testByPrefixOrder() {
//		Term[] queries = queryList.toArray(new Term[queryList.size()]);
//    	StdOut.println("\nsorted by query comparator:");
//    	Arrays.sort(queries, Term.byPrefixOrder(1));
//    	for (Term el: queries) StdOut.println(el.toString());
//	}

}
