package Midterm;
import java.util.Arrays;
/*
 * Java��  ��int��ΧΪ-2147483648~2147483648��Ϊ�˳�����ÿռ䣬���㷨����1��000��000��000���ƣ��������������Ĵ洢ʹ��int�����飻
 */
public class BigNumStruct implements Cloneable{
	protected static final int STEP=9,MAX_INT=1000000000;//STEPΪÿ�����鵥Ԫ���ܴ�����λ����MAX_INTΪÿ�����鵥Ԫ���ܴ�������
	protected StringBuffer strBI;//�ַ����ʹ�������������;����Ҫ������źͿ�ͷ��0������Ϊ�ɱ��ַ�����
	protected byte sign;//�������������ԣ���������ʱsign=' ';����ʱ��sign='-';
	protected int size;//�޷��Ŵ������ĳ���
	protected int arrayLen;//��¼ʵ�����鳤�ȣ���Ϊ��Arrays��length�õ��Ŀ��ܻ��ʵ�ʴ洢���������鳤�ȶ�һλ�����Ա�������һ������arrayLen��
	protected int[] array;//�洢����������������ʽ�洢����������λ

	
	//�޲ι��췽�������ڴ˴��Կ���ָ�����ȵ�����
	public BigNumStruct(){
		strBI=new StringBuffer();
		sign=1;
		size=1;
		arrayLen=1;
		//cloneFlag=0;
	}
	
	//�вι��췽��������ʱΪ�ַ����������ַ���������
	public BigNumStruct(StringBuffer s){
		strBI=s;
		if (strBI.indexOf("-")==0){
			sign=-1;
			strBI.replace(0,1,"");//�������õ���ʹ���ַ�����Ϊ�޷�������
		}
		else sign=1;
		//�����ͷ����Ч0
		while ((strBI.indexOf("0")==0)&&(strBI.length()>1) )
			strBI.replace(0,1,"");
		
		size=strBI.length();
		
		//��������Ĵ��������ȣ�����ָ�����ȵ�����
		array=new int[(size-1)/STEP+1];//��������9876543210����������int��Ԫ���ʿ��ٵĳ���Ϊ(size-1)/STEP+1
		
		//stringToArray
		int i=0,l,r;//iָ�����飻
		r=size;
		l=r-STEP>0?r-STEP:0;
		while (r>0){
			//substring()ȡ���±�Ϊl��index<r֮����Ӵ���parseInt()ʹ�������ַ���תΪint��
			array[i]=Integer.parseInt(strBI.substring(l,r));
			r=r-STEP;
			l=r-STEP>0?r-STEP:0;
			i++;
		}
		
		//��¼���鳤��
		arrayLen=i;
	
	}
	
	//�вι��췽��������ָ�����ȵ����飬һ��Ϊ�洢���������
	public BigNumStruct(int length){
		strBI=new StringBuffer("");
		array=new int[length];
		arrayLen=length;
		sign=1;
		size=1;
		Arrays.fill(array, 0);
		//cloneFlag=0;
	}
	
	public StringBuffer getStrBI(){
		return strBI;
	}
	public byte getSign(){
		return sign;
	}
	public int size(){
		return size;
	}
	public int getArrayLen(){
		return arrayLen;
	}
	public int getArray(int i){
		return array[i];
	}
	public int[] getArray(){
		return array;
	}
	/*public byte getCloneFlag(){
		return cloneFlag;
	}*/
	
	public void appendStrBI(int newInt){
		strBI.append(newInt);
	}
	public void setSign(byte newSign){
		sign=newSign;
	}
	public void setSize(int newSize){
		size=newSize;
	}
	public void setArrayLen(int newLen){
		arrayLen=newLen;
	}
	public void setArray(int i,int newEle){
		array[i]=newEle;
	}
	/*public void setCloneFlag(byte newCF){
		cloneFlag=newCF;
	}*/
	
	//�����Ƚ�StringBuffer��String�Ƿ���ȣ����ж�������Ƿ�Ϊ0������ΪStringBuffer��δ��дequals()�������Ƚϵ��ǵ�ַ�Ƿ���ȣ��ʴ˴���дStringBuffer���equals()����
	public boolean equals(String s2){
		String s1=new String(strBI);
		return s1.equals(s2);
	}
	
	
	//�����������洢�������У�arrayToString()���Խ������е�����ȡ����ת��Ϊ�ַ���
	public String arrayToString(){
		strBI.replace(0,size,"");
		if (getSign()==-1) strBI.append('-');
		int i=arrayLen-1;
		strBI.append(array[i]);//��λ��ֱ�Ӹ��Ƶ��ַ���
		
		i--;
		//ʮ�ڽ��ƣ�����λ��Ҫ���㣻
		for (;i>=0;i--){
			if (getArray(i)<100000000) strBI.append(0);
			if (getArray(i)<10000000) strBI.append(0);
			if (getArray(i)<1000000) strBI.append(0);
			if (getArray(i)<100000) strBI.append(0);
			if (getArray(i)<10000) strBI.append(0);
			if (getArray(i)<1000) strBI.append(0);
			if (getArray(i)<100) strBI.append(0);
			if (getArray(i)<10) strBI.append(0);
			appendStrBI(getArray(i));
		}
		size=strBI.length();
		return strBI.toString();
				
			
	}
	//��¡��Ϊ�˲��ı�ԭ��	
	public BigNumStruct clone(){
		BigNumStruct bI = null; 
		try {
			bI=(BigNumStruct)super.clone();  
	    }
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	    return bI;
	}
		
		
}
	
	
	
	
	
	


