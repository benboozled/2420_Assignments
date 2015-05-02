/**
 * @author Ben Anderl
 * @author David Weber
 * @Date Created Apr 19, 2015 
 * Last modified: May 2, 2015 
 */
package synsets;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Outcast {
	private WordNet net;
	private String outcast;

	/**
	 *  constructor takes a WordNet object
	 * @param wordnet
	 */
	public Outcast(WordNet wordnet) {
		this.net = wordnet;
	}

	/**
	 *  given an array of WordNet nouns, return an outcast
	 * @param nouns
	 * @return
	 */
	public String outcast(String[] nouns) {
		int max = 0;
		int noun = 0;
		for (int q = 0; q != nouns.length; q++) {
			int dist = 0;
			for (int r = 0; r != nouns.length; r++) {
				dist = dist + net.distance(nouns[q], nouns[r]);
				if (dist > max) {
					max = dist;
					noun = q;
				}
			}
			outcast = nouns[noun];
		}
		return outcast;
	}

	public static void main(String[] args) {
		WordNet wordnet = new WordNet(args[0], args[1]);
		Outcast outcast = new Outcast(wordnet);
		for (int t = 2; t < args.length; t++) {
			In in = new In(args[t]);
			String[] nouns = in.readAllStrings();
			StdOut.println(args[t] + ": " + outcast.outcast(nouns));
		}
	}

}
