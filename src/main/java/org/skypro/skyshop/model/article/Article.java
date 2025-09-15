package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.common.util.StringUtils;
import org.skypro.skyshop.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    private final String name;
    private final String text;
    private final UUID id;

    public Article(String name, String text, UUID id) {
        if (name == null || StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Неверно введено имя стаьи");
        }
        this.name = name;
        this.text = text;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @JsonIgnore
    public String searchTerm() {
        return name + " " + text;
    }

    @JsonIgnore
    public String contentType() {
        return "Article";
    }

    @Override
    public UUID getId() {
        return id;
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
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
