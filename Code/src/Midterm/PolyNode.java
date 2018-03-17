package Midterm;

public class PolyNode {    
    protected BigNumStruct coe;//系数
    protected long exp;//指数  
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
    
    //改变符号
    public void opposeSign(){
    	coe.setSign((byte) (-1*coe.getSign()));
    }
} 