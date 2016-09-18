public class SelectionTree {
	public static void main(String args[]) {

		int set[][] = new int[][] { { 1, 9, 11, 19, 21, 31, 41, 51, 61, 71 },
				{ 7, 17, 27, 37, 47, 50, 57, 60, 67, 77 },
				{ 2, 12, 22, 29, 32, 39, 42, 52, 62, 72 },
				{ 4, 14, 24, 34, 44, 54, 64, 69, 74, 79 },
				{ 8, 18, 28, 38, 48, 58, 68, 70, 78, 80 },
				{ 5, 10, 15, 20, 25, 35, 45, 55, 65, 75 },
				{ 3, 13, 23, 33, 43, 49, 53, 59, 63, 73 },
				{ 6, 16, 26, 30, 36, 40, 46, 56, 66, 76 } };

		Data[] tree = new Data[16];
		int[] count = new int[16];

		for (int i = tree.length / 2; i < tree.length; i++)
			tree[i] = new Data(set[i - 8][0], -1);

		while (true) {
			for (int i = tree.length / 2 - 1; i >= 1; i--) {
				if (tree[i * 2].element < tree[i * 2 + 1].element)
					tree[i] = new Data(tree[i * 2].element, i * 2);
				else
					tree[i] = new Data(tree[i * 2 + 1].element, i * 2 + 1);
			}

			if (tree[1].element == Integer.MAX_VALUE)
				break;
			else
				System.out.print(tree[1].element + " ");

			for (int index = 1; index != -1; index = tree[index].child) {
				if (tree[index].child == -1)
					if (count[index] < 9)
						tree[index].element = set[index - 8][++count[index]];
					else
						tree[index].element = Integer.MAX_VALUE;
			}
		}
	}
}
