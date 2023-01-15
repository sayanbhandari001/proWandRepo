package weekSelectionAndLogging;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WeekHelper {

	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public static Date getStartDate(Date currDate) {
		Calendar cStart = Calendar.getInstance();
		cStart.setTime(currDate);
		cStart.setFirstDayOfWeek(Calendar.MONDAY);
		cStart.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cStart.set(Calendar.HOUR_OF_DAY, 13);
		cStart.set(Calendar.MINUTE, 30);
		cStart.set(Calendar.SECOND, 0);
		cStart.set(Calendar.MILLISECOND, 0);
		// System.out.println("Date " + cStart.getTime());
		return cStart.getTime();
	}

	public static Date getEndDate(Date currDate) {
		Calendar cEnd = Calendar.getInstance();
		cEnd.setTime(currDate);
		cEnd.setFirstDayOfWeek(Calendar.MONDAY);
		cEnd.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cEnd.set(Calendar.HOUR_OF_DAY, 13);
		cEnd.set(Calendar.MINUTE, 30);
		cEnd.set(Calendar.SECOND, 0);
		cEnd.set(Calendar.MILLISECOND, 0);
		// System.out.println("Date " + cEnd.getTime());
		return cEnd.getTime();
	}

	public static String getSelectionValue(Date currDate) {
		return sdf.format(getStartDate(currDate)) + " - " + sdf.format(getEndDate(currDate));
	}

	public static long dayOfTheWeekIndex(Date currDate) {
		long diff = new Date().getTime() - getStartDate(currDate).getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	

	public static void main(String[] args) {

//		WebDriver driver = new ChromeDriver();
//		System.out.println(WeekHelper.getSelectionValue(new Date()));
		System.out.println(WeekHelper.dayOfTheWeekIndex(new Date()));
//		System.out.println(driver.findElement(By.xpath(
//				"//input[@id='billingDetailItems " + WeekHelper.dayOfTheWeekIndex(new Date()) + ".noBreakTaken1']")));

		
	}
}
