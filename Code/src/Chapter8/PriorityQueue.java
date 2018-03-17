/**
 * 优先队列ADT
 * @author 金 洋
 *
 */
public interface PriorityQueue<K,V> {
	/** 返回优先队列里的项数 */
	public int size();
	
	/**判断优先队列是否为空*/
	public boolean isEmpty();
	
	/**返回优先队列里具有最小key值的项*/
	public Entry<K,V> min() throws EmptyPriorityQueueException;
	
	/**删除并返回返回优先队列里具有最小key值的项*/
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException;
	
	/**插入项，同时返回*/
	public Entry<K,V> insert(K key,V value) throws InvalidKeyException;
	
	
}
