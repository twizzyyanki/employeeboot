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
		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}

	@Test
	public void contextLoads2() {
		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}

	@Test
	public void contextLoads3() {
		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}

	@Test
	public void contextLoads4() {
		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}

	@Test
	public void contextLoads5() {
		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}

	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}

}
