package com.alico.chat;

import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;

public class ChatClient extends Frame {
	
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
		setVisible(true);
	}
	
	

}
