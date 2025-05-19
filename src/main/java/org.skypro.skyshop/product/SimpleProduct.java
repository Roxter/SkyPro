package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 1)  {
            throw new IllegalArgumentException("Неверно введена стоимость продукта");
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String contentType() {
        return "SimpleProduct";
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