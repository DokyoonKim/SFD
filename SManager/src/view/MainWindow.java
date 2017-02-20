package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import control.ScreenSize;

public class MainWindow {
	
	private JFrame frame;
	
	public MainWindow(){
		
		frame = new JFrame();
		frame.setSize(400, 300);
		frame.setLocation((ScreenSize.getScreenWidth() -frame.getWidth())/2, ScreenSize.getScreenHeight()/2 - (int)(frame.getHeight()/1.5) );
		
	}
	
	
	public void show(){
		frame.show();
	}
	
	
	public void dispose(){
		frame.dispose();
	}
	
}
