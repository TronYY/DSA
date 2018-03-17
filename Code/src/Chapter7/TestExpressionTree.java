import java.util.Scanner;

public class TestExpressionTree {
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		String str;
		System.out.println("请输入表达式：");
		str=input.nextLine();
		ExpressionTree tree = new ExpressionTree();
		
		tree.setNode(tree.creatTree(str, 0, str.length()-1));

		BTNode node = new BTNode(tree.getNode().getData(),tree.getNode().getLeft(),tree.getNode().getRight());
		System.out.println(tree.calculate(tree.node));
	}	
}