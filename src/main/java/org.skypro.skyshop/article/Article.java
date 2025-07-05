package org.skypro.skyshop.article;

import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable, Comparable<Article> {
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getName() +
                "\n" + getText();
    }

    @Override
    public int compareTo(Article o) {
        return name.compareTo(o.name);
    }
}
