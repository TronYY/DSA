package Chapter1;
public class CheckElement {
	public static int[] a=new int[]{2,3,5,2,3,2,-6,98};//��ʼ������
	public static int findCount(int[] a ,int k){//kΪҪ�ҵ�ֵ
		int count=0;//count��¼k�������г��ֵĴ���
		for (int i=0;i<a.length;i++){
			if (a[i]==k) //���μ��ÿ��Ԫ���Ƿ����k
				count++;
			
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.print("The elments in array a are:");
		int j;
		for (j=0;j<a.length;j++)
			System.out.print(a[j]+" ");//�������a������Ԫ��
		System.out.println();
		System.out.println("The element 2 appears "+findCount(a,2)+" times in a");
	}

}
