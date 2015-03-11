/**********************************************************************
 *  readme.txt template                                                   
 *  Autocomplete
 **********************************************************************/

Name: David Weber
Partner name: Greg Hiatt

/**********************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 **********************************************************************/

It performs a binary search of the Key array searching for the first 
identical key value that is preceded by a non-matching key value. Does not
use a recursive loop.  
 
/**********************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms N and the
 *  number of matching terms M?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower order terms, e.g., M^2 + M log N.
 **********************************************************************/

constructor: N log N

allMatches(): M log M

numberOfMatches(): 1


/**********************************************************************
 *  Known bugs / limitations.
 **********************************************************************/

 - Does not print special, non-English characters (possibly an issue with my computer's fonts).
 - Term.byPrefixOrder might not meet strict definition of "lexicographic order" according to 
	http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#compareTo%28java.lang.String%29
 - Test client provided by assignment description throws indexOutOfBounds exception when 
	calling for arguments through the Main method args array. We have substituted hard-coded
	values for file and k for testing purposes under the assumption that this client is 
	not part of the API, just an example of a possible client. 

/**********************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 **********************************************************************/

 - Greg Hiatt (of course). 
 - if/then logic in Terms.byPrefixOrder is modified from Sedgewicks's "SuffixArray" class.
 - Melissa Weber provided some explanation of Sedgewick's mergesort code. 

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

 - A considerable amount of time went toward Term.byPrefixOrder.
 
/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
 
 Greg and I worked together better than any other partner I have had for an assignment
 yet. Whenever either of us hit a problem we were having difficulty with, the other 
 was able to solve it, or we fixed it collaboratively. Everything went smoothly and we
 had a working solution a week before the due date. I'd definitely work with Greg again 
 if it were an option. 