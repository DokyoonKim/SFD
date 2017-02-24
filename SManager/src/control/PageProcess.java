package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import model.Data;
import model.Person;
import view.MainWindow;
import view.PageWindow;

public class PageProcess implements WindowListener, ActionListener {
	
	PageWindow view;
	DataManager data = new DataManager();
	private int studentInfo;
	private String targetTime = null;
	
	
	
	public PageProcess(PageWindow inView, int inInfo){
		
		data.readData();
		
		view = inView;
		studentInfo = inInfo;
		
		view.getFrame().addWindowListener(this);
		view.getBtnSave().addActionListener(this);
		view.getBtnCancel().addActionListener(this);
		

		view.setLblMsg(studentInfo+"");
		
		view.show();
		
	}
	
	public PageProcess(PageWindow inView, int inInfo, String inTime){
		
		data.readData();
		
		view = inView;
		studentInfo = inInfo;
		targetTime = inTime;
		
		view.getFrame().addWindowListener(this);
		view.getBtnSave().addActionListener(this);
		view.getBtnCancel().addActionListener(this);
		
		for(int i = 0; i < data.getData().size(); i++){
			Person tmp = data.getData().get(i);
			
			System.out.println(tmp.getGrade()*10000 + tmp.getClassNum()*100 + tmp.getNumber());
			System.out.println(inInfo);
			
			if(tmp.getGrade()*10000 + tmp.getClassNum()*100 + tmp.getNumber() == inInfo){
				for(int j = 0; j < tmp.getData().size(); j++){
					if(tmp.getData().get(j).getTime().equals(targetTime)){
						view.getTextArea().setText(tmp.getData().get(j).getContent());
					}
				}
			}
		}
		
		view.setLblMsg("(수)" + studentInfo);
		
		view.show();
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		
		view.dispose();
		new MainProcess(new MainWindow());
	}
	
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(view.getBtnSave())){
			
			
			Data datToSave = new Data(GetTime.currToString(), view.getTextArea().getText());
			
			Boolean isSaved = false;
			
			int iGrade = studentInfo/10000;
			int iClass = (studentInfo/100)%100;
			int iNum = studentInfo%100;
			
			
			for(int i = 0; i < data.getData().size(); i++){
				
				Person selected = data.getData().get(i);
				
				if (selected.getGrade() == iGrade && selected.getClassNum() == iClass && selected.getNumber() == iNum){
					
					data.getData().get(i).getData().add(datToSave);
					
					isSaved = true;
					break;
					
				}
			}
			
			
			if(!isSaved){
				Person tmp = new Person(iGrade, iClass, iNum, new ArrayList<Data>());
				tmp.getData().add(datToSave);
				data.getData().add(tmp);
			}
			
//			정보에 해당하는 학생 클래스를 찾은 후
//			그 학생 정보에 더하는 방식으로 진
			
			
			data.writeData();
			
			view.dispose();
			new MainProcess(new MainWindow());
			
		}
		else if(e.getSource().equals(view.getBtnCancel())){
			view.dispose();
			new MainProcess(new MainWindow());
		}
		
	}
	
	
	
	
}
