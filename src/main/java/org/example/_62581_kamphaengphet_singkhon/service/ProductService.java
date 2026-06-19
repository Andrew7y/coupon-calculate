package org.example._62581_kamphaengphet_singkhon.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example._62581_kamphaengphet_singkhon.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Getter
@NoArgsConstructor
public class ProductService {
    private final List<Product> products = List.of(
            new Product("1", "Wireless Mouse", "Electronics", BigDecimal.valueOf(299.00)),
            new Product("2", "USB-C Hub", "Electronics", BigDecimal.valueOf(450.00)),
            new Product("3", "Cotton T-Shirt", "Apparel", BigDecimal.valueOf(199.00)),
            new Product("4", "Running Shoes", "Apparel", BigDecimal.valueOf(1490.00)),
            new Product("5", "Organic Coffee Beans", "Groceries", BigDecimal.valueOf(259.00)),
            new Product("6", "Extra Virgin Olive Oil", "Groceries", BigDecimal.valueOf(349.00)),
            new Product("7", "Brown Rice 5kg", "Groceries", BigDecimal.valueOf(199.00)),
            new Product("8", "Scented Candle", "Home & Living", BigDecimal.valueOf(159.00)),
            new Product("9", "Ceramic Mug Set", "Home & Living", BigDecimal.valueOf(390.00)),
            new Product("10", "LED Desk Lamp", "Home & Living", BigDecimal.valueOf(680.00))
    );

    public List<Product> getProductByIds(List<String> ids){
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }
        return products.stream()
                .filter(product -> ids.contains(product.getId()))
                .toList();
    }
}
