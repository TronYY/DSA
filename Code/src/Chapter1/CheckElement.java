package Chapter1;
public class CheckElement {
	public static int[] a=new int[]{2,3,5,2,3,2,-6,98};//初始化数组
	public static int findCount(int[] a ,int k){//k为要找的值
		int count=0;//count记录k在数组中出现的次数
		for (int i=0;i<a.length;i++){
			if (a[i]==k) //依次检查每个元素是否等于k
				count++;
			
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.print("The elments in array a are:");
		int j;
		for (j=0;j<a.length;j++)
			System.out.print(a[j]+" ");//输出数组a中所有元素
		System.out.println();
		System.out.println("The element 2 appears "+findCount(a,2)+" times in a");
	}

}
