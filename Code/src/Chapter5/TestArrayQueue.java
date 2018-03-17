
public class TestArrayQueue {

	public static void main(String[] args) {
		System.out.println("(1)初始化队列");
		ArrayQueue<Character> Q=new ArrayQueue<Character>(6);//设置容量为6；
		
		System.out.println("(2)队列是否为空："+Q.isEmpty());
		
		System.out.println("(3)依次进队列元素a,b,c");
		Q.enqueue('a');
		Q.enqueue('b');
		Q.enqueue('c');
		
		System.out.println("(4)出队一个元素："+Q.dequeue());
		
		System.out.println("(5)队列的元素个数："+Q.size());
		
		System.out.println("(6)依次进队列元素d,e,f");
		Q.enqueue('d');
		Q.enqueue('e');
		Q.enqueue('f');
		
		System.out.println("(7)队列的元素个数："+Q.size());
		
		System.out.print("(8)出队序列：");
		while(!Q.isEmpty()) System.out.print(Q.dequeue());
		System.out.println();
		
	}

}
