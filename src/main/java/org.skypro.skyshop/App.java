package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;
import java.util.Set;

class App {

    public static void main(String[] args) {
        testProducts();
        testBasket();
    }

    static void testProducts() {
        //SimpleProduct product1 = new SimpleProduct(" ", 560);
        //SimpleProduct product1 = new SimpleProduct("Яйца", 560);
        //SimpleProduct product1 = new SimpleProduct("Яйца", -200);
        SimpleProduct product1 = new SimpleProduct("Яйца", 200);
        SimpleProduct product2 = new SimpleProduct("Сыр", 680);
        SimpleProduct product3 = new SimpleProduct("Яблоки", 260);
        //DiscountedProduct product4 = new DiscountedProduct(" ", 327, 30);
        //DiscountedProduct product4 = new DiscountedProduct("Масло", -327, 30);
        //DiscountedProduct product4 = new DiscountedProduct("Масло", 327, -30);
        DiscountedProduct product4 = new DiscountedProduct("Масло", 327, 30);
        DiscountedProduct product5 = new DiscountedProduct("Хлеб", 49, 50);
        DiscountedProduct product6 = new DiscountedProduct("Тушенка", 235, 26);
        FixPriceProduct product7 = new FixPriceProduct("Масло");
        FixPriceProduct product8 = new FixPriceProduct("Хлеб");
        FixPriceProduct product9 = new FixPriceProduct("Тушенка");
        Article product10 = new Article("Сырная продукция", "Виды сыра");
        Article product11 = new Article("Мясная продукция", "Говядина и свинина");
        Article product12 = new Article("Мясная продукция", "Курица");

        System.out.println();
        SearchEngine searchProducts = new SearchEngine();
        searchProducts.add(product1);
        searchProducts.add(product2);
        searchProducts.add(product3);
        searchProducts.add(product4);
        searchProducts.add(product5);
        searchProducts.add(product6);
        searchProducts.add(product7);
        searchProducts.add(product8);
        searchProducts.add(product9);
        searchProducts.add(product10);
        searchProducts.add(product11);
        searchProducts.add(product12);
        //System.out.println(searchProducts.getSearchStorage()[0].searchTerm());
        System.out.println("Содержимое поискового движка:");
        System.out.println(searchProducts.getSearchStorage());
    }

    static void testBasket() {
        Basket basket = new Basket();

        SimpleProduct product1 = new SimpleProduct("Яйца", 560);
        SimpleProduct product2 = new SimpleProduct("Сыр", 680);
        SimpleProduct product3 = new SimpleProduct("Яблоки", 260);
        DiscountedProduct product4 = new DiscountedProduct("Масло", 327, 30);
        DiscountedProduct product5 = new DiscountedProduct("Хлеб", 49, 50);
        DiscountedProduct product6 = new DiscountedProduct("Тушенка", 235, 26);
        DiscountedProduct product7 = new DiscountedProduct("Тушенка", 235, 26);
        /*FixPriceProduct product7 = new FixPriceProduct("Масло");
        FixPriceProduct product8 = new FixPriceProduct("Хлеб");
        FixPriceProduct product9 = new FixPriceProduct("Тушенка");*/

        System.out.println("\nДобавление в корзину:");
        basket.addToBasket(product1);
        basket.addToBasket(product2);
        basket.addToBasket(product3);
        basket.addToBasket(product4);
        basket.addToBasket(product5);
        basket.addToBasket(product6);
        basket.addToBasket(product7);

        System.out.println("\nСодержимое корзины:");
        basket.printContent();

        String nameOfDeletedProduct = "Хлеб";
        System.out.println("\nУдаляем продукт " + nameOfDeletedProduct + "...");
        Set deletedProducts = basket.deleteProduct(nameOfDeletedProduct);
        System.out.println("\nУдаленные продукты:" + " " + Arrays.asList(deletedProducts));
        System.out.println("\nСодержимое корзины:");
        basket.printContent();
        nameOfDeletedProduct = "Чай";
        System.out.println("\nУдаляем продукт " + nameOfDeletedProduct + "...");
        deletedProducts = basket.deleteProduct(nameOfDeletedProduct);
        System.out.println("\nУдаленные продукты:" + " " + Arrays.asList(deletedProducts));
        System.out.println("\nСодержимое корзины:");
        basket.printContent();
    }

    static boolean check(Basket basket, String name) {
        return basket.checkProduct(name);
    }

}