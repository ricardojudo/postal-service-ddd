package com.example.mensajes.events;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mensajes.MensajeEvent;

public interface MensajeEventRepository extends MongoRepository<MensajeEvent, String>{

}
