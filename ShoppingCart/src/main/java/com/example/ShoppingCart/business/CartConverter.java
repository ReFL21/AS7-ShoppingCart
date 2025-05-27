package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.Cart;
import com.example.ShoppingCart.domain.CartItem;
import com.example.ShoppingCart.repository.CartEntity;
import com.example.ShoppingCart.repository.CartItemEntity;

import java.util.List;

public class CartConverter {
    private CartConverter(){}
    public static Cart convert(CartEntity entity) {
        List<CartItem> items = null;
        if(entity != null){
            items = entity.getItems()
                    .stream()
                    .map(CartConverter::convertCartItem)
                    .toList();
        }
        return Cart.builder()
                .id(entity.getId())
                .user_id(entity.getUserId())
                .itemList(items)
                .build();

    }


    public static CartItem convertCartItem(CartItemEntity cartItemEntity){
        return CartItem.builder()
                .id(cartItemEntity.getId())
                .productId(cartItemEntity.getProductId())
                .price(cartItemEntity.getPrice())
                .build();
    }


}
