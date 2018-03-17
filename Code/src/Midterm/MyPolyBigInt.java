package Midterm;
public class MyPolyBigInt extends MyBigInt implements IMyPolyBigInt{
	
	protected PolySLink ansSLink;
	 
	public MyPolyBigInt(){
		ansSLink=new PolySLink();
	}
	
	
	public PolySLink getAnsSLink(){
		return ansSLink;
	}
	
	//多项式加法
	public void addPoly(PolySLink fx,PolySLink gx){
		ansSLink=fx;
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrent为g(x)中的第一项
		while (gxCurrent!=null){
			ansSLink.insert(gxCurrent);
			gxCurrent=gxCurrent.getNext();
		}
	}
	
	//多项式减法
	public void minusPoly(PolySLink fx,PolySLink gx){
		ansSLink=fx;
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrent为g(x)中的当前项
		while (gxCurrent!=null){
			gxCurrent.opposeSign();//改变g(x)每一项系数的符号
			ansSLink.insert(gxCurrent);
			gxCurrent=gxCurrent.getNext();
		}
	}
	
	//多项式乘法
	public void multiplyPoly(PolySLink fx,PolySLink gx){
		PolyNode fxCurrent=fx.getHead().getNext();//fxCurrent为f(x)中的当前项
		PolyNode gxCurrent=gx.getHead().getNext();//gxCurrent为g(x)中的当前项
		
		while (fxCurrent!=null){
			gxCurrent=gx.getHead().getNext();
			while (gxCurrent!=null){
				PolyNode tempAnsNode=new PolyNode();//临时存储f(x),g(x)的各项相乘结果
				tempAnsNode.setCoe(multiply(fxCurrent.getCoe(),gxCurrent.getCoe()));
				tempAnsNode.setExp(fxCurrent.getExp()+gxCurrent.getExp());
				ansSLink.insert(tempAnsNode);
				gxCurrent=gxCurrent.getNext();
			}
			fxCurrent=fxCurrent.getNext();
		}
	}

	
		
		
	
}
