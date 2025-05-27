package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.GetCartByUserIdRequest;
import com.example.ShoppingCart.domain.GetCartByUserIdResponse;

public interface IGetUserCart {
    GetCartByUserIdResponse getCartByUserId(Long userId);
}
