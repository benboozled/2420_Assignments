package autocomplete;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class TermTest {
	
	private static List<Term> queryList = new ArrayList<Term>();
	static String testString = "No";
	Term testTerm = new Term(testString, 1.00);
	int testLength = testString.length();
	static String file = "/autocompleteTests/fortune1000-randomly-ordered.txt";
	//("/autocompleteTests/fortune1000-randomly-ordered.txt"));
	//("/autocompleteTests/2grams.txt"));
	//("/autocompleteTests/5grams.txt"));
	//("/autocompleteTests/wiktionary.txt"));
	//("/autocompleteTests/dweber.txt"));
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        try {Scanner scanner = new Scanner(TermTest.class.getResourceAsStream (file));
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
        StdOut.println("done");

	}
	
	@Test
	public void testFirstIndexOf(){
		long startTime = System.currentTimeMillis();
		Term[] queries = queryList.toArray(new Term[queryList.size()]);
		Arrays.sort(queries, Term.byPrefixOrder(testLength));
    	for (int i = 0; i < queries.length-1; i++){
    		StdOut.println(i+"\t"+queries[i].toString());
    	}
    	StdOut.println();
    	StdOut.println("CHAR ARRAY\t"+file);
    	StdOut.println("testString: "+testString);
		StdOut.println("First index: "+BinarySearchDeluxe.firstIndexOf
				(queries, testTerm, Term.byPrefixOrder(testLength)));
		StdOut.println("Last index: "+BinarySearchDeluxe.lastIndexOf
				(queries, testTerm, Term.byPrefixOrder(testLength)));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("runtime: "+totalTime/1000.0);
		
	}

	
	@AfterClass
	public static void afterClass() throws Exception {
		
//		  // read in the terms from a file
//		  //String filename = "/autocompleteTests/fortune1000-randomly-ordered.txt";
//		  In in = new In(file);
//		  int N = in.readInt();
//		  Term[] terms = new Term[N];
//		  for (int i = 0; i < N; i++) {
//		      double weight = in.readDouble();       // read the next weight
//		      in.readChar();                         // scan past the tab
//		      String query = in.readLine();          // read the next query
//		      terms[i] = new Term(query, weight);    // construct the term
//		  }
//		
//		  // read in queries from standard input and print out the top k matching terms
//		  int k = 1;//Integer.parseInt(args[1]);
//		  Autocomplete autocomplete = new Autocomplete(terms);
//		  while (StdIn.hasNextLine()) {
//		      String prefix = testString;//StdIn.readLine();
//		      Term[] results = autocomplete.allMatches(prefix);
//		      for (int i = 0; i < Math.min(k, results.length); i++)
//		          StdOut.println(results[i]);
//		  }
		
	}
	
}
