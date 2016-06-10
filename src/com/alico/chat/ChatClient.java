package com.alico.chat;

import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;
import java.io.IOException;
import java.net.*;
import java.io.*;

/*	������Client�˵���Ӧ
 * 
 */


public class ChatClient extends Frame {
	
	Socket s = null;
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	

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
System.out.println("Connected!");
		} catch (IOException e) {
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
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeUTF(str);
				dos.flush();
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			tfTxt.setText("");
		}
		
	}
	
	

}
