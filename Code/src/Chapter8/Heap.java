
public class Heap {
	int[] heapArray;
	int size;
	//���췽��
	public Heap(int[] array){
		this.heapArray=array;    
		this.size=heapArray.length;
	}
	
	//����
	public void buildHeap(){
		for(int i=size/2-1;i>=0;i--){
			smallroot(i);//���Ͻ���ǰ�������ѻ�
		}
	}
	
	//������
	public void heapSort(){
		for(int i=0;i<heapArray.length;i++){
			//ִ��n�Σ���ÿ����ǰ��С��ֵ�ŵ���ĩβ
			int tmp=heapArray[0];
			heapArray[0]=heapArray[size-1];
			heapArray[size-1]=tmp;
			size--;
			smallroot(0);
		}
	}
	
	
	public void smallroot(int i){
		int l=left(i);
		int r=right(i);
		int smallest;
    
		if(l<size&&heapArray[l]<heapArray[i])
			smallest=l;
		else
			smallest=i;
		if(r<size&&heapArray[r]<heapArray[smallest])
			smallest=r;
		
		//���largest����i˵��i�����Ԫ�� largest����heap��Χ˵�������ڱ�i�ڵ�����Ů
		if(smallest==i||smallest>=size) return ;
		
		int tmp=heapArray[i];//����i��largest��Ӧ��Ԫ��λ�ã���largestλ�õݹ����maxify
		heapArray[i]=heapArray[smallest];
		heapArray[smallest]=tmp;
		smallroot(smallest);
	}
	
	

	private int Parent(int i){
		return (i-1)/2;
	}
	private int left(int i){
		return 2*(i+1)-1;
	}
	private int right(int i){
		return 2*(i+1);
	}
	

	public void printHeapTree() {
		
		for(int i=1;i<=heapArray.length;i=i*2){
			for(int k=i-1;k<2*(i)-1&&k<heapArray.length;k++){
				System.out.print(heapArray[k]+" ");
			}
			System.out.println();
		}    	
	}
	
}
