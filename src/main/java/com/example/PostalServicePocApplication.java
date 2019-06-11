package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.example.mensajes.MensajeEvent;
import com.example.mensajes.events.MensajeEventRepository;

@SpringBootApplication
@EnableBinding(Sink.class)
public class PostalServicePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostalServicePocApplication.class, args);
	}
	
	private MensajeEventRepository mensajeEventRepository;

	@StreamListener(value="mensajeEventosChannel")
	public void handleEvent(MensajeEvent event) {
		mensajeEventRepository.save(event);
	}

}
