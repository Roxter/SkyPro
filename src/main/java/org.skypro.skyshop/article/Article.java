package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private String name;
    private String text;

    public Article(String name, String text) {
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
        return name;
    }

    public String contentType() {
        return "Article";
    }

    @Override
    public String toString() {
        return getName() +
                "\n" + getText();
    }
}
