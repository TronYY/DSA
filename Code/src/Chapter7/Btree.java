
import java.util.*;

public class Btree{
 private BTNode root;
  private BTNode curr;
  private int depth;
  private int width;
  private int allNode;    //ͳ�����нڵ����
  private int leafNode;   //ͳ��Ҷ�ӽڵ����
  private int maxPathLen=0;
	public Btree(String str){    //���ݹ������ʽ���ַ�������һ�Ŷ�����
		char[] array=str.toCharArray();
		BTNode[] nodeStack=new BTNode[array.length/2];
		int top=-1;
		int flag=0;
		curr=null;
		for(int i=0;i<array.length;i++){
			switch(array[i]){
			case'(':
				top++;
				nodeStack[top]=curr;
				flag=1;
				break;
			case')':
				top--;
				break;
			case',':
				flag=2;
				break;
			default:
				curr=new BTNode(array[i]);
				if(i==0)this.root=curr;		
				switch(flag){
			case 1:
				nodeStack[top].left=curr;
				break;
			case 2:
				nodeStack[top].right=curr;
				break;
			default:
				break;
				}
			}
			}
	}
	
	private static class BTNode{//�������������
		char data;
		BTNode left;
		BTNode right;
		public BTNode(char data){
			this.data=data;
			this.left=null;
			this.right=null;
			}
		public BTNode(){}
	}
	
	
	
	private static class QueueNode{   //���н������
		BTNode node;
		QueueNode parent;
		public QueueNode(BTNode newNode,QueueNode parent){
			this.node=newNode;
			this.parent=parent;  
		}
	}
	
	
	
 
	
	/**
	 * �������ʽ���������
	 * @param node
	 */
	public void display1(BTNode node){
		if(node==null)return;
		else if(node!=null){
			System.out.print(node.data);
			if(node.left!=null||node.right!=null){
				System.out.print("(");
				display1(node.left);
				if(node.right!=null) System.out.print(",");	
				display1(node.right);
				System.out.print(")");
			}
		}
	}


	

/**
 * ����������Ŀ�ȣ���ȣ������
 * @param root
 * ��������α���ԭ��
 */
public void layerTraverse(BTNode root) {
	          if (root == null)
	              return ;
	          Queue<BTNode> queue = new LinkedList<BTNode>();
	         int maxWitdth = 1; // �����
	          queue.add(root); // ���
	          int count=0; //��������
	          int height=0;//�������
	         while (true) {
	             int len = queue.size(); // ��ǰ��Ľڵ����
	             if (len == 0)
	                 break;
	             while (len > 0) {// �����ǰ�㣬���нڵ�
	            	 BTNode t = queue.poll();
	            	 count++;
	                 len--;
	                 if (t.left != null)
	                     queue.add(t.left); // ��һ��ڵ����
	                 if (t.right != null)
	                     queue.add(t.right);// ��һ��ڵ����
	                 
	             }
	             maxWitdth = Math.max(maxWitdth, queue.size());
	             height++;
	         }
	         this.depth=height;
	         this.allNode=count;
	         this. width=maxWitdth;
	     }




/**
 * ���Ҷ������е�ĳ����㲢����֮
 * @param node
 * @param ch
 * @return node
 */
public BTNode getNode(BTNode node,char ch){

	if(node!=null&&node.data==ch){
		return node;			
	}
	if(node.left!=null){
		return getNode(node.left,ch);	
	}
	if(node.right!=null){
		return getNode(node.right,ch);
	}


return null;

}




/**
 * �ж�ĳ�����node�Ƿ�ΪҶ�ӽ��
 * @param args
 */
public boolean isLeaf(BTNode node){
	if(node.right==null&&node.left==null)return true;
	else return false;
}
	




/**
 * ͳ������Ҷ�ӽ�����������Ҷ�ӽڵ�
 */

public int leafNode(BTNode node){
	int count=0;
	if(node==null)return 0;
	if(isLeaf(node)){
		System.out.print(node.data+"   ");
		count=1;
	}
	else{
	count+=leafNode(node.left)+leafNode(node.right);
	}
	return count;
}	




/**
 *��α�����ԭ��    �ҳ���Ҷ�ڵ㵽��������·��
 * @param root
 */
public void allPath(BTNode root){
	Queue<QueueNode> queue = new LinkedList<QueueNode>();
	StringBuffer[] path=new StringBuffer[(int) Math.pow(2,this.depth)];
	QueueNode temp;
	QueueNode t;
	int pathlen = 0;
	if(root==null) return;
	queue.add(new QueueNode(root,null));
	if(!queue.isEmpty()){
		for(int i=0;!queue.isEmpty();i++)
	{
		temp=queue.poll();
		if(isLeaf(temp.node)){
			pathlen=0;
			t=temp;
			path[i]=new StringBuffer();
			while(t.parent!=null){
				path[i].append(t.node.data);
				pathlen++;
				t=t.parent;		
			}
			path[i].append(t.node.data);
			pathlen++;
			System.out.println(path[i]);
		}
		this.maxPathLen= Math.max(maxPathLen,pathlen);
		Math.max(maxPathLen,pathlen);
		if(temp.node.left!=null){
			queue.add(new QueueNode(temp.node.left,temp));
		}
		if(temp.node.right!=null){
			queue.add(new QueueNode(temp.node.right,temp));
		}
	}
	}
	System.out.println("�����ǰ���������·����");
	for(StringBuffer str:path){
		if(str!=null){
		if(str.length()==this.maxPathLen){
			System.out.println(str);
		}	
		}
		
	}
	}


	
	public static void main(String[] args){
		Btree tree=new Btree("A(B(D(G,H(J,K)),E),C(,F(,I(M))))");
		System.out.print("�����������   ");
		tree.display1(tree.root);
		tree.layerTraverse(tree.root);
		System.out.println("\n"+"�������������Ϊ"+tree.allNode);
		System.out.println("�������߶�ΪΪ"+tree.depth);
		System.out.println("���������ΪΪ"+tree.width);
		System.out.print("����B���ӽ��:   ");
		System.out.println("B�����ӽ��Ϊ"+tree.getNode(tree.root, 'B').left.data+"      B�����ӽ��Ϊ"+tree.getNode(tree.root, 'B').right.data);	
		System.out.println("�������Ҷ��� ������Ҷ���������");
		System.out.println(tree.leafNode(tree.root));
		System.out.println("��ǰ��������·����");
		tree.allPath(tree.root);
		System.out.println("�·������Ϊ��  "+tree.maxPathLen);
	}
	}

