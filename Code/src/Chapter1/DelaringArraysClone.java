package Chapter1;
public class DelaringArraysClone {
	public static double[] a,b;//����double������a,b;
	//display()Ϊ�������������Ԫ�صķ���
	public static void display(double [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();	
	}
	public static void main(String[] args){
		a=new double[10];//��new����a���飬��ָ������10���ռ䣬ÿһ������double��
		b=new double[10];
		for (int k=0;k<a.length;k++) a[k]=1.0;
		//����b=a��b=a.clone();
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
