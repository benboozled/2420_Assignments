package synsets;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;

public class WordNet {
	private Digraph graph;
	private SAP sap;
	private ST<Integer, String> dictionary = new ST<>();
	private ST<String, Bag<Integer>> revDictionary = new ST<>();//bag stores possible nodes for nouns

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		if (synsets == null || hypernyms == null)
			throw new java.lang.NullPointerException();
		
		In inSyn = new In(synsets);
		int id = 0;
		while (inSyn.hasNextLine()) {//import nouns
			String[] line = inSyn.readLine().split(",");
			String a = line[0];
			String[] nouns = line[1].split(" ");
			String c = line[2];
			id = Integer.parseInt(a);

			for (int i = 0; i != nouns.length; i++) {
				Bag<Integer> bag = new Bag<>();
				bag.add(id);
				revDictionary.put(nouns[i], bag);
				dictionary.put(id, nouns[i]);
			}

		}

		
		graph = new Digraph(dictionary.size());//build graph 

		In inNym = new In(hypernyms);//import hypernyms
		while (inNym.hasNextLine()) {
			String[] line = inNym.readLine().split(",");
			String a = line[0];
			String b = null;
			int VertB = 0;
			int VertA = 0;
			if (line.length > 1 && line[1] != null) {
				b = line[1];
				VertB = Integer.parseInt(b);
			}
			String c = null;
			if (line.length > 2 && line[2] != null) {
				c = line[2];
			}

			VertA = Integer.parseInt(a);

			graph.addEdge(VertA, VertB);
			if (c != null) {
				int VertC = Integer.parseInt(c);
				graph.addEdge(VertA, VertC);
				c = null;
			}

		}
		sap = new SAP(graph);
		// if (!sap.isRootedDAG()||!sap.isDAG()) throw new
		// java.lang.IllegalArgumentException(); //Sap is returning false on
		// these for some reason
	}

	// returns all WordNet nouns
	public Iterable<String> nouns() {
		if (revDictionary == null)
			throw new java.lang.NullPointerException();
		Queue<String> returnQueue = new Queue<>();

		for (String e : revDictionary.keys()) {
			returnQueue.enqueue(e);
		}
		return returnQueue;

	}

	// is the word a WordNet noun?
	public boolean isNoun(String word) {
		if (word == null)
			throw new java.lang.NullPointerException();
		return (revDictionary.contains(word));
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB) {
		if (nounA == null || nounB == null)
			throw new java.lang.NullPointerException();
		if (!isNoun(nounA) || !isNoun(nounB))
			throw new java.lang.IllegalArgumentException(
					"One of these is not in the dictionary:" + nounA + " "
							+ nounB);
		Bag<Integer> bagA = revDictionary.get(nounA);
		Bag<Integer> bagB = revDictionary.get(nounB);
		SAPTest.trace(bagA, "bagA");
		SAPTest.trace(bagB, "bagB");
		int distance = sap.length(bagA, bagB);
		return distance;
	}

	// a synset (second field of synsets.txt) that is the common ancestor of
	// nounA and nounB
	// in a shortest ancestral path (defined below)
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
//		WordNet net = new WordNet("/wordnetTests/big_synset.txt", "/wordnetTests/big_hypernyms.txt");
//		//WordNet net = new WordNet("/wordnetTests/synsets15.txt", "/wordnetTests/hypernyms100-subgraph.txt");
//		StdOut.println("Here is all the nouns: " + net.nouns());
//		StdOut.println("is it a noun? " + net.isNoun("a"));
//		StdOut.println("SAP test: " + net.sap("c", "f"));
//		StdOut.println("Distance test : " + net.distance("c", "f"));

	}

}