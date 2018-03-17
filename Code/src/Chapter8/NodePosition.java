
public class NodePosition<E>  implements IPositionList<E> {
	protected int numElts;
	protected DNode<E> header,trailer;
	public NodePosition(){
		numElts=0;
		header=new DNode<E>(null,null,null);
		trailer=new DNode<E>(null,header,null);
		header.setNext(trailer);
	}
	
	public int size(){return numElts;}
	
	public boolean isEmpty(){return numElts==0;}
	
	public Position<E> first(){return header.getNext();}
	
	public Position<E> prev(Position<E> p){
		return ((DNode<E>) p).getPrev();
	}
	
	public void addBefore(Position<E> p,E element){
		numElts++;
		DNode<E> v=(DNode<E>) p;
		DNode<E> newNode=new DNode<E>(element,v.getPrev(),v);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
	}
	
	public void addFirst(E element){
		numElts++;
		DNode<E> newNode=new DNode<E>(element,header,header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		
	}
	
	public E remove(Position<E> p){
		DNode<E> v=(DNode<E>) p;
		numElts--;
		DNode<E> vPrev=v.getPrev();
		DNode<E> vNext=v.getNext();	
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		E vElem=v.element();
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}
	
	public E set(Position<E> p,E element){
		DNode<E> v=(DNode<E>) p;
		E oldElem=v.element();
		v.setElement(element);
		return oldElem;
	}

	public Position<E> last() {	
		return trailer.getPrev();
	}

	
	public Position<E> next(Position<E> p) {
		return ((DNode<E>) p).getNext();
	}

	
	public Position<E> pre(Position<E> p) {
		return ((DNode<E>) p).getPrev();
	}

	
	public void addLast(E e) {
		addBefore(trailer,e);
	}

	
	public void addAfter(Position<E> p, E e) {
		numElts++;
		DNode<E> v=(DNode<E>) p;
		DNode<E> newNode=new DNode<E>(e,v,v.getNext());
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		
	}
	
	
}
