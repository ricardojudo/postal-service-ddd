package com.example.mensajes.events;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mensajes.Mensaje;
import com.example.mensajes.MensajeEvent;

public class MensajeEventListenerTest {

	private MensajeEventListener listener;
	
	@Before
	public void setUp() {
		
	}
	
	
	@Test
	public void testChangeState() {
		Mensaje<Object> m = new Mensaje<>();
		listener = new MensajeEventListener() {
			@Override
			public void changeState(MensajeEvent e) {
				assertNotNull(e);
			}
		};
		m.addListener(listener);
		m.generarAcuse();
		
	}

}
