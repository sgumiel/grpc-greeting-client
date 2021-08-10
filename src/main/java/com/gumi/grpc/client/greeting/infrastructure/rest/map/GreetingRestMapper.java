package com.gumi.grpc.client.greeting.infrastructure.rest.map;

import com.gumi.grpc.client.greeting.infrastructure.rest.model.GreetingRestRequest;
import com.gumi.grpc.client.greeting.infrastructure.rest.model.GreetingRestResponse;
import com.gumi.grpc.client.greeting.model.Greeting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GreetingRestMapper {

    Greeting toDomain(GreetingRestRequest source);
    GreetingRestResponse toResponse(Greeting source);
}
