package deque;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class Subset {
	
	private int k;
	private static RandomizedQueueArray<String> rray;
	
	public Subset(int k){
		this.k = k;
	}
	
	public static void main(String[] args) {
		
//		RandomizedQueueArray<String> test = null;
//		test.enqueue("args");

		for (int i = 0; i < args.length; i++){
			String str = StdIn.readString();
			rray.enqueue(str);
		}
		StdOut.println(rray.dequeue());
		
	}

}
