
public class ArrayIndexList<E> {
	protected E[] A;
	protected int capacity;
	protected int size;
	
	public ArrayIndexList(int newCapacity){
		capacity=newCapacity;
		size=0;
		A=(E[]) new Object[capacity];
	}
	public void add(int r,E e){
		//Õÿ’πø’º‰
		if (size==capacity){
			capacity=2*capacity;
			E[] B=(E[]) new Object[capacity];
			for (int i=0;i<size;i++) B[i]=A[i];
			A=B;
		}
		for (int i=size-1;i>=r;i--) A[i+1]=A[i];
		A[r]=e;
		size++;
	}
	
	public E remove(int r){
		E temp=A[r];
		for (int i=r;i<size-1;i++) A[i]=A[i+1];
		size--;
		return temp;
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public E get(int i){
		return A[i];
	}
	public void set(int i, E e){
		A[i]=e;
	}
}
