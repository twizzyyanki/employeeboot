package com.eboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static junit.framework.TestCase.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeebootApplicationTests {

	@Test
	public void contextLoads() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads2() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads3() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads4() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads5() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads6() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads7() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads8() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads9() {
		whatToDoInTest();
	}

	@Test
	public void contextLoads10() {
		whatToDoInTest();
	}

	private boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}

	private void whatToDoInTest()
	{
		for (int i=0; i < 1000000000; i++ )
		{
			// just waste time and do nothing
		}
		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}



}
