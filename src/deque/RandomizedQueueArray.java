/**
 * @author David Weber and Mark Richardson  
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * 
 * @Date created: 2/11/2014 - David Weber
 * @Date last modified: 2/14/2014 - David Weber 
 * CSIS 2420 - SPR 2014
 * 
 * Code available on GitHub here:
 * https://github.com/davidlweber/2420_Assignments/tree/master/src/deque
 * 
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 * 
 */
package deque;

import java.util.ArrayList;
import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class RandomizedQueueArray<Item> implements Iterable<Item> 
{
	private int N;  
	private ArrayList<Item> rray = new ArrayList<Item>(32);
	
    /**
     * Initializes an empty queue.
     */
	 public RandomizedQueueArray() {

	 }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
	public boolean isEmpty() {
		//TODO
        return false;
    }

	/**
	 * Returns the number of items in this queue.
	 * @return the number of items in this queue
	 */
	public int size() {
		 return N;   
	 }
	 
    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
	public void enqueue(Item item) {
		//TODO							
	}
	 
    /**
     * Removes and returns the item on this queue.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
	public Item dequeue() {
		
		//TODO
		return null;
	 }

	/**
	 * Make it so. 
	 * @return Item
	 */
	 public Item sample()                    	
	 {
		//TODO
		return null;
	 }
	 
    /**
     * Returns an iterator that iterates over the items in this queue
     * @return an iterator that iterates over the items in this queue
     */
    public Iterator<Item> iterator()  {
    	//TODO
		return null;
       /* return new ListIterator<Item>(first);  //TODO: figure out what's going on here*/
    }

    // an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
 
    }   
    
    /**
     * Unit tests the <tt>Queue</tt> data type.
     */
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }


}
