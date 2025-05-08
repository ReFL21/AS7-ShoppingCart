package com.example.ShoppingCart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddingItemsToCartRequest {
    private Long cart_id;
    private Long productId;
    private Long price;
}
