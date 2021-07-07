package com.cdfi.group;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupMemberProfileServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    String baseUrl;

    static URI uri;
    static String token;
    @Before
    public void init() throws URISyntaxException {
        baseUrl = "http://localhost:"+randomServerPort;
        uri = new URI(baseUrl + "/users/login");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("login", "sraj1");
        map.add("password", "password");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity( uri, request, String.class );

        token = response.getHeaders().getFirst("Authorization");
    }

    @Test
    public void testUploadJson() throws URISyntaxException {
        uri = new URI(baseUrl + "/group-v1/mobile/upload");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("User", "sraj1");
        headers.set("X-Tenant-Identifier", "dynamic_lokos");
        headers.set("Authorization", token);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("files", new org.springframework.core.io.ClassPathResource("files/pic1.jpg"));
        body.add("shgProfile", new org.springframework.core.io.ClassPathResource("files/uploadShg.json"));
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate
                .postForEntity(uri, requestEntity, String.class);
        Assert.assertEquals(200, response.getStatusCodeValue());
    }
}
