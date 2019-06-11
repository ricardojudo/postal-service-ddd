package com.example.mensajes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.mensajes.Mensaje.MensajeEventState;

public class MensajeTest {

	private Mensaje<String> mensaje;
	
	@Before
	public void setUp() {
		mensaje=new Mensaje<>();
	}
	
	@Test
	public void testMensaje() {
		assertNotNull("Mensaje nulo", mensaje);
	}
	
	
	@Test
	public void testGenerarAcuse() {
		mensaje.generarAcuse();
		assertNotNull("Acuse nulo", mensaje.getAcuse());
	}
	
	@Test
	public void testEstados() {
		assertNull(mensaje.getEstado());
		mensaje.recibir();
		assertEquals(MensajeEventState.RECIBIDO, mensaje.getEstado());
		mensaje.esValido();
		assertEquals(MensajeEventState.VALIDADO, mensaje.getEstado());
		mensaje.guardar();
		assertEquals(MensajeEventState.GUARDADO, mensaje.getEstado());
		mensaje.generarAcuse();
		assertEquals(MensajeEventState.ACUSE_GENERADO, mensaje.getEstado());
	}

	
	
	
}
