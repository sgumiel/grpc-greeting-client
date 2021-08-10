package com.gumi.grpc.client.greeting.infrastructure.grpc.map;

import com.gumi.grpc.client.greeting.model.Greeting;
import com.gumi.grpc.greeting.model.GreetingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingGrpcMapper {

    GreetingRequest toGrpc(Greeting source);
}
