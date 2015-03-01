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
	String testString = "a";
	Term testTerm = new Term(testString, 1.00);
	int testLength = testString.length();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        try {Scanner scanner = new Scanner(TermTest.class.getResourceAsStream
        		//("/autocompleteTests/fortune1000-randomly-ordered.txt"));
        		//("/autocompleteTests/2grams.txt"));
        		//("/autocompleteTests/5grams.txt"));
        		//("/autocompleteTests/wiktionary.txt"));
        		("/autocompleteTests/dweber.txt"));
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
		Arrays.sort(queries, Term.byPrefixOrderARRAY(testLength));
    	for (int i = 0; i < queries.length-1; i++){
    		StdOut.println(i+"\t"+queries[i].toString());
    	}
		StdOut.println("\nFirst index: "+BinarySearchDeluxe.firstIndexOf(queries, testTerm, Term.byPrefixOrder(testLength)));
	}
	
	
	

}
