package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import control.ScreenSize;

public class MainWindow {
	
	private JFrame frame;
	
	public MainWindow(){
		
		frame = new JFrame();
		//JTable table = new JTable(100,4);
		frame.setSize(400, 300);
		frame.setLocation((ScreenSize.getScreenWidth() -frame.getWidth())/2, ScreenSize.getScreenHeight()/2 - (int)(frame.getHeight()/1.5) );
		
		
		
		
		
		
		
		
        String []a = {"a","b","c"};
        String [][]b = {{"a1","a2","a3"},
                        {"b1","b2","b3"},
                        {"c1","c2","c3"}};
        
        //1. 모델과 데이터를 연결
        DefaultTableModel model = new DefaultTableModel(b,a);
        
        //2. Model을 매개변수로 설정, new JTable(b,a)도 가능하지만 
        //삽입 삭제를 하기 위해 해당 방법을 사용합니다
        JTable table = new JTable(model);
        
        //3. 결과적으로는 JScrollPane를 추가합니다.
        JScrollPane sc = new JScrollPane(table);
        
        //4. 컴포넌트에  Table 추가
        frame.getContentPane().add(sc, "Center");
        
        //테이블에 데이터 추가하기
        //원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
        DefaultTableModel m =
                (DefaultTableModel)table.getModel();
        //모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
        m.insertRow(1, new Object[]{"d1","d2","d3"});
        
        
        
//[출처] [Java] 자바 GUI, JTable 만들기 / Table 데이터 추가하기|작성자 Printf
		
		
		
		
		table.updateUI();
		
	}
	
	
	public void show(){
		frame.show();
	}
	
	
	public void dispose(){
		frame.dispose();
	}
	
}
