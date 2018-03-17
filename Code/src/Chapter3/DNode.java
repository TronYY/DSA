
public class DNode<E> {
	protected E element;//element 为储存在DNode的元素，元素类型为泛型E；
	protected DNode<E> next,prev;//next、prev分别为后继指针、前趋指针；
	//构造方法
	public DNode(E e,DNode<E> p,DNode<E> n){
		element =e;
		prev=p;
		next=n;
	}
	//得到element元素值；
	public E getElement(){
		return element;
	}
	//得到后继节点
	public DNode<E> getNext(){
		return next;
	}
	//得到前趋节点
	public DNode<E> getPrev(){
		return prev;
	}
	//element 赋值
	public void setElement(E newEle){element=newEle;}
	//next 赋值
		public void setNext(DNode<E> newNext){next=newNext;}
	//prev 赋值
	public void setPrev(DNode<E> newPrev){prev=newPrev;}

}
