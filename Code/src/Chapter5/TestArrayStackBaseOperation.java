
public class TestArrayStackBaseOperation {

	public static void main(String[] args) {
		System.out.println("(1)��ʼ��ջ");
		ArrayStack<Character> A=new ArrayStack<Character>(5);
		System.out.print("(2)ջΪ��");
		System.out.println(A.isEmpty()?"��":"�ǿ�");
		System.out.println("(3)���ν�ջԪ��a,b,c,d,e");
		A.push('a');
		A.push('b');
		A.push('c');
		A.push('d');
		A.push('e');
		System.out.print("(4)ջΪ��");
		System.out.println(A.isEmpty()?"��":"�ǿ�");
		
		System.out.println("(5)ջ����Ϊ��"+A.size());
		System.out.println("(6)ȡջ��Ԫ�أ�"+A.top());
		System.out.print("(7)��ջ����ջ�����Ԫ�أ�");
		int i=A.top;
		while (i!=-1){
			System.out.print(A.getStack(i));
			i--;
		}
		
		System.out.println();
		System.out.print("(8)��ջ˳����");
		while (!A.isEmpty()){
			System.out.print(A.pop());
		}
		System.out.println();
		System.out.print("(9)ջΪ��");
		System.out.println(A.isEmpty()?"��":"�ǿ�");
		
	}

}
