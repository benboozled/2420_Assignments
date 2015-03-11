/**
 * @author David Weber
 * @author Greg Hiatt 
 * 
 * @Date created: 2/24/2014 - d
 * @Date last modified: 3/2/2014 - d 
 * CSIS 2420 - SPR 2014
 * 
 * Term is a datatype representation of a key/value pair for query and weight to be 
 * used for a search engine autocomplete. Query is a string--typically a name--and 
 * weight refers to the priority in which it might show. The for loop in the method
 * "byPrefixOrder" is modified from Robert Sedgewick's "SuffixArray" class. 
 * 
 * Code available on GitHub here:
 * https://github.com/davidlweber/2420_Assignments/tree/master/src/autocomplete
 */
package autocomplete;

import java.util.Comparator;

public class Term implements Comparable<Term> {
	
	private String query;
	private double weight;

	
    public Term(String query, double weight){
    	if (query == null)	throw new java.lang.NullPointerException();
    	if (weight < 0) 	throw new java.lang.IllegalArgumentException();
    	this.query = query;
    	this.weight = weight;
    }

    
    /**
     * comparator that arranges Terms in order of the query
     * @return comparator that arranges Terms in order of the query
     */
    public static Comparator<Term> byPrefixOrder(int r){
    	if (r < 0) 	throw new java.lang.IllegalArgumentException();
    	final int rfinal = r;
    	class PrefixComparator implements Comparator<Term>{
			@Override
			public int compare(Term term1, Term term2) {
				if (term1.query.equals(term2.query)) return 0;
	            int len = Math.min(rfinal, Math.min(term1.query.length(), term2.query.length()));
	            for (int i = 0; i < len; i++) {
	            	if (Character.toLowerCase(term1.query.charAt(i))
	            			< Character.toLowerCase(term2.query.charAt(i))) return -1;
        			if (Character.toLowerCase(term1.query.charAt(i))
        					> Character.toLowerCase(term2.query.charAt(i))) return +1;
	            }
	            return 0;
	            /**
	             * By the strict definition of "lexicographic", this should produce the correct output:
	             *
 	             *for (int i = 0; i < len; i++) {
	             *	if (term1.query.charAt(i)
	             *			< term2.query.charAt(i)) return -1;
        		 *	if (term1.query.charAt(i)
        		 *			> term2.query.charAt(i)) return +1;
	             *}
	             *return term1.query.length() - term2.query.length();
	             */
			}
    	}
    	return new PrefixComparator();

    }
    
    /**
     * comparator that arranges Terms in the reverse order of their weight
     * @return comparator that arranges Terms in the reverse order of their weight
     */
    public static Comparator<Term> byReverseWeightOrder(){
    	class ByReverseWeightOrderClass implements Comparator<Term>{
    		@Override
			public int compare(Term term1, Term term2) {
    			if (term1.weight > term2.weight) return -1;
    			if (term1.weight < term2.weight) return 1;
    			else return 0;
			}
    	}
    	return new ByReverseWeightOrderClass();
    }

    /**
     * Compare by query field (name of thing)
     * @return integer
     */
    @Override
    public int compareTo(Term that){
		return this.query.compareToIgnoreCase(that.query);
    }
    
	/**
	 * Returns a string representation of the term
	 * @return String representation
	 */
    public String toString(){
		return this.weight+"\t"+this.query;
    }

}
