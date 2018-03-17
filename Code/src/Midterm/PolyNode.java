package Midterm;

public class PolyNode {    
    protected BigNumStruct coe;//ϵ��
    protected long exp;//ָ��  
    PolyNode next;  
    public PolyNode(StringBuffer s,long newExp){  
    	 
         coe=new BigNumStruct(s);  
         exp=newExp;  
         next=null;  
    }  
    public PolyNode(){     
    	coe=null;  
        exp=0;  
        next=null;
    }
    public BigNumStruct getCoe() {  
        return coe;  
    }  
    public long getExp() {  
        return exp;  
    }
    public PolyNode getNext() {  
        return next;  
    }
    
    public void setCoe(BigNumStruct newCoe){
    	coe=newCoe;
    }
    
    public void setExp(long newExp){
    	exp=newExp;
    }
    public void setNext(PolyNode newNext)
	{
		next=newNext;
	}
    
    //�ı����
    public void opposeSign(){
    	coe.setSign((byte) (-1*coe.getSign()));
    }
} 