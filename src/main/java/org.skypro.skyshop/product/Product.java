package org.skypro.skyshop.product;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Неверно введено имя продукта");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String searchTerm() {
        return name;
    }

    public String contentType() {
        return "Product";
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}