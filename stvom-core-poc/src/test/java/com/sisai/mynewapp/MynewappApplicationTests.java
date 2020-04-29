package com.sisai.mynewapp;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sisai.mynewapp.listener.Person;
import com.sisai.mynewapp.manager.TimeService;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class MynewappApplicationTests {
	
	
	@Test
	public final void testFindByTimestamp() {
		List<Person> list=(new TimeService()).findByTimestamp(25);
		assertEquals("List may be empty",0,list.size());
	}

}
