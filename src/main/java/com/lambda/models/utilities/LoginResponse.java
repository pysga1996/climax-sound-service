package com.lambda.models.utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    @JsonProperty
    private String accessToken;

    @JsonProperty
    private String tokenType = "Bearer";

    @JsonProperty
    private Long userId;

    public LoginResponse(String accessToken, Long userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }
}
