
package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
	private Node first;
	private Node last;
	private Node hold;
	private Item holdItem;

	private class Node
	{
		private Item item;
		private Node next;
	}
	
	 public RandomizedQueue()                 	// construct an empty randomized queue
	 {
		 
	 }
	 public boolean isEmpty()                 	// is the queue empty?
	 {
		 										//iterate Through the queue to find if all are null
		 return false;
	 }
	 public int size()                        	// return the number of items on the queue
	 {
		 										//count how many elements have anything other than null
	   return 0;
	 }
	 public void enqueue(Item item)           	// add the item
	 {
		 										//add the item to the last available element if none are available resize the array
		 										//return;
	 }
	 public Item dequeue()                   	 // delete and return a random item
	 {
												 //save the item to a holder variable
												 // set element to null and return holder value
		 return null;
	 }
	 public Item sample()                    	 // return (but do not delete) a random item
	 {
		 										//return the element that you are currently wanting to view
	   return null;
	 }
	 public Iterator<Item> iterator()        	 // return an independent iterator over items in random order
	 {
		  return new IterateThrough();
	 }
	 private class IterateThrough implements Iterator<Item>{
		 private Node current = first;
		   
		@Override
		public boolean hasNext() {
			return current != null;
		}
	
		@Override
		public Item next() {
			if(!hasNext()){throw new NoSuchElementException();}
			Item item = current.item;
			current = current.next;
			return item;
		}
			
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	 }
	 
	 public static void main(String[] args)   // unit testing
	 {
		 
	 }
}

