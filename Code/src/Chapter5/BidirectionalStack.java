public class BidirectionalStack<E> {
	protected int capacity;//实际数组容量
	public static final int CAPACITY=1000;
	protected E S[];
	protected int top0=-1;
	protected int top1=CAPACITY;
	public BidirectionalStack(){
		this(CAPACITY);
	}
	public BidirectionalStack(int capacity2) {
		capacity=capacity2;
		//泛型类中的泛型数据只能调用Object类中的方法
		S=(E[]) new Object[capacity];
		top1=capacity2;
	}
	
	public int getCapacity(){
		return capacity;
	}
	public int size(int i){
		switch (i){
			case 0:return top0+1;
			case 1:return (capacity-top1);
			default:return 0;
		}
	}
	public boolean isEmpty(int i){
		switch (i){
			case 0:return(top0<0);
			case 1:return (top1>=capacity);
			default:return true;
		}
	}
	public void push(E ele,int i) throws FullStackException{
		if (top0==top1)
			throw new FullStackException("Stack is full!");
		if (i==0){
			top0++;
			S[top0]=ele;
		}
		else if (i==1){
			top1--;
			S[top1]=ele;
		}
	}
	public E top(int i)throws EmptyStackException{
		if (isEmpty(i))
			throw new EmptyStackException("Stack is empty!");
		switch (i){
			case 0:return(S[top0]);
			case 1:return (S[top1]);
			default:return null;
		}
		
	}
	public E pop(int i)throws EmptyStackException{
		if (isEmpty(i))
			throw new EmptyStackException("Stack is empty!");
		E topEle = null;
		switch (i){
			case 0:
				topEle=S[top0];
				S[top0]=null;
				top0--;
				break;
			case 1:
				topEle=S[top1];
				S[top1]=null;
				top1++;
				break;
		}
		
		return topEle;
	}
	
	public String toString(int i){
		String s;
		s="[";
		if (i==0){
			if (size(i)>0) s=s+S[0];
			if (size(i)>1) 
				for (int j=1;j<size(i);j++){
					s=s+","+S[j];
				}
		}
		
		else if (i==1){
			if (size(i)>0) s=s+S[capacity-1];
			if (size(i)>1) 
				for (int j=1;j<size(i);j++){
					s=s+","+S[capacity-1-j];
				}
		}
		s=s+"]";
		return s;
	}
	
	public E getStack(int i){
		return S[i];
	}
	
	
	

}