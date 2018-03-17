
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 使用邻接矩阵实现图的操作
 * @author 金 洋
 *
 */
public class Graph {
	
	protected MGraph MG;
	protected int visitedNum;//记录已访问的节点个数
	protected boolean[] visited;
	
	public Graph(){
		
	}
	public Graph(int n,int m){
		MG=new MGraph(n,m);
		visited=new boolean[n];
		visitedNum=0;
	}
	
	/**
	 * 创建邻接矩阵
	 * @throws IOException
	 */
	public void creatAdjMatrix(int n,int m) throws IOException{
		Scanner input=new Scanner(System.in);
	
	
		System.out.println("请依次输入"+m+"条边的信息(端点i 端点j 权值Wij): ");
		
		int vi,vj;
		for (int i=0;i<m;i++){
			vi=input.nextInt();  
			vj=input.nextInt();
			MG.adjMatrix[vi][vj]=input.nextInt();
		}
		
	}
	
	/**
	 * 输出邻接矩阵
	 */
	public void dispAdjMatrix(){
		for (int i=0;i<MG.vexNum;i++){
			for (int j=0;j<MG.vexNum;j++) System.out.print(MG.adjMatrix[i][j]+" ");
			System.out.println();
		}
	}
	
	/**
	 * 连通图/非连通图的广度优先遍历
	 */
	public void bfsMGraph(){
		visitedNum=0;
		int i;
		
		Arrays.fill(visited, false);
		for (i=0;i<MG.getVexNum();i++)
			if (!visited[i]) bfsNonRecursive(i);
		
		
	}
	
		
	/**
	 * 连通子图的广度优先遍历
	 * 
	 * (1)初始化队列Q；
	 * (2)访问顶点v；visited[v]=1；顶点v入队列Q；
	 * (3)while（队列Q非空）   
 	 *			v=队列Q的对头元素出队；
	 *			w=顶点v的第一个邻接点；
	 *			while（w存在） 
 	 *				如果w未访问，则访问顶点w；
	 *				visited[w]=1；
	 *				顶点w入队列Q；
	 *				w=顶点v的下一个邻接点。
	 *
	 * @param i:从第i个顶点开始访问
	 */
	private void bfsNonRecursive(int i) {
		
		
		ArrayQueue<Integer> queue= new ArrayQueue<Integer>(MG.getVexNum());//初始化队列Q；
		
		visit(i);
		queue.enqueue(i);
		
		int v,w;
		while(!queue.isEmpty()){
			v=queue.dequeue();
			
			//找顶点v的第一个邻接点w
			w=nextFirstVex(v);
			//如果w存在
			while (w<MG.getVexNum()){
				if (!visited[w]) visit(w);
				queue.enqueue(w);
				w=nextFirstVex(w);
				
				
				
			}
			
			
		}
		
		
	}
	
	
	
	
	
	/**
	 * 连通图/非连通图的深度优先遍历
	 * @param type
	 * type为1进行递归dfs；
	 * type为2进行非递归dfs；
	 */
	public void dfsMGraph(int type) {
		int i;
		visitedNum=0;
		Arrays.fill(visited, false);
		for (i=0;i<MG.getVexNum();i++){
			if (!visited[i]) {
				if (type==1) dfsRecursive(i);
				else dfsNonRecursive(i);
				 
			}
		}
			
		
	}

	
	/**
	 * 连通子图的深度优先遍历(递归）
	 * @param i：节点i
	 */
	public void dfsRecursive(int i) {
		//将该点设为已访问
		
		visit(i);
		
		//探索与节点i未被访问过且直接相连的点
		for (int j=0;j<MG.getVexNum();j++){
			if ((!visited[j]) && (MG.adjMatrix[i][j]>0)) dfsRecursive(j);
		}
		
		
	}
	
	/**
	 * 连通子图的深度优先遍历(非递归）
	 * （1) 栈S初始化；visited[n]=0；
	 * （2）访问顶点v；visited[v]=1；顶点v入栈S
	 * （3）while(栈S非空)
     *        x=栈S的顶元素(不出栈)；
     *        if(存在并找到未被访问的x的邻接点w)
	 *				访问w；visited[w]=1；
	 *				w进栈;
     *        else       
	 *		  		x出栈；
	 *             
	 * @param i
	 */
	public void dfsNonRecursive(int i){
		ArrayStack<Integer> stack= new ArrayStack<Integer>(MG.getVexNum());
		
		visit(i);
		stack.push(i);
		
		while (!stack.isEmpty()){
			int x=stack.top();
			int w;
			for (w=0;w<MG.getVexNum();w++)
				if ((!visited[w]) && (MG.adjMatrix[x][w]>0)){
					visit(w);
					stack.push(w);
					break;
				}
			
			if (w==MG.getVexNum() ) stack.pop();
		
		}
		
		
	}
	
	
	
	public void visit(int i){
		visited[i]=true;
		visitedNum++;
		if(visitedNum!= MG.getVexNum())
			System.out.print(""+i+" -> ");
		else System.out.println(""+i);
	}
	
	/**
	 * 寻找节点x的第一个未被访问的邻接点
	 * @param x
	 * @return 找到的第一个邻接点
	 */
	public int nextFirstVex(int x){
		int w;
		for (w=0;w<MG.getVexNum();w++)
			if ((!visited[w]) && (MG.adjMatrix[x][w]>0)) break;
		
		return w;
	}
	
	

	
}
