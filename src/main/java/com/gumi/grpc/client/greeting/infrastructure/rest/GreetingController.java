package com.gumi.grpc.client.greeting.infrastructure.rest;

import com.gumi.grpc.client.greeting.application.service.GreetingService;
import com.gumi.grpc.client.greeting.infrastructure.rest.map.GreetingRestMapper;
import com.gumi.grpc.client.greeting.infrastructure.rest.model.GreetingRestRequest;
import com.gumi.grpc.client.greeting.infrastructure.rest.model.GreetingRestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greeting")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingRestMapper greetingRestMapper;
    private final GreetingService greetingService;

    @PostMapping
    public ResponseEntity<GreetingRestResponse> greeting(@RequestBody GreetingRestRequest greetingRestRequest) {

        final var greeting = this.greetingRestMapper.toDomain(greetingRestRequest);

        final var greetingSaved = this.greetingService.greeting(greeting);
        final var greetingResponse = this.greetingRestMapper.toResponse(greetingSaved);
        return ResponseEntity.ok(greetingResponse);
    }
}
