/**
 * @author Robert Sedgewick
 * @author David Weber
 * 
 * @Date created: 3/1/2014 - d
 * @Date last modified: 3/7/2014 - d 
 * CSIS 2420 - SPR 2014
 * 
 * Code available on GitHub here:
 * https://github.com/davidlweber/2420_Assignments/tree/master/src/autocomplete
 */
package autocomplete;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class AutocompleteApp {

    public static void main(String[] args) {

        // read in the terms from a file
        String filename =  "/autocompleteTests/cities.txt";//args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            double weight = in.readDouble();       // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = 7;//Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
        
    }

}
