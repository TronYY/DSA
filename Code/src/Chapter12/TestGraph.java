import java.io.IOException;
import java.util.Scanner;


public class TestGraph {

	public static void main(String[] args) throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("创建有向网的邻接矩阵：");
		System.out.println("请输入顶点数");
		int n=input.nextInt();
		System.out.println("请输入有向边数");
		int m=input.nextInt();
		Graph G=new Graph(n,m);
		
		System.out.println();
		G.creatAdjMatrix(n,m);
		System.out.println("邻接矩阵如下所示：");
		G.dispAdjMatrix();
		
		System.out.println("深度优先遍历结果（递归）：");
		G.dfsMGraph(1);

		System.out.println("深度优先遍历结果（非递归）：");
		G.dfsMGraph(2);
		
		System.out.println("广度优先遍历结果（非递归）：");
		G.bfsMGraph();
		
	}

}
