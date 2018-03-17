
public class DList<E> {
	protected int size;//元素总数
	protected DNode<E> header;
	//构造方法
	public DList(){
		size=0;
		header=new DNode<E>(null,null,null);	//头节点初始化
	}
	public int size(){return size;}//得到元素总数；
	public boolean isEmpty(){return size==0;}//判断是否为空，空则返回TRUE；
	public DNode<E> getPrev(DNode<E> v){return v.getPrev();}//得到v的前趋节点；
	public DNode<E> getNext(DNode<E> v){return v.getNext();}//得到v的后继节点；
	public DNode<E> getHeader(){return header;}//得到双向循环链表的头节点
	
	
	//在带头节点的双向循环链表中寻找第i个节点，找出返回该节点；
	public DNode<E> getDNodeI(int i) throws IllegalStateException{
		if (isEmpty()) throw new IllegalStateException("List is empty");
		if ((i>size()+1)||(i<1)) throw new IllegalStateException("i is invalid.");
		int k=1;//k从头结点开始计数，直到找到第i个节点；
		DNode<E> p=header;//p为工作指针
		while (k<i){
			k++;
			p=p.getNext();
		}//但i=size+1时，则工作指针再次指向header 
		return p;
	}
	
	
	//在header节点中存值
	public void addFirst(E ele){
		header.setElement(ele);
		//只有一个元素时，前后节点都为其本身，需要设置好prev和next值，防止出现NullPointException异常
		header.setNext(header);
		header.setPrev(header);
		size++;
	}
	
	
	//在带头节点的双向循环链表的位置i前插入新节点v；
	public void addBefore(int i,E ele){
		DNode<E> y=getDNodeI(i);//y为第i个节点；
		DNode<E> x=y.getPrev();//x为第i-1个节点；
		DNode<E> v=new DNode<E>(ele,null,null) ;
		v.setPrev(x);
		v.setNext(y);
		y.setPrev(v);
		x.setNext(v);
		size++;//表长加1；
	}
	
	
	//在带头节点的双向循环链表中删除第i个位置上的节点
	public void remove(int i){
		DNode<E> v=getDNodeI(i);//v为第i个节点；
		DNode<E> y=v.getNext();
		DNode<E> x=v.getPrev();
		y.setPrev(x);
		x.setNext(y);
		//v的前后指向置为空；
		v.setPrev(null);
		v.setNext(null);
		size--;//表长减1；
	}
	
	//输出带头节点的双向循环链表中的元素；
	public String toString(String s){
		DNode<E> v=getHeader();
		int k=1;//k统计已输出元素的个数
		while (k<=size()){
			s=s+v.getElement()+" ";
			v=v.getNext();
			k++;
		}
		return s;
	}
	
	public void freeDList(){
		DNode<E> q=getHeader(),p;
		do{
			p=q;
			p.setPrev(null);
			p.setElement(null);
			q=p.getNext();
			p.setNext(null);
		}while (q!=null);
	}
}
