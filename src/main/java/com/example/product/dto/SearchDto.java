package com.example.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
    private String search;
    private Integer quantity;
    private Integer quantity2;
    private Integer cost;
    private Integer cost2;
    private Boolean delivery;
}
