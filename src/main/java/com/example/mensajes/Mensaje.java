package com.example.mensajes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.example.acuses.Acuse;
import com.example.acuses.AcuseFactory;
import com.example.mensajes.events.MensajeEventListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties({"mensajeEventListeners","data"})
public class Mensaje<D> {

	
	public enum MensajeEventState {
		RECIBIDO, VALIDADO, GUARDADO, ACUSE_GENERADO
	}
	
	@Id
	private String id;
	private Acuse acuse;
	private D data;
	private MensajeEventState estado;
	
	@Transient
	private transient List<MensajeEventListener> mensajeEventListeners=Collections.synchronizedList(new LinkedList<>());

	public boolean esValido() {
		notify(MensajeEventState.VALIDADO);
		
		return true;
	}
	
	public Mensaje<D> guardar() {
		notify(MensajeEventState.GUARDADO);
		return this;
	}
	
	public void generarAcuse() {
		this.acuse = AcuseFactory.getInstance().createAcuse();
		notify(MensajeEventState.ACUSE_GENERADO);
	}
	
	public void recibir() {
		notify(MensajeEventState.RECIBIDO);
	}
	
	public void addListener(MensajeEventListener l) {
		mensajeEventListeners.add(l);
	}
	
	
	public void notify(MensajeEventState state) {
		this.estado = state;
		MensajeEvent e = new MensajeEvent(this);
		notify(e);
	}
	
	private void notify(MensajeEvent e) {
		for(MensajeEventListener l : mensajeEventListeners) {
			//TODO invocacion asincrona
			l.changeState(e);
		}
	}

	public void clearData() {
	}
	
	
}
