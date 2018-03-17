
import java.util.*;

public class Btree{
 private BTNode root;
  private BTNode curr;
  private int depth;
  private int width;
  private int allNode;    //统计所有节点个数
  private int leafNode;   //统计叶子节点个数
  private int maxPathLen=0;
	public Btree(String str){    //根据广义表形式的字符串构造一颗二叉树
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
	
	private static class BTNode{//二叉树结点类型
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
	
	
	
	private static class QueueNode{   //队列结点类型
		BTNode node;
		QueueNode parent;
		public QueueNode(BTNode newNode,QueueNode parent){
			this.node=newNode;
			this.parent=parent;  
		}
	}
	
	
	
 
	
	/**
	 * 广义表形式输出二叉树
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
 * 计算二叉树的宽度，深度，结点数
 * @param root
 * 二叉树层次遍历原理
 */
public void layerTraverse(BTNode root) {
	          if (root == null)
	              return ;
	          Queue<BTNode> queue = new LinkedList<BTNode>();
	         int maxWitdth = 1; // 最大宽度
	          queue.add(root); // 入队
	          int count=0; //结点计数器
	          int height=0;//层计数器
	         while (true) {
	             int len = queue.size(); // 当前层的节点个数
	             if (len == 0)
	                 break;
	             while (len > 0) {// 如果当前层，还有节点
	            	 BTNode t = queue.poll();
	            	 count++;
	                 len--;
	                 if (t.left != null)
	                     queue.add(t.left); // 下一层节点入队
	                 if (t.right != null)
	                     queue.add(t.right);// 下一层节点入队
	                 
	             }
	             maxWitdth = Math.max(maxWitdth, queue.size());
	             height++;
	         }
	         this.depth=height;
	         this.allNode=count;
	         this. width=maxWitdth;
	     }




/**
 * 查找二叉树中的某个结点并返回之
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
 * 判断某个结点node是否为叶子结点
 * @param args
 */
public boolean isLeaf(BTNode node){
	if(node.right==null&&node.left==null)return true;
	else return false;
}
	




/**
 * 统计树的叶子结点总数并输出叶子节点
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
 *层次遍历的原理    找出从叶节点到根的所有路径
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
	System.out.println("输出当前树中所有最长路径：");
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
		System.out.print("输出二叉树：   ");
		tree.display1(tree.root);
		tree.layerTraverse(tree.root);
		System.out.println("\n"+"二叉树结点总数为"+tree.allNode);
		System.out.println("二叉树高度为为"+tree.depth);
		System.out.println("二叉树宽度为为"+tree.width);
		System.out.print("查找B的子结点:   ");
		System.out.println("B的左子结点为"+tree.getNode(tree.root, 'B').left.data+"      B的右子结点为"+tree.getNode(tree.root, 'B').right.data);	
		System.out.println("输出所有叶结点 及计算叶结点总数：");
		System.out.println(tree.leafNode(tree.root));
		System.out.println("当前树中所有路径：");
		tree.allPath(tree.root);
		System.out.println("最长路径长度为：  "+tree.maxPathLen);
	}
	}

