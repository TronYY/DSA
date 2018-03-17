package Chapter1;
import java.io.*;
import java.util.Scanner;
public class OutputAndInput {
	public static void main(String[] args) throws IOException {
		System.out.print("Jva value: ");
		System.out.print(3.1415);
		System.out.print(',');
		System.out.print(15);
		System.out.print("(double,char,int)");
		Scanner s=new Scanner(System.in);//创建Scanner对象s，用于输入
		System.out.print("Enter your age in years:");
		double age=s.nextDouble();
		System.out.print("Enter your maximum heart rate:");
		double rate=s.nextDouble();
		double fb=(rate-age)*0.65;
		System.out.println("Your target fat burning heart rates is "+fb+".");
		
		Scanner input=new Scanner(System.in);
		System.out.print("Please enter an integer:");
		while (!input.hasNextInt()){//判断下一个输入是否是整数
			input.nextLine();
			System.out.print("That's not an integer;please enter an integer:");
		}
		int i=input.nextInt();
		System.out.println("i="+i);
	
	
	}

}
