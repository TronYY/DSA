//双向链表实现双端队列
import java.io.Serializable;
import java.security.acl.LastOwnerException;


public class LinkedDeque <T> implements DequeInterface<T>,Serializable{

	private DLNode firstNode;
	private DLNode lastNode;
	public LinkedDeque()
	{
		firstNode=null;
		lastNode=null;
	}
	
	private class DLNode implements Serializable
	{
		private T data;
		private DLNode next;
		private DLNode previous;
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public DLNode getNext() {
			return next;
		}
		public void setNext(DLNode next) {
			this.next = next;
		}
		public DLNode getPrevious() {
			return previous;
		}
		public void setPrevious(DLNode previous) {
			this.previous = previous;
		}
		public DLNode(T data, DLNode next, DLNode previous) {
			super();
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		
	}
	@Override
	public void addToFront(T newEntry) {
		// TODO Auto-generated method stub
		DLNode newNode=new DLNode(newEntry, firstNode, null);
		if(isEmpty())
			lastNode=newNode;
		else 
			firstNode.setPrevious(newNode);
		firstNode=newNode;
	}

	@Override
	public void addToBack(T newEntry) {
		// TODO Auto-generated method stub
		DLNode newNode=new DLNode(newEntry, null, lastNode);
		if(isEmpty())
			firstNode=newNode;
		else
		    lastNode.setNext(newNode);
		lastNode=newNode;
	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
		T front=null;
		if(!isEmpty())
		{
			front=firstNode.getData();
			firstNode=firstNode.getNext();
			if(firstNode==null)
				lastNode=null;
			else 
				firstNode.setPrevious(null);
		}
		return front;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		T back=null;
		if(!isEmpty())
		{
			back=lastNode.getData();
			lastNode=lastNode.getPrevious();
			if(lastNode==null)
				firstNode=null;
			else 
				lastNode.setNext(null);
		}
		return back;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		T front=null;
		if(!isEmpty())
			front=firstNode.getData();
		return front;

	}

	@Override
	public T getBack() {
		// TODO Auto-generated method stub
		T back=null;
		if(!isEmpty())
			back=lastNode.getData();
		return back;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode==null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode=null;
		lastNode=null;
	}
    
    
}
