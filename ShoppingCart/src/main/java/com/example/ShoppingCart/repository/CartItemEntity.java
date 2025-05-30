package com.example.ShoppingCart.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    @JsonBackReference
    private CartEntity cart;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "price")
    private Long price;


}
