package org.example._62581_kamphaengphet_singkhon.service;

import lombok.RequiredArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.factory.PromotionCalculatorFactory;
import org.example._62581_kamphaengphet_singkhon.model.Chart;
import org.example._62581_kamphaengphet_singkhon.model.Promotion;
import org.example._62581_kamphaengphet_singkhon.model.PromotionCategory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class PromotionCalculateEngine {
    private final PromotionCalculatorFactory factory;

    public Chart applyCoupon(
            Chart chart,
            Promotion promotion
    ){
        return applyByCategory(chart, promotion, PromotionCategory.COUPON);
    }

    public Chart applyOnTop(
            Chart chart,
            Promotion promotion
    ){
        return applyByCategory(chart, promotion, PromotionCategory.ON_TOP);
    }

    public Chart applySeasonal(
            Chart chart,
            Promotion promotion
    ){
        return applyByCategory(chart, promotion, PromotionCategory.SEASONAL);
    }

    private Chart applyByCategory(
            Chart chart,
            Promotion promotion,
            PromotionCategory category
    ){
        BigDecimal discount = factory.getCalculator(promotion.getType())
                .calculate(chart, promotion)
                .setScale(2, RoundingMode.HALF_UP);

        chart.setTotalDiscount(chart.getTotalDiscount().add(discount)
                .setScale(2, RoundingMode.HALF_UP));
        chart.setCurrentTotalPrice(chart.getCurrentTotalPrice().subtract(discount)
                .setScale(2, RoundingMode.HALF_UP));

        switch (category) {
            case COUPON -> chart.setCouponDiscount(discount);
            case ON_TOP -> chart.setOnTopDiscount(discount);
            case SEASONAL -> chart.setSeasonalDiscount(discount);
        }

        return chart;
    }
}
