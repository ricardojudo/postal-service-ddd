package com.example.mensajes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.acuses.Acuse;
import com.example.mensajes.Mensaje.MensajeEventState;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class MensajeServiceTest {

	@Autowired
	private MensajeService mensajeService;
	
	@Test
	public void test() {
		Mensaje<Object> mensaje = new Mensaje<>();
		Acuse acuse = mensajeService.recibir(mensaje);
		assertNotNull(acuse);
		assertEquals(MensajeEventState.ACUSE_GENERADO, mensaje.getEstado());
		assertNotNull(mensaje.getId());
	}

}
