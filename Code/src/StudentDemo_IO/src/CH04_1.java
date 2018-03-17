import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class CH04_1 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
//		File f=new File("D:\\Eclipse Workspace\\StudentDemo\\src\\abc.txt");
		File f=new File("D:/Course/StudentDemo_IO/src/abc.txt");
		try {
			FileInputStream fis=new FileInputStream(f);//read file
			InputStreamReader isr=new InputStreamReader(fis);//translate  character encoding
			BufferedReader reader=new BufferedReader(isr);//read line
			
			String line;
			while ((line=reader.readLine())!=null){
				System.out.println(line);
			}
			
			reader.close();
			isr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
