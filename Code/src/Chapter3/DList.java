
public class DList<E> {
	protected int size;//Ԫ������
	protected DNode<E> header;
	//���췽��
	public DList(){
		size=0;
		header=new DNode<E>(null,null,null);	//ͷ�ڵ��ʼ��
	}
	public int size(){return size;}//�õ�Ԫ��������
	public boolean isEmpty(){return size==0;}//�ж��Ƿ�Ϊ�գ����򷵻�TRUE��
	public DNode<E> getPrev(DNode<E> v){return v.getPrev();}//�õ�v��ǰ���ڵ㣻
	public DNode<E> getNext(DNode<E> v){return v.getNext();}//�õ�v�ĺ�̽ڵ㣻
	public DNode<E> getHeader(){return header;}//�õ�˫��ѭ�������ͷ�ڵ�
	
	
	//�ڴ�ͷ�ڵ��˫��ѭ��������Ѱ�ҵ�i���ڵ㣬�ҳ����ظýڵ㣻
	public DNode<E> getDNodeI(int i) throws IllegalStateException{
		if (isEmpty()) throw new IllegalStateException("List is empty");
		if ((i>size()+1)||(i<1)) throw new IllegalStateException("i is invalid.");
		int k=1;//k��ͷ��㿪ʼ������ֱ���ҵ���i���ڵ㣻
		DNode<E> p=header;//pΪ����ָ��
		while (k<i){
			k++;
			p=p.getNext();
		}//��i=size+1ʱ������ָ���ٴ�ָ��header 
		return p;
	}
	
	
	//��header�ڵ��д�ֵ
	public void addFirst(E ele){
		header.setElement(ele);
		//ֻ��һ��Ԫ��ʱ��ǰ��ڵ㶼Ϊ�䱾����Ҫ���ú�prev��nextֵ����ֹ����NullPointException�쳣
		header.setNext(header);
		header.setPrev(header);
		size++;
	}
	
	
	//�ڴ�ͷ�ڵ��˫��ѭ�������λ��iǰ�����½ڵ�v��
	public void addBefore(int i,E ele){
		DNode<E> y=getDNodeI(i);//yΪ��i���ڵ㣻
		DNode<E> x=y.getPrev();//xΪ��i-1���ڵ㣻
		DNode<E> v=new DNode<E>(ele,null,null) ;
		v.setPrev(x);
		v.setNext(y);
		y.setPrev(v);
		x.setNext(v);
		size++;//����1��
	}
	
	
	//�ڴ�ͷ�ڵ��˫��ѭ��������ɾ����i��λ���ϵĽڵ�
	public void remove(int i){
		DNode<E> v=getDNodeI(i);//vΪ��i���ڵ㣻
		DNode<E> y=v.getNext();
		DNode<E> x=v.getPrev();
		y.setPrev(x);
		x.setNext(y);
		//v��ǰ��ָ����Ϊ�գ�
		v.setPrev(null);
		v.setNext(null);
		size--;//����1��
	}
	
	//�����ͷ�ڵ��˫��ѭ�������е�Ԫ�أ�
	public String toString(String s){
		DNode<E> v=getHeader();
		int k=1;//kͳ�������Ԫ�صĸ���
		while (k<=size()){
			s=s+v.getElement()+" ";
			v=v.getNext();
			k++;
		}
		return s;
	}
	
	public void freeDList(){
		DNode<E> q=getHeader(),p;
		do{
			p=q;
			p.setPrev(null);
			p.setElement(null);
			q=p.getNext();
			p.setNext(null);
		}while (q!=null);
	}
}
