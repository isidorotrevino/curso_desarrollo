package com.ies.curso.micronaut.tema15.front.service;

import io.micronaut.http.annotation.Header;
import io.reactivex.Single;

public interface UsernameFetcher {

	Single<String> findUsername();
} 
