package sysnets;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class WordNet {
	private Digraph graph;
	private SAP sap;
	private ST<Integer, String> dictionary = new ST<>();
	private ST<String, Integer> revDictionary = new ST<>();

	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) {
		if (synsets == null || hypernyms == null)
			throw new java.lang.NullPointerException();

		In inSyn = new In(synsets);
		int id = 0;
		while (inSyn.hasNextLine()) {
			String[] line = inSyn.readLine().split(",");
			String a = line[0];
			String b = line[1];
			String c = line[2];
			id = Integer.parseInt(a);
			dictionary.put(id, b);
			revDictionary.put(b, id);

		}
		graph = new Digraph(dictionary.size());

		In inNym = new In(hypernyms);
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
		if (!sap.isRootedDAG()) throw new java.lang.IllegalArgumentException();

	}

	// returns all WordNet nouns
	public Iterable<String> nouns() {
		if (revDictionary == null)
			throw new java.lang.NullPointerException();
		Queue<String> returnQueue = new Queue<>();

		for (String e : revDictionary) {
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
		if (!isNoun(nounA)||!isNoun(nounB)) throw new java.lang.IllegalArgumentException();
		int distance = sap.length(revDictionary.get(nounA), revDictionary.get(nounB));
		return distance;
	}

	// a synset (second field of synsets.txt) that is the common ancestor of
	// nounA and nounB
	// in a shortest ancestral path (defined below)
	public String sap(String nounA, String nounB) {
		if (nounA == null || nounB == null)
			throw new java.lang.NullPointerException();
		int vector = sap.ancestor(revDictionary.get(nounA), revDictionary.get(nounB));
		String ancestor = dictionary.get(vector);
		return ancestor;
	}

	public static void main(String[] args) throws InterruptedException {	
		WordNet net = new WordNet("src/sysnets/big_Synset.txt",
				"src/sysnets/big_Hypernyms.txt");
		StdOut.println(net.isNoun("subcompact subcompact_car"));
		
	}

}
