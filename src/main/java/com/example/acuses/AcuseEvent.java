package com.example.acuses;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class AcuseEvent {

	@Id
	private final String id;
	private final Date createdAt;
	private final Acuse acuse;
	private String description;
	
	
	public AcuseEvent(Acuse acuse, String description) {
		this(acuse);
		this.description = description;
	}

	public AcuseEvent(Acuse acuse) {
		this.createdAt = new Date();
		this.acuse=acuse;
		this.id = UUID.randomUUID().toString();
	}

	

}
