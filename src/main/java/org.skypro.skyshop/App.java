package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;

class App {

    public static void main(String[] args) {
        testProducts();

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

        System.out.println();
        List<Searchable> searchResult1 = searchProducts.search("Яйца");
        List<Searchable> searchResult2 = searchProducts.search("Молочная продукция");
        List<Searchable> searchResult3 = searchProducts.search("Мясная продукция");
        List<Searchable> searchResult4 = searchProducts.search("Хлеб");
        //List<Searchable> searchResult5 = searchProducts.search(null);
        //List<Searchable> searchResult6 = searchProducts.search("");
        System.out.println(Arrays.asList(searchResult1));
        System.out.println(Arrays.asList(searchResult3));
        System.out.println(Arrays.asList(searchResult2));
        System.out.println(Arrays.asList(searchResult4));
        //System.out.println(Arrays.asList(searchResult5));
        //System.out.println(Arrays.asList(searchResult6));

        System.out.println();
        //Searchable searchedObj = searchProducts.getSearchTerm("Груши");
        Searchable searchedObj = searchProducts.getSearchTerm("Хлеб");
        System.out.println("Найденный объект: " + searchedObj.searchTerm());
    }

    static void testBasket() {
        Basket basket = new Basket();

        SimpleProduct product1 = new Basket("Яйца", 560);
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

    static boolean check(String name) {
        return basket.checkProduct(name);
    }

}