package Midterm;
public interface IMyBigInt {
	
	//�Ƚ������޷��Ŵ������Ĵ�С
	public byte compare(BigNumStruct bigInt1,BigNumStruct bigInt2);
	
	//�ӷ�����
	public BigNumStruct add(BigNumStruct bigInt1,BigNumStruct bigInt2); 

	//��������
	public BigNumStruct minus(BigNumStruct bigInt1,BigNumStruct bigInt2);
	
	//�˷�����
	public BigNumStruct multiply(BigNumStruct bigInt1,BigNumStruct bigInt2);
	
	//�������㣬�����̺�����
	public void devide(BigNumStruct bigInt1,BigNumStruct bigInt2) 
			throws ArithmeticException;
	
	//��������ֵ
	public BigNumStruct half(BigNumStruct a,BigNumStruct b);
	
	//��������������ʵ�ʳ���
	public void changArrayLen(BigNumStruct ans);
	
	//�����ת��Ϊ�ַ���
	public String getAns(BigNumStruct ansBigInt);
	
	//���ó�����������getQuoBigInt()�ɵõ��̣�
	public BigNumStruct getQuoBigInt();
	
	//���ó�����������getRemBigInt()�ɵõ�������
	public BigNumStruct getRemBigInt();
}
