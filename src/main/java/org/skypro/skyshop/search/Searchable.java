package org.skypro.skyshop.search;

import java.util.UUID;

public interface Searchable {
    String searchTerm();

    String contentType();

    default String getStringPresentation() {
        return searchTerm() + " " + contentType();
    }

    UUID getId();
}