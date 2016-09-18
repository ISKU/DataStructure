import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class HuffmanTree {

	private DoubleHashTable freqTable = new DoubleHashTable();
	private DoubleHashTable huffmanCode = new DoubleHashTable();
	private StringBuilder encode = new StringBuilder();
	private StringBuilder decode = new StringBuilder();
	private PriorityQueue<Trecord> queue = new PriorityQueue<Trecord>();

	private final String FILENAME;
	private Trecord huffmanTree;

	public HuffmanTree(String file) {
		FILENAME = file;
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for (int i = 0; i < word.length(); i++)
						freqTable.put(word.charAt(i), 1);
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		addToQueue();
	}

	private void addToQueue() {
		DoubleHashTable.Entry[] array = freqTable.array();
		for (int i = 0; i < freqTable.size(); i++) {
			queue.add(new Trecord((char) array[i].key, (int) array[i].value));
		}
	}

	public void buildHuffmanTree() {
		while (queue.size() != 1) {
			Trecord tnode = new Trecord(queue.remove(), queue.remove());
			tnode.freq = tnode.left.freq + tnode.right.freq;
			queue.add(tnode);
		}

		huffmanTree = queue.peek();
		encode(huffmanTree, "");
	}

	private void encode(Trecord root, String code) {
		if (root.left == null || root.right == null) {
			huffmanCode.put(root.alphabet, code);
			return;
		}
		encode(root.left, code + "0");
		encode(root.right, code + "1");
	}

	public void encoding() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for (int i = 0; i < word.length(); i++)
						encode.append(huffmanCode.get(word.charAt(i)));
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		System.out.println(encode.toString() + "\n");
	}

	public void decoding() {
		Trecord huffman = this.huffmanTree;

		for (int i = 0; i < encode.length(); i++) {
			char bit = encode.toString().charAt(i);
			if (bit == '0')
				huffman = huffman.left;
			if (bit == '1')
				huffman = huffman.right;
			if (huffman.left == null || huffman.right == null) {
				decode.append(huffman.alphabet);
				huffman = this.huffmanTree;
			}
		}

		System.out.println(decode.toString() + "\n");
	}

	public void printFrequency() {
		freqTable.print();
	}

	public void printHuffmanCode() {
		huffmanCode.print();
	}

	private class Trecord implements Comparable<Trecord> {
		Trecord left;
		char alphabet;
		int freq;
		Trecord right;

		Trecord(Trecord left, Trecord right) {
			this.left = left;
			this.right = right;
		}

		Trecord(char alphabet, int freq) {
			this.alphabet = alphabet;
			this.freq = freq;
		}

		@Override
		public int compareTo(Trecord tnode) {
			if (this.freq < tnode.freq)
				return -1;
			else if (this.freq > tnode.freq)
				return 1;
			else
				return 0;
		}
	}
}
