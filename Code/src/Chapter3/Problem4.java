import java.io.*;
import java.util.Scanner;
public class Problem4 {
	public static void main(String[] args) {
		
		
		DList<Character> L;//����L�е�element ����Ϊchar��
		//��ʼ��
		System.out.println("(1)��ʼ��˫����L");
		L=new DList<Character>();
		
		
		//����Ԫ��
		System.out.println("(2)���β���Ԫ��a,b,c,d,e");
		char ele='a';
		L.addFirst(ele);//header�ڵ���Ϊ�׽ڵ㣬��header�д�ֵ
		int j=1;
		//�������� b,c,d,e
		do{
			j++;
			ele++;
			L.addBefore(j,ele);//������λ��jǰ�����½ڵ�v
		}while (j<5);
		System.out.println(L.toString("(3)���˫����L��"));
		
		
		//ɾ����i���ڵ�
		System.out.println("(4)������ɾ���ڵ����ţ�");
		Scanner s=new Scanner(System.in);
		int NumRemove=s.nextInt();//NumRemoveΪ�����ɾ���ڵ����
		L.remove(NumRemove);
		System.out.println(L.toString("(5)���ɾ���ڵ�"+NumRemove+"���˫����L��"));
		
		
		System.out.println("(6)�ͷ�˫����");	
		L.freeDList();
	}

}
