
public interface IArrayIndexList<E> {
	public int size();//返回表中元素个数
	public boolean isEmpty();//判断表是否为空
	public void add(int r,E e);//在表中下标i处增加元素e；
	public E remove(int r);//移去表中坐标i处的元素；
	public E get(int i);//得到表中坐标i处的元素；
	public void set(int i, E e);//将表中坐标i处的元素改为新元素e；
}
