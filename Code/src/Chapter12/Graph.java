
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * ʹ���ڽӾ���ʵ��ͼ�Ĳ���
 * @author �� ��
 *
 */
public class Graph {
	
	protected MGraph MG;
	protected int visitedNum;//��¼�ѷ��ʵĽڵ����
	protected boolean[] visited;
	
	public Graph(){
		
	}
	public Graph(int n,int m){
		MG=new MGraph(n,m);
		visited=new boolean[n];
		visitedNum=0;
	}
	
	/**
	 * �����ڽӾ���
	 * @throws IOException
	 */
	public void creatAdjMatrix(int n,int m) throws IOException{
		Scanner input=new Scanner(System.in);
	
	
		System.out.println("����������"+m+"���ߵ���Ϣ(�˵�i �˵�j ȨֵWij): ");
		
		int vi,vj;
		for (int i=0;i<m;i++){
			vi=input.nextInt();  
			vj=input.nextInt();
			MG.adjMatrix[vi][vj]=input.nextInt();
		}
		
	}
	
	/**
	 * ����ڽӾ���
	 */
	public void dispAdjMatrix(){
		for (int i=0;i<MG.vexNum;i++){
			for (int j=0;j<MG.vexNum;j++) System.out.print(MG.adjMatrix[i][j]+" ");
			System.out.println();
		}
	}
	
	/**
	 * ��ͨͼ/����ͨͼ�Ĺ�����ȱ���
	 */
	public void bfsMGraph(){
		visitedNum=0;
		int i;
		
		Arrays.fill(visited, false);
		for (i=0;i<MG.getVexNum();i++)
			if (!visited[i]) bfsNonRecursive(i);
		
		
	}
	
		
	/**
	 * ��ͨ��ͼ�Ĺ�����ȱ���
	 * 
	 * (1)��ʼ������Q��
	 * (2)���ʶ���v��visited[v]=1������v�����Q��
	 * (3)while������Q�ǿգ�   
 	 *			v=����Q�Ķ�ͷԪ�س��ӣ�
	 *			w=����v�ĵ�һ���ڽӵ㣻
	 *			while��w���ڣ� 
 	 *				���wδ���ʣ�����ʶ���w��
	 *				visited[w]=1��
	 *				����w�����Q��
	 *				w=����v����һ���ڽӵ㡣
	 *
	 * @param i:�ӵ�i�����㿪ʼ����
	 */
	private void bfsNonRecursive(int i) {
		
		
		ArrayQueue<Integer> queue= new ArrayQueue<Integer>(MG.getVexNum());//��ʼ������Q��
		
		visit(i);
		queue.enqueue(i);
		
		int v,w;
		while(!queue.isEmpty()){
			v=queue.dequeue();
			
			//�Ҷ���v�ĵ�һ���ڽӵ�w
			w=nextFirstVex(v);
			//���w����
			while (w<MG.getVexNum()){
				if (!visited[w]) visit(w);
				queue.enqueue(w);
				w=nextFirstVex(w);
				
				
				
			}
			
			
		}
		
		
	}
	
	
	
	
	
	/**
	 * ��ͨͼ/����ͨͼ��������ȱ���
	 * @param type
	 * typeΪ1���еݹ�dfs��
	 * typeΪ2���зǵݹ�dfs��
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
	 * ��ͨ��ͼ��������ȱ���(�ݹ飩
	 * @param i���ڵ�i
	 */
	public void dfsRecursive(int i) {
		//���õ���Ϊ�ѷ���
		
		visit(i);
		
		//̽����ڵ�iδ�����ʹ���ֱ�������ĵ�
		for (int j=0;j<MG.getVexNum();j++){
			if ((!visited[j]) && (MG.adjMatrix[i][j]>0)) dfsRecursive(j);
		}
		
		
	}
	
	/**
	 * ��ͨ��ͼ��������ȱ���(�ǵݹ飩
	 * ��1) ջS��ʼ����visited[n]=0��
	 * ��2�����ʶ���v��visited[v]=1������v��ջS
	 * ��3��while(ջS�ǿ�)
     *        x=ջS�Ķ�Ԫ��(����ջ)��
     *        if(���ڲ��ҵ�δ�����ʵ�x���ڽӵ�w)
	 *				����w��visited[w]=1��
	 *				w��ջ;
     *        else       
	 *		  		x��ջ��
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
	 * Ѱ�ҽڵ�x�ĵ�һ��δ�����ʵ��ڽӵ�
	 * @param x
	 * @return �ҵ��ĵ�һ���ڽӵ�
	 */
	public int nextFirstVex(int x){
		int w;
		for (w=0;w<MG.getVexNum();w++)
			if ((!visited[w]) && (MG.adjMatrix[x][w]>0)) break;
		
		return w;
	}
	
	

	
}
