package Chapter1;
public class DelaringArraysClone {
	public static double[] a,b;//声明double型数组a,b;
	//display()为输出数组中所有元素的方法
	public static void display(double [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();	
	}
	public static void main(String[] args){
		a=new double[10];//用new创建a数组，并指定其有10个空间，每一个都是double型
		b=new double[10];
		for (int k=0;k<a.length;k++) a[k]=1.0;
		//区别b=a和b=a.clone();
		System.out.println("After b=a");
		b=a;
		System.out.println("a:");
		display(a);
		System.out.println("b:");
		display(b);
	    b[3]=5;
		System.out.println("a:");
		display(a);
		System.out.println("b:");
		display(b);
		
		a[3]=1.0;
		b=a.clone();
		System.out.println("After b=a.clone()");
		System.out.println("a:");
		display(a);
		System.out.println("b:");
		display(b);
		b[3]=5;
		System.out.println("a:");
		display(a);
		System.out.println("b:");
		display(b);	
	}
}
