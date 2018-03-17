/**
 * ���ȶ���ADT
 * @author �� ��
 *
 */
public interface PriorityQueue<K,V> {
	/** �������ȶ���������� */
	public int size();
	
	/**�ж����ȶ����Ƿ�Ϊ��*/
	public boolean isEmpty();
	
	/**�������ȶ����������Сkeyֵ����*/
	public Entry<K,V> min() throws EmptyPriorityQueueException;
	
	/**ɾ�������ط������ȶ����������Сkeyֵ����*/
	public Entry<K,V> removeMin() throws EmptyPriorityQueueException;
	
	/**�����ͬʱ����*/
	public Entry<K,V> insert(K key,V value) throws InvalidKeyException;
	
	
}
