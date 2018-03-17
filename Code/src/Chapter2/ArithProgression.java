
//Arithmetic progression.
public class ArithProgression extends Progression{
	protected long inc;//Increment
	//Inherits variables first and cur;
	
	//Default constructor setting a unit increment
	ArithProgression(){
		this(1);//this关键字可以出现在类的实例方法中，代表使用该方法的当前对象；
		//往下找同名的方法，1为参数
	}
	//Parametric constructor providing the increment
	ArithProgression(long increment){
		inc=increment;
	}
	/*Advances the progression by adding the increment to the current value
	 * @return next value of the progression
	 */
	protected long nextValue(){
		cur+=inc;
		return cur;
	}

}
