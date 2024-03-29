package com.ies.curso.micronaut.tema14.calendarizacion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.Date;

@Singleton
public class EmailUseCase {
    private static final Logger LOG = LoggerFactory.getLogger(EmailUseCase.class); // <2>

    public void send(String user, String message) {
        LOG.info("Sending email to {} : {} at {}", user, message, new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
    }
}
