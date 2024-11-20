package com.gitikapinjani.yummyrestaurant.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ProductRequest(
        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        @JsonProperty("product_name")
        String productName,

        @JsonProperty("price")
        Float price
){
}
