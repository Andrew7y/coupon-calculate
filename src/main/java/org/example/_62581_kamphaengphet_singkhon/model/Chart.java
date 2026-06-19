package org.example._62581_kamphaengphet_singkhon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Chart {
    private List<Product> products;
    private int customerPoint;
    private BigDecimal originalTotalPrice;
    private BigDecimal currentTotalPrice;
    private BigDecimal totalDiscount;
    private BigDecimal couponDiscount;
    private BigDecimal onTopDiscount;
    private BigDecimal seasonalDiscount;
}
