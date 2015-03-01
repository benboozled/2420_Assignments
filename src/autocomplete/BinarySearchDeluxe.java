package autocomplete;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.introcs.StdOut;

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
              else if(key == a[mid] && key == a[mid-1]) hi = mid - 1;
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
	      while (lo <= hi) {
	          // Key is in a[lo..hi] or not present.
	          int mid = lo + (hi - lo) / 2;
	          if      (comparator.compare(key, a[mid]) <= -1) hi = mid - 1;
	          else if (comparator.compare(key, a[mid]) >= 1) lo = mid + 1;
	          else if(key == a[mid] && key == a[mid+1]) lo = mid + 1;
	          else return mid;
	          
	      	}
	    	
	    	return -1;
	    	
	    }

	
	public static void main(String[] args) {
		
    	String[] keys = {"Ai","Bi","Ci","Di","Ei","Fi","Hi","Hi","Hi","Hi","Hi","Hm","Ii",};
    	Arrays.sort(keys);
    	StdOut.println(lastIndexOf(keys, "Hi", String.CASE_INSENSITIVE_ORDER));
		
	}

}
