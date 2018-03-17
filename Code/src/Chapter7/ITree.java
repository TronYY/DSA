import java.util.Iterator;


public interface ITree<E> {
	//返回节点个数
	public int size();
	
	//判断树是否为空
	public boolean isEmpty();
	
	//利用迭代器返回树中的节点
	public Iterator<E> iterator();
	
	public Iterator<Position<E>> position();
	
	//替换某一节点的储存元素
	public E replace(Position<E> v,E e) throws InvalidPositionException;
	
	//返回树的根
	public Position<E> root() throws EmptyTreeException;
	
	//返回父节点
	public Position<E> parent(Position<E> v) throws InvalidPositionException,BoundaryViolationException;
	
	//返回子节点
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
	
	//判断节点是否为内部节点
	public boolean isInternal(Position<E> v) throws InvalidPositionException;
	
	//判断节点是否为外部节点
	public boolean isExternal(Position<E> v) throws InvalidPositionException;
	
	////判断节点是否为根
	public boolean isRoot(Position<E> v) throws InvalidPositionException;
	
}
