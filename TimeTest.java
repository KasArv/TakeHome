

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TimeTest {

		
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testTimeConstructorforExceptionWhenInputMinutesGreaterThanMaxMins() {
		new Time(10090);
		expectedException.expectMessage("Invalid number of minutes");
	}
	
	@Test
	public void testTimeConstructorforValidInputMinutes() {
		Time t= new Time(9090);
		int expectedValue = 9090;
		int actualValue = t.getminutesFromReference();
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetDayforTimeInThursday() {
    Time t = new Time (4320);
    DaysOfWeek expectedValue = DaysOfWeek.THURSDAY;
    DaysOfWeek actualValue = t.getDay();
    assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetDayfor0000HrsMonday() {
    Time t = new Time (0);
    DaysOfWeek expectedValue = DaysOfWeek.MONDAY;
    DaysOfWeek actualValue = t.getDay();
    assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testTimeOfTheDayfor1345HrsOnSunday() {
		Time t = new Time (9465);
		TimeOfDay expectedValue= new TimeOfDay(13,45);
		TimeOfDay actualValue = t.TimeOfTheDay();
		assertEquals(expectedValue.hour, actualValue.hour);
		assertEquals(expectedValue.minute, actualValue.minute);
	}
	
	@Test
	public void testTimeOfTheDayfor0000HrsOnMonday() {
		Time t = new Time (0);
		TimeOfDay expectedValue= new TimeOfDay(0,0);
		TimeOfDay actualValue = t.TimeOfTheDay();
		assertEquals(expectedValue.hour, actualValue.hour);
		assertEquals(expectedValue.minute, actualValue.minute);
	}

}
