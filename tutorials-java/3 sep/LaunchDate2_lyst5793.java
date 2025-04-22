import java.time.*;
public class LaunchDate2 
{

	public static void main(String[] args) 
	{
		
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
