package org.skypro.skyshop;

import org.skypro.skyshop.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search(String searchString) {
        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }

        return storageService.getSearchStorageStream()
            .filter(searchable -> searchable.getStringPresentation()
                .toLowerCase()
                .contains(searchString.toLowerCase()))
            .map(searchable1 -> SearchResult.fromSearchable(searchable1))
            .collect(Collectors.toSet());
    }
}