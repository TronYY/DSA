
import java.util.Arrays;
import java.util.Scanner;
public class TestMergeSort {

	public static void main(String[] args) {
		
		int n;
		Scanner input=new Scanner(System.in);
		System.out.println("������������г���");
		n=input.nextInt();
		MergeSort MS=new MergeSort(n);
		System.out.println("�������������");
		
		for (int i=0;i<n;i++){
			MS.a[i]=input.nextInt();
		}
		MS.sort(0, n-1);
		
		System.out.print("���������У����򣩣�");
		System.out.println(Arrays.toString(MS.a));
		
		
		
		

	}

}
