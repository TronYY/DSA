package Midterm;


public class MyBigInt implements IMyBigInt {
	protected static final int MAX_INT=1000000000;//MAX_INTΪÿ�����鵥Ԫ���ܴ�������
	protected BigNumStruct bigInt1,bigInt2;//Ϊ��������
	protected BigNumStruct quoBigInt,remBigInt;//���ڳ�������������ֵ���̣��������ʳ�����������Ϊ���������������������Ϊȫ�ֱ���
	
	public MyBigInt(){}/**/
	
	//��Щ��������ֻ��һ����������׳�
	public MyBigInt(StringBuffer para1){
		bigInt1=new BigNumStruct(para1);
	}
	
	//��������Ĺ��췽������Ԫ��������Ӽ��˳�
	public MyBigInt(StringBuffer para1,StringBuffer para2){
		bigInt1=new BigNumStruct(para1);
		bigInt2=new BigNumStruct(para2);
	}
	
	public BigNumStruct getBigInt1(){
		return bigInt1;
	}
	public BigNumStruct getBigInt2(){
		return bigInt2;
	}
	public BigNumStruct getQuoBigInt(){
		return quoBigInt;
	}
	public BigNumStruct getRemBigInt(){
		return remBigInt;
	}
	
	
	//�Ƚ������޷��Ŵ������Ĵ�С
	//bigInt1>bigInt2 ����1��bigInt1<bigInt2 ����-1��bigInt1=bigInt2 ����0��
	public byte compare(BigNumStruct bigInt1,BigNumStruct bigInt2){
		if (bigInt1.getArrayLen()>bigInt2.getArrayLen()) return 1;
		if (bigInt1.getArrayLen()<bigInt2.getArrayLen()) return -1;
		for (int i=bigInt1.getArrayLen()-1; i>=0; i--){
			if (bigInt1.getArray(i)>bigInt2.getArray(i)) return 1;
			if (bigInt1.getArray(i)<bigInt2.getArray(i)) return -1;
		}
		return 0;
	}
	
	//�ӷ���Ϊ������ͬ�ļӷ������Ų�ͬ�ļӷ�
	public BigNumStruct add(BigNumStruct bigInt1,BigNumStruct bigInt2) {
		BigNumStruct ansBigInt=new BigNumStruct();
		
		//���bigInt1<bigInt2,�򽻻�(���õĽ�����ʱ�临�ӶȽ�ΪO(1)),
		//��֤�޷���λbigInt1>bigInt2,���Լ��ٴ������д���������ں�������
		Byte ansCompare;
		ansCompare=compare(bigInt1,bigInt2);
		if (ansCompare<0) {BigNumStruct bigIntTemp = bigInt1;bigInt1=bigInt2;bigInt2=bigIntTemp;}
		
		//�������һ��Ϊ0������������һ��������
		if (bigInt2.equals("0")){
			ansBigInt=bigInt1.clone();
			//ansBigInt.setCloneFlag((byte)(1));
			return ansBigInt;
		}
		
		
		//������ͬ�ļӷ�,��  a+b��(-a)+(-b),  (a��0��b��0)����������ͬ���Ƚ�����ӣ��ϴ�����ʣ�೤��ֱ�ӷ�������
		if (bigInt1.getSign()==bigInt2.getSign()){
			
			//�洢��������ݽṹ
			ansBigInt=new BigNumStruct(bigInt1.getArrayLen()+1);
			ansBigInt.setSign(bigInt1.getSign());
			
			//�����Ѿ���֤���޷���λbigInt1>bigInt2���Ƚ��г��Ƚ϶̵�bigInt2һ�γ��ȵ����
			int carry=0,tempSum=0,i;//carry��¼��λ��tempSumΪÿһ�����鵥Ԫ����ʱ�ͣ�iΪָ��������±�
			for(i=0;i<bigInt2.getArrayLen();i++){
				tempSum=bigInt1.getArray(i)+bigInt2.getArray(i)+carry;
				ansBigInt.setArray(i,tempSum % MAX_INT);
				carry=tempSum /MAX_INT;
			}
			//����bigInt1ʣ�೤�ȵļ���
			for (;i<bigInt1.getArrayLen();i++){
				tempSum=bigInt1.getArray(i)+carry;
				ansBigInt.setArray(i,tempSum % MAX_INT);
				carry=tempSum /MAX_INT;
			}
			if (carry!=0){
				ansBigInt.setArray(i,carry);
				i++;
			}
			//��¼ʵ�����鳤��
			ansBigInt.setArrayLen(i);
			return ansBigInt;
		}
		
		//���Ų�ͬ�ļӷ�,�� a+(-b), (-a)+b, (a>0��b>0)
		else{
			//���Ų�ͬ�������ļӷ��������˵�Ǽ�����
			//���ڲ�֪���ĸ�����������������ܻ���ָ�λ�Ǹ��������⣻Ϊ�˼��ٶԿ��ܽ���ķ������ۣ������Ѿ��������������޷���λ���бȽϣ������Ϊ��������С����Ϊ�����������������������ָ�λΪ���������⣻
			
			
			
			
			//������ȣ�����Ϊ0��ֱ�ӷ���
			if (ansCompare==0){
				ansBigInt=new BigNumStruct(1);
				return ansBigInt;
			}
			
			//�洢��������ݽṹ
			ansBigInt=new BigNumStruct(bigInt1.getArrayLen());
			ansBigInt.setSign(bigInt1.getSign());//����ķ���һ���뱻�����ķ�����ͬ
			
			//�Ƚ���bigInt2һ�γ��ȵ����
			int borrow=0,tempResult=0,i;//borrow��¼��λ��tempResultΪÿһ�����鵥Ԫ����ʱ�iΪָ��������±�
			for(i=0;i<bigInt2.getArrayLen();i++){
				tempResult=bigInt1.getArray(i)-bigInt2.getArray(i)-borrow;
				if (tempResult<0) {
					borrow=1;//��λ
					tempResult+=MAX_INT;
				}
				else borrow=0;
				ansBigInt.setArray(i, tempResult);
			}
			//����bigInt1ʣ�೤�ȵļ���
			for (;i<bigInt1.getArrayLen();i++){
				tempResult=bigInt1.getArray(i)-borrow;
				if (tempResult<0) {
					borrow=1;//��λ
					tempResult+=MAX_INT;
				}
				else borrow=0;
				ansBigInt.setArray(i, tempResult);
			}
			
			this.changArrayLen(ansBigInt);
			return ansBigInt;			
		}
	}
	
