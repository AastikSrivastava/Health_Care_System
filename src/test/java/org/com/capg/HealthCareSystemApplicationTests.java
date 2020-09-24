package org.com.capg.healthcare;

import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;
import org.com.capg.healthcare.service.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthCareSystemApplicationTests {

	@Autowired 
	private TestService testService;
	
	@Test
	public void testAddTestOne() throws TestNotFoundException, CenterNotFoundException, NameAlreadyExistException
	{
		String expected = "Test added successfully for center ";
		
		
		String actual = testService.addTestToCenter("applo","kidney");
		
		Assertions.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testAddToCenter() throws TestNotFoundException, CenterNotFoundException, NameAlreadyExistException
	{
		Assertions.assertThrows(CenterNotFoundException.class, ()->testService.addTestToCenter("max", "covid19"));
	
	}
	
	
	@Test
	public void testAddToCenterTwo() throws TestNotFoundException, CenterNotFoundException, NameAlreadyExistException
	{
		Assertions.assertThrows(TestNotFoundException.class, ()->testService.addTestToCenter("applo", "999"));
	
	}
	
}
