public class ArrayStack<E> implements Stack<E>{
	protected int capacity;//实际数组容量
	public static final int CAPACITY=1000;
	protected E S[];
	protected int top=-1;
	public ArrayStack(){
		this(CAPACITY);
	}
	public ArrayStack(int capacity2) {
		capacity=capacity2;
		//泛型类中的泛型数据只能调用Object类中的方法
		S=(E[]) new Object[capacity];
	}
	public int size(){
		return(top+1);
	}
	public boolean isEmpty(){
		return(top<0);
	}
	public void push(E ele) throws FullStackException{
		if (size()==capacity)
			throw new FullStackException("Stack is full!");
		top++;
		S[top]=ele;
	}
	public E top()throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("Stack is empty!");
		return S[top];
	}
	public E pop()throws EmptyStackException{
		if (isEmpty())
			throw new EmptyStackException("Stack is empty!");
		E topEle;
		topEle=S[top];
		S[top]=null;
		top--;
		return topEle;
	}
	
	public String toString(){
		String s;
		s="[";
		if (size()>0) s=s+S[0];
		if (size()>1) 
			for (int i=1;i<size();i++){
				s=s+","+S[i];
			}
		s=s+"]";
		return s;
	}
	public void status(String op,Object element){
		System.out.print("-->"+op);
		System.out.println(",returns "+element);
		System.out.print("result;size="+size()+",isEmpty="+isEmpty());
		System.out.println(",stack: "+this.toString());//?
	}
	public E getStack(int i){
		return S[i];
	}
	
	
	

}
