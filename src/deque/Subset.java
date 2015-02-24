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
			
	}

}
