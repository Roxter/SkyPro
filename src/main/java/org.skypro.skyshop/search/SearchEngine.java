package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchStorage;
    private static final int tempStorageSize = 5;

    public SearchEngine(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Передано неверное значение. Повторите запрос");
        }
        this.searchStorage = new Searchable[size];
    }

    public Searchable[] search(String searchString) {
        Searchable[] tempStorage = new Searchable[tempStorageSize];
        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }

        int tempStorageIndex = 0;
        for (Searchable searchable : searchStorage) {
            if (searchable.searchTerm().contains(searchString)) {
                tempStorage[tempStorageIndex] = searchable;
                tempStorageIndex++;
            }
            if (tempStorageIndex >= tempStorageSize) {
                break;
            }
        }
        return tempStorage;
    }

    public void add(Searchable addedObject) {
        if (addedObject == null) {
            throw new IllegalArgumentException("Передан нулевой объект. Добавление отменено");
        }
        for (int i = 0; i < searchStorage.length; i++) {
            if (i >= searchStorage.length - 1) {
                throw new BestResultNotFound("Массив поиска заполнен");
            }
            if (searchStorage[i] == null) {
                searchStorage[i] = addedObject;
                System.out.println("Объект " + addedObject + " добавлен в поиск");
                break;
            }
        }
    }

    public Searchable[] getSearchStorage() {
        return searchStorage;
    }

    public Searchable getSearchTerm(String search) {
        Integer[] cntSearches = new Integer[searchStorage.length];
        int indexOfMaxSearches;
        int foundedSubstringsTotal = 0;

        for (int i = 0; i < searchStorage.length; i++) {
            Searchable searchable = searchStorage[i];
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
                cntSearches[i] = cnt;
                if (cnt > 0) {
                    foundedSubstringsTotal++;
                }
            }
        }

        if (foundedSubstringsTotal < 1) {
            throw new BestResultNotFound("Не найден ни один из объектов");
        }

        indexOfMaxSearches = findOfMaxSearches(cntSearches);

        return searchStorage[indexOfMaxSearches];
    }

    private int findOfMaxSearches(Integer[] cntSearches) {
        int maxCntSearch = 0;
        int indexOfMaxSearches = -1;

        for (int i = 0; i < cntSearches.length; i++) {
            if (cntSearches[i] > maxCntSearch) {
                maxCntSearch = cntSearches[i];
                indexOfMaxSearches = i;
            }
        }
        return indexOfMaxSearches;
    }
}