package org.skypro.skyshop.basket;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final Map<String, List<Product>> productStorage;

    public Basket() {
        this.productStorage = new TreeMap<>();
    }

    public void addToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Передан неверный продукт. Запись не добавлена");
        }
        String productName = product.getName();
        List<Product> tempListProd;
        if (productStorage.containsKey(productName)) {
            tempListProd = productStorage.get(productName);
        } else {
            tempListProd = new ArrayList<>();
        }
        tempListProd.add(product);
        productStorage.put(productName, tempListProd);
        System.out.println("Продукт " + product.getName() + " добавлен в корзину.");
    }

    public int costBasket() {
        int total = 0;

        for (Map.Entry<String, List<Product>> product : productStorage.entrySet()) {
            for (Product prod : product.getValue()) {
                if (prod != null) {
                    total = total + prod.getPrice();
                } else {
                    break;
                }
            }
        }
        return total;
    }

    public void printContent() {
        int total = 0;
        int totalSpecProd = 0;

        if (productStorage.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }
        System.out.println("Корзина содержит:");
        for (Map.Entry<String, List<Product>> product : productStorage.entrySet()) {
            for (Product prod : product.getValue()) {
                System.out.println(prod);
                total = total + prod.getPrice();
                if (prod.isSpecial()) {
                    totalSpecProd = totalSpecProd + 1;
                }
            }
        }
        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + totalSpecProd);
    }

    public boolean checkProduct(String name) {
        if (productStorage.isEmpty()) {
            System.out.println("Корзина пуста.");
            return false;
        }
        for (Map.Entry<String, List<Product>> product : productStorage.entrySet()) {
            for (Product prod : product.getValue()) {
                String prodName = prod.getName();
                if (name.equals(prodName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {

    }

    public List deleteProduct(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Map<String, List<Product>> tempListProd = new TreeMap<>();
        String currProdKey = null;
        List<Product> currProdValue;

        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Неверно введено имя продукта");
        }
        for (Map.Entry<String, List<Product>> product : productStorage.entrySet()) {
            currProdKey = product.getKey();
            currProdValue = product.getValue();
            if (currProdKey.equals(name)) {
                tempListProd.put(currProdKey, currProdValue);
                removedProducts.addAll(currProdValue);
                break;
                /**
                 Iterator<Product> iterator = product.getValue().iterator();
                 while (iterator.hasNext()) {
                 Product prod = iterator.next();
                 if (prod.getName().equals(name)) {
                 removedProducts.add(prod);
                 }
                 }**/
            }
        }

        if (!removedProducts.isEmpty()) {
            productStorage.remove(currProdKey);
        } else {
            System.out.println("Список продуктов для удаления был пуст.");
        }

        return removedProducts;
    }
}