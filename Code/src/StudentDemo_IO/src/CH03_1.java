import java.util.ArrayList;
import java.util.Iterator;


public class CH03_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		for (int idx=0;idx<10;idx++)
			al.add(idx);
		
		//µü´úÆ÷
		Iterator<Integer> iter=al.iterator();
		while (iter.hasNext()){
			System.out.println((Integer)iter.next());
		}
	}

}
