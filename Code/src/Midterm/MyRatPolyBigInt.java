package Midterm;

public class MyRatPolyBigInt extends MyPolyBigInt{
	protected PolySLink quoSLink,remSLink;
	
	public MyRatPolyBigInt(){
		quoSLink=new PolySLink();
		remSLink=new PolySLink();
	}
	//�õ���ʽ
	public PolySLink getQuoSLink(){
		return quoSLink;
	}
	//�õ���ʽ
	public PolySLink getRemSLink(){
		return remSLink;
	}
	
	//����ʽ��������
	public void devidePoly(PolySLink fx,PolySLink gx){
		
		PolyNode fxCurrent=fx.getHead().getNext();//fxCurrentΪf(x)�еĵ�ǰ��
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrentΪg(x)�еĵ�ǰ��
		//PolyNode quoCurrent=quoSLink.getHead();//quoCurrentΪ�̵ĵ�ǰ��
		
		PolyNode tempQuoNode;//��ʱ�洢�̵�һ��
		MyBigInt BI=new MyBigInt();
		while (fxCurrent.getExp()>=gxCurrent.getExp()){
			tempQuoNode=new PolyNode();
			BI.devide(fxCurrent.getCoe(),gxCurrent.getCoe());
			tempQuoNode.setCoe(BI.getQuoBigInt());//����ʽ�������ϵ�����Գ�ʽ�������ϵ��Ϊ�̵������ϵ��
			tempQuoNode.setExp(fxCurrent.getExp()-gxCurrent.getExp());//����ʽ�������ָ����ȥ��ʽ�������ָ��Ϊ�̵������ָ��
			quoSLink.insert(tempQuoNode);//������ʱ���������
			
			//����һ��ֻ��head��tempQuoNode�ĵ�����
			PolySLink tempSLink = new PolySLink();
			tempSLink.insert(tempQuoNode);
			
			//��ʱ�̱�˳���
			super.ansSLink=new PolySLink();
			super.multiplyPoly(gx, tempSLink);
			
			//ʹ�� tempProduct�洢��˽��
			PolySLink tempProduct=new PolySLink();
			tempProduct=super.getAnsSLink();
			
			//��ǰ����ʽ-��˽��=�µı���ʽ
			super.ansSLink=new PolySLink();
			super.minusPoly(fx,tempProduct);
			fx=super.getAnsSLink();//�µı���ʽ
			fxCurrent=fx.getHead().getNext();//�µı���ʽ�ĵ�һ��������ϵ��һ��Ϊ0��
			
			while ((fxCurrent!=null) && fxCurrent.getCoe().arrayToString().equals("0") ) fxCurrent=fxCurrent.getNext();//ϵ��Ϊ0�������
			if (fxCurrent==null) break;
		}
		remSLink=fx;
		
	}
}
