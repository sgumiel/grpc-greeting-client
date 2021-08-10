package com.gumi.grpc.client.greeting.infrastructure.grpc;

import com.gumi.grpc.client.greeting.application.client.GreetingClient;
import com.gumi.grpc.client.greeting.infrastructure.grpc.map.GreetingGrpcMapper;
import com.gumi.grpc.client.greeting.model.Greeting;
import com.gumi.grpc.greeting.service.GreetingServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingGrpcClientImpl implements GreetingClient {

    @GrpcClient("greetingService")
    private GreetingServiceGrpc.GreetingServiceBlockingStub greetingServiceBlockingStub;

    private final GreetingGrpcMapper greetingGrpcMapper;

    @Override
    public Greeting greeting(Greeting greeting) {

        final var greetingGrpcRequest = this.greetingGrpcMapper.toGrpc(greeting);
        final var greetingGrpcResponse = this.greetingServiceBlockingStub.greeting(greetingGrpcRequest);
        greeting.setId((int)greetingGrpcResponse.getId());
        greeting.setMessage(greetingGrpcResponse.getGreeting());
        return greeting;
    }
}
