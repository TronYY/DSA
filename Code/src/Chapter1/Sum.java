public class Sum
{
	public static int[] a=new int[]{1,2,3,4,5};//新建数组；
        //求和方法
	public static int sum(int[] a ){
		int total=0;
		for(int i=0;i<a.length;i++)
			total+=a[i];
		return total;

	}
	public static void main(String[] args){
		System.out.println(sum(a));
	}
	
}