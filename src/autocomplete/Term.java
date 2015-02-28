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

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.introcs.StdOut;


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

    	class ByPrefixOrderClass implements Comparator<Term>{
    		int prefx;
    		public ByPrefixOrderClass (int p){this.prefx = p;}
    		
    		@Override
			public int compare(Term term1, Term term2) {
				String temp1 = term1.query.substring(0, prefx);
				String temp2 = term2.query.substring(0, prefx);
				return	temp1.compareTo(temp2);
			}
    	}
    	return new ByPrefixOrderClass(r);
    }

    // Compare the terms in lexicographic order by query.
    @Override
    public int compareTo(Term that){
		return this.query.compareToIgnoreCase(that.query);
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
		return this.weight+"\t"+this.query;
    }
    
    public static void main(String[] args){
    	
    	int[] ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,18,18,18,18,18,18,18,18,18,19,20};
    	
    	
    	
    	/*
    	Term nanook = new Term("Nanook of the North", 124.00);
    	Term repo = new Term("Repo Man", 70.00);
    	Term motels = new Term("200 Motels", 98.00);
    	Term normal = new Term("Normal People", 54.00);
    	Term noCountry = new Term("No Country for Old Men", 54.00);
    	Term[] terms = {nanook,repo,noCountry,motels,normal};
    	
    	StdOut.println("unsorted:");
    	for (Term el: terms) StdOut.println(el.toString());
    	
    	StdOut.println("\nsorted by query comparator:");
    	Arrays.sort(terms, Term.byPrefixOrder(3));
    	for (Term el: terms) StdOut.println(el.toString());
    	
    	StdOut.println("\nsorted by rev weight comparator:");
    	Arrays.sort(terms, Term.byReverseWeightOrder());
    	for (Term el: terms) StdOut.println(el.toString());
*/
    	
    }

}
