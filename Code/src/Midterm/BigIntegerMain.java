
import java.util.Scanner;
import java.math.*;
import java.text.*;
public class Main 
{
public static void main(String args[])
{
   Scanner cin = new Scanner ( System.in );
   BigInteger a,b;
   int c;
   char op;
   String s;
  
   while( cin.hasNext() )
   {
    a = cin.nextBigInteger();
    s = cin.next();
    op = s.charAt(0);
    if( op == '+')
    {
     b = cin.nextBigInteger();
     System.out.println(a.add(b));
    }
    else if( op == '-')
    {
     b = cin.nextBigInteger();
     System.out.println(a.subtract(b));
    }
    else if( op == '*')
    {
     b = cin.nextBigInteger();
     System.out.println(a.multiply(b));
    }
    else
    {
     BigDecimal a1,b1,eps;
     String s1,s2,temp;
     s1 = a.toString();
       a1 = new BigDecimal(s1);
     b = cin.nextBigInteger();
     s2 = b.toString();
     b1 = new BigDecimal(s2);
     c = cin.nextInt();
     eps = a1.divide(b1,c,4);
     //System.out.println(a + " " + b + " " + c);
     //System.out.println(a1.doubleValue() + " " + b1.doubleValue() + " " + c);
     System.out.print( a.divide(b) + " " + a.mod(b) + " ");
     if( c != 0)
     {
      temp = "0.";
      for(int i = 0; i < c; i ++) temp += "0";
      DecimalFormat gd = new DecimalFormat(temp);
      System.out.println(gd.format(eps));
     }
     else System.out.println(eps);
    }
   }
   }
}

/*���䣺

        a=a.pow(b);
        a=a.stripTrailingZeros();
         d=a.toPlainString();
        if(d.charAt(0)=='0') d=d.substring(1);

�����������

1.valueOf(parament); ������ת��Ϊ�ƶ�������

   ���� int a=3;

       BigInteger b=BigInteger.valueOf(a);

     ��b=3;

         String s=��12345��;

       BigInteger c=BigInteger.valueOf(s);

       ��c=12345��

 

2.add(); ���������

   BigInteger a=new BigInteger(��23��);

   BigInteger b=new BigInteger(��34��);

a.      add(b);

 

3.subtract(); ���

4.multiply(); ���

5.divide();    ���ȡ��

6.remainder(); ȡ��

7.pow();   a.pow(b)=a^b

8.gcd();   ���Լ��

9.abs(); ����ֵ

10.negate(); ȡ����

11.mod(); a.mod(b)=a%b=a.remainder(b);

12.max(); min();

13.punlic int comareTo(); 

14.boolean equals(); �Ƿ����

15.BigInteger���캯����

   һ���õ��������֣�

   BigInteger(String val);

��ָ���ַ���ת��Ϊʮ���Ʊ�ʾ��ʽ��

   BigInteger(String val,int radix);

��ָ�������� BigInteger ���ַ�����ʾ��ʽת��Ϊ BigInteger
 
��.����������

   A=BigInteger.ONE    1

B=BigInteger.TEN    10

C=BigInteger.ZERO   0

��.��������

1.   ���룺

��Scanner�ඨ�������п���̨����,Scanner����java.util.*����

Scanner cin=new Scanner(System.in);// ����

while(cin.hasNext())   //��ͬ��!=EOF

{

   int n;

   BigInteger m;

   n=cin.nextInt(); //����һ��int;

   m=cin.BigInteger();//����һ��BigInteger;

System.out.print(m.toString());

}

��.����

����Ԥ�㣺

import java.util.Scanner;
import java.math.*;
import java.text.*;

*/