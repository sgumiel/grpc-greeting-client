package com.gumi.grpc.client.greeting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gumi.grpc.client.greeting.infrastructure.rest.model.GreetingRestRequest;
import com.gumi.grpc.client.greeting.infrastructure.rest.model.GreetingRestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("it")
public class GreetingIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void greetingIntegrationTest() throws Exception {

        final var name = "Sergio";
        final var city = "Barajas";

        final var request = GreetingRestRequest.builder()
                .name(name)
                .city(city).build();
        
        final var responseString = this.mockMvc.perform(MockMvcRequestBuilders.post("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(request))).andReturn().getResponse().getContentAsString();
        final var greetingResponse = this.objectMapper.readValue(responseString, new TypeReference<GreetingRestResponse>() {});

        final var messageExpected = name + city;
        Assertions.assertEquals(messageExpected, greetingResponse.getMessage());

    }
}
