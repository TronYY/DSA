import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class CH04_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",35000);
			
			InputStreamReader isr=new InputStreamReader(socket.getInputStream());
			BufferedReader reader=new BufferedReader(isr);
			System.out.println(reader.readLine());
			reader.close();
			isr.close();
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
