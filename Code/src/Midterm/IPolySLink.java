package Midterm;
//����ʽ����ṹ
public interface IPolySLink {
	//�����Ƿ�Ϊ��
	public boolean isEmpty();
	
	public PolyNode getHead();

	public long getSize();
	
	//��prePolyNode�����ӽڵ�newPolyNode
	public void addAfter(PolyNode prePolyNode,PolyNode newPolyNode);
	
	//��һ���½ڵ�newPolyNode���뵽��������,����ָ���Ӹߵ�������
	public void insert(PolyNode newPolyNode);
	
	//������ת��Ϊ����ʽ��ʽ���ַ���
	public String toString();
}
