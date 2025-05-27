package com.example.ShoppingCart.controller;

import com.example.ShoppingCart.business.IAddItem;
import com.example.ShoppingCart.business.IAddingCart;
import com.example.ShoppingCart.business.IDeleteItemFromCart;
import com.example.ShoppingCart.business.IGetUserCart;
import com.example.ShoppingCart.domain.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private final IGetUserCart getUserCart;

    @Autowired
    private final IAddingCart addingCart;
    @Autowired
    private final IDeleteItemFromCart deleteItemFromCart;
    @Autowired
    private final IAddItem addItem;

    @DeleteMapping("{id}")
    public ResponseEntity<Void>removeProduct(@PathVariable Long id){
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

    @GetMapping("/{userId}")
    public ResponseEntity<Object>getCart(@PathVariable(value = "userId") Long userId){
       GetCartByUserIdResponse response= getUserCart.getCartByUserId(userId);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("{cart_id}")
    public ResponseEntity<Void> clearCart(@PathVariable(value = "cart_id") Long cartId){
        deleteItemFromCart.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }

}
