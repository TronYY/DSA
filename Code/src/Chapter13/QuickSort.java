
import java.util.Random;
/**
 * 
 * @author �� ��
 *
 */
public class QuickSort {
	protected int[] a;
	protected Random rand;//�������������
	
	public QuickSort(int n){
		a=new int[n];
		rand=new Random();
	}
	
	/**
	 * 
	 * @param left:����������ʼ�±�
	 * @param right:�������н����±�
	 */
	public void qs(int left,int right){
		int i,j,k,pivot;//iΪ����±꣬jΪ�Ҳ������±꣬pivotΪ��׼�㣬kΪ��׼���±�
		int tmp;
		k=rand.nextInt(right-left)+left;
		pivot=a[k];//�����׼��
		i=left;j=right;
		//����Ϊ����������ֱ��ң�pivotΪ��׼�㣬��С�ڻ�׼���Ԫ������pivot��࣬�������pivot�Ҳ�
		do{
			while (a[i]<pivot) i++;//����ʼѰ�Ҵ��ڻ�׼�����
			while (a[j]>pivot) j--;//����ʼѰ�Ҵ��ڻ�׼�����
			if (i<=j){
				tmp=a[j];a[j]=a[i];a[i]=tmp;
				i++;
				j--;
			}
			
		} while (i<=j);
		
		if (left<j) qs(left,j);
		if (i<right) qs(i,right);
	}
	


}
