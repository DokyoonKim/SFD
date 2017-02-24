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
	private JButton btnNew;
	
	private String[] colTitle = {"Date"};
	private String[][] data = {{"Empty"}};
	
	public MainWindow(){
		
		frame = new JFrame();
		txtDate = new JTextField();
		btnNew = new JButton("New");
		
		JLabel title = new JLabel("학년반번호 ex>30101");
		frame.setSize(400, 300);
		frame.setLocation((ScreenSize.getScreenWidth() -frame.getWidth())/2, ScreenSize.getScreenHeight()/2 - (int)(frame.getHeight()/1.5) );
		JPanel northPane = new JPanel();
		
        
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
        northPane.add(btnNew);
		

		
	}
	
	
	
	public void updateTable(String date){
		
        //테이블에 데이터 추가하기
        //원본데이터를 건들지 않고 table의 매개변수인 model에 있는 데이터를 변경합니다
        DefaultTableModel m =
                new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column){
        		return false;
        	}
        };
        
        m = (DefaultTableModel)table.getModel();
        
        if(m.getValueAt(0, 0).toString().matches("Empty"))
        	m.removeRow(0);
        
        //모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
        m.insertRow(m.getRowCount(), new Object[]{date});
        
		table.updateUI();
		
	}
	
	
	
	public void clearTable(){
		
        DefaultTableModel m =
                new DefaultTableModel() {
        	public boolean isCellEditable(int row, int column){
        		return false;
        	}
        };
        
        m = (DefaultTableModel)table.getModel();
        
        int currTableRow = table.getRowCount();
        for(int i = 0; i < currTableRow; i++)
        	m.removeRow(0);
        
        m.insertRow(0, new String[]{"Empty"});
        
        
		table.updateUI();
		
	}
	
	
	
	public JTable getTable(){
		return table;
	}
	
	public JTextField getTxtDate(){
		return txtDate;
	}
	
	public JButton getBtnNew(){
		return btnNew;
	}
	
	
	
	public void show(){
		frame.show();
	}
	
	
	public void dispose(){
		frame.dispose();
	}
	
}
