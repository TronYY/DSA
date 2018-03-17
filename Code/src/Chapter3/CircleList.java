
public class CircleList {
	protected Node cursor;
	protected int size;
	public CircleList(){
		cursor=null;
		size=0;
	}
	public int size(){
		return size;
	}
	public Node getCursor(){
		return cursor;
	}
	public void advance(){cursor=cursor.getNext();}
	public void add(Node newNode){
		if (cursor==null) {
			newNode.setNext(newNode);
			cursor=newNode;
		}
		else {
			newNode.setNext(cursor.getNext());
			cursor.setNext(newNode);
		}
		size++;
	}
	public Node remove(){
		Node oldNode=cursor.getNext();
		if (oldNode==cursor) cursor=null;
		else{
			cursor.setNext(oldNode.getNext());
			oldNode.setNext(null);
		}
		size--;
		return oldNode;
		
	}
	public String toString(){
		if (cursor==null) return "[]";
		String s="[..."+cursor.getElement();
		Node oldCursor=cursor;
		for (advance();oldCursor!=cursor;advance())
			s+=","+cursor.getElement();
		return s+"]";
	}
}
