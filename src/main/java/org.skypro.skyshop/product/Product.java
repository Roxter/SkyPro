package org.skypro.skyshop.product;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable, Comparable<Product> {
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

    @Override
    public int compareTo(Product o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}