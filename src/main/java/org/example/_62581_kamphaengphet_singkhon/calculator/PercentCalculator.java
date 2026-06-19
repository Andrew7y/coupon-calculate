package org.example._62581_kamphaengphet_singkhon.calculator;

import lombok.NoArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@NoArgsConstructor
public class PercentCalculator implements PromotionCalculator{
    @Override
    public BigDecimal calculate(
            Chart chart,
            Promotion promotion
    ){
        return chart.getCurrentTotalPrice()
                .multiply(promotion.getValue()
                        .divide(
                                BigDecimal.valueOf(100),
                                3,
                                RoundingMode.HALF_UP
                        )
                );
    }
}
