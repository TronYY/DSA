import java.util.Iterator;


public interface ITree<E> {
	//���ؽڵ����
	public int size();
	
	//�ж����Ƿ�Ϊ��
	public boolean isEmpty();
	
	//���õ������������еĽڵ�
	public Iterator<E> iterator();
	
	public Iterator<Position<E>> position();
	
	//�滻ĳһ�ڵ�Ĵ���Ԫ��
	public E replace(Position<E> v,E e) throws InvalidPositionException;
	
	//�������ĸ�
	public Position<E> root() throws EmptyTreeException;
	
	//���ظ��ڵ�
	public Position<E> parent(Position<E> v) throws InvalidPositionException,BoundaryViolationException;
	
	//�����ӽڵ�
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
	
	//�жϽڵ��Ƿ�Ϊ�ڲ��ڵ�
	public boolean isInternal(Position<E> v) throws InvalidPositionException;
	
	//�жϽڵ��Ƿ�Ϊ�ⲿ�ڵ�
	public boolean isExternal(Position<E> v) throws InvalidPositionException;
	
	////�жϽڵ��Ƿ�Ϊ��
	public boolean isRoot(Position<E> v) throws InvalidPositionException;
	
}
