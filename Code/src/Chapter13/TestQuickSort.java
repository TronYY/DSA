
import java.util.Arrays;
import java.util.Scanner;
public class TestQuickSort {

	public static void main(String[] args) {
		
		int n;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入待排序列长度");
		n=input.nextInt();
		QuickSort QS=new QuickSort(n);
		System.out.println("请输入待排序列");
		
		for (int i=0;i<n;i++){
			QS.a[i]=input.nextInt();
		}
		QS.qs(0, n-1);
		
		System.out.print("排序完序列（升序）：");
		System.out.println(Arrays.toString(QS.a));
		
		
		
		

	}

}
