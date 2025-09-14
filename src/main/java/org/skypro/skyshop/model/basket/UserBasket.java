package org.skypro.skyshop.model.basket;

import java.util.List;

public final class UserBasket {
    List<BasketItem> basketItemList;
    int totalCostOfBasket;

    public UserBasket(List<BasketItem> basketItemList) {
        this.basketItemList = basketItemList;
        this.totalCostOfBasket = basketItemList.stream()
            .map(item -> item.getProduct().getPrice() * item.getCount())
            .reduce(0, (subtotal, element) -> subtotal + element);
    }

    public List<BasketItem> getBasketItemList() {
        return basketItemList;
    }

    public int getTotalCostOfBasket() {
        return totalCostOfBasket;
    }
}