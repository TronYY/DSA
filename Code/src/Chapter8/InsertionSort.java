import java.util.Scanner;
public class InsertionSort {

	public static void main(String[] args) throws InvalidKeyException, EmptyPriorityQueueException {
		SortedListPriorityQueue<Integer, String> priorityqueuetest= new SortedListPriorityQueue<Integer, String>();
		
		Scanner input=new Scanner(System.in);
		
		System.out.print("请输入整数个数n=");
		int n=input.nextInt();
		System.out.println("请输入"+n+"个待排序的整数");
		
		int num;
		for (int i=0;i<n;i++){
			num=input.nextInt();
			priorityqueuetest.insert(num, ""); 
		}
		
		System.out.println("排序好后的数为：");
		for (int i=0;i<n;i++) System.out.println(priorityqueuetest.removeMin().getKey()+" "); 

	}
}
