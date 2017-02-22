package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import control.Index;
import control.ScreenSize;


public class LogInWindow {
	
	private JFrame frame;
	private double screenWidth;
	private double screenHeight;
	private JButton btnEnter;
	private JPasswordField txtPassWd;
	
	public LogInWindow(){
		
		frame = new JFrame();
		JPanel layout = new JPanel();
		JLabel lblTitle = new JLabel();
		
		txtPassWd = new JPasswordField();
		btnEnter = new JButton();
		
		
		frame.setResizable(false);
		frame.setSize(300, 60);
		frame.setLocation((ScreenSize.getScreenWidth() -frame.getWidth())/2, ScreenSize.getScreenHeight()/2 - frame.getHeight() );
		layout.setLayout(new BorderLayout());
		
		lblTitle.setText("Enter password: ");
		btnEnter.setText("->");
		
		
		
		frame.getContentPane().add(layout);
		layout.add(lblTitle, "North");
		layout.add(txtPassWd, "Center");
		layout.add(btnEnter, "East");
		
	}
	
	
	public void show(){
		frame.show();
	}
	
	
	public void dispose(){
		frame.dispose();
	}
	
	
	
	public JButton getBtnEnter(){
		return btnEnter;
	}
	
	public JPasswordField getTxtPassWd(){
		return txtPassWd;
	}
	
	
	
	public String getTxtPassWdStr(){
		return txtPassWd.getText();
	}
	
	
}
