
public class TestArrayStackBaseOperation {

	public static void main(String[] args) {
		System.out.println("(1)初始化栈");
		ArrayStack<Character> A=new ArrayStack<Character>(5);
		System.out.print("(2)栈为：");
		System.out.println(A.isEmpty()?"空":"非空");
		System.out.println("(3)依次进栈元素a,b,c,d,e");
		A.push('a');
		A.push('b');
		A.push('c');
		A.push('d');
		A.push('e');
		System.out.print("(4)栈为：");
		System.out.println(A.isEmpty()?"空":"非空");
		
		System.out.println("(5)栈长度为："+A.size());
		System.out.println("(6)取栈顶元素："+A.top());
		System.out.print("(7)从栈顶到栈顶输出元素：");
		int i=A.top;
		while (i!=-1){
			System.out.print(A.getStack(i));
			i--;
		}
		
		System.out.println();
		System.out.print("(8)出栈顺利：");
		while (!A.isEmpty()){
			System.out.print(A.pop());
		}
		System.out.println();
		System.out.print("(9)栈为：");
		System.out.println(A.isEmpty()?"空":"非空");
		
	}

}
