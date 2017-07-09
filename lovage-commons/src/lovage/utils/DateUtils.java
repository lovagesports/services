package lovage.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date fromPieces(int year, int month, int day, int hour, int minute, int second) {

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month - 1, day, hour, minute, second);
		Date date = calendar.getTime();
		return date;
	}

	public static Date fromPieces(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(year, month - 1, day);
		Date date = calendar.getTime();
		return date;
	}
}
