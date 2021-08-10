package com.gumi.grpc.client.greeting.application.client;

import com.gumi.grpc.client.greeting.model.Greeting;

public interface GreetingClient {

    Greeting greeting(Greeting greeting);
}
