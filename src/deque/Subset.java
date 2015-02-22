package deque;

import edu.princeton.cs.introcs.StdOut;

public class Subset {
	
	private int k;
	
	public Subset(int k){
		this.k = k;
	}
	
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
		
/*
		myRray.enqueue("one");
		StdOut.println("\nmyRray 1:");
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		myRray.enqueue("two");
		StdOut.println("\nmyRray 2:");
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		myRray.enqueue("three");
		StdOut.println("\nmyRray 3:");
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		myRray.enqueue("four");
		StdOut.println("\nmyRray 4:");
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		myRray.enqueue("five");
		StdOut.println("\nmyRray 5:");
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		myRray.enqueue("six");
		StdOut.println("\nmyRray 6:");
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		//////////////////////////////
		
		StdOut.print("\n\ndequeueing: ");
		StdOut.println(myRray.dequeue());
		for (String el : myRray){
			StdOut.print(el+", ");
		}

		StdOut.print("\n\ndequeueing: ");
		StdOut.println(myRray.dequeue());
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		StdOut.print("\n\ndequeueing: ");
		StdOut.println(myRray.dequeue());
		for (String el : myRray){
			StdOut.print(el+", ");
		}
		
		StdOut.print("\n\ndequeueing: ");
		StdOut.println(myRray.dequeue());
		for (String el : myRray){
			StdOut.print(el+", ");
		}
*/		
			
	}

}
