package Midterm;

public interface IMyPolyBigInt {
	//返回结果
	public PolySLink getAnsSLink();
	
	//多项式加法
	public void addPoly(PolySLink fx,PolySLink gx);
	
	//多项式减法
	public void minusPoly(PolySLink fx,PolySLink gx);
	
	//多项式乘法
	public void multiplyPoly(PolySLink fx,PolySLink gx);
	
	
	

}
