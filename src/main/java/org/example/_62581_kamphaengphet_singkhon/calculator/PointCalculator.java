package org.example._62581_kamphaengphet_singkhon.calculator;

import lombok.NoArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@NoArgsConstructor
public class PointCalculator implements PromotionCalculator{
    @Override
    public BigDecimal calculate(
            Chart chart,
            Promotion promotion
    ){
        BigDecimal maxDiscount = chart.getCurrentTotalPrice()
                .multiply(BigDecimal.valueOf(0.20))
                .setScale(2, RoundingMode.DOWN);

        BigDecimal pointDiscount = BigDecimal.valueOf(chart.getCustomerPoint());

        return pointDiscount.min(maxDiscount);
    }
}
