package com.alico.chat;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8887);
			while (true) {
				Socket s = ss.accept();
System.out.println("A client is connected!");
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println(str);
				dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
