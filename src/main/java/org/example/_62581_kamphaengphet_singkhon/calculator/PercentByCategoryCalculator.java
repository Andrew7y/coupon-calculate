package org.example._62581_kamphaengphet_singkhon.calculator;

import lombok.NoArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Product;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@NoArgsConstructor
public class PercentByCategoryCalculator implements PromotionCalculator {
    @Override
    public BigDecimal calculate(
            Chart chart,
            Promotion promotion
    ){
        BigDecimal categoryTotal = chart.getProducts().stream()
                .filter(product -> product.getCategory().equals(promotion.getCategoryDiscount()))
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return categoryTotal
                .multiply(promotion.getValue())
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
}
