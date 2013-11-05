import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MeetingTimeTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testMeetingTime() {
		new MeetingTime(new Time(1500),new Time(1440)) ;
		expectedException.expectMessage("Start Time is after end time");
		
	}

	@Test
	public void testOverlapReturnsTrueWhenMt2StartTimeBetweeenMt1STandET() {
	MeetingTime mt1 = new MeetingTime(new Time(1440),new Time(1500)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1460),new Time(1520)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt2EndTimeTimeBetweeenMt1STandET() {
	MeetingTime mt1 = new MeetingTime(new Time(1440),new Time(1500)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1400),new Time(1460)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt1StartTimeBetweeenMt2STandET() {
	MeetingTime mt1 = new MeetingTime(new Time(1440),new Time(1560)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1400),new Time(1460)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt1EndTimeBetweeenMt2STandET() {
	MeetingTime mt1 = new MeetingTime(new Time(1390),new Time(1450)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1400),new Time(1460)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt1StartTimeEqualsMt2ST() {
	MeetingTime mt1 = new MeetingTime(new Time(1390),new Time(1450)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1390),new Time(1465)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt1StartTimeEqualsMt2ET() {
	MeetingTime mt1 = new MeetingTime(new Time(1390),new Time(1450)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1300),new Time(1390)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt1EndTimeEqualsMt2ET() {
	MeetingTime mt1 = new MeetingTime(new Time(1390),new Time(1450)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1360),new Time(1450)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsTrueWhenMt1EndTimeEqualsMt2ST() {
	MeetingTime mt1 = new MeetingTime(new Time(1390),new Time(1450)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1450),new Time(1510)) ;
	boolean expectedValue=true;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void testOverlapReturnsFalseWhenMt1AndMt2DoNotOverlap() {
	MeetingTime mt1 = new MeetingTime(new Time(1390),new Time(1450)) ;
	MeetingTime mt2 = new MeetingTime(new Time(1890),new Time(1865)) ;
	boolean expectedValue=false;
	boolean actualValue= mt1.Overlap(mt2);
	assertEquals(expectedValue,actualValue);
	}
	


}
