/**
 * @author David Weber
 * @author Greg Hiatt 
 * 
 * @Date created: 2/24/2014 - David Weber
 * @Date last modified: 2/26/2014 - David Weber 
 * CSIS 2420 - SPR 2014
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
    	if (weight <= 0) 	throw new java.lang.IllegalArgumentException();
    	this.query = query;
    	this.weight = weight;
    }

    /**
	 *FOR TESTING PURPOSES! DELETE OR SUBSTITUTE BEFORE FINAL SUBMISSION
	 *TODO: delete this
     */
    public static Comparator<Term> byPrefixOrderPREFIX(int r){
    	if (r < 0) 	throw new java.lang.IllegalArgumentException();
    	final int rfinal = r;
    	class PrefixComparator implements Comparator<Term>{
			@Override
			public int compare(Term t1, Term t2) {
				//Prefix pre1 = new Prefix();
				
			return 0;
			}
    	}
    	return new PrefixComparator();
    }
    
    
    /**
	 *FOR TESTING PURPOSES! DELETE OR SUBSTITUTE BEFORE FINAL SUBMISSION
	 *TODO: delete this
     */
    public static Comparator<Term> byPrefixOrderARRAY(int r){
    	if (r < 0) 	throw new java.lang.IllegalArgumentException();
    	final int rfinal = r;
    	class PrefixComparator implements Comparator<Term>{
    		
			@Override
			public int compare(Term term1, Term term2) {
	            //if (term1.query.length() < rfinal) return -1; 	// optimization
				int shorter = Math.min(term1.query.length(), term2.query.length());
	            int len = Math.min(rfinal, shorter);
	            for (int i = 0; i < len; i++) {
	                if (term1.query.charAt(i) < term2.query.charAt(i)) return -1;
	                if (term1.query.charAt(i) > term2.query.charAt(i)) return +1;
	            }
	           return 0;
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
    			if (term1.weight > term2.weight) return 1;
    			if (term1.weight < term2.weight) return -1;
    			else return 0;
			}
    	}
    	return new ByReverseWeightOrderClass();
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
			public int compare(Term t1, Term t2) {
				String temp1 = t1.query.substring(0, rfinal-1);
				String temp2 = t2.query.substring(0, rfinal-1);
			return	temp1.compareToIgnoreCase(temp2);
				
			}
    	}
    	return new PrefixComparator();
    }

    // Compare the terms in lexicographic order by query.
    @Override
    public int compareTo(Term that){
		return this.query.compareToIgnoreCase(that.query);
    }
    
    /**
	 *FOR TESTING PURPOSES! DELETE OR SUBSTITUTE BEFORE FINAL SUBMISSION
	 *TODO: delete this
     */
    private static class Prefix implements Comparable<Prefix> {
        private final String text;
        private final int index;

        private Prefix(String text, int index) {
            this.text = text;
            this.index = index;
        }
        private int length() {
            return index;
        }
        private char charAt(int i) {
            return text.charAt(i);
        }

        public int compareTo(Prefix that) {
            if (this == that) return 0;  // optimization
            int N = Math.min(this.length(), that.length());
            for (int i = 0; i < N; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }

    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
		return this.weight+"\t"+this.query;
    }
    

}
