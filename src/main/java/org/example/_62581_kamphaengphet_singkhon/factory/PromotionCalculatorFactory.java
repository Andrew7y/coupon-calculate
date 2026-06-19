package org.example._62581_kamphaengphet_singkhon.factory;

import lombok.RequiredArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.calculator.*;
import org.example._62581_kamphaengphet_singkhon.model.PromotionType;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionCalculatorFactory {
    private final AmountCalculator amountCalculator;
    private final PercentCalculator percentCalculator;
    private final PercentByCategoryCalculator percentByCategoryCalculator;
    private final PointCalculator pointCalculator;
    private final SpecialCalculator specialCalculator;

    public PromotionCalculator getCalculator(PromotionType type){
        return switch (type){
            case AMOUNT -> amountCalculator;

            case PERCENTAGE -> percentCalculator;

            case PERCENT_BY_CATEGORY -> percentByCategoryCalculator;

            case POINT ->  pointCalculator;

            case SPECIAL ->  specialCalculator;
        };
    }
}
