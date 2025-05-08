package com.example.ShoppingCart.business;
import com.example.ShoppingCart.domain.CreateCartRequest;
import com.example.ShoppingCart.domain.CreateCartResponse;
import com.example.ShoppingCart.repository.CartEntity;
import com.example.ShoppingCart.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AddingCartImplTest {
    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private AddingCartImpl addingCartImpl;

    @Test
    void createCartForUser_shouldSaveEntityAndReturnResponse() {
        // Arrange
        CreateCartRequest request = new CreateCartRequest();
        request.setUserId(123L);

        CartEntity savedEntity = CartEntity.builder()
                .id(10L)
                .userId(123L)
                .build();
        when(cartRepository.save(any(CartEntity.class)))
                .thenReturn(savedEntity);

        // Act
        CreateCartResponse response = addingCartImpl.createCartForUser(request);

        // Assert
        assertNotNull(response, "response must not be null");
        assertEquals(savedEntity.getId(), response.getId(), "returned id should match saved entity");

        // verify save was called with correct userId
        ArgumentCaptor<CartEntity> captor = ArgumentCaptor.forClass(CartEntity.class);
        verify(cartRepository).save(captor.capture());
        assertEquals(123L, captor.getValue().getUserId());
    }
}