	//������ֻ��Ķ������ķ��ţ��ٰ��ռӷ�����
	public BigNumStruct minus(BigNumStruct bigInt1,BigNumStruct bigInt2){
		
		bigInt2.setSign((byte) -bigInt2.getSign());
		return(this.add(bigInt1,bigInt2));
	}
	
	//�˷�����ͬ����˷���
	//����ѭ����bigInt1[i]��bigInt2[j]�Ľ���ۼ���ansBigInt[i+j]��
	public BigNumStruct multiply(BigNumStruct bigInt1,BigNumStruct bigInt2){
		BigNumStruct ansBigInt=new BigNumStruct();
		
		ansBigInt=new BigNumStruct(bigInt1.getArrayLen()+bigInt2.getArrayLen());//���ĳ������Ϊ���������ĳ��Ⱥ�
		
		//��һ��Ϊ0������Ϊ0
		if (bigInt1.equals("0")){
			ansBigInt=bigInt1.clone();
			//ansBigInt.setCloneFlag((byte)(1));
			return ansBigInt;	
		}
		else if (bigInt2.equals("0")){
			ansBigInt=bigInt2.clone();
			//ansBigInt.setCloneFlag((byte)(1));
			return ansBigInt;	
		}
		
		ansBigInt.setSign((byte) (bigInt1.getSign()*bigInt2.getSign()));//����ķ��ţ�����byte�����Ϊ���Ϊint����ǿ��ת��
		
		//�������+��λ+���л� ���������Ƿ���Ҫlong����ʱ���������Ǽ���������������+��λ+���л�=(10^9-1)*(10^9-1)+(10^9-1)+(10^9-1)=10^18-1>Integer.MAX_VALUE,����Ҫ
		long carry=0,tempResult=0;
		int i,j;//i,jΪ����������������±�
		for (i=0;i<bigInt1.getArrayLen();i++){
			carry=0;
			for (j=0;j<bigInt2.getArrayLen();j++){
				tempResult=(long)(bigInt1.getArray(i))*(long)(bigInt2.getArray(j))+carry+(long)(ansBigInt.getArray(i+j));//�������+��λ+���л�,����ǿ��ת��
				carry=tempResult /MAX_INT;
				ansBigInt.setArray(i+j,(int) (tempResult % MAX_INT));			
			}
			if (carry!=0)
				ansBigInt.setArray(i+j,(int) (carry));
		}
		
		this.changArrayLen(ansBigInt);
		return ansBigInt;	
	}
	
	
	//����
	public void devide(BigNumStruct bigInt1,BigNumStruct bigInt2) throws ArithmeticException{
		
		
		if (bigInt2.equals("0")) throw new ArithmeticException("����Ϊ0�����Ͻ�һ���ô��");
		StringBuffer ze=new StringBuffer("0");
		BigNumStruct zero=new BigNumStruct(ze);//BigNumStruct ���㣻
		
		//������Ϊ0������Ϊ0���������ڳ���
		if (bigInt1.equals("0")){
			
			quoBigInt=zero.clone();
			remBigInt=bigInt2.clone();
			//remBigInt.setCloneFlag((byte)(1));
			return;
		}
		
		//����Ϊ��1���̵��ڱ�����������Ϊ0��
		if (bigInt2.equals("1")){
			
			quoBigInt=bigInt1.clone();
			quoBigInt.setSign((byte) (bigInt1.getSign()*bigInt2.getSign()));
			remBigInt=zero.clone();
			return;
		}
		
		
		quoBigInt=new BigNumStruct(bigInt1.getArrayLen()-bigInt2.getArrayLen()+1);//�̵ĳ���
		quoBigInt.setSign((byte) (bigInt1.getSign()*bigInt2.getSign()));//����ͬ�ţ���Ϊ��������Ϊ��
		remBigInt=new BigNumStruct(bigInt2.getArrayLen());//�����ĳ����ܡܳ���
		remBigInt.setSign((byte) (bigInt1.getSign()));//�����ķ��źͱ�������ͬ
		
		//���ַ��ҳ���
		//�����������̵ķ����Ѿ�ȷ����ʣ�µĳ���Ϊ�޷�������
		bigInt1.setSign((byte) 1);
		bigInt2.setSign((byte) 1);
		
		StringBuffer oneS=new StringBuffer("1");
		BigNumStruct one=new BigNumStruct(oneS);
		BigNumStruct low=one.clone();//�½�Ϊ1
		BigNumStruct high=bigInt1.clone();//�Ͻ�Ϊ������
		BigNumStruct mid=new BigNumStruct();
		BigNumStruct tempBigInt1=new BigNumStruct(bigInt1.getArrayLen());//�����뱻�����Ƚ�
		
		
		do{
			mid=half(low,high).clone();//midΪ��ʱ�������
			tempBigInt1=multiply(mid,bigInt2).clone();
		
			int ansCompare=compare(tempBigInt1,bigInt1);
			if (ansCompare==0){
				quoBigInt.array=mid.getArray().clone();/**/
				
				remBigInt=zero.clone();
				return;
			}
			else if (ansCompare<0)
				low=this.add(mid,one.clone());//���ڲ������ݵ��ǵ�ַ�����ڼ���������ı�one����λ1�Ĵ�����ʽ���ķ���ֵ��Ϊ��ʹone���䣬ʹ��clone()������
			else 
				high=this.minus(mid,one.clone());	
		}while (compare(low,high)<=0);
		
		tempBigInt1=multiply(mid,bigInt2);//midΪ�������ַ�����ʱ��ӽ��̵���
		//�Ե���������
		if (compare(tempBigInt1,bigInt1)<=0){
			quoBigInt=mid.clone();
			remBigInt=minus(bigInt1,tempBigInt1.clone());
		}
		//�Եõ��̹������һ
		else{
			quoBigInt=minus(mid,one.clone());
			remBigInt=minus(bigInt1,minus(tempBigInt1,bigInt2.clone()));//���������ʱ��������-����=��ʵ��*������
		}	
		
		this.changArrayLen(quoBigInt);
		this.changArrayLen(remBigInt);
	}
	
	//����ֵ
	public BigNumStruct half(BigNumStruct a,BigNumStruct b){
		BigNumStruct temp=add(a,b);
		int i=temp.getArrayLen()-1,t=0;
		for (;i>0;i--){
			t=temp.getArray(i);
			temp.setArray(i, t/2);
			if (t%2==1) temp.setArray(i-1, temp.getArray(i-1)+MAX_INT);
		}
		temp.setArray(0,temp.getArray(0)/2);
		
		//ʵ�ʳ���
		this.changArrayLen(temp);
		return temp;	
	}
	
	//��������������ʵ�ʳ���
	public void changArrayLen(BigNumStruct ans){
		int i;
		i=ans.getArrayLen()-1;
		while(ans.getArray(i)==0 && i>0) i--;
		ans.setArrayLen(i+1);
	}
	
	//�����ת��Ϊ�ַ���
	public String getAns(BigNumStruct ansBigInt){
		return ansBigInt.arrayToString();
	}
				
}

	
	
	
	
	
	
	
	
	
	


