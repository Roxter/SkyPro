package org.skypro.skyshop.product;

interface Searchable {
    String searchTerm();
    String contentType();
    default String getStringPresentation() {
        return "";
    }
}
