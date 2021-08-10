package com.gumi.grpc.client.greeting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Greeting {

    private Integer id;
    private String name;
    private String city;
    private String message;
}
