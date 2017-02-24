package model;

import java.io.Serializable;

import javax.swing.*;

public class Data implements Serializable {
	
	private String time;
	private String content;
	
	public Data(String iTime, String iContents){
		
		time = iTime;
		content = iContents;
		
	}
	
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
