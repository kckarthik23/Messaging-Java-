package com.multiThreaded.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	DataInputStream dis = null;
	DataOutputStream dos = null;
	Socket soc = null;

	Client(int port) {
		try {
			soc = new Socket("127.0.0.1", 5067);
			dis = new DataInputStream(soc.getInputStream());
			dos = new DataOutputStream(soc.getOutputStream());
			while (true) {
				InetAddress inet;
				System.out.println("entering while");
				// inet = InetAddress.getByName("localhost");
				System.out.println(dis.readUTF());
				Scanner sc = new Scanner(System.in);

				System.out.println("what the");
				String input = sc.next();
				if (input.equals("Exit")) {
					
					dis.close();
					dos.close();
					break;
				} else {

					dos.writeUTF(input);
					System.out.println(dis.readUTF());
				}
				try {
					soc.close();
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Client cl = new Client(5067);

	}

}
