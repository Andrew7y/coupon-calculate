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
public class Promotion {
    private String id;
    private String name;
    private PromotionType type;
    private PromotionCategory category;
    private BigDecimal value;
    private String categoryDiscount;
    private BigDecimal everyXAmount;
    private BigDecimal discountYAmount;
}
