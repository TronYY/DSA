
public class TestArrayQueue {

	public static void main(String[] args) {
		System.out.println("(1)��ʼ������");
		ArrayQueue<Character> Q=new ArrayQueue<Character>(6);//��������Ϊ6��
		
		System.out.println("(2)�����Ƿ�Ϊ�գ�"+Q.isEmpty());
		
		System.out.println("(3)���ν�����Ԫ��a,b,c");
		Q.enqueue('a');
		Q.enqueue('b');
		Q.enqueue('c');
		
		System.out.println("(4)����һ��Ԫ�أ�"+Q.dequeue());
		
		System.out.println("(5)���е�Ԫ�ظ�����"+Q.size());
		
		System.out.println("(6)���ν�����Ԫ��d,e,f");
		Q.enqueue('d');
		Q.enqueue('e');
		Q.enqueue('f');
		
		System.out.println("(7)���е�Ԫ�ظ�����"+Q.size());
		
		System.out.print("(8)�������У�");
		while(!Q.isEmpty()) System.out.print(Q.dequeue());
		System.out.println();
		
	}

}
