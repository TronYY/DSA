
public class BTNode{
	protected char data;
	protected BTNode left;
	protected BTNode right;
	
	public BTNode(){
		this.data='0';
		this.left=null;
		this.right=null;
	}
	
	public BTNode(char data){
		this.data=data;
		this.left=null;
		this.right=null;
		}
	public BTNode(char newData,BTNode newL,BTNode newR){
		this.data=newData;
		this.left=newL;
		this.right=newR;
		
	}
	
	public char getData(){ 
		return data;
	}
	
	public BTNode getLeft(){
		return left;
	}
	public BTNode getRight(){
		return right;
	}
	
}
