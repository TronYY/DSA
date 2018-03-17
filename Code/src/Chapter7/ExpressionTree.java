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
	//�Ƿ�Ϊ�Ӽ���
	public boolean isPlus(char ch){
		if(ch=='+' || ch=='-') return true;
		return false;
	}

	//�Ƿ�Ϊ�˳���
	public boolean isMultiply(char ch){
		if(ch=='*' || ch=='/') return true;
		return false;
	}
	
	//����һ���ַ�������������
	public BTNode creatTree(String str, int i, int j){
		BTNode node=new BTNode();
		int k,pos = 0;
		int flag = 0;

		if(i == j){
			node.data = str.charAt(i);
			node.left = null;
			node.right = null;
		}

		//�ȿ����޼Ӽ�����
		for(k=i; k<=j; k++)
			if(isPlus(str.charAt(k))){
				++ flag;
				pos = k;
			}

		//û�мӼ���ʱ���ٿ����޳˳���
		if(flag == 0){
			for(k=i; k<=j; k++)
				if(isMultiply(str.charAt(k))){
					++ flag;
					pos = k;
				}
		}

		//�ַ����к��������
		if(flag != 0){
			node.data = str.charAt(pos);
			node.left = creatTree(str, i, pos-1);
			node.right = creatTree(str, pos+1, j);
			return node;
		}
		return node;
	}

	//��������ʽ�������м���
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


