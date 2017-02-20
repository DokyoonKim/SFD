package control;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {
	
	private static double screenWidth;
	private static double screenHeight;
	
	public static int getScreenWidth(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.getWidth();
		return (int)screenWidth;
	}
	
	public static int getScreenHeight(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenHeight = screenSize.getHeight();
		return (int)screenHeight;
	}
	
}
