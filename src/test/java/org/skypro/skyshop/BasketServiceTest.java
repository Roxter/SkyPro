package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    private ProductBasket productBasket;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private BasketService basketService;

    @Test
    void addToBasket_shouldThrowException_whenProductNotFound() {
        UUID productId = UUID.randomUUID();
        Mockito.when(storageService.getProductById(productId)).thenReturn(Optional.empty());

        NoSuchProductException thrown = assertThrows(
            NoSuchProductException.class,
            () -> basketService.addToBasket(productId)
        );
        assertEquals(productId, thrown.getId());
    }

    @Test
    void addToBasket_shouldCallAddProductInBasket_whenProductExists() {
        UUID existingProductId = UUID.randomUUID();
        Product testProduct = new SimpleProduct("Молоко", 100, existingProductId);
        Mockito.when(storageService.getProductById(existingProductId)).thenReturn(Optional.of(testProduct));
        basketService.addToBasket(existingProductId);
        verify(productBasket, times(1)).addToBasket(existingProductId);
    }

    @Test
    void getUserBasket_shouldReturnEmptyBasket_whenProductBasketIsEmpty() {
        Mockito.when(productBasket.getContent()).thenReturn(Collections.emptyMap());
        UserBasket userBasket = basketService.getUserBasket();

        assertNotNull(userBasket);
        assertTrue(userBasket.getBasketItemList().isEmpty());
        assertEquals(0, userBasket.getTotalCostOfBasket());
    }

    @Test
    void getUserBasket_shouldReturnCorrectBasket_whenProductBasketHasItems() {
        Product product1 = new SimpleProduct("Сыр", 500, UUID.randomUUID());
        Product product2 = new SimpleProduct("Хлеб", 50, UUID.randomUUID());

        Map<UUID, Integer> itemsInBasket = Map.of(
            product1.getId(), 2,
            product2.getId(), 1
        );
        Mockito.when(productBasket.getContent()).thenReturn(itemsInBasket);
        Mockito.when(storageService.getProductById(product1.getId())).thenReturn(Optional.of(product1));
        Mockito.when(storageService.getProductById(product2.getId())).thenReturn(Optional.of(product2));
        UserBasket userBasket = basketService.getUserBasket();
        assertNotNull(userBasket);
        assertEquals(2, userBasket.getBasketItemList().size());

        int expectedTotalCost = 1050;
        assertEquals(expectedTotalCost, userBasket.getTotalCostOfBasket());
    }
}