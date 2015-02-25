/**
 * @author David Weber
 * @author Greg Hiatt 
 * 
 * @Date created: 2/24/2014 - David Weber
 * @Date last modified: 2/24/2014 - David Weber 
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

	
    // Initialize a term with the given query string and weight.
    public Term(String query, double weight){
    	if (query == null)	throw new java.lang.NullPointerException();
    	if (weight <= 0) 	throw new java.lang.IllegalArgumentException();
    	this.query = query;
    	this.weight = weight;
    }

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	return null;
    	//use BY_PREFIX_ORDER as template when finished. 
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
    	if (r < 0) 	throw new java.lang.IllegalArgumentException();

    	class ByPrefixOrderClass implements Comparator<Term>{
    		int prefx;
    		public ByPrefixOrderClass (int prefx){this.prefx = prefx;}
    		@Override
			public int compare(Term term1, Term term2) {
    			return	term1.query.substring(0, prefx-1).compareTo(term2.query.substring(0, prefx-1));
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
    	
    	Term nanook = new Term("Nanook of the North", 124.00);
    	Term repo = new Term("Repo Man", 70.00);
    	Term motels = new Term("200 Motels", 98.00);
    	Term normal = new Term("Normal People", 54.00);
    	Term noCountry = new Term("No Country for Old Men", 54.00);
    	Term[] terms = {nanook,repo,noCountry,motels,normal};
    	
    	StdOut.println("unsorted:");
    	for (Term el: terms) StdOut.println(el.toString());
    	
    	StdOut.println("\nsorted by comparator:");
    	Arrays.sort(terms, Term.byPrefixOrder(1));
    	for (Term el: terms) StdOut.println(el.toString());
    	
    	StdOut.println("\nsorted by compareTo:");
    	Arrays.sort(terms);
    	for (Term el: terms) StdOut.println(el.toString());
    	
    }

}
