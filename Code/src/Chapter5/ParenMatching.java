import java.io.*;
import java.util.Scanner;
public class ParenMatching {
	public static boolean isMatching(char left,char right){
		if (left=='(' && right==')') return true;
		if (left=='[' && right==']') return true;
		if (left=='{' && right=='}') return true;
		return false;
		
	}
	
	public static boolean ParenMatch(char[] X,int n){
		ArrayStack<Character> S=new ArrayStack<Character>(n);
		for (int i=0;i<n;i++)
			if (X[i]=='(' || X[i]=='[' || X[i]=='{')
				S.push(X[i]);
			else if (X[i]==')' || X[i]==']' || X[i]=='}'){
				if (S.isEmpty())
					return false;
				if (!isMatching(S.pop(),X[i]))
					return false;
			}
		if (S.isEmpty()) return true;
		else return false;
		
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String s;
		s=input.nextLine();
		char[] X=s.toCharArray();
		System.out.println(ParenMatch(X,s.length())?"Correct":"Incorrect");
	}
}
