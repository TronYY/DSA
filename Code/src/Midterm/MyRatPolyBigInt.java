package Midterm;

public class MyRatPolyBigInt extends MyPolyBigInt{
	protected PolySLink quoSLink,remSLink;
	
	public MyRatPolyBigInt(){
		quoSLink=new PolySLink();
		remSLink=new PolySLink();
	}
	//得到商式
	public PolySLink getQuoSLink(){
		return quoSLink;
	}
	//得到余式
	public PolySLink getRemSLink(){
		return remSLink;
	}
	
	//多项式除法运算
	public void devidePoly(PolySLink fx,PolySLink gx){
		
		PolyNode fxCurrent=fx.getHead().getNext();//fxCurrent为f(x)中的当前项
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrent为g(x)中的当前项
		//PolyNode quoCurrent=quoSLink.getHead();//quoCurrent为商的当前项
		
		PolyNode tempQuoNode;//临时存储商的一项
		MyBigInt BI=new MyBigInt();
		while (fxCurrent.getExp()>=gxCurrent.getExp()){
			tempQuoNode=new PolyNode();
			BI.devide(fxCurrent.getCoe(),gxCurrent.getCoe());
			tempQuoNode.setCoe(BI.getQuoBigInt());//被除式的最高项系数除以除式的最高项系数为商的最高项系数
			tempQuoNode.setExp(fxCurrent.getExp()-gxCurrent.getExp());//被除式的最高项指数减去除式的最高项指数为商的最高项指数
			quoSLink.insert(tempQuoNode);//将该临时点放入商中
			
			//构造一条只含head和tempQuoNode的单链表
			PolySLink tempSLink = new PolySLink();
			tempSLink.insert(tempQuoNode);
			
			//临时商遍乘除数
			super.ansSLink=new PolySLink();
			super.multiplyPoly(gx, tempSLink);
			
			//使用 tempProduct存储遍乘结果
			PolySLink tempProduct=new PolySLink();
			tempProduct=super.getAnsSLink();
			
			//当前被除式-遍乘结果=新的被除式
			super.ansSLink=new PolySLink();
			super.minusPoly(fx,tempProduct);
			fx=super.getAnsSLink();//新的被除式
			fxCurrent=fx.getHead().getNext();//新的被除式的第一项，但此项的系数一定为0；
			
			while ((fxCurrent!=null) && fxCurrent.getCoe().arrayToString().equals("0") ) fxCurrent=fxCurrent.getNext();//系数为0，则后移
			if (fxCurrent==null) break;
		}
		remSLink=fx;
		
	}
}
