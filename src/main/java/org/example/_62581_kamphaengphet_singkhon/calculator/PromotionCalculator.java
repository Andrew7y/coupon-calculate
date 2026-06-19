package org.example._62581_kamphaengphet_singkhon.calculator;

import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;

import java.math.BigDecimal;

public interface PromotionCalculator {
    BigDecimal calculate(
            Chart chart,
            Promotion promotion
    );
}
