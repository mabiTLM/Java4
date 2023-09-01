package webClass230901;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void test() {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		System.out.println(sdf.format(now));
//		now.getHours()
		
//		Calendar
	}
}
