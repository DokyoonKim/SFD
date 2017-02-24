package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Data;
import model.Person;
import view.MainWindow;
import view.PageWindow;

public class MainProcess implements MouseListener, KeyListener, ActionListener {
	
	private MainWindow view;
	private DataManager data = new DataManager();
	private int pNum = 0;
	
	public MainProcess(MainWindow inView){
		
		view = inView;
		view.getTable().addMouseListener(this);
		view.getTxtDate().addKeyListener(this);
		view.getBtnNew().addActionListener(this);
		
		view.show();
		
		data.readData();
		

		
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(view.getTable().getSelectedRow());
		String targetTime = (String)view.getTable().getValueAt(view.getTable().getSelectedRow(), 0);
		
		new PageProcess(new PageWindow(), pNum, targetTime);
		
		view.dispose();
		
	}


	@Override
	public void mousePressed(MouseEvent e) {}



	@Override
	public void mouseReleased(MouseEvent e) {}



	@Override
	public void mouseEntered(MouseEvent e) {}



	@Override
	public void mouseExited(MouseEvent e) {}




	@Override
	public void keyTyped(KeyEvent e) {}




	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == '\n'){
			
			int iGrade;
			int iClass;
			int iNum;
			
			view.clearTable();
			
			
			
			
			String input = view.getTxtDate().getText();
			
			if(input.equals("all")){
				
				for(int i = 0; i < data.getData().size(); i++){
					
					Person select = data.getData().get(i);
					
					for(int j = 0; j < select.getData().size(); j++){
						String tmp = select.getGrade() + String.format("%02d", select.getClassNum()) + String.format("%02d", select.getNumber());
						view.updateTable("(" + tmp + ") " + select.getData().get(i).getTime());
					}
				}
				
				return;
			}
			
			
			
			try{
				pNum = Integer.parseInt(input);
			}
			catch(java.lang.NumberFormatException e1){
				JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
			}
			iGrade = pNum/10000;
			iClass = (pNum/100)%100;
			iNum = pNum%100;
			
			
			for(int i = 0; i < data.getData().size(); i++){
				
				Person select = data.getData().get(i);
				
				if(select.getGrade() == iGrade && select.getClassNum() == iClass && select.getNumber() == iNum){
					for(int j = 0; j < select.getData().size(); j++){
						view.updateTable(select.getData().get(i).getTime());
					}
				}
				
			}
			
			if(view.getTable().getValueAt(0, 0).toString().matches("Empty")){
				view.updateTable("Empty - " + iGrade +"학년 "+ iClass + "반 " + iNum + "번 학생에게 새로운 문서를 작성합니다.");
			}
			
			
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "새 자기소개서를 작성합니다.");
		new PageProcess(new PageWindow(), pNum);
		view.dispose();
		
	}

}
