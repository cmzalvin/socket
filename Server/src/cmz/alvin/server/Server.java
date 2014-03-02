package cmz.alvin.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server=null;
		Socket you=null;
		DataOutputStream out=null;
		DataInputStream in=null;
		try{
			server=new ServerSocket(4331);
		}catch(IOException e1){
			System.out.println(e1);
		}
		try{
			System.out.println("等待客户呼叫");
			you=server.accept();
			out=new DataOutputStream(you.getOutputStream());
			in=new DataInputStream(you.getInputStream());
			while(true){
				char c=in.readChar();
				System.out.println("服务器收到:"+c);
				out.writeChar((char)(c-32));
				Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("客户以断开"+e);
		}
	}

}
