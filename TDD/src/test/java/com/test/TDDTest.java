package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TDDTest {
	
	TDD tdd=new TDD();
	
	@Test
	public void whenNumberStringIsEmpty()
	{
	assertEquals(0, tdd.addNumber(""));	
	}
	
	
	@Test
	public void whenNumberStringIsValid()
	{
	assertEquals(6, tdd.addNumber("1,5"));	
	}
	
	@Test
	public void whenNumberStringIsInValid()
	{
	assertEquals(57, tdd.addNumber("1,e245,56"));	
	}
	
	@Test
	public void whenNumberStringIsContainsEscapeChracters()
	{
	assertEquals(53, tdd.addNumber("1\n,52"));	
	}
	
	@Test
	public void whenNumberStringIsContainsEscapeChracters_2()
	{
	assertEquals(1, tdd.addNumber("1,\n"));	
	}
	
	@Test
	public void whenNumberStringContainsNegative()
	{
		try
		{
	int addNumber = tdd.addNumber("1,-1");
		}catch(Exception ex)
		{
			assertEquals("negative numbers not allowed negative_number", ex.getMessage());	
		}

	}
	
	@Test
	public void whenNumberStringContainsMultipleNegative()
	{
		try
		{
	int addNumber = tdd.addNumber("1,-1,-2,-4,-8");
		}catch(Exception ex)
		{
			boolean containsMultipleNumbers=ex.getMessage().contains("negative numbers found");
			assertTrue(containsMultipleNumbers);
		}

	}

}
