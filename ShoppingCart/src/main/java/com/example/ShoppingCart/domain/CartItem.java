package com.example.ShoppingCart.domain;

import com.example.ShoppingCart.repository.CartEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItem {
    private Long id;
    private CartEntity cart;
    private String productId;
    private Long price;
}
