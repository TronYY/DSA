
public class ArrayQueue<E> implements IQueue<E>{
	protected int f;//第一个元素的下边
	protected int r;//最后一个元素的下一个坐标
	protected int N;//容量
	protected E Q[];
	public static final int CAPACITY=1000;//默认容量
	
	public ArrayQueue(){
		this(CAPACITY);
	}
	public  ArrayQueue(int capacity2) {
		N=capacity2;
		f=r=0;
		//泛型类中的泛型数据只能调用Object类中的方法
		Q=(E[]) new Object[N];
	}
	public int size() {
		//顺序循环队列，不能用r-f直接代表元素个数
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
		if (size()==N-1) throw new FullQueueException("Queue is full!");//队列满和空时都有f=r,所以此处用size判断
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
