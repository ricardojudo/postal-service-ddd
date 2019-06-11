package com.example.mensajes.events;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventsSource {
	@Output("mensajeEventosChannel")
	MessageChannel mensajeEventosChannel();
}
