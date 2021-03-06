package com.eboot;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Created by iagu on 3/23/17.
 */
@RestController @RequestMapping("/jenkins") public class JenkinsController
{

    private static final String JENKINS_USERNAME = "yanki";
    private static final String JENKINS_TOKEN = "dee9d5070ab7bb79132f724f11ffc40c";
    private static final String CRUMB = "9657500fa32133c0176ade354f709017";
    private static final String JOB_TOKEN = "eboot";

    @RequestMapping(value = "/{jobUrl}", method = RequestMethod.GET) public void stopBuild(
            @PathVariable String jobUrl)
    {
        String uri = null;
        System.out.println("The job url is " + jobUrl);
        try
        {
            uri = new String(java.util.Base64.getDecoder().decode(jobUrl));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate
                    .exchange(uri, HttpMethod.POST, new HttpEntity<String>(
                                    createHeaders(JENKINS_USERNAME, JENKINS_TOKEN)),
                            String.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/{jobUrl}/{jobUrlForTrigger}/{lastPart}", method = RequestMethod.GET) public void restartBuild(
            @PathVariable String jobUrl, @PathVariable String jobUrlForTrigger,
            @PathVariable String lastPart)
    {
        String uri = null;
        try
        {
            stopBuild(jobUrl);
            uri = new String(java.util.Base64.getDecoder()
                    .decode(jobUrlForTrigger + "/" + lastPart));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate
                    .exchange(uri, HttpMethod.POST, new HttpEntity<String>(
                                    createHeaders(JENKINS_USERNAME, JENKINS_TOKEN)),
                            String.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private HttpHeaders createHeaders(String username, String password)
    {
        return new HttpHeaders()
        {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64
                    .encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
            set("Jenkins-Crumb", CRUMB);
        }};
    }
}
