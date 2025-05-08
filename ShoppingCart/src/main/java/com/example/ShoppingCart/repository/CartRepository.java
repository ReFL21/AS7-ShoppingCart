package com.example.ShoppingCart.repository;

import com.example.ShoppingCart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    Optional<Cart> findByUserId(Long userId);
}
