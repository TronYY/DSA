import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class CH04_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student stu=new Student();
		stu.setId(1);
		stu.setName("ÕÅÈý");
		stu.setGrade(1);
		
		File f=new File("D:\\Course\\StudentDemo_IO\\src\\obj.bin");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream ofo=new ObjectOutputStream(fos);
			ofo.writeObject(stu);
			
			ofo.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
