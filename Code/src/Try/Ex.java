package Try;
import java.util.Arrays;
import java.util.Random;

public class Ex {

	public static void main(String[] args) {
		int[] num=new int[10];
		Random rand=new Random();
		rand.setSeed(System.currentTimeMillis());
		
		for (int i=0;i<num.length;i++)
			num[i]=rand.nextInt(100);
		int[] old=num.clone();
		System.out.print("arrays equal before sort:"+Arrays.equals(old, num));
		Arrays.sort(num);
		

	}

}
