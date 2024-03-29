package com.ies.curso.tema16.micronaut.gateway.service;

import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.Collections;

@Singleton // <1>
public class AuthenticationProviderUserPassword implements AuthenticationProvider { // <2>

    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        if ( (authenticationRequest.getIdentity().equals("juan") || authenticationRequest.getIdentity().equals("perez")) &&
                authenticationRequest.getSecret().equals("perez") ) {
            return Flowable.just(new UserDetails((String) authenticationRequest.getIdentity(), Collections.emptyList()));
        }
        return Flowable.just(new AuthenticationFailed());
    }
}
