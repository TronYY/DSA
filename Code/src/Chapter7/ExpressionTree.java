public class ExpressionTree {
	
	protected BTNode node;

	public ExpressionTree(){
		node = new BTNode();
	}
	
	public BTNode getNode(){
		return node;
	}
	
	public void setNode(BTNode newN){
		node=newN;
	}
	//是否为加减法
	public boolean isPlus(char ch){
		if(ch=='+' || ch=='-') return true;
		return false;
	}

	//是否为乘除法
	public boolean isMultiply(char ch){
		if(ch=='*' || ch=='/') return true;
		return false;
	}
	
	//对于一个字符串，来构造树
	public BTNode creatTree(String str, int i, int j){
		BTNode node=new BTNode();
		int k,pos = 0;
		int flag = 0;

		if(i == j){
			node.data = str.charAt(i);
			node.left = null;
			node.right = null;
		}

		//先看有无加减法，
		for(k=i; k<=j; k++)
			if(isPlus(str.charAt(k))){
				++ flag;
				pos = k;
			}

		//没有加减法时，再看有无乘除法
		if(flag == 0){
			for(k=i; k<=j; k++)
				if(isMultiply(str.charAt(k))){
					++ flag;
					pos = k;
				}
		}

		//字符串中含有运算符
		if(flag != 0){
			node.data = str.charAt(pos);
			node.left = creatTree(str, i, pos-1);
			node.right = creatTree(str, pos+1, j);
			return node;
		}
		return node;
	}

	//构造完表达式树，进行计算
	public double calculate(BTNode node){
		double n1,n2;
		if(node == null){
			return 0;
		}


		if(node.left == null && node.right == null){
			return (node.data-'0');
		}

		n1 = calculate(node.left);
		n2 = calculate(node.right);

		switch(node.data){
		case '+':
			return n1+n2;
		case '-':
			return n1-n2;
		case '*':
			return n1*n2;
		case '/':
			return n1/n2;
		}
		return 0;
	}
}


