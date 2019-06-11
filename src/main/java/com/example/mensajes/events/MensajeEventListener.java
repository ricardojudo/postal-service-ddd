package com.example.mensajes.events;

import java.util.EventListener;

import com.example.mensajes.MensajeEvent;

public interface MensajeEventListener extends EventListener {

	void changeState(MensajeEvent event);

}
