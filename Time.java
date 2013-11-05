
public class Time 
{
	private int minutesFromReference;
	private static final int numOfMinsInAnHour=60;
	private  static final int numOfHoursInADay=24;
	private static final int maxMinutesInAWeek= numOfHoursInADay * numOfMinsInAnHour * 7;
	
	public int getminutesFromReference()
	{
		return this.minutesFromReference;
	}
	
	public Time(int minsFromReference)
	{
		if (minsFromReference > maxMinutesInAWeek)
			{
			throw new Error("Invalid number of minutes");
			}
		else
		{
		this.minutesFromReference = minsFromReference;
	}
	}
	
	public DaysOfWeek getDay()  
	{
	  		int dayIndex =(int) Math.floor(minutesFromReference/(numOfMinsInAnHour*numOfHoursInADay));
	 		switch(dayIndex)
	 		{
		 		case(0): return DaysOfWeek.MONDAY; 
				case(1): return DaysOfWeek.TUESDAY; 
	 			case(2): return DaysOfWeek.WEDNESDAY; 
	 			case(3): return DaysOfWeek.THURSDAY; 
	 	 		case(4): return DaysOfWeek.FRIDAY; 
	 			case(5): return DaysOfWeek.SATURDAY; 
		 		case(6): return DaysOfWeek.SUNDAY; 
		 		default: throw new Error("Invalid MinutesfromReference value"); 			
	 		}
	 }
	
	 		
	public TimeOfDay TimeOfTheDay()
	{
			double  a = (double)minutesFromReference/(numOfMinsInAnHour*numOfHoursInADay) ;
			double partialDayComponent = (double) (a - Math.floor(a));
			int hourComponent = (int)Math.floor(partialDayComponent * 24);
			double partialHourComponent = (partialDayComponent * 24) - hourComponent;
			int minComponent = (int)Math.round(partialHourComponent * 60);
			return (new TimeOfDay(hourComponent, minComponent));
	
	}
			
}
	  		  

