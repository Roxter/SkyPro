package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchStorage;

    public SearchEngine() {
        this.searchStorage = new ArrayList<>();
    }

    public List<Searchable> search(String searchString) {
        List<Searchable> tempStorage = new ArrayList<>();

        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }
       //int tempStorageIndex = 0;
        for (Searchable searchable : searchStorage) {
            if (searchable.searchTerm().contains(searchString)) {
                tempStorage.add(searchable);
            }
        }
        return tempStorage;
    }

    public void add(Searchable addedObject) {
        if (addedObject == null) {
            throw new IllegalArgumentException("Передан нулевой объект. Добавление отменено");
        }
        searchStorage.add(addedObject);
        System.out.println("Объект " + addedObject + " добавлен в поиск");
    }

    public List<Searchable> getSearchStorage() {
        List<Searchable> tempStorage = new ArrayList<>();

        Collections.copy(searchStorage, tempStorage);
        return tempStorage;
    }

    public Searchable getSearchTerm(String search) {
        List<Integer> cntSearches = new ArrayList<>();
        int indexOfMaxSearches;
        int foundedSubstringsTotal = 0;

        for (Searchable searchable: searchStorage) {
            if (searchable != null) {
                String searchString = searchable.getStringPresentation();
                int cnt = 0;
                int index = 0;
                int indexSubstring = searchString.indexOf(search, index);
                while (indexSubstring != -1) {
                    cnt++;
                    index = indexSubstring + searchString.length();
                    indexSubstring = searchString.indexOf(search, index);
                }
                cntSearches.add(cnt);
                if (cnt > 0) {
                    foundedSubstringsTotal++;
                }
            } else {
                cntSearches.add(0);
            }
        }
        if (foundedSubstringsTotal < 1) {
            throw new BestResultNotFound("Не найден ни один из объектов");
        }
        indexOfMaxSearches = findOfMaxSearches(cntSearches);
        return searchStorage.get(indexOfMaxSearches);
    }

    private int findOfMaxSearches(List<Integer> cntSearches) {
        int maxCntSearch = 0;
        int indexOfMaxSearches = -1;
        int indexCnt = 0;

        for (Integer i: cntSearches) {
            if (i > maxCntSearch) {
                maxCntSearch = i;
                indexOfMaxSearches = indexCnt;
            }
            indexCnt++;
        }

        return indexOfMaxSearches;
    }
}