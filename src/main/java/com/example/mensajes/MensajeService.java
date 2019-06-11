package com.example.mensajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;

import com.example.acuses.Acuse;
import com.example.mensajes.Mensaje.MensajeEventState;
import com.example.mensajes.events.EventsService;
import com.example.mensajes.events.EventsSource;
import com.example.mensajes.events.MensajeEventListener;

@Service
@EnableBinding(EventsSource.class)
public class MensajeService implements MensajeEventListener {

	@Autowired
	private MensajeRepository mensajeRepository;

	@Autowired
	private EventsService eventsService;

	public Acuse recibir(Mensaje<?> mensaje) {
		mensaje.addListener(this);
		mensaje.recibir();
		mensaje.guardar();
		mensaje.esValido();
		mensaje.generarAcuse();
		return mensaje.getAcuse();
	}

	@Override
	public void changeState(MensajeEvent event) {
		MensajeEventState state = event.getState();
		switch (state) {
		case RECIBIDO:
			break;
		case VALIDADO:
			break;
		case GUARDADO:
			Mensaje<?> m = mensajeRepository.save(event.getMensaje());
			event.getMensaje().setId(m.getId());
			//TODO save to S3
			break;
		case ACUSE_GENERADO:
			break;

		}
		
		eventsService.send(event);

	}

}
