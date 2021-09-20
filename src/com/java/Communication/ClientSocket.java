package com.java.Communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

	public DataInputStream input = null;
	public DataOutputStream output = null;
	Socket socket = null;

	public void createConnection(String addr, int port) {
		try {
			socket = new Socket(addr, port);
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			String str = "";
			while (!str.equals("Over")) {
				str = input.readLine();
				output.writeUTF(str);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			input.close();
			output.close();
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ClientSocket client = new ClientSocket();
		client.createConnection("127.0.0.1", 5000);

	}

}
