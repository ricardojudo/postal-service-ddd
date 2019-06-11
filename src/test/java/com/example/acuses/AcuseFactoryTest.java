package com.example.acuses;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.acuses.Acuse;
import com.example.acuses.AcuseFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcuseFactoryTest {

	@Autowired
	private AcuseFactory factory;
	
	
	@Test
	public void testCreateAcuse() {
		Acuse acuse = factory.createAcuse();
		assertNotNull("Acuse nulo", acuse);
	}

}
