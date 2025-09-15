package org.skypro.skyshop.service;

import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addToBasket(UUID id) {
        Optional<Product> optionalProduct = storageService.getProductById(id);
        if (optionalProduct.isPresent()) {
            productBasket.addToBasket(id);
        } else {
            throw new NoSuchProductException("Продукт с ID " + id + " не найден");
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getContent()
            .entrySet()
            .stream()
            .map(uuidIntegerEntry -> {
                UUID productID = uuidIntegerEntry.getKey();
                int count = uuidIntegerEntry.getValue();
                Optional<Product> optionalProduct = storageService.getProductById(productID);
                if (optionalProduct.isEmpty()) {
                   throw new NoSuchProductException("Продукт с ID " + productID + " не найден");
                }
                Product product = optionalProduct.get();
                return new BasketItem(product, count);
            })
            .collect(Collectors.toList());
        return new UserBasket(basketItems);
    }
}