package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorageMap;
    private final Map<UUID, Article> articleStorageMap;

    public StorageService() {
        Product productStorageArray[] = fillProductStorageTestData();
        productStorageMap = Arrays.stream(productStorageArray).collect(Collectors.toMap(key -> key.getId(), value -> value));
        Article articleStorageArray[] = fillArticleStorageTestData();
        articleStorageMap = Arrays.stream(articleStorageArray).collect(Collectors.toMap(key -> key.getId(), value -> value));
    }

    public TreeSet<Product> getProductStorage() {
        return productStorageMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Product::getName))));
    }

    public TreeSet<Article> getArticleStorage() {
        return articleStorageMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Article::getName))));
    }

    private Product[] fillProductStorageTestData() {
        return new Product[]{
                new SimpleProduct("Яйца", 200, UUID.randomUUID()),
                new SimpleProduct("Сыр", 680, UUID.randomUUID()),
                new SimpleProduct("ЯблОки", 260, UUID.randomUUID()),
                new DiscountedProduct("Масло", 327, 30, UUID.randomUUID()),
                new DiscountedProduct("Хлеб", 49, 50, UUID.randomUUID()),
                new DiscountedProduct("Тушенка", 235, 26, UUID.randomUUID()),
                new FixPriceProduct("Масло", UUID.randomUUID()),
                new FixPriceProduct("Хлеб", UUID.randomUUID()),
                new FixPriceProduct("Тушенка", UUID.randomUUID())
        };
    }

    private Article[] fillArticleStorageTestData() {
        return new Article[]{
                new Article("Сырная продукция", "Виды сыра", UUID.randomUUID()),
                new Article("Мясная продукция", "Говядина и свинина", UUID.randomUUID()),
                new Article("Мясная продукция", "Курица", UUID.randomUUID())
        };
    }

    public Set<Searchable> getSearchStorage() {
        Set<Searchable> searchStorageResult = new HashSet<>();
        searchStorageResult.addAll(getProductStorage());
        searchStorageResult.addAll(getArticleStorage());
        return searchStorageResult;
    }
}