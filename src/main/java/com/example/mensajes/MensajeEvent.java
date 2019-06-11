package com.example.mensajes;

import java.util.Date;
import java.util.EventObject;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import com.example.mensajes.Mensaje.MensajeEventState;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper=false)
public class MensajeEvent extends EventObject{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8984290889388362799L;
	@Id
	private final String id;
	private final Date createdAt;
	private String description;
	
	
	public MensajeEvent(Mensaje<?> mensaje,String description) {
		this(mensaje);
		this.description = description;
	}

	public MensajeEvent(Mensaje<?> mensaje) {
		super(mensaje);
		this.createdAt = new Date();
		this.id = UUID.randomUUID().toString();
	}
	
	public MensajeEventState getState() {
		return this.getMensaje().getEstado();
	}
	
	public Mensaje<?> getMensaje(){
		return (Mensaje<?>)source;
	}
}
