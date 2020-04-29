package com.sisai.mynewapp;

import static org.junit.Assert.*; 

import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.sisai.mynewapp.listener.Person;
import com.sisai.mynewapp.manager.TimeService;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ServiceTest {
	
	
	@Test
	public final void testFindByTimestamp() {
		//List<Person> list=(new TimeService()).findByTimestamp(25);
		assertEquals("List may be empty",0,(new TimeService()).findByTimestamp(25).size());
	}

}
