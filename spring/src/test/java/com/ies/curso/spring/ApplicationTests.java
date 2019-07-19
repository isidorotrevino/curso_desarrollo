package com.ies.curso.spring;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	protected ApplicationContext ctx;
	
	@Test
	public void contextLoads() {
		assertNotNull(ctx);
		System.out.println("Application Context: "+ctx);
	}

}
