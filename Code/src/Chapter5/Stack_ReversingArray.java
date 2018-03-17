import java.util.Arrays;
public class Stack_ReversingArray {

	public static <E> void reverse(E[] a){
		Stack<E> S=new ArrayStack<E>(a.length);
		for (int i=0;i<a.length;i++)
			S.push(a[i]);
		for (int i=0;i<a.length;i++)
			a[i]=S.pop();
		
	}
	public static void main(String[] args) {
		Integer[] a={2,4,6,8,10};
		String[] s={"a","b","e","f","g"};
		System.out.println("a="+Arrays.toString(a));
		System.out.println("s="+Arrays.toString(s));
		System.out.println("After Reversing:");
		reverse(a);
		reverse(s);
		System.out.println("a="+Arrays.toString(a));
		System.out.println("s="+Arrays.toString(s));
		
	}

}
