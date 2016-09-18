
public class TestHuffmanTree {
	public static void main(String args[]) {
		
		HuffmanTree huffman = new HuffmanTree("book.txt");
	
		System.out.println("*********** 빈도수 표");
		huffman.printFrequency();
		
		huffman.buildHuffmanTree();
		
		System.out.println("*********** 허프만 코드");
		huffman.printHuffmanCode();
		
		System.out.println("*********** Encoding");
		huffman.encoding();
		
		System.out.println("*********** Decoding");
		huffman.decoding();
	}
}
