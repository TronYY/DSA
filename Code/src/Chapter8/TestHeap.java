
public class TestHeap {
	public static void main(String[] args){
		int[] array=new int[]{5,8,6,4,9,3,7,1};
		Heap heap=new Heap(array);
		
		System.out.println("��ʼʱ�ѵĽṹ��");
		heap.printHeapTree();
		heap.buildHeap();
		System.out.println("ִ��С���ѻ���ѵĽṹ��");
    	heap.printHeapTree();
    	heap.heapSort();
    	System.out.println("����������������");
    	
    	for(int i=array.length-1;i>=0;i--){
    		System.out.print(array[i]+" ");
    		
    	}
	}

}
