package Chapter1;

public class WhileExample {
	public static void getUserInput(){
		String input;
		do{
			input=getInputString();
			handleInput(input);
			
		}while (input.length()>0);
	}



	private static void handleInput(String input) {
		// TODO Auto-generated method stub
		
	}



	private static String getInputString() {
		// TODO Auto-generated method stub
		return null;
	}



	public static void main(String[] args) {
		getUserInput();

	}

}
