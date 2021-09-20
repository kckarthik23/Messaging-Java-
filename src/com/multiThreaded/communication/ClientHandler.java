package com.multiThreaded.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler implements Runnable {
	DataInputStream dis = null;
	DataOutputStream dos = null;
	Socket soc = null;

	ClientHandler(DataInputStream dis, DataOutputStream dos, Socket soc) {
		System.out.println("inside ClientHandler");

		this.dis = dis;
		this.dos = dos;
		this.soc = soc;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try {
			System.out.println("entering the thread ");
			while (true) {
				System.out.println("entering the while ");
				dos.writeUTF("Enter Date to get Date" + "Enter time to get Time" + "Enter Exit to exit the program");
				System.out.println("dos updated");
				String input = dis.readUTF();
				Date Date = new Date();
				SimpleDateFormat sdate = new SimpleDateFormat("dd-mm-YYYY");
				SimpleDateFormat stime = new SimpleDateFormat("HH:mm:ss");
				System.out.println("is thred running "+Thread.currentThread());
				if (input.equals("Exit")) {
					soc.close();
					dis.close();
					dos.close();
					break;

				} else {
					switch (input) {
					case "Date":
						dos.writeUTF(sdate.format(Date));
						break;
					case "Time":
						dos.writeUTF(stime.format(Date));
						break;

					default:
						break;
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
