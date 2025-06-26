package org.skypro.skyshop.basket;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class Basket {
    private final Map<String, List<Product>> products;

    public Basket() {
        this.products = new TreeMap<>();
    }

    public void addToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передан неверный продукт. Запись не добавлена");
        }
        String productName = product.getName();
        if (products.containsKey(productName)) {
            List<Product> tempListProd = products.get(productName);
            tempListProd.add(product);
            products.put(productName, tempListProd);
            products.put(productName, tempListProd);
        } else {
            List<Product> tempListProd = new ArrayList<>();
            products.put(productName, tempListProd);
        }
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

    public List deleteProduct(String name) {
        List<Product> removedProducts = new ArrayList<>();

        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Неверно введено имя продукта");
        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список продуктов для удаления был пуст.");
        } else {
            products.removeAll(removedProducts);
        }
        return removedProducts;
    }
}