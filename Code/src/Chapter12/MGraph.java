

/**
 * 图的邻接矩阵
 * @author 金 洋
 * 规定各顶点依次为0,1,2,3,...
 * 顶点i和顶点j之间的有向边的权值记录在adjMatrix[i][j]中，adjMatrix[i][j]=0表示无边相连
 */
public class MGraph {
	int vexNum;//顶点数
	int arcNum;//有向边数
	int[][] adjMatrix;//邻接矩阵
	
	public MGraph(){
		this(20,40);//默认顶点数20，边数40
	}
	
	public MGraph(int n,int m){
		vexNum=n;
		arcNum=m;
		adjMatrix=new int[n][n];
		
	}
	
	public int getVexNum(){
		return vexNum;
	}
	
	public int getArcNum(){
		return arcNum;
	}
}
