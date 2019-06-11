package com.example.mensajes.events;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.mensajes.Mensaje;
import com.example.mensajes.MensajeEvent;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class MensajeEventsRepositoryTest {

	
	@Autowired
	private MensajeEventRepository repository;
	
	@Test
	public void testSave() {
		MensajeEvent e = new MensajeEvent(new Mensaje<String>());
		MensajeEvent a = repository.save(e);
		assertNotNull(a);
		
		assertEquals(1,repository.count());
	}

}
