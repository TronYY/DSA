
//Geometric Progression
public class GeomProgression extends Progression{
	protected long base;//Base
	//Inherits variables first and cur
	
	//Default constructor setting base 2
	GeomProgression(){
		this(2);
	}
	/*Parametric constructor providing the base
	 * @param b base of the progression
	 */
	GeomProgression(long b){
		base=b;
		first=1;
		cur=first;
	}
	/*Advances the progression by multiplying the base with the currnt value
	 * return next value of the progress
	 */
	protected long nextValue(){
		cur*=base;
		return cur;
	}
	//Inherits methods firstValue() and printProgression(int)
	
}
