package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productStorageBasket;

    public ProductBasket() {
        productStorageBasket = new HashMap<>();
    }

    public void addToBasket(UUID id) {
        Integer currCountProducts = productStorageBasket.get(id);
        if (currCountProducts != null) {
            currCountProducts++;
        } else {
            currCountProducts = 1;
        }
        productStorageBasket.put(id, currCountProducts);
    }

    public Map<UUID, Integer> getContent() {
        return productStorageBasket;
    }
}
