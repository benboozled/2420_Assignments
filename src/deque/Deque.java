package dequeRandomQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdOut;
/**
 * 
 * @author Mark
 * Used to create a data structure known as Deque("Deck") that will be used to 
 *   add/remove from the front and the back of the list.
 * Created: 2/15/2015
 * Modified: 2/15/2015
 * Cited: Use of Code By Dr. Robert Sedgewick and Kevin Wayne
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> 
{
	private Node first;
	private Node last;
	private Node hold;
	private Item holdItem;
	private int count = 0;
/**
 * Sub-Class to create a "Node" this is the base of the Deque structure.
 * @author Mark
 * @param <Item> item
 * @param <Node> next
 * @param <Node> prior
 *
 */
	private class Node
	{
		private Item item;
		private Node next;
		private Node prior;
	}
/**
 * Constructor to create a Deque Element
 * @param <Node> first
 * @param <Node> last
 * @param <Node> hold
 * @param <Item> holdItem	
 */
	   public Deque()      // construct an empty deque
	   {
		   //should we make this doubly linked list not just linked list?
//		   first = new Node();
//		   last = first;
//		   first.prior = null;
	   }
	   /**
	    * Method used to determine if the Deque is empty
	    * @return <code>true or false </code>
	    */
	   public boolean isEmpty()      // is the deque empty?
	   {
		   return (first == null)?true:false;
	   }           
	   /**
	    * Method used to return the size of the list
	    * @return <code> element </code>
	    */
	   public int size() // return the number of items on the deque
	   {
		   return count;
	   }                 
	   /**
	    * The method used to add an <code> Item </code> to the front of the list
	    * @param item
	    */
	   public void addFirst(Item item)// insert the item at the front
	   {
		   if(isEmpty()){
			   first = new Node();
			   last = first;
			   first.prior = null;
			   first.item = item;
			   count++;
		   }
		   else{
			   hold = first;
			   hold.item = first.item;
			   first = new Node();
			   first.item = item;
			   first.next = hold;
			   hold.prior = first; // this will point to the new first that we created(this is the backwards pointer).
			   first.prior = null;
			   count++;
		   }
	   }          
	   /**
	    * The method used to add an <code> Item </code> to the end of the list
	    * @param item
	    */
	   public void addLast(Item item)// insert the item at the end
	   {
		   if(isEmpty()){addFirst(item);}
		   else{
			   hold = last;
			   hold.item = last.item;
			   last = new Node();
			   last.item = item;
			   hold.next = last;
			   last.prior = hold;//this will point to the element immediately prior to the current element
			   count++;
		   }
	   }           
	   /**
	    * The method used to remove the first element of the list and to reassign the first node
	    * @return <code> holdItem </code>
	    */
	   public Item removeFirst()// delete and return the item at the front
	   {
		   holdItem = first.item;
		   first = first.next;
		   first.prior = null;
		   if(count != 0)count--;
		   return holdItem;
	   }                
	   /**
	    * The method to  remove the last element in the list and re-assign the <code> last </code> Node
	    * @return <code> holdItem </code>
	    */
	   public Item removeLast()// delete and return the item at the end
	   {
		   holdItem = last.item;
		   last = last.prior;
		   if(count != 0)count--;
		   return holdItem;
	   }                 
	   /**
	    * The method used to iterate through a data structure
	    */
	   public Iterator<Item> iterator()// return an iterator over items in order from front to end
	   {
		   //call a static class that you can code the methods for the hasNext(), remove(throw exception instead of not including it), next()
		   return new linkedListIterator();
	   }
	   /**
	    * This is the subclass used to iterate through the Deque
	    * @author Mark
	    *
	    */
	   private class linkedListIterator implements Iterator<Item>{
		   private Node checkSpace = first;
		   
			@Override
			public boolean hasNext() {
				return checkSpace != null;
			}
	
			@Override
			public Item next() {
				if(!hasNext()){throw new NoSuchElementException();}
				Item item = checkSpace.item;
				checkSpace = checkSpace.next;
				return item;
			}
			
			@Override
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		}
	   /**
	    * Main Method used to test the Deque class to make sure it works properly
	    * @param args
	    */
	   public static void main(String[] args)
	   {
		   Deque<String> list = new Deque<>();
		   list.addFirst("Mark");
		   list.addLast("David");
		   list.addFirst("Tom");
		   list.addLast("Herro");
		   
		   for(String el: list){StdOut.printf("%s ",el);}
		   StdOut.println();
		   
		   StdOut.printf("this was removed from the first: %s\n",list.removeFirst());
		   StdOut.printf("this was removed from the last: %s\n",list.removeLast());
		   for(String el: list){StdOut.println(el);}
		   
		   list.removeFirst();
		   list.removeFirst();
		   
	   }   	   
}

