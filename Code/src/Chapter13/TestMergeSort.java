
import java.util.Arrays;
import java.util.Scanner;
public class TestMergeSort {

	public static void main(String[] args) {
		
		int n;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入待排序列长度");
		n=input.nextInt();
		MergeSort MS=new MergeSort(n);
		System.out.println("请输入待排序列");
		
		for (int i=0;i<n;i++){
			MS.a[i]=input.nextInt();
		}
		MS.sort(0, n-1);
		
		System.out.print("排序完序列（升序）：");
		System.out.println(Arrays.toString(MS.a));
		
		
		
		

	}

}
