/**
 * @author Ben Anderl
 * @author David Weber
 * @Date Created Apr 19, 2015 
 * Last modified: May 2, 2015 
 */
package synsets;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class WordNet {
	private Digraph graph;
	private SAP sap;
	private ST<Integer, String> dictionary = new ST<>();
	private ST<String, Bag<Integer>> revDictionary = new ST<>();

	/**
	 *  constructor takes the name of the two input files
	 * @param synsets
	 * @param hypernyms
	 */
	public WordNet(String synsets, String hypernyms) {
		if (synsets == null || hypernyms == null)
			throw new java.lang.NullPointerException();
		
		In inSyn = new In(synsets);
		int id = 0;
		while (inSyn.hasNextLine()) {
			String[] line = inSyn.readLine().split(",");
			String a = line[0];
			String[] nouns = line[1].split(" "); 
			id = Integer.parseInt(a);
			
			for (int i = 0; i != nouns.length; i++) {
				if (!revDictionary.contains(nouns[i])){
					Bag<Integer> bag = new Bag<>();	
					bag.add(id);
					revDictionary.put(nouns[i], bag);
				}
				dictionary.put(id, nouns[i]);
			}
		}
		
		graph = new Digraph(dictionary.size());

		In inNym = new In(hypernyms);
		id=0;
		while (inNym.hasNextLine()) {
			String[] line = inNym.readLine().split(","); 
			int root = 0;
			int connection = 0;
			for (int i = 1; i != line.length; i++) {
				root=Integer.parseInt(line[0]);
				connection = Integer.parseInt(line[i]);
				graph.addEdge(root,connection );
			}
		}
		sap = new SAP(graph);
	}

		

	/**
	 *  returns all WordNet nouns
	 * @return
	 */
	public Iterable<String> nouns() {
		if (revDictionary == null)
			throw new java.lang.NullPointerException();
		Queue<String> returnQueue = new Queue<>();
		
		for (String e : revDictionary.keys()) {
			returnQueue.enqueue(e);
		}
		return returnQueue;
	}

	/**
	 *  is the word a WordNet noun?
	 * @param word
	 * @return
	 */
	public boolean isNoun(String word) {
		if (word == null)
			throw new java.lang.NullPointerException();
		return (revDictionary.contains(word));
	}

	/**
	 *  distance between nounA and nounB (defined below)
	 * @param nounA
	 * @param nounB
	 * @return
	 */
	public int distance(String nounA, String nounB) {
		if (nounA == null || nounB == null)
			throw new java.lang.NullPointerException();
		if (!isNoun(nounA) || !isNoun(nounB))
			throw new java.lang.IllegalArgumentException(
					"One of these is not in the dictionary:" + nounA + " "
							+ nounB);
		Bag<Integer> bagA = revDictionary.get(nounA);
		Bag<Integer> bagB = revDictionary.get(nounB);
		int distance = sap.length(bagA, bagB);
		return distance;
	}

	/**
	 *  a synset (second field of synsets.txt) that is the common ancestor of
	 *  in a shortest ancestral path
	 * @param nounA
	 * @param nounB
	 * @return
	 */
	public String sap(String nounA, String nounB) {
		if (nounA == null || nounB == null)
			throw new java.lang.NullPointerException();
		Bag<Integer> bagA = revDictionary.get(nounA);
		Bag<Integer> bagB = revDictionary.get(nounB);
		int vector = sap.ancestor(bagA, bagB);
		String ancestor = dictionary.get(vector);
		return ancestor;
	}

	public static void main(String[] args) throws InterruptedException {
		WordNet net = new WordNet("/wordnetTests/synset.txt", "/wordnetTests/hypernyms.txt");
		StdOut.println("Here is all the nouns: " + net.nouns());
		StdOut.println("is it a noun? " + net.isNoun("a"));
		StdOut.println("SAP test: " + net.sap("Black_Plague", "black_marlin"));
		StdOut.println("Distance test : " + net.distance("Black_Plague", "black_marlin"));
	}

}