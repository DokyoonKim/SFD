package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.LogInWindow;

public class LogInProcess implements ActionListener {
	
	private LogInWindow a;
	private boolean isValidate;
	
	public LogInProcess(LogInWindow input) {
		
		a = input;
		a.getBtnEnter().addActionListener(this);
		isValidate = false;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(a.getBtnEnter())){
			
			//암호화 및 복호화 클래스랑 연결 
			
			if(a.getTxtPassWdStr().equals("1234")){
				isValidate = true;
			}
			else{
				JOptionPane.showMessageDialog(a.getBtnEnter(), "Wrong password");
			}
			
		}
		
	}
	
	
	public boolean getValidation(){
		return isValidate;
	}
	
	
}
