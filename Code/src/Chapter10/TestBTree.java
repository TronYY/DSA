
public class TestBTree {
	public static void main(String[] args) {
		BTree<Character> tree = new BTree<Character>(3);
		System.out.println(tree);
		Character[] cL = { 'D', 'E', 'F', 'A', 'C', 'B', 'Z', 'H', 'I', 'J' };
		for (int i = 0; i < cL.length; i++) {
			tree.insertElem(cL[i]);
			System.out.println("After insert the: " + cL[i]);
			System.out.println(tree);
		}
	}
}
