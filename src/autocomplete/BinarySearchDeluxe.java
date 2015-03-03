/**
 * @author David Weber
 * @author Greg Hiatt 
 * 
 * @Date created: 2/24/2014 - David Weber
 * @Date last modified: by Greg sometime 
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

public class BinarySearchDeluxe {


	/**
	 * Return the index of the first key in a[] that equals the search key, or -1 if no such key.
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	if(a == null || key == null || comparator == null) throw new NullPointerException();
    	
    	  int lo = 0;
          int hi = a.length - 1;
          if(key == a[lo]) return lo;
          while (lo <= hi) {
              // Key is in a[lo..hi] or not present.
              int mid = lo + (hi - lo) / 2;
              if      (comparator.compare(key, a[mid]) <= -1) hi = mid - 1;
              else if (comparator.compare(key, a[mid]) >= 1) lo = mid + 1;
              else if(comparator.compare(key, a[mid])== 0 && comparator.compare(key, a[mid-1])== 0) hi = mid - 1;
              else return mid;
            
          }
    	
    	return -1;
    }
    /**
     * Return the index of the last key in a[] that equals the search key, or -1 if no such key.
     * @param a
     * @param key
     * @param comparator
     * @return
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	if(a == null || key == null || comparator == null) throw new NullPointerException();
    	
  	  int lo = 0;
      int hi = a.length - 1;
      if(key == a[hi]) return hi;
      while (lo <= hi) {
          // Key is in a[lo..hi] or not present.
          int mid = lo + (hi - lo) / 2;
          if      (comparator.compare(key, a[mid]) <= -1) hi = mid - 1;
          else if (comparator.compare(key, a[mid]) >= 1) lo = mid + 1;
          else if(comparator.compare(key, a[mid])== 0 && comparator.compare(key, a[mid+1])==0) lo = mid + 1;
          else return mid;
        
      	}
    	
    	return -1;
    	
    }


}
