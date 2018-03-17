
public class CH01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student();
		stu.setId(1);
		stu.setGrade(2);
		stu.setName("王二");
		
		if (stu.getGrade()<3)
			System.out.println("低年级");
		else
			System.out.println("高年级");
	}

}
