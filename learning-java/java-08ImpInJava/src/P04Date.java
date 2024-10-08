import java.time.*;

class DateEx1 {
	@SuppressWarnings("deprecation")
	public DateEx1() {
		java.util.Date date = new java.util.Date();
		System.out.println(date);
		
		int month=date.getMonth();
		System.out.println("Month : "+ month);
		
		int time = (int) date.getTime();
		java.sql.Date dt = new java.sql.Date(time);
		System.out.println(dt);		
	}
}

class DateEx2 {
	public DateEx2() {
		LocalDate date=LocalDate.now();
        System.out.println(date);
        
       int day= date.getDayOfMonth();
       System.out.println("Day : "+day);
        int month=date.getMonthValue();
        System.out.println("Month : "+month);
        
        int dayOfYear=date.getDayOfYear();
        System.out.println("Day of year is : "+dayOfYear);
        int year=date.getYear();
        System.out.println(year);
        
        System.out.println(day + " / "+ month + " / "+ year);
        
        LocalTime time=LocalTime.now();
        System.out.println("Time : "+time);
        
        int hour=time.getHour();
        System.out.println(hour);
        int min=time.getMinute();
        System.out.println(min);
        int sec=time.getSecond();
        System.out.println(sec);
        int nano=time.getNano();
        System.out.println(nano);
        
        System.out.println(hour+ " : " + min + " : " + sec + " : "+ nano);
	}
}


public class P04Date {
	public static void main(String[] args) {
		new DateEx1();
		new DateEx2();
	}
}
