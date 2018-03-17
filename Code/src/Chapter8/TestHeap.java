
public class TestHeap {
	public static void main(String[] args){
		int[] array=new int[]{5,8,6,4,9,3,7,1};
		Heap heap=new Heap(array);
		
		System.out.println("初始时堆的结构：");
		heap.printHeapTree();
		heap.buildHeap();
		System.out.println("执行小根堆化后堆的结构：");
    	heap.printHeapTree();
    	heap.heapSort();
    	System.out.println("堆排序后数组的内容");
    	
    	for(int i=array.length-1;i>=0;i--){
    		System.out.print(array[i]+" ");
    		
    	}
	}

}
