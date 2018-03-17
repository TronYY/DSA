/**
 * 
 * @author 金 洋
 *
 */
public class MergeSort {
	protected int[] a;
	/**
	 * 
	 * @param start
	 * 待合并序列起点
	 * @param end
	 * 待合并序列终点
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
	 * 第一个待合并序列的起点
	 * 
	 * @param start2
	 * 第二个待合并序列的起点
	 * 
	 * @param end
	 * 待合并序列终点
	 * 
	 */
	public void merge(int start1,int start2,int end){
		
		int tmp[]=new int[end-start1+1];//临时数组
		
		int i,j,t;//i为第一个待合并序列的下标，j为第二个待合并序列的下标，t为合并后的序列下标
		i=start1;j=start2;t=0;
		//两个序列都未排完
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
		
		//第一个序列未排完
		while (i<start2){
			tmp[t]=a[i];
			t++;
			i++;
		}
		
		//第二个序列未排完
		while (j<=end){
			tmp[t]=a[j];
			t++;
			j++;
		}
		
		//将临时数组的内容复制到a中
		//对于方法 arraycopy可以用来实现数组之间的复制：void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) src:源数组； srcPos:源数组要复制的起始位置； dest:目的数组； destPos:目的数组放置的起始位置； length:复制的长度
		System.arraycopy(tmp,0,a,start1,tmp.length);
		
	}

	
}
