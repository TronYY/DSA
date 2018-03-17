
public class ArrayQueue<E> implements IQueue<E>{
	protected int f;//��һ��Ԫ�ص��±�
	protected int r;//���һ��Ԫ�ص���һ������
	protected int N;//����
	protected E Q[];
	public static final int CAPACITY=1000;//Ĭ������
	
	public ArrayQueue(){
		this(CAPACITY);
	}
	public  ArrayQueue(int capacity2) {
		N=capacity2;
		f=r=0;
		//�������еķ�������ֻ�ܵ���Object���еķ���
		Q=(E[]) new Object[N];
	}
	public int size() {
		//˳��ѭ�����У�������r-fֱ�Ӵ���Ԫ�ظ���
		return (r+N-f)% N;
	}

	
	public boolean isEmpty() {
		return r==f;
	}

	public E front() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("Queue is empty!");
		return Q[f];
		
	}

	public void enqueue(E element) throws FullQueueException {
		if (size()==N-1) throw new FullQueueException("Queue is full!");//�������Ϳ�ʱ����f=r,���Դ˴���size�ж�
		Q[r]=element;
		r=(r+1)%N;
		
	}


	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) throw new EmptyQueueException("Queue is empty!");
		E temp;
		temp=Q[f];
		f=(f+1)%N;
		return temp;
		
	}

}
