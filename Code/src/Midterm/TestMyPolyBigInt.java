package Midterm;
import java.io.BufferedReader;
import java.io.*;


public class TestMyPolyBigInt {

	public static void main(String[] args) throws IOException {
		String ope=new String();
		long n;//n为项数
		long exp;//exp代表输入的指数
		long i;
		int operator;//进行的运算类型
		PolySLink fx;
		PolySLink gx;
		MyPolyBigInt MPBI;
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		do{
			//构造f(x);
			System.out.println("请输入一元多项式f(x)的项数：");
			fx=new PolySLink();
			ope=input.readLine();
			n=Integer.parseInt(ope);
			for (i=0;i<n;i++){
				System.out.println("系数：");
				ope=input.readLine();
				StringBuffer coe = new StringBuffer(ope);
				System.out.println("指数：");
				ope=input.readLine();
				exp=Integer.parseInt(ope);
				PolyNode newPN=new PolyNode(coe,exp);//构造输入的这一节点newPN
				fx.insert(newPN);//将新输入的项插入到fx单链表中
			}
			System.out.println("f(x)="+fx.toString());
			
			//构造g(x);
			System.out.println("请输入一元多项式g(x)的项数：");
			gx=new PolySLink();
			ope=input.readLine();
			n=Integer.parseInt(ope);
			for (i=0;i<n;i++){
				System.out.println("系数：");
				ope=input.readLine();
				StringBuffer coe = new StringBuffer(ope);
				System.out.println("指数：");
				ope=input.readLine();
				exp=Integer.parseInt(ope);
				PolyNode newPN=new PolyNode(coe,exp);//构造输入的这一节点newPN
				gx.insert(newPN);//将新输入的项插入到fx单链表中
			}
			System.out.println("g(x)="+gx.toString());
			
			
			System.out.println("1.加法	2.减法	3.乘法	4.除法");
			System.out.println("请选择要进行的一元多项式运算：");
			
			
			ope=input.readLine();
			operator=Integer.parseInt(ope);
			
			MPBI=new MyPolyBigInt();
			switch (operator){
				case 1:
					MPBI.addPoly(fx,gx);
					System.out.println("f(x)+g(x)="+MPBI.getAnsSLink().toString());
					break;
				case 2:
					MPBI.minusPoly(fx,gx);
					System.out.println("f(x)-g(x)="+MPBI.getAnsSLink().toString());
					break;
				case 3:
					MPBI.multiplyPoly(fx,gx);
					System.out.println("f(x)*g(x)="+MPBI.getAnsSLink().toString());	
					break;
					
				case 4:
					MyRatPolyBigInt MRPBI=new MyRatPolyBigInt();
					MRPBI.devidePoly(fx, gx);
					System.out.println("f(x)/g(x):");	
					System.out.println("商式="+MRPBI.getQuoSLink().toString());
					System.out.println("余式="+MRPBI.getRemSLink().toString());
					break;
			}
			
			System.out.println("是否继续进行计算Y/N:");
			ope=input.readLine();
		}while (ope.equals("Y"));	
	}	

}
