package com.example.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItemEntity, Long> {
    List<CartItemEntity> findByCartId(Long cartId);  // Find all items in a cart
    void deleteByCartIdAndProductId(Long cartId, Long productId);
}
