
import java.util.ArrayList;
public class DequeAdapter<T>]{
	private ArrayList<T> list=new ArrayList<T>()£»
	public int size(){
		return list.size();
	}
	
	public boollean isEmpty(){
		return list.isEmpty();
	}
	
	public T getFirst(){
		return list.get(0);
	}
	
	public T getLast(){
		return list.get(size()-1;
	}

	public void addFirst(e){
		list.add(0,e);
	}

	public voidaddLast(e){
		add(size(),e);
	}
	public E removeFirst(){
		list.remove(0);
	}
	public E removeLast(){
		list.remove(size()-1);
	}
}