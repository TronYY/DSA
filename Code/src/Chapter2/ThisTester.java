public class ThisTester {
	public int dog=2;//instance variable;
	public void clobber(){
		int dog=5;//a different dog!
		System.out.println("The dog local variable="+dog);//局部变量的dog
		System.out.println("The dog field="+this.dog);//当前对象里的dog变量
	}
	public static void main(String[] args) {
		ThisTester t=new ThisTester();
		t.clobber();
	}
}
