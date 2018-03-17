/**
 * 
 * @author �� ��
 *
 */
public class MergeSort {
	protected int[] a;
	/**
	 * 
	 * @param start
	 * ���ϲ��������
	 * @param end
	 * ���ϲ������յ�
	 */
	
	public MergeSort(int n){
		a=new int[n];
	}
	public void sort(int start,int end){
		int mid;
		if (start!=end){
			mid=(start+end)/2;
			sort(start,mid);
			sort(mid+1,end);
			merge(start,mid+1,end);
		}
	}
	
	/**
	 * 
	 * @param start1
	 * ��һ�����ϲ����е����
	 * 
	 * @param start2
	 * �ڶ������ϲ����е����
	 * 
	 * @param end
	 * ���ϲ������յ�
	 * 
	 */
	public void merge(int start1,int start2,int end){
		
		int tmp[]=new int[end-start1+1];//��ʱ����
		
		int i,j,t;//iΪ��һ�����ϲ����е��±꣬jΪ�ڶ������ϲ����е��±꣬tΪ�ϲ���������±�
		i=start1;j=start2;t=0;
		//�������ж�δ����
		while (i<start2 && j<=end){
			if (a[i]<=a[j]) {
				tmp[t]=a[i];
				t++;
				i++;
			}
			else {
				tmp[t]=a[j];
				t++;
				j++;
			}	
		}
		
		//��һ������δ����
		while (i<start2){
			tmp[t]=a[i];
			t++;
			i++;
		}
		
		//�ڶ�������δ����
		while (j<=end){
			tmp[t]=a[j];
			t++;
			j++;
		}
		
		//����ʱ��������ݸ��Ƶ�a��
		//���ڷ��� arraycopy��������ʵ������֮��ĸ��ƣ�void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) src:Դ���飻 srcPos:Դ����Ҫ���Ƶ���ʼλ�ã� dest:Ŀ�����飻 destPos:Ŀ��������õ���ʼλ�ã� length:���Ƶĳ���
		System.arraycopy(tmp,0,a,start1,tmp.length);
		
	}

	
}
