package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

class App {

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
        Article product10 = new Article("Сырная продукция", "Виды сыра");
        Article product11 = new Article("Мясная продукция", "Говядина и свинина");
        Article product12 = new Article("Мясная продукция", "Курица");

        SearchEngine searchProducts = new SearchEngine(9);
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
        System.out.println(searchProducts.searchStorage[0].searchTerm());

        String[] searchResult1 = searchProducts.search("Яйца");
        String[] searchResult2 = searchProducts.search("Молочная продукция");
        String[] searchResult3 = searchProducts.search("Мясная продукция");
        String[] searchResult4 = searchProducts.search("Хлеб");
        System.out.println(Arrays.toString(searchResult1));
        System.out.println(Arrays.toString(searchResult2));
        System.out.println(Arrays.toString(searchResult3));
        System.out.println(Arrays.toString(searchResult4));
    }
}