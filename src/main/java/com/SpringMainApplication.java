package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSource.class})
public class SpringMainApplication {


	public static void main(String[] args) {

		SpringApplication.run(SpringMainApplication.class);
	}


}

