import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Try3 {

	public static void main(String[] args) throws IOException {
		//int i=Integer.MAX_VALUE;
		//System.out.println(i);
		int a[]=new int[0];
		StringBuffer s =new StringBuffer("-10234");
		int k=s.indexOf("-");
		System.out.println("k="+k);
		System.out.println("old length="+s.length());
		System.out.println(s);
	
		System.out.println("new length="+s.length());
		System.out.println("sub="+s.substring(5,6));
		int kk=Integer.parseInt(s.substring(2,4));
		System.out.println("kkk="+kk);
		
		
		String c="-1234";
		System.out.println(c.replace('-',' '));
		
		int[] a1=new int[6];
		a1[0]=2;a1[1]=1;
		System.out.println(a1.length);
		
		String para1,para2;
		
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		para1=input.readLine();
		System.out.println("1=="+para1);
		para2=input.readLine();
		System.out.println("2=="+para1);
		System.out.println("3=="+para2);
		
		
	}

}
