package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {
    private final Product[] products;
    private final int maxCells = 5;

    public Basket() {
        this.products = new Product[maxCells];
    }

    public void addToBusket(Product product) {
        if (product == null) {
            System.out.println("Передан неверный продукт. Запись не добавлена");
            return;
        }
        int len = products.length;
        for (int i = 0; i < len; i++) {
            if (this.products[i] == null) {
                this.products[i] = product;
                System.out.println("Продукт " + product.getName() + " добавлен в корзину.");
                break;
            } else if (i == len - 1) {
                System.out.println("Корзина переполнена. Пожалуйста, освободите корзину.");
                return;
            }
        }
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

        if (products[0] == null) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Корзина содержит:");
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
        if (products[0] == null) {
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
        boolean basketIsNotFill = false;
        int len = products.length;

        for (int i = 0; i < len; i++) {
            if (products[i] != null) {
                products[i] = null;
                System.out.println("Элемент удалён");
                basketIsNotFill = true;
            }
            if (i == len - 1 && basketIsNotFill) {
                System.out.println("Корзина очищена.");
            } else if (i == len - 1 && !basketIsNotFill) {
                System.out.println("Корзина пуста.");
            }
        }
    }
}