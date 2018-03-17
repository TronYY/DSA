
//A class for numeric progression

public class Progression {
	//First value of the progression
	protected long first;
	//Current value of the progression
	protected long cur;
	//Default constructor
	////构造函数的特点：①与类名同名  ②无返回值
	Progression(){
		cur=first=0;
	}
	
	/*Reset the progression to the first value
	 * @return first value
	 */
	protected long firstValue(){
		cur=first;
		return cur;
	}
	
	/*Advances the progression to the next value
	 * @return next value of the progression
	 */
	protected long nextValue(){
		return ++cur;//default next value
	}
	/*Print the first n value of the progression
	 * @param n number of values to print
	 */
	public void printProgression(int n){
		System.out.print(firstValue());
		for(int i=2;i<=n;i++)
			System.out.print(" "+nextValue());
		System.out.println();//ends the line
	}
}
