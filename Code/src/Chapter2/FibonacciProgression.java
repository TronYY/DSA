
//Fibonacci progression

public class FibonacciProgression extends Progression {
	//Previous value
	long prev;
	//Inherits variables first and cur
	
	//Default constructor setting 0 and 1 as the first two values
	FibonacciProgression(){
		this(0,1);
	}
	/*Parametric constructor providing the first and second values
	 * @param value1 first value.
	 * @param value2 second value.
	 */
	public FibonacciProgression(long value1,long value2) {
		first=value1;
		prev=value2-value1;//
	}
	protected long nextValue(){
		long temp=prev;
		prev=cur;
		cur+=temp;
		return cur;
	}
	//Inherits methods firstValue() and printProgrss(int)
}
