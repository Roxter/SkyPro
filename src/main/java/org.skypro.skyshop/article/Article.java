package org.skypro.skyshop.article;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String name;
    private final String text;

    public Article(String name, String text) {
        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Неверно введено имя стаьи");
        }
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String searchTerm() {
        return name + " " + text;
    }

    public String contentType() {
        return "Article";
    }

    @Override
    public String toString() {
        return getName() +
                "\n" + getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
