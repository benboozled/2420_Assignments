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

import java.util.Iterator;

public class RandomizedQueueArray<Item> implements Iterable<Item> 
{
	private int N;  
	private Item[] rray;
	
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }
	
	@SuppressWarnings("unchecked")
	private void resize(int max)
	{ // Move stack to a new array of size max.
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
		temp[i] = rray[i];
		rray = temp;
	}
	
    /**
     * Initializes an empty queue.
     */
	public RandomizedQueueArray() {
		
	}
	 
    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
	public void enqueue(Item item) {
		if (N == rray.length) resize(2*rray.length);
		rray[N++] = item;
	}
	 
    /**
     * Removes and returns the item on this queue.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
	public Item dequeue() {
		Item item = rray[--N];
		rray[N] = null; // Avoid loitering (see text).
		if (N > 0 && N == rray.length/4) resize(rray.length/2);
		return item;
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
	 public Iterator<Item> iterator()
	 { return new ReverseArrayIterator(); }
	 
	 private class ReverseArrayIterator implements Iterator<Item>
	 { 
		 private int i = N;
		 public boolean hasNext() { return i > 0; }
		 public Item next() { return rray[--i]; }
		 public void remove() { }
	 }
   
    
    /**
     * Unit tests
     */
    public static void main(String[] args) {
    	//TODO
    }


}
