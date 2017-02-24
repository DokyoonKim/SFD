package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.LogInWindow;

public class LogInProcess implements ActionListener {
	
	private LogInWindow view;
	private boolean isValidate;
	
	public LogInProcess(LogInWindow inView) {
		
		view = inView;
		view.getTxtPassWd().addActionListener(this);
		view.getBtnEnter().addActionListener(this);
		
		view.show();
		
		isValidate = false;
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(view.getBtnEnter()) || e.getSource().equals(view.getTxtPassWd()) ){
			
			//암호화 및 복호화 클래스랑 연결 
			if(view.getTxtPassWdStr().equals("1234")){
				isValidate = true;
			}
			else{
				JOptionPane.showMessageDialog(view.getBtnEnter(), "Wrong password");
			}
			
		}
		
		
	}
	
	
	public boolean getValidation(){
		return isValidate;
	}
	
	
}
