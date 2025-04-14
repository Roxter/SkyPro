package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

class App {
    static Basket basket = new Basket();

    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Яйца", 560);
        SimpleProduct product2 = new SimpleProduct("Сыр", 680);
        SimpleProduct product3 = new SimpleProduct("Яблоки", 260);
        DiscountedProduct product4 = new DiscountedProduct("Масло", 327, 30);
        DiscountedProduct product5 = new DiscountedProduct("Хлеб", 49, 50);
        DiscountedProduct product6 = new DiscountedProduct("Тушенка", 235, 26);
        FixPriceProduct product7 = new FixPriceProduct("Масло");
        FixPriceProduct product8 = new FixPriceProduct("Хлеб");
        FixPriceProduct product9 = new FixPriceProduct("Тушенка");

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