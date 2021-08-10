package com.gumi.grpc.client.greeting.infrastructure.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GreetingRestRequest implements Serializable {

    private static final long serialVersionUID = -916166602138542842L;

    private Integer id;
    private String name;
    private String city;
    private String message;
}
