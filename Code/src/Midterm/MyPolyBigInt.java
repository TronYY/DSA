package Midterm;
public class MyPolyBigInt extends MyBigInt implements IMyPolyBigInt{
	
	protected PolySLink ansSLink;
	 
	public MyPolyBigInt(){
		ansSLink=new PolySLink();
	}
	
	
	public PolySLink getAnsSLink(){
		return ansSLink;
	}
	
	//����ʽ�ӷ�
	public void addPoly(PolySLink fx,PolySLink gx){
		ansSLink=fx;
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrentΪg(x)�еĵ�һ��
		while (gxCurrent!=null){
			ansSLink.insert(gxCurrent);
			gxCurrent=gxCurrent.getNext();
		}
	}
	
	//����ʽ����
	public void minusPoly(PolySLink fx,PolySLink gx){
		ansSLink=fx;
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrentΪg(x)�еĵ�ǰ��
		while (gxCurrent!=null){
			gxCurrent.opposeSign();//�ı�g(x)ÿһ��ϵ���ķ���
			ansSLink.insert(gxCurrent);
			gxCurrent=gxCurrent.getNext();
		}
	}
	
	//����ʽ�˷�
	public void multiplyPoly(PolySLink fx,PolySLink gx){
		PolyNode fxCurrent=fx.getHead().getNext();//fxCurrentΪf(x)�еĵ�ǰ��
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrentΪg(x)�еĵ�ǰ��
		
		while (fxCurrent!=null){
			gxCurrent=gx.getHead().getNext();
			while (gxCurrent!=null){
				PolyNode tempAnsNode=new PolyNode();//��ʱ�洢f(x),g(x)�ĸ�����˽��
				tempAnsNode.setCoe(multiply(fxCurrent.getCoe(),gxCurrent.getCoe()));
				tempAnsNode.setExp(fxCurrent.getExp()+gxCurrent.getExp());
				ansSLink.insert(tempAnsNode);
				gxCurrent=gxCurrent.getNext();
			}
			fxCurrent=fxCurrent.getNext();
		}
	}

	
		
		
	
}
