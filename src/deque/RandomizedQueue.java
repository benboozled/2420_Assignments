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
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
	private int N;  
	//TODO: Node has to be of type <Item>, can't be a raw type as we have it here.
	private Node<Item> first;
	private Node<Item> last;
//	private Node hold;
//	private Item holdItem;

	@SuppressWarnings("hiding")
	private class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
    /**
     * Initializes an empty queue.
     */
	 public RandomizedQueue() {
	        first = null;
	        last  = null;
	        N = 0;
	 }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
	public boolean isEmpty() {
        return first == null;
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
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++; 										//add the item to the last available element if none are available resize the array
	 }
	 
    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
	public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
	 }

	/**
	 * Make it so. 
	 * @return Item
	 */
	 public Item sample()                    	
	 {
		Item rand = null;
		 //TODO: return (but do not delete) a random item		
		return rand;
	 }
	 
    /**
     * Returns an iterator that iterates over the items in this queue
     * @return an iterator that iterates over the items in this queue
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first.item);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

		public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
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

/**
 *
 *  Copyright 2002-2012, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4-package.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4-package.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4-package.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.

 *  You should have received a copy of the GNU General Public License
 *  along with algs4-package.jar.  If not, see http://www.gnu.org/licenses.
 */


