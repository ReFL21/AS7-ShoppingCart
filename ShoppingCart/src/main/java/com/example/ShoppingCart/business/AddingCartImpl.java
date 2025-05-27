package com.example.ShoppingCart.business;

import com.example.ShoppingCart.domain.CreateCartRequest;
import com.example.ShoppingCart.domain.CreateCartResponse;
import com.example.ShoppingCart.repository.CartEntity;
import com.example.ShoppingCart.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddingCartImpl implements IAddingCart{
    private final CartRepository repository;

    @Transactional
    @Override
    public CreateCartResponse createCartForUser(CreateCartRequest request) {
        CartEntity entity = saveCart(request);
        return CreateCartResponse.builder().Id(entity.getId()).build();
    }


    private CartEntity saveCart(CreateCartRequest request){
        CartEntity entity = CartEntity.builder()
                .userId(request.getUserId())
                .build();
        return repository.save(entity);
    }
}
