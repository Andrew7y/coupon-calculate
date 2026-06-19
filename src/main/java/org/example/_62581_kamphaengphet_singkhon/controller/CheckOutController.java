package org.example._62581_kamphaengphet_singkhon.controller;

import lombok.RequiredArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.*;
import org.example._62581_kamphaengphet_singkhon.service.ProductService;
import org.example._62581_kamphaengphet_singkhon.service.PromotionCalculateEngine;
import org.example._62581_kamphaengphet_singkhon.service.PromotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CheckOutController {
    private final PromotionService promotionService;
    private final ProductService productService;
    private final PromotionCalculateEngine engine;

    @GetMapping("/")
    public String checkout(Model model){
        loadPage(model);
        model.addAttribute(
                "request",
                new CheckoutRequest()
        );

        return "checkout";
    }

    @PostMapping("/checkout")
    public String result(
            Model model,
            @ModelAttribute("request") CheckoutRequest request
    ){
        loadPage(model);

        List<Product> products = productService.getProductByIds(
                request.getProductIds()
        );

        if (products.isEmpty()){
            return "redirect:/";
        }

        BigDecimal totalPrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);

        Chart chart = Chart.builder()
                .products(products)
                .customerPoint(request.getCustomerPoint())
                .currentTotalPrice(totalPrice)
                .originalTotalPrice(totalPrice)
                .totalDiscount(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP))
                .couponDiscount(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP))
                .seasonalDiscount(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP))
                .onTopDiscount(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP))
                .build();

        if (request.getCouponId() != null){
            Promotion coupon = promotionService.getPromotionById(request.getCouponId());
            chart = engine.applyCoupon(
                    chart,
                    coupon
            );
        }

        if (request.getOnTopId() != null){
            Promotion onTop = promotionService.getPromotionById(request.getOnTopId());
            chart = engine.applyOnTop(
                    chart,
                    onTop
            );
        }

        if (request.getSeasonalId() != null){
            Promotion seasonal = promotionService.getPromotionById(request.getSeasonalId());
            chart = engine.applySeasonal(
                    chart,
                    seasonal
            );
        }

        CheckoutResult result = CheckoutResult.builder()
                .originalTotal(chart.getOriginalTotalPrice())
                .couponDiscount(chart.getCouponDiscount())
                .onTopDiscount(chart.getOnTopDiscount())
                .seasonalDiscount(chart.getSeasonalDiscount())
                .totalDiscount(chart.getTotalDiscount())
                .finalPrice(chart.getCurrentTotalPrice())
                .build();

        model.addAttribute(
                "result",
                result
        );

        return "checkout";
    }

    private void loadPage(Model model){

        model.addAttribute(
                "products",
                productService.getProducts()
        );

        model.addAttribute(
                "coupons",
                promotionService.getPromotionsByCategory(PromotionCategory.COUPON)
        );

        model.addAttribute(
                "onTops",
                promotionService.getPromotionsByCategory(PromotionCategory.ON_TOP)
        );

        model.addAttribute(
                "seasonals",
                promotionService.getPromotionsByCategory(PromotionCategory.SEASONAL)
        );
    }
}
