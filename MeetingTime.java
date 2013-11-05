
public class MeetingTime 
{
	
	private Time startTime;
	private Time endTime;
	


public MeetingTime(Time stTime,Time enTime)
	{
	if (stTime.getminutesFromReference()> enTime.getminutesFromReference())
		{
		throw new Error("Start Time is after end time");
		}
	else
		{
		this.startTime=stTime;
		this.endTime=enTime;
		}
	}

public Time getStartTime()
{
	return this.startTime;
}

public Time getEndTime()
{
	return this.endTime;
}

public boolean Overlap(MeetingTime mt2)
{
   	Time mt2StartTime=mt2.getStartTime();
   	Time mt2EndTime=mt2.getEndTime();
   	
   	if (mt2StartTime.getminutesFromReference() > this.startTime.getminutesFromReference() && mt2StartTime.getminutesFromReference() < this.endTime.getminutesFromReference())
   	{
   		return true;
   		
   	}
   	else if (mt2EndTime.getminutesFromReference() > this.startTime.getminutesFromReference() && mt2StartTime.getminutesFromReference() < this.endTime.getminutesFromReference())
   	{
   		return true;
   	}
   	else if (this.startTime.getminutesFromReference() > mt2StartTime.getminutesFromReference() && this.startTime.getminutesFromReference() < mt2EndTime.getminutesFromReference())
   	{
   		return true;
   		
   	}
	else if (this.endTime.getminutesFromReference() > mt2StartTime.getminutesFromReference() && this.endTime.getminutesFromReference() < mt2EndTime.getminutesFromReference())
   	{
   		return true;
   		
   	}
   	else if ((mt2StartTime.getminutesFromReference() == this.startTime.getminutesFromReference()) || (mt2StartTime.getminutesFromReference() == this.endTime.getminutesFromReference()) ||
   			(mt2EndTime.getminutesFromReference() == this.startTime.getminutesFromReference()) || (mt2EndTime.getminutesFromReference() == this.endTime.getminutesFromReference()))
   			{
   				return true;
   			}
   	else return false;
}
}
