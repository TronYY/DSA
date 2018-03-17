import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class CH04_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f=new File("D:\\Course\\StudentDemo_IO\\src\\abc.txt");
		try {
			FileOutputStream fos=new FileOutputStream(f);
			// 创建FileOutputStream对应OutputStreamWriter：将字节流转换为字符流，即写入osw的数据会自动由字节转换为字符。
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter writer=new BufferedWriter(osw);
			
			for (int idx=0;idx<10;idx++){
				writer.write("Line:"+idx);
				writer.newLine();
			}
			
			writer.close();
			osw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
