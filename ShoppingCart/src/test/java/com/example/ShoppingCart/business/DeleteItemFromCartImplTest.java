package com.example.ShoppingCart.business;
import com.example.ShoppingCart.repository.CartItemsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteItemFromCartImplTest {
    @Mock
    private CartItemsRepository cartItemsRepository;

    @InjectMocks
    private DeleteItemFromCartImpl deleteItemFromCartImpl;

    @Test
    void deleteItemFromCart_shouldCallRepositoryDeleteById() {
        // Arrange
        Long itemId = 33L;

        // Act
        deleteItemFromCartImpl.deleteItemFromCart(itemId);

        // Assert
        verify(cartItemsRepository).deleteById(itemId);
    }
}
