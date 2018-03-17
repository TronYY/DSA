package Chapter1;
public class BreakExample{
	//main方法是静态的，静态方法无法调用非静态属性或方法，需要通过创建对象去调用；
	//static 修饰的方法只能访问static
	public static int[][] a =new int[][]{{0,1,2},{5,9,7},{2,4,8}};
	
	public static boolean hasZeroEntry(int[][] a){
		boolean foundFlag=false;
		zeroSearch:
		for (int i=0;i<a.length;i++){
			for (int j=0;j<a[i].length;j++){
				
				if (a[i][j]==0){
					foundFlag=true;
					break zeroSearch; 
				}
			}
		}
		return foundFlag;
	}
       
	public static void main(String[] args){
		System.out.println("Is these any zeros in array a?"+hasZeroEntry(a));
	}
}