/**
 * 
 * @author Greg Hiatt
 * @author David Weber
 * Date Created: 2/22/2015
 * Date Modified: 3/7/2015
 * Date Due: 3/7/2015
 * 
 * This class uses a modified binary search in order to find the first index or 
 * the last index using a specific key.
 * 
 * Sources:
 * http://algs4.cs.princeton.edu/11model/BinarySearch.java.html
 * by Robert Sedgewick and Kevin Wayne.
 * 
 */

package autocomplete;

import java.util.Comparator;

public class BinarySearchDeluxe {
	
	
	/**
	 * Return the index of the first key in a[] that equals the search key, or -1 if no such key.
	 * @param a an array of keys.
	 * @param key key to be searched for.
	 * @param comparator comparator used to sort array.
	 * @return
	 */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	if(a == null || key == null || comparator == null) throw new NullPointerException();
    	int lo = 0;
    	int hi = a.length - 1;
    	if(comparator.compare(key, a[lo])== 0) return lo;
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
     * @param a an array of keys.
     * @param key key used to search for in the array.
     * @param comparator comparator used to sort keys in array.
     * @return
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	if(a == null || key == null || comparator == null) throw new NullPointerException();
    	
    	int lo = 0;
    	int hi = a.length - 1;
    	if(comparator.compare(key, a[hi])== 0 ) return hi;
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