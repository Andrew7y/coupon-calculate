package org.example._62581_kamphaengphet_singkhon.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CheckoutRequest {
    private List<String> productIds;
    private String couponId;
    private String onTopId;
    private String seasonalId;
    private int customerPoint;
}
