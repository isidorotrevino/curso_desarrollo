package com.ies.curso.spring.tema08.ejemplo02.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ies.curso.spring.tema08.ejemplo02.service.AsyncService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

	@Override
	@Async
	public void metodoAsincrono(boolean lanzarExcepcion) {
		log.info("Comenzando método asíncrono");
		for(int i=0;i<10;i++) {
			log.info("Invocando método, iteración {}",i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if(lanzarExcepcion) {
			throw new IllegalArgumentException("No me reclamen, solo sigo instrucciones");
		}
	}

}
