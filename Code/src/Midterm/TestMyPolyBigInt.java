package Midterm;
import java.io.BufferedReader;
import java.io.*;


public class TestMyPolyBigInt {

	public static void main(String[] args) throws IOException {
		String ope=new String();
		long n;//nΪ����
		long exp;//exp���������ָ��
		long i;
		int operator;//���е���������
		PolySLink fx;
		PolySLink gx;
		MyPolyBigInt MPBI;
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		do{
			//����f(x);
			System.out.println("������һԪ����ʽf(x)��������");
			fx=new PolySLink();
			ope=input.readLine();
			n=Integer.parseInt(ope);
			for (i=0;i<n;i++){
				System.out.println("ϵ����");
				ope=input.readLine();
				StringBuffer coe = new StringBuffer(ope);
				System.out.println("ָ����");
				ope=input.readLine();
				exp=Integer.parseInt(ope);
				PolyNode newPN=new PolyNode(coe,exp);//�����������һ�ڵ�newPN
				fx.insert(newPN);//�������������뵽fx��������
			}
			System.out.println("f(x)="+fx.toString());
			
			//����g(x);
			System.out.println("������һԪ����ʽg(x)��������");
			gx=new PolySLink();
			ope=input.readLine();
			n=Integer.parseInt(ope);
			for (i=0;i<n;i++){
				System.out.println("ϵ����");
				ope=input.readLine();
				StringBuffer coe = new StringBuffer(ope);
				System.out.println("ָ����");
				ope=input.readLine();
				exp=Integer.parseInt(ope);
				PolyNode newPN=new PolyNode(coe,exp);//�����������һ�ڵ�newPN
				gx.insert(newPN);//�������������뵽fx��������
			}
			System.out.println("g(x)="+gx.toString());
			
			
			System.out.println("1.�ӷ�	2.����	3.�˷�	4.����");
			System.out.println("��ѡ��Ҫ���е�һԪ����ʽ���㣺");
			
			
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
					System.out.println("��ʽ="+MRPBI.getQuoSLink().toString());
					System.out.println("��ʽ="+MRPBI.getRemSLink().toString());
					break;
			}
			
			System.out.println("�Ƿ�������м���Y/N:");
			ope=input.readLine();
		}while (ope.equals("Y"));	
	}	

}
