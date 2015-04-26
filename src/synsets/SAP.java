package synsets;

import java.util.Set;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.introcs.StdOut;

public class SAP {

	//TODO: deprecate topo;
	private Topological topo;
	private final Digraph digraph;
    
	/**
	 *  constructor takes a digraph (not necessarily a DAG)
	 * @param digraph
	 */
	public SAP(Digraph graph){
		this.digraph = graph;
		topo = new Topological(graph);
	}
	
	/**
	 *  is the digraph a directed acyclic graph?
	 * @return
	 */
	public boolean isDAG(){
		return topo.order() !=null;
	}
	
	/**TODO:
	 *  is the digraph a rooted DAG?
	 * @return
	 */
	public boolean isRootedDAG(){
		return false;
	}
	
	/**TODO
	 *  length of shortest ancestral path between v and w; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int length(int v, int w){
		
		return w;
	}
	
	/**TODO
	 *  a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int ancestor(int v, int w){
	//public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
		int ancestor = -1;		
		@SuppressWarnings("unused")
		Graph graph = null;
		
		BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
		BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);

		Stack<Integer> stackV = new Stack<>();
		for (int i : bfsV.pathTo(0))	{stackV.push(i);}	
		Stack<Integer> stackW = new Stack<>();
		for (int i : bfsW.pathTo(0))	{stackW.push(i);}
		
		for (int i : stackV){
			if (stackV.peek() == stackW.peek()){
				ancestor = stackV.peek();
				stackV.pop(); 
				stackW.pop();
			}
		}
		
		StdOut.print("\nancestor: "+ancestor);
		StdOut.print("\n");	
		

		
//TODO: delete unused----------------------------------------
//		StdOut.print("\nstackV:\n");
//		StdOut.print(stackV.toString());
//		StdOut.print("\n");
//		StdOut.print("stackW:\n");
//		StdOut.print(stackW.toString());
//		StdOut.print("\n");	
//				if (stackV.peek() != null){
//					graph.addEdge(stackV.pop(), stackV.peek());
//				}
//		int vPeek = 0;
//		int wPeek = 0;
		//while (!stackV.isEmpty())
		//for (int i : stackW.pop())
//			vPeek = stackV.peek();
//			wPeek = stackW.peek();
//		Queue<Integer> queueW = new Queue<>();
//		for (int i : bfsW.pathTo(0))
//			if (stackV.peek() != i)
//				queueW.enqueue(stackV.pop());
		
//		for (int i : bfsW.pathTo(0))
//			stackW.push(i); wlength++;
		
//		Queue<Integer> queueV = new Queue<>();
//		for (int i : bfsV.pathTo(0)) 
//			queueV.enqueue(i);
//		StdOut.print("\nbfsV:\n");
//		for (int i : bfsV.pathTo(0)){
//			StdOut.print(i);
//			if (i != 0) StdOut.print(" > ");
//		}
//		StdOut.print("\nbfsW:\n");
//		for (int i : bfsW.pathTo(0)){
//			StdOut.print(i);
//			if (i != 0) StdOut.print(" > ");
//		}
//		StdOut.print("\nqueueV:\n");
//		StdOut.print(queueV.toString());																								
//		StdOut.print("\nqueueW:\n");
//		StdOut.print(queueW.toString());
																								

//end trace--------------------------------------------------
		return ancestor;
	}

	/**TODO
	 *  a common ancestor that participates in shortest ancestral path; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	//public int ancestor(int v, int w){
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
		
		return 0;
	}
	
	/**TODO
	 *  length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	 * @param v
	 * @param w
	 * @return
	 */
	public int length(Iterable<Integer> v, Iterable<Integer> w){
		
		return 0;
	}
	

	/**TODO
	 *  do unit testing of this class
	 * @param args
	 */
	public static void main(String[] args){
		
	}

//TODO: delete testing functions----------------------------------------
//	public Topological getTopo() {
//		return topo;
//	}
	
    public BreadthFirstDirectedPaths getBfs(int source) {
		BreadthFirstDirectedPaths bfs;
		return bfs = new BreadthFirstDirectedPaths(digraph, source);
	}
}
