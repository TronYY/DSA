package Midterm;
public class PolySLink extends MyBigInt implements IPolySLink {
	protected PolyNode head;//头节点
	protected long size;//链表长度
	
	public PolySLink(){
		head=new PolyNode(); 
	    size=0;
	}
	//链表是否为空
	public boolean isEmpty(){   
        return size==0;  
    }
	
	public PolyNode getHead(){
		return head;
	}
	
	public long getSize(){
		return size;
	}
	
	
	//在prePolyNode后增加节点newPolyNode
	public void addAfter(PolyNode prePolyNode,PolyNode newPolyNode){    
        newPolyNode.setNext(prePolyNode.getNext());
        prePolyNode.setNext(newPolyNode);  
        size++;
    }
	
	//将一个新节点newPolyNode插入到单链表中,按照指数从高到低排列
	public void insert(PolyNode newPolyNode){
		PolyNode p,r;
		r=head;//r为p的前驱节点
		p=head.getNext();//p指向为当前节点
		long e=newPolyNode.getExp();
		while ((p!=null)&&(p.getExp()>=e)){
			r=p;
			p=p.getNext();
		}
		
		//系数相等，则指数相加，不产生新节点
		if ((e==r.getExp())&&(r!=head))
			r.setCoe(add(r.getCoe(),newPolyNode.getCoe().clone()));	
		//否则插到r之后
		else {
			addAfter(r,newPolyNode);
		}
	}
	
	public String toString()
	{
		String s=new String();
		PolyNode p=head.getNext();
		
		while (p!=null){
			//系数不为0需要输出
			if (!p.getCoe().equals("0")){
				//常数项和非常数项分别操作
				//非常数项
				if (p.getExp()!=0){
					//先输符号
					if (p.getCoe().getSign()==1) s=s+"+";
					//非常数项的系数1不必输出
					if (!p.getCoe().equals("1")) s=s+p.getCoe().arrayToString();
					s=s+"x";
					//指数为1,1不必输出
					if (p.getExp()!=1) s=s+"^"+p.getExp();
					
				}
				//常数项
				else{
					if (p.getCoe().getSign()==1) s=s+"+";
					
					s=s+p.getCoe().arrayToString();
				}		
				
			}	
			p=p.getNext();
		}
		if (s.equals("")) return "0";
		//首项+号不输出
		if (s.charAt(0)=='+') return s.substring(1,s.length());
		else return s;
	}

}
