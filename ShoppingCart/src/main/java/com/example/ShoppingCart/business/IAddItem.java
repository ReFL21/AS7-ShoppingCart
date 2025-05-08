package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.AddingItemsToCartRequest;
import com.example.ShoppingCart.domain.AddingItemsToCartResonse;

public interface IAddItem {
    AddingItemsToCartResonse addItemToCart(AddingItemsToCartRequest request);
}
