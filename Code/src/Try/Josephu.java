
import java.io.*;
import java.util.Scanner;

public class Josephu{
protected static int m,n,k;
public static void inputParameter(){
	Scanner s=new Scanner(System.in);
	System.out.println("����������n��");
	n=s.nextInt();
	System.out.println("�����뿪ʼ�����˵ı��k��");
	k=s.nextInt();
	System.out.println("����������������ĺ�m��");
	m=s.nextInt();
}
public static void gameStart(){
	String s="";
	int t = 0;
	int[] a;
	int[] b;
	a=new int[n];
	b=new int[n];
	for(int i=0;i<b.length;i++)	
		b[i]=0;
	for(int i=0;i<a.length-1;i++)
		a[i]=i+1;
	a[a.length-1]=0;
	k=k-1;
	for(int j=0;j<b.length;j++){
		for(int i=0;i<m-1;i++){
			t=k;
			k=a[k];
		}
		b[j]=k+1;
		a[t]=a[k];
		k=a[k];
		s=s+b[j]+" ";
	}
	System.out.println(s);
}
	


public static void main(String[] args){
	inputParameter();
	gameStart();
}
	
}