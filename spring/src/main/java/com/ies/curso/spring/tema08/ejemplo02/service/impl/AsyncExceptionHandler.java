package com.ies.curso.spring.tema08.ejemplo02.service.impl;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		log.error("El metodo {} arrojó el error {}, habrá que revisar que pasó",
				method.getName(),ex.getMessage(),ex);
	}

}
