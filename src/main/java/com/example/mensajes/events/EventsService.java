package com.example.mensajes.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.mensajes.MensajeEvent;

@Service
@EnableBinding(EventsSource.class)
public class EventsService {

	
	@Autowired
	private EventsSource eventsSource;
	
	public void send(MensajeEvent e) {
		e.getMensaje().clearData();
		Message<?> message=MessageBuilder.withPayload(e).build();
		eventsSource.mensajeEventosChannel().send(message);
	}
}
