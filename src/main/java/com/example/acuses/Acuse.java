package com.example.acuses;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Acuse {
	
	@Id
    public String id;

}
