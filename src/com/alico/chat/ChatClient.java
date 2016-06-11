package com.alico.chat;

import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;
import java.io.IOException;
import java.net.*;
import java.io.*;

/*	更新并解决了流的错误
 * 
 */


public class ChatClient extends Frame {
	
	Socket s = null;
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	DataOutputStream dos = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().launchFrame();
	}
	
	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		add(tfTxt, BorderLayout.SOUTH);
		add(taContent, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				disconnect();
				System.exit(0);
				
			}
			
		});
		tfTxt.addActionListener(new TFListener());
		setVisible(true);
		connect();
	}
	
	public void connect() {
		try {
			s = new Socket("127.0.0.1", 8887);
			dos = new DataOutputStream(s.getOutputStream());
System.out.println("Connected!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = tfTxt.getText().trim();
			taContent.setText(str);
			
			try {
				
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			tfTxt.setText("");
		}
		
	}
	
	

}
