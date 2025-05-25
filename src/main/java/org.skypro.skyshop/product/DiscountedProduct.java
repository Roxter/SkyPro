package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int baseCost;
    private final int discountInPerc;

    public DiscountedProduct(String name, int baseCost, int discountInPer) {
        super(name);
        if (baseCost <= 1) {
            throw new IllegalArgumentException("Неверно введена базовая стоимость");
        }
        this.baseCost = baseCost;
        if (discountInPer < 0 || discountInPer > 100) {
            throw new IllegalArgumentException("Неверно введена стоимость скидки");
        }
        this.discountInPerc = discountInPer;
    }

    @Override
    public int getPrice() {
        double perInverter = 1.0;
        double perMux = 100.0;
        return (int) (baseCost * (perMux - discountInPerc / perMux));
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