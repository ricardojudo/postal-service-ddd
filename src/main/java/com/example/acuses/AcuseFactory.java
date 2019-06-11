package com.example.acuses;

import org.springframework.stereotype.Component;

@Component
public class AcuseFactory {

	private static ThreadLocal<AcuseFactory> tlocal=new ThreadLocal<>();

	public Acuse createAcuse() {

		return new Acuse();
	}

	public static AcuseFactory getInstance() {

		AcuseFactory f = tlocal.get();
		if (f == null) {
			f = new AcuseFactory();
			tlocal.set(f);
		}

		return new AcuseFactory();

	}

}
