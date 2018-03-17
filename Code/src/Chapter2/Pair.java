
public class Pair<K,V> {//键值对  大写字母是形式类型上的参数
	K key;//自变量
	V value;//因变量
	public void set(K k,V v){
		key=k;
		value=v;
	}
	public K getKey(){return key;	}
    public V getValue(){return value;}
    public String toString(){
    	return "["+getKey()+","+getValue()+"]";
    }    
	public static void main(String[] args) {
		Pair<String,Integer> pair1 =new Pair<String,Integer>();
		pair1.set(new String("height"), new Integer(36));
		System.out.println(pair1);
		Pair<Student,Double> pair2=new Pair<Student,Double>();
		pair2.set(new Student("A5976","Sue",19),new Double(9.5));
		System.out.println(pair2);
	}
}
