/**
 * 
 * @author Greg Hiatt
 * @author David Weber
 * Date Created: 2/22/2015
 * Date Modified: 3/7/2015
 * Date Due: 3/7/2015
 * 
 * This class finds all the matches given a key in an array.  It will also 
 * return the number of matches found between the first and last index of the key.
 *
 */

package autocomplete;

import java.util.Arrays;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Autocomplete {
	
	
	private final Term[] terms;
	
	
	/**
	 * Initialize the data structure from the given array of terms.
	 * @param terms
	 */
    public Autocomplete(Term[] t){
    	if(t == null) throw new NullPointerException();
    	Arrays.sort(t);
    	terms = t;
    }
    
    /**
     * Return all terms that start with the given prefix, in descending order of weight.
     * @param prefix
     * @return
     */
    public Term[] allMatches(String prefix){
    	if(prefix == null) throw new NullPointerException();
    	Term temp = new Term(prefix,0);
    	int pre = prefix.length();
    	
    	int first = BinarySearchDeluxe.firstIndexOf(terms, temp, Term.byPrefixOrder(pre));
    	int last = BinarySearchDeluxe.lastIndexOf(terms, temp, Term.byPrefixOrder(pre));
    	Term[] matches = new Term[last-first];
    	int count = 0;
    	for(int i= first; i < last; i++){
    		matches[count]= terms[i];
    		count++;
    	}
    	Arrays.sort(matches, Term.byReverseWeightOrder());
    	
    	return matches;
    	
    }
    /**
     * Return the number of terms that start with the given prefix.
     * @param prefix
     * @return
     */
    public int numberOfMatches(String prefix){
    	if(prefix == null) throw new NullPointerException();
    	int pre = prefix.length();
    	Term temp = new Term(prefix,0);
    	
    	int first = BinarySearchDeluxe.firstIndexOf(terms, temp, Term.byPrefixOrder(pre));
    	int last = BinarySearchDeluxe.lastIndexOf(terms, temp, Term.byPrefixOrder(pre));
    	
    	return last-first;
    }
    
    
}

