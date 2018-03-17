import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class CH04_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(35000);
			
			while (true){
				Socket sock=serverSocket.accept();
				OutputStreamWriter osw=new OutputStreamWriter(sock.getOutputStream());
	 		BufferedWriter writer=new BufferedWriter(osw);
				
				writer.write("Hello Client.");
				//writer.newLine();
				
				writer.close();
				osw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
