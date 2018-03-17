
public class TestSortedListPriorityQueue {
	public static void main(String args[]) throws EmptyPriorityQueueException, InvalidKeyException { 
		SortedListPriorityQueue<String, String> priorityqueuetest= new SortedListPriorityQueue<String, String>();
		priorityqueuetest.insert("4", "A"); 
		priorityqueuetest.insert("12", "B"); 
		priorityqueuetest.insert("556", "C"); 
		priorityqueuetest.insert("557", "D"); 
		System.out.println("min£º("+priorityqueuetest.min().getKey()+","+ priorityqueuetest.min().getValue() + ") "); 
		System.out.println("size()£º" + priorityqueuetest.entries.size()); 
		System.out .println("removeMin()£º" + priorityqueuetest.removeMin().getValue()); 
		System.out.println("size()£º" + priorityqueuetest.entries.size()); 
		System.out .println("removeMin()£º" + priorityqueuetest.removeMin().getValue()); 
		System.out.println("size()£º" + priorityqueuetest.entries.size()); 
		System.out .println("removeMin()£º" + priorityqueuetest.removeMin().getValue()); 
		System.out.println("size()£º" + priorityqueuetest.entries.size()); 
		System.out .println("removeMin()£º" + priorityqueuetest.removeMin().getValue()); 
		System.out.println("size()£º" + priorityqueuetest.entries.size()); 
	}
}
