
//Arithmetic progression.
public class ArithProgression extends Progression{
	protected long inc;//Increment
	//Inherits variables first and cur;
	
	//Default constructor setting a unit increment
	ArithProgression(){
		this(1);//this�ؼ��ֿ��Գ��������ʵ�������У�����ʹ�ø÷����ĵ�ǰ����
		//������ͬ���ķ�����1Ϊ����
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
