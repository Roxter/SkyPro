package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int baseCost;
    private int discountInProc;

    public DiscountedProduct(String name, int baseCost, int discountInProc) {
        super(name);
        this.baseCost = baseCost;
        this.discountInProc = discountInProc;
    }

    public String contentType() {
        return "DiscountedProduct";
    }

    @Override
    public int getPrice() {
        return (int) (baseCost * (1.0 - discountInProc / 100.0));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() +
                ": " + getPrice() +
                "р. (" + discountInProc + "%)";
    }
}