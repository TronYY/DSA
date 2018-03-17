package Midterm;
public interface IMyBigInt {
	
	//比较两个无符号大整数的大小
	public byte compare(BigNumStruct bigInt1,BigNumStruct bigInt2);
	
	//加法计算
	public BigNumStruct add(BigNumStruct bigInt1,BigNumStruct bigInt2); 

	//减法计算
	public BigNumStruct minus(BigNumStruct bigInt1,BigNumStruct bigInt2);
	
	//乘法计算
	public BigNumStruct multiply(BigNumStruct bigInt1,BigNumStruct bigInt2);
	
	//除法计算，产生商和余数
	public void devide(BigNumStruct bigInt1,BigNumStruct bigInt2) 
			throws ArithmeticException;
	
	//求两数中值
	public BigNumStruct half(BigNumStruct a,BigNumStruct b);
	
	//求出大数的数组的实际长度
	public void changArrayLen(BigNumStruct ans);
	
	//将结果转化为字符串
	public String getAns(BigNumStruct ansBigInt);
	
	//调用除法过后，再用getQuoBigInt()可得到商；
	public BigNumStruct getQuoBigInt();
	
	//调用除法过后，再用getRemBigInt()可得到余数；
	public BigNumStruct getRemBigInt();
}
