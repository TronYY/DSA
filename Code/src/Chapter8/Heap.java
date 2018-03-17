
public class Heap {
	int[] heapArray;
	int size;
	//构造方法
	public Heap(int[] array){
		this.heapArray=array;    
		this.size=heapArray.length;
	}
	
	//建堆
	public void buildHeap(){
		for(int i=size/2-1;i>=0;i--){
			smallroot(i);//向上将当前子树最大堆化
		}
	}
	
	//堆排序
	public void heapSort(){
		for(int i=0;i<heapArray.length;i++){
			//执行n次，将每个当前最小的值放到堆末尾
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
		
		//如果largest等于i说明i是最大元素 largest超出heap范围说明不存在比i节点大的子女
		if(smallest==i||smallest>=size) return ;
		
		int tmp=heapArray[i];//交换i与largest对应的元素位置，在largest位置递归调用maxify
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
