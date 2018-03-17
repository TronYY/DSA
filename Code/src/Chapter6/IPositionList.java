
public interface IPositionList<E> {
	public int size();
	
	public boolean isEmpty();
	
	public Position<E> first();
	
	public Position<E> last();
	
	public Position<E> next(Position<E> p);
	
	public Position<E> pre(Position<E> p);
	
	public void addFirst(E e);
	
	public void addLast(E e);
	
	public void addAfter(Position<E> p,E e);
	
	public void addBefore(Position<E> p,E e);
	
	public void remove(Position<E> p);
	
	public E set(Position<E> p,E e);
}
