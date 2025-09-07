package org.skypro.skyshop.basket;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Basket {
    private final Map<String, Set<Product>> productStorage;

    public Basket() {
        this.productStorage = new TreeMap<>();
    }

    public void addToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передан неверный продукт. Запись не добавлена");
        }
        String productName = product.getName();
        productStorage.computeIfPresent(productName, (k, v) -> v = productStorage.get(k));
        productStorage.computeIfAbsent(productName, v -> new HashSet<>()).add(product);
        System.out.println("Продукт " + productName + " добавлен в корзину.");
    }

    public int costBasket() {
        return productStorage.entrySet()
                .stream()
                .filter(Objects::nonNull)
                .flatMap(element -> element.getValue()
                        .stream()
                        .filter(Objects::nonNull))
                .mapToInt(product -> product.getPrice())
                .sum();
    }

    public void printContent() {
        int total = 0;
        int totalSpecProd = 0;

        if (productStorage.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Корзина содержит:");

        for (Map.Entry<String, Set<Product>> product : productStorage.entrySet()) {
            total = total + product.getValue()
                    .stream()
                    .filter(Objects::nonNull)
                    .mapToInt(productMap -> productMap.getPrice())
                    .sum();
        }
        totalSpecProd = getSpecialCount();
        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + totalSpecProd);
    }

    public boolean checkProduct(String name) {
        if (productStorage.isEmpty()) {
            System.out.println("Корзина пуста.");
            return false;
        }
        for (Map.Entry<String, Set<Product>> product : productStorage.entrySet()) {
            for (Product prod : product.getValue()) {
                String prodName = prod.getName();
                if (name.equals(prodName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<Product> deleteProduct(String name) {
        Set<Product> removedProducts = new HashSet<>();
        Map<String, Set<Product>> tempListProd = new TreeMap<>();
        String currProdKey = null;
        Set<Product> currProdValue;

        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Неверно введено имя продукта");
        }

        for (Map.Entry<String, Set<Product>> product : productStorage.entrySet()) {
            currProdKey = product.getKey();
            currProdValue = product.getValue();
            if (currProdKey.equals(name)) {
                tempListProd.put(product.getKey(), product.getValue());
                removedProducts.addAll(currProdValue);
                break;
            }
        }

        if (!removedProducts.isEmpty()) {
            productStorage.remove(currProdKey);
        } else {
            System.out.println("Список продуктов для удаления был пуст.");
        }

        return removedProducts;
    }

    private int getSpecialCount() {
        long count = productStorage.entrySet()
                .stream()
                .filter(Objects::nonNull)
                .flatMap(element -> element.getValue()
                        .stream()
                        .filter(Objects::nonNull)
                        .filter(Product::isSpecial))
                .mapToInt(product -> product.getPrice())
                .count();
        return Long.valueOf(count).intValue();
    }
}