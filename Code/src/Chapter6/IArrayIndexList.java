
public interface IArrayIndexList<E> {
	public int size();//���ر���Ԫ�ظ���
	public boolean isEmpty();//�жϱ��Ƿ�Ϊ��
	public void add(int r,E e);//�ڱ����±�i������Ԫ��e��
	public E remove(int r);//��ȥ��������i����Ԫ�أ�
	public E get(int i);//�õ���������i����Ԫ�أ�
	public void set(int i, E e);//����������i����Ԫ�ظ�Ϊ��Ԫ��e��
}
