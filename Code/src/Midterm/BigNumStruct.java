package Midterm;
import java.util.Arrays;
/*
 * Java中  ，int范围为-2147483648~2147483648，为了充分利用空间，本算法采用1，000，000，000进制；输入的运算参数的存储使用int型数组；
 */
public class BigNumStruct implements Cloneable{
	protected static final int STEP=9,MAX_INT=1000000000;//STEP为每个数组单元中能存的最大位数，MAX_INT为每个数组单元中能存的最大数
	protected StringBuffer strBI;//字符串型大整数，含符号;由于要处理符号和开头的0所以设为可变字符串型
	protected byte sign;//大整数的正负性，正数和零时sign=' ';负数时，sign='-';
	protected int size;//无符号大整数的长度
	protected int arrayLen;//记录实际数组长度，因为用Arrays。length得到的可能会比实际存储了数的数组长度多一位，所以必须再设一个变量arrayLen；
	protected int[] array;//存储大整数，以数组形式存储，不含符号位

	
	//无参构造方法，不在此处对开辟指定长度的数组
	public BigNumStruct(){
		strBI=new StringBuffer();
		sign=1;
		size=1;
		arrayLen=1;
		//cloneFlag=0;
	}
	
	//有参构造方法，输入时为字符串，根据字符串来构造
	public BigNumStruct(StringBuffer s){
		strBI=s;
		if (strBI.indexOf("-")==0){
			sign=-1;
			strBI.replace(0,1,"");//将负号拿掉，使得字符串变为无符号整数
		}
		else sign=1;
		//清除开头的无效0
		while ((strBI.indexOf("0")==0)&&(strBI.length()>1) )
			strBI.replace(0,1,"");
		
		size=strBI.length();
		
		//根据输入的大整数长度，开辟指定长度的数组
		array=new int[(size-1)/STEP+1];//例如数字9876543210，需用两个int单元；故开辟的长度为(size-1)/STEP+1
		
		//stringToArray
		int i=0,l,r;//i指向数组；
		r=size;
		l=r-STEP>0?r-STEP:0;
		while (r>0){
			//substring()取出下标为l≤index<r之间的子串；parseInt()使得数字字符串转为int型
			array[i]=Integer.parseInt(strBI.substring(l,r));
			r=r-STEP;
			l=r-STEP>0?r-STEP:0;
			i++;
		}
		
		//记录数组长度
		arrayLen=i;
	
	}
	
	//有参构造方法，开辟指定长度的数组，一般为存储结果来开辟
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
	
	//用来比较StringBuffer与String是否相等（如判断输入的是否为0），因为StringBuffer类未重写equals()方法，比较的是地址是否相等；故此处重写StringBuffer类的equals()方法
	public boolean equals(String s2){
		String s1=new String(strBI);
		return s1.equals(s2);
	}
	
	
	//大数运算结果存储在数组中，arrayToString()可以将数组中的数提取出来转化为字符串
	public String arrayToString(){
		strBI.replace(0,size,"");
		if (getSign()==-1) strBI.append('-');
		int i=arrayLen-1;
		strBI.append(array[i]);//首位数直接复制到字符串
		
		i--;
		//十亿进制，不足位需要补零；
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
	//克隆，为了不改变原数	
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
	
	
	
	
	
	


