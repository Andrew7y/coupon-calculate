package org.example._62581_kamphaengphet_singkhon.calculator;

import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AmountCalculator implements PromotionCalculator{
    @Override
    public BigDecimal calculate(
            Chart chart,
            Promotion promotion
    ){
        return promotion.getValue();
    }
}
