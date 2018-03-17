public class TestMyMap {

	public static void main(String[] args) {
		
		int x[]={16,42,54,41,66,80,3,2,23};
		
		MyMap<String, String> hashTable = new MyMap<String, String>();
		for(int i=0;i<x.length;i++){  
	        hashTable.put(""+x[i], ""+i*100);  
	    }
		
		
		
		hashTable.dispMyMap();
		
		System.out.println("平均搜索长度ASL("+hashTable.container.length+")="+(double)(hashTable.container.length/x.length));
		
			
	}
}
