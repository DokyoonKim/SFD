//http://blog.daum.net/_blog/BlogTypeView.do?blogid=0XrpC&articleno=170&categoryId=0&regdt=20131124203647

package control;

import java.util.Calendar;

public class GetTime {
	
	private static Calendar cal;
	
	public static String currToString(){
		cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + " " 
				+ cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	}
	
}
