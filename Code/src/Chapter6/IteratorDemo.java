
import java.util.* ;
public class IteratorDemo{
public static void main(String args[]){
	// 创建一个ArrayList数组
	ArrayList al = new ArrayList();
	// 加入元素到ArrayList中
	al.add("C");
	al.add("A");
	al.add("E");
	al.add("B");
	al.add("D");
	al.add("F");
	// 使用iterator显示a1中的内容
	System.out.print("a1 中原始内容是：");
	Iterator itr = al.iterator();
	while (itr.hasNext()){
		Object element = itr.next();
		System.out.print(element + " ");
	}
	System.out.println();
	
	
	// 在ListIterator中修改内容
	ListIterator litr = al.listIterator();
	while (litr.hasNext()) {
		Object element = litr.next();
		// 用set方法修改其内容
		litr.set(element + "+");
	}
	System.out.print("a1 被修改之后的内容：");
	itr = al.iterator();
	while (itr.hasNext()){
		Object element = itr.next();
		System.out.print(element + " ");
	}
	System.out.println();
	
	// 下面是将列表中的内容反向输出
	System.out.print("将列表反向输出：");
	// hasPreviours由后向前输出
	while (litr.hasPrevious()){
		Object element = litr.previous();
		System.out.print(element + " ");
	}
	System.out.println();
	}
}
