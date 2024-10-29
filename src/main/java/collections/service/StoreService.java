package collections.service;

import collections.domain.Basket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class StoreService {
    private Basket basket;
    private final ObjectMapper objectMapper;

    public StoreService() {
        this.basket = new Basket();
        this.objectMapper = new ObjectMapper();
    }

    public void addToBasket(Integer objId) {
        basket.add(objId);
    }

    public String getFromBasket() throws JsonProcessingException {
        return objectMapper.writeValueAsString(basket.get());
    }
}
