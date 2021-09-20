package com.java.Communication;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerSocket {

	Socket socket = null;
	java.net.ServerSocket server = null;
	DataInputStream input = null;

	public ServerSocket(int port) {

		try {
			server = new java.net.ServerSocket(port);
			socket = server.accept();
			input = new DataInputStream(socket.getInputStream());
			String str = "";
			while (!str.equals("Over")) {

				str = input.readUTF();
				System.out.println(str);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// server.close();
			socket.close();
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ServerSocket server = new ServerSocket(5000);

	}

}
