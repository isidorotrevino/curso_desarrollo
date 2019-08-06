package com.ies.curso.tema16.micronaut.gateway.service;

import io.reactivex.Single;

public interface UsernameFetcher {
    Single<String> findUsername();
}
