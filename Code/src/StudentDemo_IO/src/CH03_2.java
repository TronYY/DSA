import java.util.HashMap;


public class CH03_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap hm=new HashMap();

		for (int idx=0;idx<10;idx++){
			hm.put(idx, "VALUE:"+idx);
		}
		
		for (int idx=0;idx<hm.size();idx++){
			String value=(String) hm.get(idx);
			System.out.println(value);
		}
	}

}
