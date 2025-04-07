package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

class App {
    static Basket basket = new Basket();

    public static void main(String[] args) {
        Product product1 = new Product("Яйца", 560);
        Product product2 = new Product("Сыр", 680);
        Product product3 = new Product("Яблоки", 260);
        Product product4 = new Product("Масло", 327);
        Product product5 = new Product("Хлеб", 49);
        Product product6 = new Product("Тушенка", 235);

        System.out.println("Добавление в корзину:");
        basket.addToBusket(product1);
        basket.addToBusket(product2);
        basket.addToBusket(product3);
        basket.addToBusket(product4);
        basket.addToBusket(product5);
        basket.addToBusket(product6);

        System.out.println("\nСодержимое корзины:");
        basket.printContent();

        System.out.println("\nСтоимость корзины: \n" + basket.costBasket());

        System.out.println("\nОтдельные продукты корзины:");
        String nameOfCheckedProduct = "Хлеб";
        if (check(nameOfCheckedProduct)) {
            System.out.println("Продукт " + nameOfCheckedProduct + " найден.");
        } else {
            System.out.println("Продукт " + nameOfCheckedProduct + " не найден.");
        }

        nameOfCheckedProduct = "Яйца";
        if (check(nameOfCheckedProduct)) {
            System.out.println("Продукт " + nameOfCheckedProduct + " найден.");
        } else {
            System.out.println("Продукт " + nameOfCheckedProduct + " не найден.");
        }

        nameOfCheckedProduct = "Тушенка";
        if (check(nameOfCheckedProduct)) {
            System.out.println("Продукт " + nameOfCheckedProduct + " найден.");
        } else {
            System.out.println("Продукт " + nameOfCheckedProduct + " не найден.");
        }

        System.out.println("\nОчистка корзины:");
        basket.clearBasket();
        System.out.println("\nСодержимое пустой корзины:");
        basket.printContent();
        System.out.println("\nСтоимость пустой корзины: \n" + basket.costBasket());

        System.out.println("\nПоиск товара в пустой корзине:");
        nameOfCheckedProduct = "Тушенка";
        if (check(nameOfCheckedProduct)) {
            System.out.println("Продукт " + nameOfCheckedProduct + " найден.");
        } else {
            System.out.println("Продукт " + nameOfCheckedProduct + " не найден.");
        }

    }

    public static boolean check(String name) {
        return basket.checkProduct(name);
    }
}