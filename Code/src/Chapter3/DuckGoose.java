import java.util.Random;
public class DuckGoose {
	public static void main(String[] args) {
		CircleList C=new CircleList();
		int N=3;//ÖØ¸´Êý£»
		Node it;
		Node goose;
		Random rand=new Random();
		rand.setSeed(System.currentTimeMillis());
		String[] names={"Bob","Jen","Pam","Tom","Ron","Vic","Sue","Joe"};
		for (int i=0;i<names.length;i++){
			C.add(new Node(names[i],null));
			C.advance();
		}
		for (int i=0;i<N;i++){
			System.out.println("Playing Duck,Duck,Goose for"+C.toString());
			it=C.remove();
			System.out.println(it.getElement()+"is it.");
			while (rand.nextBoolean()||rand.nextBoolean()){
				C.advance();
				System.out.println(C.getCursor().getElement()+"is a duck.");
			}
			goose=C.remove();
			System.out.println(goose.getElement()+"is the goose!");
			if (rand.nextBoolean()){
				System.out.println("The goose won!");
				C.add(goose);
				C.advance();
				C.add(it);
			}
			else{
				System.out.println("The goose lost!");
				C.add(it);
				C.advance();
				C.add(goose);
			}
		}
		System.out.println("Final circle is "+C.toString()+"...");

	}

}
