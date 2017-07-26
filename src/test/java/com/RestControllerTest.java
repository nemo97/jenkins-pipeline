package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by popy on 7/25/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void indexTest(){
        String body = this.restTemplate.getForObject("/",String.class);
        assertThat(body).isNotEmpty();
    }

    @Test
    public void hello(){
        String body = this.restTemplate.getForObject("/hello", String.class);
        assertThat(body).isEqualTo("Hello World");
    }

}
