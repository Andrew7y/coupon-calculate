package org.example._62581_kamphaengphet_singkhon.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Getter
@NoArgsConstructor
public class PromotionService {
    private final List<Promotion> promotions = List.of(
            Promotion.builder()
                    .id("PROMO1")
                    .name("25 THB off on total price")
                    .type(PromotionType.PERCENTAGE)
                    .category(PromotionCategory.COUPON)
                    .value(BigDecimal.valueOf(10))
                    .build(),
            Promotion.builder()
                    .id("PROMO2")
                    .name("20% off on total price")
                    .type(PromotionType.PERCENTAGE)
                    .category(PromotionCategory.COUPON)
                    .value(BigDecimal.valueOf(10))
                    .build(),
            Promotion.builder()
                    .id("PROMO3")
                    .name("5 THB off on every 50 THB spent")
                    .type(PromotionType.SPECIAL)
                    .category(PromotionCategory.SEASONAL)
                    .everyXAmount(BigDecimal.valueOf(50))
                    .discountYAmount(BigDecimal.valueOf(5))
                    .build(),
            Promotion.builder()
                    .id("PROMO4")
                    .name("15% off on electronics category")
                    .type(PromotionType.PERCENT_BY_CATEGORY)
                    .category(PromotionCategory.ON_TOP)
                    .categoryDiscount("Electronics")
                    .value(BigDecimal.valueOf(20))
                    .build(),
            Promotion.builder()
                    .id("PROMO5")
                    .name("10% off on home & living category")
                    .type(PromotionType.PERCENT_BY_CATEGORY)
                    .category(PromotionCategory.ON_TOP)
                    .categoryDiscount("Home & Living")
                    .value(BigDecimal.valueOf(20))
                    .build(),
            Promotion.builder()
                    .id("PROMO6")
                    .name("Points")
                    .type(PromotionType.POINT)
                    .category(PromotionCategory.ON_TOP)
                    .value(BigDecimal.valueOf(0))
                    .build()
    );

    public List<Promotion> getPromotionsByCategory(PromotionCategory category){
        return promotions.stream()
                .filter(promotion -> promotion.getCategory().equals(category))
                .toList();
    }

    public Promotion getPromotionById(String id){
        return promotions.stream()
                .filter(promotion -> promotion.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
