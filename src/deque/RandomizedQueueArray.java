/**
 * @author David Weber
 * @author Mark Richardson  
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * 
 * @Date created: 2/11/2014 - David Weber
 * @Date last modified: 2/21/2014 - David Weber 
 * CSIS 2420 - SPR 2014
 * 
 * Code available on GitHub here:
 * https://github.com/davidlweber/2420_Assignments/tree/master/src/deque
 */
package deque;

import java.util.Iterator;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueueArray<Item> implements Iterable<Item> 
{

	@SuppressWarnings("unchecked")
	private Item[] rray = (Item[]) new Object[1]; // stack items
	private int N = 0; // number of items
	
	public boolean isEmpty() 	{ return N == 0; }
	public int size() 			{ return N; }
	
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

		if (N == rray.length) 	resize(2*rray.length);
		rray[N++] = item;
		int rand = StdRandom.uniform(N);
		Item t = rray[rand];
		rray[rand] = rray[N-1];
		rray[N-1] = t;

	}
	 
    /**
     * Removes and returns the item on this queue.
     * @return random item
     * @throws java.util.NoSuchElementException if this queue is empty
     */
	public Item dequeue() {
		
		Item item = rray[--N];
		rray[N] = null;
		if (N > 0 && N == rray.length/4) resize(rray.length/2);
		return item;
		
	}

	/**
	 * returns an item without deleting. 
	 * @return Item
	 */
	public Item sample(){
		return rray[StdRandom.uniform(N)];
	}
	 
    /**
     * Returns an iterator that iterates over the items in this queue
     * @return an iterator that iterates over the items in this queue
     */
	public Iterator<Item> iterator(){ 
		return new ReverseArrayIterator(); 
	}
	 
	private class ReverseArrayIterator implements Iterator<Item>{ 
		 private int i = N;
		 public boolean hasNext() { return i > 0; }
		 public Item next() { return rray[--i]; }
		 public void remove() { }
	}
     
    /**
     * Unit tests
     */
    public static void main(String[] args) {
    	
		String[] test = {"A","B","C","D","E","F","G"};
		RandomizedQueueArray<String> myRray = new RandomizedQueueArray<String>();
		for (String el: test) myRray.enqueue(el);
		
		StdOut.print("subset: \n");
		for (int i = 0; i<3; i++){
			 StdOut.println(myRray.dequeue());
		}
		
		StdOut.print("test array: \n");
		for (String el : myRray){
			StdOut.print(el+", ");
		}	
    }

}

/*************************************************************************
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
 *************************************************************************/
