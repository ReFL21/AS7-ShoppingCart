package com.example.ShoppingCart.business;

import com.example.ShoppingCart.repository.CartItemsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeleteItemFromCartImpl implements IDeleteItemFromCart{
    private final CartItemsRepository repository;
    @Override
    @Transactional
    public void deleteItemFromCart(Long id){repository.deleteById(id);}
}
