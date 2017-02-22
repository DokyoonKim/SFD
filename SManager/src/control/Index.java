package control;


import model.Person;
import view.LogInWindow;
import view.MainWindow;
import view.PageWindow;


public class Index {
	
	public static void main(String args[]){
		
		LogInWindow a = new LogInWindow();
		a.show();
		LogInProcess logIn = new LogInProcess(a);
		
		while(!logIn.getValidation()){System.out.print("");}
		a.dispose();
		
		PageWindow c = new PageWindow();
		c.show();
		
		MainWindow b = new MainWindow();
		MainProcess Main = new MainProcess(b);
		b.show();
		
	}
	
	
}

