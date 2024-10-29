package collections.service;

import collections.domain.Basket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class StoreService {
    private Basket basket;

    public StoreService() {
        this.basket = new Basket();
    }

    public Basket addToBasket(Integer objId) {
        basket.add(objId);
    }

    public String getFromBasket() {
        return basket.g;
    }
}
