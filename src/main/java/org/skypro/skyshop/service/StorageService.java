package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorageMap;
    private final Map<UUID, Article> articleStorageMap;

    public StorageService() {
        Product productStorageArray[] = fillProductStorageTestData();
        productStorageMap = Arrays.stream(productStorageArray)
            .collect(Collectors.toMap(Searchable::getId, value -> value)
            );
        Article articleStorageArray[] = fillArticleStorageTestData();
        articleStorageMap = Arrays.stream(articleStorageArray)
            .collect(
                Collectors.toMap(Article::getId, value -> value)
            );
    }

    public List<Product> getProductStorage() {
        return new ArrayList<>(productStorageMap.values());
    }

    public List<Article> getArticleStorage() {
        return new ArrayList<>(articleStorageMap.values());
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

    public Stream<Searchable> getSearchStorageStream() {
        return Stream.concat(
            productStorageMap.values().stream(),
            articleStorageMap.values().stream()
        );
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(productStorageMap.get(id));
    }
}