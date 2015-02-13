package deque;

import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> 
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
	
	   public Deque()      // construct an empty deque
	   {
		   first = new Node();
		   last = first;
	   }                     
	   public boolean isEmpty()      // is the deque empty?
	   {
		   return (first == null)?true:false;
	   }           
	   public int size() // return the number of items on the deque
	   {
		   int elements = 0;
		   //call iterator to go through each element in the list and add one to the size
		   return elements;
	   }                       
	   public void addFirst(Item item)// insert the item at the front
	   {
		   hold = first;
		   first = new Node();
		   first.next = hold;		   
	   }          
	   public void addLast(Item item)// insert the item at the end
	   {
		   hold = last;
		   last = new Node();
		   hold.next = last;
	   }           
	   public Item removeFirst()// delete and return the item at the front
	   {
		   holdItem = first.item;
		   first = first.next;
		   return holdItem;
	   }                
	   public Item removeLast()// delete and return the item at the end
	   {
		   holdItem = last.item;
		   //reset last to second to last item in list
		   return holdItem;
	   }                 
	   public Iterator<Item> iterator()// return an iterator over items in order from front to end
	   {
		   //call a static class that you can code the methods for the hasNext(), remove(throw exception instead of not including it), next()
		   return ;
	   }
	   public static void main(String[] args)
	   {
		   
	   }   
