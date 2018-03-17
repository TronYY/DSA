package Midterm;
public class PolySLink extends MyBigInt implements IPolySLink {
	protected PolyNode head;//ͷ�ڵ�
	protected long size;//������
	
	public PolySLink(){
		head=new PolyNode(); 
	    size=0;
	}
	//�����Ƿ�Ϊ��
	public boolean isEmpty(){   
        return size==0;  
    }
	
	public PolyNode getHead(){
		return head;
	}
	
	public long getSize(){
		return size;
	}
	
	
	//��prePolyNode�����ӽڵ�newPolyNode
	public void addAfter(PolyNode prePolyNode,PolyNode newPolyNode){    
        newPolyNode.setNext(prePolyNode.getNext());
        prePolyNode.setNext(newPolyNode);  
        size++;
    }
	
	//��һ���½ڵ�newPolyNode���뵽��������,����ָ���Ӹߵ�������
	public void insert(PolyNode newPolyNode){
		PolyNode p,r;
		r=head;//rΪp��ǰ���ڵ�
		p=head.getNext();//pָ��Ϊ��ǰ�ڵ�
		long e=newPolyNode.getExp();
		while ((p!=null)&&(p.getExp()>=e)){
			r=p;
			p=p.getNext();
		}
		
		//ϵ����ȣ���ָ����ӣ��������½ڵ�
		if ((e==r.getExp())&&(r!=head))
			r.setCoe(add(r.getCoe(),newPolyNode.getCoe().clone()));	
		//����嵽r֮��
		else {
			addAfter(r,newPolyNode);
		}
	}
	
	public String toString()
	{
		String s=new String();
		PolyNode p=head.getNext();
		
		while (p!=null){
			//ϵ����Ϊ0��Ҫ���
			if (!p.getCoe().equals("0")){
				//������ͷǳ�����ֱ����
				//�ǳ�����
				if (p.getExp()!=0){
					//�������
					if (p.getCoe().getSign()==1) s=s+"+";
					//�ǳ������ϵ��1�������
					if (!p.getCoe().equals("1")) s=s+p.getCoe().arrayToString();
					s=s+"x";
					//ָ��Ϊ1,1�������
					if (p.getExp()!=1) s=s+"^"+p.getExp();
					
				}
				//������
				else{
					if (p.getCoe().getSign()==1) s=s+"+";
					
					s=s+p.getCoe().arrayToString();
				}		
				
			}	
			p=p.getNext();
		}
		if (s.equals("")) return "0";
		//����+�Ų����
		if (s.charAt(0)=='+') return s.substring(1,s.length());
		else return s;
	}

}
