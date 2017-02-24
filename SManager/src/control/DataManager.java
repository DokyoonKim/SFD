package control;


import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Data;
import model.Person;

public class DataManager {
	
	private ArrayList<Person> datum;
	
	public DataManager(){
		
		datum = new ArrayList<Person>();
		
	}
	
	
	
	public ArrayList<Person> getData() {
		return datum;
	}
	
	public void setData(ArrayList<Person> inData){
		datum = inData;
	}
	
	
	
	public void readData(){
		
		datum.clear();
		
		try{
			FileInputStream f = new FileInputStream("data.sdf");
			ObjectInputStream o = new ObjectInputStream(f);
			
			datum = (ArrayList<Person>) o.readObject();
			
			if(o != null) o.close();
			if(f != null) f.close(); 
			
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null, "파일을 읽을 수 없습니다. 새로운 파일을 생성합니다.");
			writeData();
		}
		catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "Internal error corrupted");
		}
		
		System.out.println(datum.size());
		
		
		
	}
	
	
	
	public void writeData(){
		
		try{
			FileOutputStream f = new FileOutputStream("data.sdf");
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(datum);
			
			if(o != null) o.close();
			if(f != null) f.close(); 
			
		}
		catch(IOException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cannot record file");
		}
		
	}
	
	
	
}
