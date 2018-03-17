import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class CH04_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File("D:\\Course\\StudentDemo_IO\\src\\obj.bin");
		try {
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			Student stu=(Student) ois.readObject();
			
			ois.close();
			
			System.out.println("ID:"+stu.getId());
			System.out.println("Name:"+stu.getName());
			System.out.println("Grade:"+stu.getGrade());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
