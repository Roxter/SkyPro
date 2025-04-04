package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {
    private final Product[] products;
    private final int max_cells = 5;

    public Basket() {
        this.products = new Product[max_cells];
    }

    public void addToBusket(Product product) {
        if (product == null) {
            System.out.println("Передан неверный продукт. Запись не добавлена");
            return;
        }
        int len = products.length;
        if (len >= max_cells) {
            System.out.println("Корзина переполнена. Пожалуйста, освободите корзину.");
            return;
        }
        for (int i = 0; i < len; i++) {
            if (this.products[i] == null) {
                this.products[i] = product;
                break;
            }
        }
    }

    public int costBasket() {
        int total = 0;
        for (Product product:products) {
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
        if (products[0] == null) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Корзина содержит:");
        for (Product product: products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
                total = total + product.getPrice();
            } else {
                break;
            }
        }
        System.out.println("Итого: " + total);
    }

    public boolean checkProduct(String name) {
        if (products[0] == null) {
            System.out.println("Корзина пуста.");
            return false;
        }
        for (Product product: products) {
            String prodName = product.getName();
            if (name.equals(prodName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        if (products[0] == null) {
            System.out.println("Корзина пуста.");
            return;
        }
        for (Product product: products) {
            if (product != null) {
                System.out.println("Элемент удалён");
            } else {
                System.out.println("Корзина очищена.");
                return;
            }
        }
    }
}