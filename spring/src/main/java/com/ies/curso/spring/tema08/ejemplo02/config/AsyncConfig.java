package com.ies.curso.spring.tema08.ejemplo02.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ies.curso.spring.tema08.ejemplo02.service.impl.AsyncExceptionHandler;

@Configuration
@EnableAsync 
public class AsyncConfig implements AsyncConfigurer{
	
	/*
	 * El pool es opcional, pero más vale tener control
	 * sobre el número de hilos
	 */
	@Override
    public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setMaxPoolSize(100);
		exec.initialize();
        return exec;
    }
	
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	    return new AsyncExceptionHandler();
	}
}
