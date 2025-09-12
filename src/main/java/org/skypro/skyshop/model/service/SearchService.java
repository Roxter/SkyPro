package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService() {
        storageService = new StorageService();
    }

    public Collection<SearchResult> search(String searchString) {
        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }

        return storageService.getSearchStorage()
                .stream()
                .filter(searchable -> searchable.getStringPresentation()
                        .toLowerCase()
                        .contains(searchString.toLowerCase()))
                .map(searchable1 -> SearchResult.fromSearchable(searchable1))
                .collect(Collectors.toSet());
    }

    public StorageService getStorageService() {
        return storageService;
    }
}