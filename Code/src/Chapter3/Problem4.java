import java.io.*;
import java.util.Scanner;
public class Problem4 {
	public static void main(String[] args) {
		
		
		DList<Character> L;//对象L中的element 类型为char；
		//初始化
		System.out.println("(1)初始化双链表L");
		L=new DList<Character>();
		
		
		//插入元素
		System.out.println("(2)依次插入元素a,b,c,d,e");
		char ele='a';
		L.addFirst(ele);//header节点设为首节点，在header中存值
		int j=1;
		//继续插入 b,c,d,e
		do{
			j++;
			ele++;
			L.addBefore(j,ele);//依次在位置j前插入新节点v
		}while (j<5);
		System.out.println(L.toString("(3)输出双链表L："));
		
		
		//删除第i个节点
		System.out.println("(4)请输入删除节点的序号：");
		Scanner s=new Scanner(System.in);
		int NumRemove=s.nextInt();//NumRemove为输入的删除节点序号
		L.remove(NumRemove);
		System.out.println(L.toString("(5)输出删除节点"+NumRemove+"后的双链表L："));
		
		
		System.out.println("(6)释放双链表");	
		L.freeDList();
	}

}
