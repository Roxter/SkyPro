package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Product> products;

    public Basket() {
        this.products = new ArrayList<>();
    }

    public void addToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передан неверный продукт. Запись не добавлена");
        }
        products.add(product);
        System.out.println("Продукт " + product.getName() + " добавлен в корзину.");
    }

    public int costBasket() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total = total + product.getPrice();
            } else {
                break;
            }
        }
        return total;
    }

    public void printContent() {
        int total = 0;
        int totalSpecProd = 0;

        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Корзина содержит:");
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            products.clear();
            System.out.println("Корзина очищена.");
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                total = total + product.getPrice();
                if (product.isSpecial()) {
                    totalSpecProd = totalSpecProd + 1;
                }
            } else {
                break;
            }
        }
        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + totalSpecProd);
    }

    public boolean checkProduct(String name) {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return false;
        }
        for (Product product : products) {
            String prodName = product.getName();
            if (name.equals(prodName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {

    }
}