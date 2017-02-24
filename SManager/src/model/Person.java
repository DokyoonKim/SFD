package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
	
	private int grade;
	private int classNum;
	private int number;
	private ArrayList<Data> data;
	
	public Person(int iG, int iC, int iN, ArrayList<Data> iD){
		grade = iG;
		classNum = iC;
		number = iN;
		data = iD;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	
	
}
