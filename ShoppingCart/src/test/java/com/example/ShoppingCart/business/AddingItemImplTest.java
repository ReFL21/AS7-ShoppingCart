package com.example.ShoppingCart.business;
import com.example.ShoppingCart.domain.AddingItemsToCartRequest;
import com.example.ShoppingCart.domain.AddingItemsToCartResonse;
import com.example.ShoppingCart.repository.CartEntity;
import com.example.ShoppingCart.repository.CartItemEntity;
import com.example.ShoppingCart.repository.CartItemsRepository;
import com.example.ShoppingCart.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AddingItemImplTest {
    @Mock
    private CartRepository cartRepository;
    @Mock
    private CartItemsRepository cartItemsRepository;

    @InjectMocks
    private AddItemImpl addItemImpl;

    @Test
    void addItemToCart_existingCart_shouldSaveItemAndReturnResponse() {
        // Arrange
        Long cartId = 55L;
        AddingItemsToCartRequest request = new AddingItemsToCartRequest();
        request.setCart_id(cartId);
        request.setProductId("prod-123");
        request.setPrice(19L);

        CartEntity cartEntity = CartEntity.builder()
                .id(cartId)
                .build();
        when(cartRepository.findById(cartId))
                .thenReturn(Optional.of(cartEntity));

        CartItemEntity savedItem = CartItemEntity.builder()
                .id(77L)
                .cart(cartEntity)
                .productId("prod-123")
                .price(19L)
                .build();
        when(cartItemsRepository.save(any(CartItemEntity.class)))
                .thenReturn(savedItem);

        // Act
        AddingItemsToCartResonse response = addItemImpl.addItemToCart(request);

        // Assert
        assertNotNull(response);
        assertEquals(77L, response.getId());

        // verify save was called with matching productId & price
        ArgumentCaptor<CartItemEntity> captor = ArgumentCaptor.forClass(CartItemEntity.class);
        verify(cartItemsRepository).save(captor.capture());
        assertEquals("prod-123", captor.getValue().getProductId());
        assertEquals(19L, captor.getValue().getPrice());
    }

    @Test
    void addItemToCart_nonExistingCart_shouldThrowException() {
        // Arrange
        Long cartId = 99L;
        AddingItemsToCartRequest request = new AddingItemsToCartRequest();
        request.setCart_id(cartId);
        when(cartRepository.findById(cartId))
                .thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> addItemImpl.addItemToCart(request));
        assertEquals("Cart not found", ex.getMessage());
    }
}
