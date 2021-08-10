package com.gumi.grpc.client.greeting.grpcmockserver;

import com.gumi.grpc.greeting.model.GreetingRequest;
import com.gumi.grpc.greeting.model.GreetingResponse;
import com.gumi.grpc.greeting.service.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceMock extends GreetingServiceGrpc.GreetingServiceImplBase{

    @Override
    public void greeting(GreetingRequest helloRequest, StreamObserver<GreetingResponse> streamObserver){

        final var name = helloRequest.getName();
        final var city = helloRequest.getCity();

        final var response = GreetingResponse.newBuilder()
                .setGreeting(name+city)
                .build();

        streamObserver.onNext(response);
        streamObserver.onCompleted();

    }
}
