
public class TestHuffmanTree {
	public static void main(String args[]) {
		
		HuffmanTree huffman = new HuffmanTree("book.txt");
	
		System.out.println("*********** �󵵼� ǥ");
		huffman.printFrequency();
		
		huffman.buildHuffmanTree();
		
		System.out.println("*********** ������ �ڵ�");
		huffman.printHuffmanCode();
		
		System.out.println("*********** Encoding");
		huffman.encoding();
		
		System.out.println("*********** Decoding");
		huffman.decoding();
	}
}
