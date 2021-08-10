package com.gumi.grpc.client.greeting.application.service;

import com.gumi.grpc.client.greeting.model.Greeting;

public interface GreetingService {

    Greeting greeting(Greeting greeting);
}
