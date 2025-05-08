package com.example.ShoppingCart.controller;

import com.example.ShoppingCart.business.IAddItem;
import com.example.ShoppingCart.business.IAddingCart;
import com.example.ShoppingCart.business.IDeleteItemFromCart;
import com.example.ShoppingCart.domain.AddingItemsToCartRequest;
import com.example.ShoppingCart.domain.AddingItemsToCartResonse;
import com.example.ShoppingCart.domain.CreateCartRequest;
import com.example.ShoppingCart.domain.CreateCartResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private final IAddingCart addingCart;
    @Autowired
    private final IDeleteItemFromCart deleteItemFromCart;
    @Autowired
    private final IAddItem addItem;

    @DeleteMapping("{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long id){
        deleteItemFromCart.deleteItemFromCart(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addItem")
    public ResponseEntity<AddingItemsToCartResonse>addingItemsToCart(@RequestBody @Valid AddingItemsToCartRequest request){
        AddingItemsToCartResonse resonse = addItem.addItemToCart(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resonse);
    }
    @PostMapping("/addCart")
    public ResponseEntity<CreateCartResponse>addingCart(@RequestBody @Valid CreateCartRequest request){
        CreateCartResponse response = addingCart.createCartForUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}
