package com.alico.chat;

import java.io.IOException;
import java.net.*;
import java.io.*;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean start = false;
		ServerSocket ss = null;
		DataInputStream dis = null;
		Socket s = null;
		try {
			ss = new ServerSocket(8887);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			start = true;
			while (start) {
				boolean hasConnected = false;
				s = ss.accept();
System.out.println("A client is connected!");
				hasConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while (hasConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
				//dis.close();
			}
		} catch (IOException e) {
			
			//e.printStackTrace();
			System.out.println("Client closed!");
		} finally {
			try {
				if (dis != null) dis.close();
				if (s != null) s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
	}

}
