package Midterm;
//多项式链表结构
public interface IPolySLink {
	//链表是否为空
	public boolean isEmpty();
	
	public PolyNode getHead();

	public long getSize();
	
	//在prePolyNode后增加节点newPolyNode
	public void addAfter(PolyNode prePolyNode,PolyNode newPolyNode);
	
	//将一个新节点newPolyNode插入到单链表中,按照指数从高到低排列
	public void insert(PolyNode newPolyNode);
	
	//将链表转化为多项式形式的字符串
	public String toString();
}
