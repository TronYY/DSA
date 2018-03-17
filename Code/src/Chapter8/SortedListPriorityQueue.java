/**
 * �������ʵ�����ȶ���
 */
import java.util.Comparator;


public class SortedListPriorityQueue<K,V> implements PriorityQueue<K,V> {
	protected IPositionList<Entry<K,V>> entries;
	protected Comparator<K> c;
	protected Position<Entry<K,V>> actionPos;
	
	protected static class MyEntry<K,V> implements Entry<K,V>{
		protected K k;
		protected V v;
		public MyEntry(K newK,V newV){
			k=newK;
			v=newV;
		}
		
		public K getKey(){
			return k;
		}
		
		public V getValue(){
			return v;
		}
	}
	
	public SortedListPriorityQueue(){
		entries=new NodePosition<Entry<K,V>>();
		c=new DefaultComparator<K>();
	}
	
	public SortedListPriorityQueue(Comparator<K> comp){
		entries=new NodePosition<Entry<K,V>>();
		c=comp;
	}
	
	public Entry<K,V> min() throws EmptyPriorityQueueException{
		if (entries.isEmpty())
			throw new EmptyPriorityQueueException("Priority queue is empty.");
		else 
			return entries.first().element();
	}
	
	

	public Entry<K,V> insert(K k,V v) throws InvalidKeyException{
		Entry<K,V> entry=new MyEntry<K,V>(k,v);
		insertEntry(entry);
		return entry;
	}
	
	
	/**
	 * ��������в�����Ԫ��
	 * @param e
	 */
	protected void insertEntry(Entry<K,V> e){
		//��Ϊ��ʱ
		if (entries.isEmpty()){
			entries.addFirst(e);
			actionPos=entries.first();
			
		}
		//����Ԫ�ص�keyֵ�����һ��Ԫ�ػ���ʱ
		else if (c.compare(e.getKey(),entries.last().element().getKey())>0){
			entries.addLast(e);
			actionPos=entries.last();
		}
		
		//�ڱ���м�壬��ͷ��ʼ������ȥ
		else{
			Position<Entry<K,V>> curr=entries.first();
			while (c.compare(e.getKey(),curr.element().getKey())>0){
				curr=entries.next(curr);
			}
			entries.addBefore(curr, e);
			actionPos=entries.pre(curr);
		}
		
	}
	
	//����
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException{
		if (entries.isEmpty())
			throw new EmptyPriorityQueueException("Priority queue is empty.");
		else 
			return entries.remove(entries.first());
	}

	public int size() {
		
		return entries.size();
	}

	
	public boolean isEmpty() {
		
		return entries.isEmpty();
	}

	
}
