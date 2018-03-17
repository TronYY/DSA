
import java.util.Random;
/**
 * 
 * @author 金 洋
 *
 */
public class QuickSort {
	protected int[] a;
	protected Random rand;//用于生成随机数
	
	public QuickSort(int n){
		a=new int[n];
		rand=new Random();
	}
	
	/**
	 * 
	 * @param left:待排序列起始下标
	 * @param right:待排序列结束下标
	 */
	public void qs(int left,int right){
		int i,j,k,pivot;//i为左侧下标，j为右侧序列下标，pivot为基准点，k为基准点下标
		int tmp;
		k=rand.nextInt(right-left)+left;
		pivot=a[k];//随机基准点
		i=left;j=right;
		//方法为从左右两侧分别找，pivot为基准点，将小于基准点的元素置于pivot左侧，大的置于pivot右侧
		do{
			while (a[i]<pivot) i++;//从左开始寻找大于基准点的数
			while (a[j]>pivot) j--;//从左开始寻找大于基准点的数
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
