package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;
    private final UUID id;

    public SimpleProduct(String name, int price, UUID id) {
        super(name);
        if (price <= 1) {
            throw new IllegalArgumentException("Неверно введена стоимость продукта");
        }
        this.price = price;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() +
            ": " + getPrice() + "р.";
    }
}