import java.io.IOException;
import java.util.Scanner;


public class TestGraph {

	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("�������������ڽӾ���");
		System.out.println("�����붥����");
		int n=input.nextInt();
		System.out.println("�������������");
		int m=input.nextInt();
		Graph G=new Graph(n,m);
		
		System.out.println();
		G.creatAdjMatrix(n,m);
		System.out.println("�ڽӾ���������ʾ��");
		G.dispAdjMatrix();
		
		System.out.println("������ȱ���������ݹ飩��");
		G.dfsMGraph(1);

		System.out.println("������ȱ���������ǵݹ飩��");
		G.dfsMGraph(2);
		
		System.out.println("������ȱ���������ǵݹ飩��");
		G.bfsMGraph();
		
	}

}
