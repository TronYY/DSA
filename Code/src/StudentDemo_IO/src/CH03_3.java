import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CH03_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//�����Զ�Ϊ��λ��ֵ����30�ȵ�60��
		ArrayList<Integer> al1=new ArrayList<Integer>();
		for (int idx=30;idx<=60;idx++)
			al1.add(idx);
		
		
		//�Զ�Ϊkey����תΪ���Ⱥ��ֵ����value��
		HashMap<Integer, Double> hm=new HashMap<Integer, Double>();
		Iterator<Integer> iter=al1.iterator();
		while (iter.hasNext()){
			int degree=(Integer)iter.next();
			hm.put(degree, Math.toRadians((Integer)degree));
		}
		
		//��ȡת��ǰ���ֵ
		Iterator<?> eiter=hm.entrySet().iterator();//��ӳ���а�����ӳ���ϵ��Set��ͼ
		while (eiter.hasNext()){
			Map.Entry entry=(Map.Entry)eiter.next();
			int degree=(Integer)entry.getKey();
			double radians=(Double)entry.getValue();
			
			System.out.println(degree+"->"+radians);
		}
	}

}
