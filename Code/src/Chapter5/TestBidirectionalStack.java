
public class TestBidirectionalStack {

	public static void main(String[] args) {
		System.out.println("��1����ʼ��˫��ջB");
		BidirectionalStack<Character> B=new BidirectionalStack<Character>(6);//��ʼ��һ������Ϊ6��˫��ջ
		
		System.out.println("��2�����ηֱ��ջԪ��a,b,c��d,e,f");
		B.push('a',0);
		B.push('b',0);
		B.push('c',0);
		B.push('d',1);
		B.push('e',1);
		B.push('f',1);
		
		System.out.println("��3��ջ�д洢�����");
		System.out.println("��ջ��"+B.toString(0));
		System.out.println("��ջ��"+B.toString(1));
		
		System.out.println("��4����ջ���У�");
		char e;
		System.out.print("��ջ�ĳ�ջ���У�");
		for (int i=0;i<B.getCapacity()/2;i++){
			e=B.pop(0);
			System.out.print(e);
		}
		System.out.println();
		System.out.print("��ջ�ĳ�ջ���У�");
		for (int i=0;i<B.getCapacity()/2;i++){
			e=B.pop(1);
			System.out.print(e);
		}
		System.out.println();
		
	}

}
