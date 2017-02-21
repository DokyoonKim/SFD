package view;

import javax.swing.*;

public class PageWindow {
	
	
	JFrame frame;
	
	public PageWindow() {
		
		frame = new JFrame();
		JLabel lblTitle = new JLabel("This is the page for writing");
		
		JTextArea text = new JTextArea();
		
		frame.setSize(400, 300);
		frame.getContentPane().add(lblTitle, "North");
		frame.getContentPane().add(text, "Center");
		
		
	}
	
	
	public void show(){
		frame.show();
	}
	
	
	
}
