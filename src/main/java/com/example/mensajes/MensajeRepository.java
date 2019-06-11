package com.example.mensajes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MensajeRepository extends MongoRepository<Mensaje<?>, String> {

}
