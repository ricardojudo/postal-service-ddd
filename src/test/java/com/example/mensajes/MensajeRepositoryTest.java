package com.example.mensajes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Data;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class MensajeRepositoryTest {

	@Autowired
	private MensajeRepository repository;
	
	
	@Test
	public void save() {
		Mensaje<String> mensaje = new Mensaje<>();
		mensaje = repository.save(mensaje);
		assertNotNull(mensaje.getId());	
	}
	
	@Test
	public void saveWithAcuse() {
		Mensaje<String> mensaje = new Mensaje<>();
		mensaje.generarAcuse();
		mensaje = repository.save(mensaje);
		assertNotNull(mensaje.getId());	
		assertNotNull(mensaje.getAcuse());
	}
	
	
	
	@Test
	public void saveWithData(){
		Mensaje<MensajeDataTest> mensaje = new Mensaje<MensajeDataTest>();
		mensaje.setData(new MensajeDataTest("1","foo","bar"));
		mensaje.generarAcuse();
		assertNull(mensaje.getId());	
		mensaje = repository.save(mensaje);
		assertNotNull(mensaje.getId());	
		assertNotNull(mensaje.getData());
	}
	
	@Data
	class MensajeDataTest	{
		private final String id;
		private final String data1;
		private final String data2;
	}

}
