package com.sisai.mynewapp;

import org.springframework.boot.SpringApplication;     

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication (exclude= {DataSourceAutoConfiguration.class})
@EnableJms
public class StvomCorePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(StvomCorePocApplication.class, args);
	}

}