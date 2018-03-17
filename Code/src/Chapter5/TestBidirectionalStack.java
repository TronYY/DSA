
public class TestBidirectionalStack {

	public static void main(String[] args) {
		System.out.println("（1）初始化双向栈B");
		BidirectionalStack<Character> B=new BidirectionalStack<Character>(6);//初始化一个容量为6的双向栈
		
		System.out.println("（2）两段分别进栈元素a,b,c和d,e,f");
		B.push('a',0);
		B.push('b',0);
		B.push('c',0);
		B.push('d',1);
		B.push('e',1);
		B.push('f',1);
		
		System.out.println("（3）栈中存储情况：");
		System.out.println("左栈："+B.toString(0));
		System.out.println("右栈："+B.toString(1));
		
		System.out.println("（4）出栈序列：");
		char e;
		System.out.print("左栈的出栈序列：");
		for (int i=0;i<B.getCapacity()/2;i++){
			e=B.pop(0);
			System.out.print(e);
		}
		System.out.println();
		System.out.print("右栈的出栈序列：");
		for (int i=0;i<B.getCapacity()/2;i++){
			e=B.pop(1);
			System.out.print(e);
		}
		System.out.println();
		
	}

}
