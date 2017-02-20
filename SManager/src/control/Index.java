package control;


import view.LogInWindow;
import view.MainWindow;

public class Index {
	
	public static void main(String args[]){
		
		LogInWindow a = new LogInWindow();
		a.show();
		LogInProcess logIn = new LogInProcess(a);
		
		while(!logIn.getValidation()){System.out.print("");}
		a.dispose();
		
		MainWindow b = new MainWindow();
		b.show();
		
		
		
	}
	
	
}

