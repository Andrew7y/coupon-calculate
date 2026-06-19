package org.example._62581_kamphaengphet_singkhon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class Product {
    private String id;
    private String name;
    private String category;
    private BigDecimal price;
}
