import java.util.Scanner;
public class InsertionSort {

	public static void main(String[] args) throws InvalidKeyException, EmptyPriorityQueueException {
		SortedListPriorityQueue<Integer, String> priorityqueuetest= new SortedListPriorityQueue<Integer, String>();
		
		Scanner input=new Scanner(System.in);
		
		System.out.print("��������������n=");
		int n=input.nextInt();
		System.out.println("������"+n+"�������������");
		
		int num;
		for (int i=0;i<n;i++){
			num=input.nextInt();
			priorityqueuetest.insert(num, ""); 
		}
		
		System.out.println("����ú����Ϊ��");
		for (int i=0;i<n;i++) System.out.println(priorityqueuetest.removeMin().getKey()+" "); 

	}
}
