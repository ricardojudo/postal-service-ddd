package com.example.acuses;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import com.example.acuses.Acuse;

public class AcuseTest {
	
	private Acuse acuse;
	
	@Before
	public void setUp() {
		acuse=new Acuse();
	}
	
	@Test
	public void testAcuse() {
		assertNotNull("Acuse nulo", acuse);
	}
}
