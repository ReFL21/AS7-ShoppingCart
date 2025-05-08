package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.CreateCartRequest;
import com.example.ShoppingCart.domain.CreateCartResponse;

public interface IAddingCart {
    CreateCartResponse createCartForUser(CreateCartRequest request);
}
