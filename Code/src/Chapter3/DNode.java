
public class DNode<E> {
	protected E element;//element Ϊ������DNode��Ԫ�أ�Ԫ������Ϊ����E��
	protected DNode<E> next,prev;//next��prev�ֱ�Ϊ���ָ�롢ǰ��ָ�룻
	//���췽��
	public DNode(E e,DNode<E> p,DNode<E> n){
		element =e;
		prev=p;
		next=n;
	}
	//�õ�elementԪ��ֵ��
	public E getElement(){
		return element;
	}
	//�õ���̽ڵ�
	public DNode<E> getNext(){
		return next;
	}
	//�õ�ǰ���ڵ�
	public DNode<E> getPrev(){
		return prev;
	}
	//element ��ֵ
	public void setElement(E newEle){element=newEle;}
	//next ��ֵ
		public void setNext(DNode<E> newNext){next=newNext;}
	//prev ��ֵ
	public void setPrev(DNode<E> newPrev){prev=newPrev;}

}
