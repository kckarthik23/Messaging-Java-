package com.multiThreaded.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket sec = null;
	Socket soc = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	public Server(int port) {
		try {
			sec = new ServerSocket(port);
			
while(true)
{
			
			soc = sec.accept();
			dis=new DataInputStream(soc.getInputStream());
			dos=new DataOutputStream(soc.getOutputStream());
			ClientHandler client = new ClientHandler(dis, dos, soc);
			new Thread(client).start();
}

		} catch (IOException e) {
			System.out.println("error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Server server = new Server(5067);

	}

}
