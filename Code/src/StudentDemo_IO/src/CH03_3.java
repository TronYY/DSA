import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CH03_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//输入以度为单位的值，从30度到60度
		ArrayList<Integer> al1=new ArrayList<Integer>();
		for (int idx=30;idx<=60;idx++)
			al1.add(idx);
		
		
		//以度为key，将转为弧度后的值放入value中
		HashMap<Integer, Double> hm=new HashMap<Integer, Double>();
		Iterator<Integer> iter=al1.iterator();
		while (iter.hasNext()){
			int degree=(Integer)iter.next();
			hm.put(degree, Math.toRadians((Integer)degree));
		}
		
		//读取转换前后的值
		Iterator<?> eiter=hm.entrySet().iterator();//此映射中包含的映射关系的Set视图
		while (eiter.hasNext()){
			Map.Entry entry=(Map.Entry)eiter.next();
			int degree=(Integer)entry.getKey();
			double radians=(Double)entry.getValue();
			
			System.out.println(degree+"->"+radians);
		}
	}

}
