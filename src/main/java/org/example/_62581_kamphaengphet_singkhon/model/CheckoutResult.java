package org.example._62581_kamphaengphet_singkhon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CheckoutResult {
    private BigDecimal originalTotal;
    private BigDecimal couponDiscount;
    private BigDecimal onTopDiscount;
    private BigDecimal seasonalDiscount;
    private BigDecimal totalDiscount;
    private BigDecimal finalPrice;
}
