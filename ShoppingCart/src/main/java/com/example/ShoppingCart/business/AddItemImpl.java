package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.AddingItemsToCartRequest;
import com.example.ShoppingCart.domain.AddingItemsToCartResonse;
import com.example.ShoppingCart.repository.CartEntity;
import com.example.ShoppingCart.repository.CartItemEntity;
import com.example.ShoppingCart.repository.CartItemsRepository;
import com.example.ShoppingCart.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddItemImpl implements IAddItem{

    private final CartRepository cartRepository;
    private final CartItemsRepository cartItemRepository;

    @Override
    public AddingItemsToCartResonse addItemToCart(AddingItemsToCartRequest request) {
        CartEntity cartEntity = cartRepository.findById(request.getCart_id())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        // Create a new cart item
        CartItemEntity cartItemEntity = CartItemEntity.builder()
                .cart(cartEntity)
                .productId(request.getProductId())
                .price(request.getPrice())
                .build();

        // Save cart item
        CartItemEntity savedItem = cartItemRepository.save(cartItemEntity);

        return AddingItemsToCartResonse.builder()
                .id(savedItem.getId())
                .build();
    }
}
