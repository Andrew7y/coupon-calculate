package org.example._62581_kamphaengphet_singkhon.calculator;

import lombok.NoArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@NoArgsConstructor
@Component
public class SpecialCalculator implements PromotionCalculator{
    @Override
    public BigDecimal calculate(
            Chart chart,
            Promotion promotion
    ){
        int roundDiscount = chart.getCurrentTotalPrice()
                .divide(promotion.getEveryXAmount(), RoundingMode.DOWN)
                .intValue();

        return promotion.getDiscountYAmount()
                .multiply(BigDecimal.valueOf(roundDiscount));
    }
}
