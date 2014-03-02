package cmz.alvin.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.Socket;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket mysocket;
		DataInputStream in=null;
		DataOutputStream out=null;
		try{
			mysocket=new Socket("127.0.0.1",4331);
			in=new DataInputStream(mysocket.getInputStream());
			out=new DataOutputStream(mysocket.getOutputStream());
			char c='a';
			while(true){
				if(c>'z') c='a';
				out.writeChar(c);
				char s=in.readChar();
				System.out.println("客户收到:"+s);
				c++;
				Thread.sleep(1000);
			}
			
		}catch(Exception e){
			System.out.println("服务器已断开"+e);
		}
	}

}
