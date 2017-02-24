package view;


import javax.swing.*;

import control.GetTime;
import control.ScreenSize;

public class PageWindow {
	
	
	private JFrame frame;
	private JButton btnSave;
	private JButton btnCancel;
	private JLabel lblTitle;
	private JTextArea text;
	
	public PageWindow() {
		
		frame = new JFrame();
		frame.setLocation((ScreenSize.getScreenWidth() - frame.getWidth())/2, ScreenSize.getScreenHeight()/2 - (int)(frame.getHeight()/1.5) );
		
		
		lblTitle = new JLabel();
		setLblMsg(null);
		btnSave = new JButton("저장 후 종료");
		btnCancel = new JButton("삭제");
		text = new JTextArea();
		
		JPanel pnlUp = new JPanel();
		JScrollPane sc = new JScrollPane(text);
		
		text.setLineWrap(true);
		
		
		frame.setSize(400, 300);
		frame.getContentPane().add(pnlUp, "North");
		pnlUp.add(lblTitle);
		pnlUp.add(btnSave);
		pnlUp.add(btnCancel);
		frame.getContentPane().add(sc, "Center");
		
	}
	
	
	public void show(){
		frame.show();
	}
	
	public void dispose(){
		frame.dispose();
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public JButton getBtnSave(){
		return btnSave;
	}
	
	public JButton getBtnCancel(){
		return btnCancel;
	}
	
	public JTextArea getTextArea(){
		return text;
	}
	
	public void setLblMsg(String input){
		lblTitle.setText(input + " 자기소개서");
	}
	
	
	
}
