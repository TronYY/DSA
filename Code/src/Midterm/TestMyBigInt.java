package Midterm;
import java.io.*;

public class TestMyBigInt {

	public static void main(String[] args) throws IOException {
		
		String ope=new String();
		StringBuffer para1;
		StringBuffer para2;
		int operator;
		
		
		do{
			MyBigInt BI;/**/
			System.out.println("1.�ӷ�	2.����	3.�˷�	4.����");
			System.out.println("��ѡ��Ҫ���е����㣺");
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
			
			ope=input.readLine();
			operator=Integer.parseInt(ope);
			
			switch (operator){
				case 1:
					System.out.println("�����������");
					ope=input.readLine();
					para1 = new StringBuffer(ope);
					System.out.println("�����������");
					ope=input.readLine();
					para2 = new StringBuffer(ope);
					BI=new MyBigInt(para1,para2);
					System.out.println("��:"+BI.getAns(BI.add(BI.getBigInt1(),BI.getBigInt2())));
					break;
				case 2:
					System.out.println("�����뱻������");
					ope=input.readLine();
					para1 = new StringBuffer(ope);
					System.out.println("�����������");
					ope=input.readLine();
					para2 = new StringBuffer(ope);
					BI=new MyBigInt(para1,para2);
					System.out.println("��:"+BI.getAns(BI.minus(BI.getBigInt1(),BI.getBigInt2())));
					break;
				
				case 3:
					System.out.println("������������");
					ope=input.readLine();
					para1 = new StringBuffer(ope);
					System.out.println("������������");
					ope=input.readLine();
					para2 = new StringBuffer(ope);
					BI=new MyBigInt(para1,para2);
					System.out.println("��:"+BI.getAns(BI.multiply(BI.getBigInt1(),BI.getBigInt2())));
					break;
				case 4:
					System.out.println("�����뱻������");
					ope=input.readLine();
					para1 = new StringBuffer(ope);
					System.out.println("�����������");
					ope=input.readLine();
					para2 = new StringBuffer(ope);
					BI=new MyBigInt(para1,para2);
					BI.devide(BI.getBigInt1(),BI.getBigInt2());
					System.out.println("��:"+BI.getAns(BI.getQuoBigInt()));
					System.out.println("����:"+BI.getAns(BI.getRemBigInt()));
					break;
					
			}
			System.out.println("�Ƿ�������м���Y/N:");
			ope=input.readLine();
		}while (ope.equals("Y"));
	}
	

}