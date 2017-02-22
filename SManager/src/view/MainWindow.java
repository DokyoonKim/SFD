//[출처] [Java] 자바 GUI, JTable 만들기 / Table 데이터 추가하기|작성자 Printf

package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import control.ScreenSize;

public class MainWindow {
	
	private JFrame frame;
	private JTextField txtDate;
	private JTable table;
	private JScrollPane scrollPane;
	
	public MainWindow(){
		
		frame = new JFrame();
		txtDate = new JTextField();
		
		JLabel title = new JLabel(" 연월일 ex>20180101");
		frame.setSize(400, 300);
		frame.setLocation((ScreenSize.getScreenWidth() -frame.getWidth())/2, ScreenSize.getScreenHeight()/2 - (int)(frame.getHeight()/1.5) );
		JPanel northPane = new JPanel();
		
		
		
        String[] colTitle = {"Date","Version"};
        String[][] data = {{"2018/03/02","00"},
                        {"2018/03/02","01"},
                        {"2018/03/03","01"}};
        
        
        
        //1. 모델과 데이터를 연결
        DefaultTableModel model = new DefaultTableModel(data,colTitle);
        northPane.setLayout(new GridLayout(1,3));
        
        
        //2. Model을 매개변수로 설정, new JTable(b,a)도 가능하지만 
        //삽입 삭제를 하기 위해 해당 방법을 사용합니다
        table = new JTable(model);
        
        //3. 결과적으로는 JScrollPane를 추가합니다.
        scrollPane = new JScrollPane(table);
        
        //4. 컴포넌트에  Table 추가
        frame.getContentPane().add(northPane, "North");
        frame.getContentPane().add(scrollPane, "Center");
        
        northPane.add(title);
        northPane.add(this.txtDate);
		

		
	}
	
	
	
	public void updateTable(String date, String version){
		
        //테이블에 데이터 추가하기
        //원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
        DefaultTableModel m =
                new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column){
        		return false;
        	}
        };
        
        m = (DefaultTableModel)table.getModel();
        
        //모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
        m.insertRow(m.getRowCount(), new Object[]{date, version});
        
		table.updateUI();
		
	}
	
	
	
	public JTable getTable(){
		return table;
	}
	
	public JTextField getTxtDate(){
		return txtDate;
	}
	
	
	
	public void show(){
		frame.show();
	}
	
	
	public void dispose(){
		frame.dispose();
	}
	
}
