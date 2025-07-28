package JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomcount = random.nextInt(10000);
		return randomcount;
	}
	
	public String getCurrentDate() {
//		Get today’s full date/time
		Date date = new Date();
//		Decide the format we want
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
//		Convert the full date into a formatted string		
		String currentdate = sim.format(date);
		return currentdate;		
	}
	
	
	   public String togetRequired(int days) {
	        Calendar cal = Calendar.getInstance(); // current date
	        cal.add(Calendar.DAY_OF_MONTH, days); // add required days
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        return formatter.format(cal.getTime());
	    }

	
//	public String togetRequired(int days) {
//		Date date = new Date();
//		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
//		sim.format(date);
////		This creates a calendar object based on the formatter's internal calendar.
//		Calendar cal = sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, days);
//		String daterequired = sim.format(cal.getTime());
////		Converts the new date (after adding days) into a formatted string like "08-13-2025".
//		return daterequired;
//	}
}
