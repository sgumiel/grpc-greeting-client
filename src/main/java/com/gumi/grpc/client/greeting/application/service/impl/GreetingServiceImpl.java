package com.gumi.grpc.client.greeting.application.service.impl;

import com.gumi.grpc.client.greeting.application.client.GreetingClient;
import com.gumi.grpc.client.greeting.application.service.GreetingService;
import com.gumi.grpc.client.greeting.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {


    private final GreetingClient greetingClient;

    @Override
    public Greeting greeting(Greeting greeting) {

        return this.greetingClient.greeting(greeting);
    }
}
