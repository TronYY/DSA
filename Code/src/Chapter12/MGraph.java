

/**
 * ͼ���ڽӾ���
 * @author �� ��
 * �涨����������Ϊ0,1,2,3,...
 * ����i�Ͷ���j֮�������ߵ�Ȩֵ��¼��adjMatrix[i][j]�У�adjMatrix[i][j]=0��ʾ�ޱ�����
 */
public class MGraph {
	int vexNum;//������
	int arcNum;//�������
	int[][] adjMatrix;//�ڽӾ���
	
	public MGraph(){
		this(20,40);//Ĭ�϶�����20������40
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
