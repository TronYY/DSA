
import java.util.Arrays;
import java.util.Scanner;
public class TestQuickSort {

	public static void main(String[] args) {
		
		int n;
		Scanner input=new Scanner(System.in);
		System.out.println("������������г���");
		n=input.nextInt();
		QuickSort QS=new QuickSort(n);
		System.out.println("�������������");
		
		for (int i=0;i<n;i++){
			QS.a[i]=input.nextInt();
		}
		QS.qs(0, n-1);
		
		System.out.print("���������У����򣩣�");
		System.out.println(Arrays.toString(QS.a));
		
		
		
		

	}

}
