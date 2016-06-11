package com.alico.chat;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean start = false;
		DataInputStream dis = null;
		try {
			ServerSocket ss = new ServerSocket(8887);
			start = true;
			while (start) {
				boolean hasConnected = false;
				Socket s = ss.accept();
				
System.out.println("A client is connected!");
				hasConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while (hasConnected) {
					
					String str = dis.readUTF();
					System.out.println(str);
				}
				dis.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
