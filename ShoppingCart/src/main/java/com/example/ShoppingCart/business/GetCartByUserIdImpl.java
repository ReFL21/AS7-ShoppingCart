package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.Cart;
import com.example.ShoppingCart.domain.GetCartByUserIdRequest;
import com.example.ShoppingCart.domain.GetCartByUserIdResponse;
import com.example.ShoppingCart.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetCartByUserIdImpl implements IGetUserCart{
    private CartRepository repository;

    public GetCartByUserIdResponse getCartByUserId(Long userId){
        List<Cart> cartList = repository.findByUserId(userId)
                .stream()
                .map(CartConverter::convert)
                .toList();

        return GetCartByUserIdResponse.builder()
                .cartList(cartList)
                .build();
    }


}
