package org.skypro.skyshop.product;

public final class Article {
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

    @Override
    public String toString() {
        return getName() +
                "\n" + getText();
    }
}
