
public class TestLinkedDeque {
	public static void main(String[] argv){
    	LinkedDeque<Integer> deque=new LinkedDeque<Integer>();
    	deque.addToBack(1);
    	deque.addToBack(2);
    	System.out.println(deque.getFront());
    	System.out.println(deque.getBack());
    	deque.addToBack(3);
    	deque.removeFront();
    	System.out.println(deque.getFront());
    	System.out.println(deque.getBack());
    	deque.removeBack();
    	deque.addToFront(4);
    	System.out.println(deque.getFront());
    	System.out.println(deque.getBack());
    	deque.clear();
    	System.out.println(deque.getFront());
    	System.out.println(deque.getBack());
    	deque.addToFront(5);
    	System.out.println(deque.getFront());
    	System.out.println(deque.getBack());
    }

}
