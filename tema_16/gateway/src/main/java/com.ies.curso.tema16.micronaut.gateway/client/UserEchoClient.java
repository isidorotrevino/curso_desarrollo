package com.ies.curso.tema16.micronaut.gateway.client;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import com.ies.curso.tema16.micronaut.gateway.service.*;

@Client(id = "userecho")
@Requires(notEnv = Environment.TEST)
public interface UserEchoClient extends UsernameFetcher {

    @Get("/user")
    Single<String> findUsername();
}
