package com.eboot;

import java.util.Base64;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

import static junit.framework.TestCase.fail;

@RunWith(SpringRunner.class) @SpringBootTest public class EmployeebootApplicationTests
{

    @Test public void contextLoads()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads2()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads3()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads4()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads5()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads6()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads7()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads8()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads9()
    {
        whatToDoInTest();
    }

    @Test public void contextLoads10()
    {
        whatToDoInTest();
    }

    private boolean getRandomBoolean()
    {
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
        Assert.assertEquals(true, condition);
    }

    @Rule public TestRule listen = new TestWatcher()
    {
        @Override public void failed(Throwable t, Description description)
        {
            String serviceUrl = "http://localhost:9191/jenkins/";
            Map<String, String> jenkinsEnvVariable = System.getenv();
            //final String endpoint = "https://hooks.slack.com/services/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";
            //final String endpoint = "https://hooks.slack.com/services/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";
            final String endpoint = "http://6ab11aaa.ngrok.io/jenkins/notifications?jobName="
                    + jenkinsEnvVariable.get("JOB_BASE_NAME")
                    + "&buildNumber="
                    + jenkinsEnvVariable.get("BUILD_ID");
            String urlParam = "";
            String urlParamForRetrigger = "";

            try
            {
                urlParam = new String(Base64.getEncoder()
                        .encode((jenkinsEnvVariable.get("JOB_URL")
                                + jenkinsEnvVariable.get("BUILD_ID") + "/"
                                + "stop").getBytes()));
                String retriggerUrl =
                        jenkinsEnvVariable.get("JOB_URL") + "build?token="
                                + jenkinsEnvVariable.get("JOB_BASE_NAME");
                urlParamForRetrigger = new String(
                        Base64.getEncoder().encode(retriggerUrl.getBytes()));
            } catch (Exception e)
            {
                e.printStackTrace();
            }

            System.out.println("The url is " + urlParamForRetrigger);
            String text = //"*TEST FAILED: *" + " \n" + jenkinsEnvVariable
                    //.get("JOB_BASE_NAME") + " job, build no "
                    //+ jenkinsEnvVariable.get("BUILD_ID") + " \n" + "<"
                   /// + serviceUrl + urlParam + "|Click to cancel build>" + " | "
                    //+ "<" + serviceUrl + urlParam + "/" + urlParamForRetrigger
                    //+ "|Click to cancel and retrigger build>" + "\n\n"
                    Arrays.toString(t.getStackTrace());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String requestJson = "{\"text\": \"" + text + "\"}";
            HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate
                    .exchange(endpoint, HttpMethod.POST, entity,
                            String.class);

        }
    };
}
