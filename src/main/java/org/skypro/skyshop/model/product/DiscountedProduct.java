package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private final int baseCost;
    private final int discountInPerc;
    private final UUID id;

    public DiscountedProduct(String name, int baseCost, int discountInPer, UUID id) {
        super(name);
        if (baseCost <= 1) {
            throw new IllegalArgumentException("Неверно введена базовая стоимость");
        }
        this.baseCost = baseCost;
        if (discountInPer < 0 || discountInPer > 100) {
            throw new IllegalArgumentException("Неверно введена стоимость скидки");
        }
        this.discountInPerc = discountInPer;
        this.id = id;
    }

    @Override
    public int getPrice() {
        double perInverter = 1.0;
        double perMux = 100.0;
        return (int) (baseCost * (perInverter - discountInPerc / perMux));
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() +
            ": " + getPrice() +
            "р. (" + discountInPerc + "%)";
    }
}