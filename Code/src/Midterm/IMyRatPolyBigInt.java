package Midterm;

public interface IMyRatPolyBigInt {
	//得到商式
	public PolySLink getQuoSLink();
	
	//得到余式
	public PolySLink getRemSLink();
	
	//多项式除法运算
	public void devidePoly(PolySLink fx,PolySLink gx);
}
