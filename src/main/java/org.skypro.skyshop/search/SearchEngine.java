package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    //private final List<Searchable> searchStorage;
    private final Map<String, List<Searchable>> searchStorage;

    public SearchEngine() {
        this.searchStorage = new HashMap<>();
    }

    public Map<String, List<Searchable>> search(String searchString) {
        Map<String, List<Searchable>> tempStorage = new TreeMap<>();

        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }
        //int tempStorageIndex = 0;
        for (Map.Entry<String, List<Searchable>> searchable : searchStorage.entrySet()) {
            for (Searchable product : searchable.getValue()) {
                if (product.searchTerm().contains(searchString)) {
                    tempStorage.put(searchable.getKey(), searchable.getValue());
                }
            }
        }
        return tempStorage;
    }

    public void add(Searchable addedObject) {
        if (addedObject == null) {
            throw new IllegalArgumentException("Передан нулевой объект. Добавление отменено");
        }
        List<Searchable> tempList = new ArrayList();
        tempList.add(addedObject);
        searchStorage.put(addedObject.searchTerm(), tempList);
        System.out.println("Объект " + addedObject + " добавлен в поиск");
    }

    public Map<String, List<Searchable>> getSearchStorage() {
        //List<Searchable> tempStorage = new ArrayList<>();
        Map<String, List<Searchable>> tempStorage = new HashMap<>();
        tempStorage.putAll(searchStorage);
        //Collections.copy(searchStorage, tempStorage);
        return tempStorage;
    }

    public Searchable getSearchTerm(String inputSearchString) {
        List<Integer> cntSearches = new ArrayList<>();
        int indexOfMaxSearches;
        int foundedSubstringsTotal = 0;

        for (Map.Entry<String, List<Searchable>> searchable : searchStorage.entrySet()) {
            for (Searchable product : searchable.getValue()) {
                if (product != null) {
                    String searchString = product.getStringPresentation();
                    int cnt = 0;
                    int index = 0;
                    int indexSubstring = searchString.indexOf(inputSearchString, index);
                    while (indexSubstring != -1) {
                        cnt++;
                        index = indexSubstring + searchString.length();
                        indexSubstring = searchString.indexOf(inputSearchString, index);
                    }
                    cntSearches.add(cnt);
                    if (cnt > 0) {
                        foundedSubstringsTotal++;
                    }
                } else {
                    cntSearches.add(0);
                }
            }
        }
        if (foundedSubstringsTotal < 1) {
            throw new BestResultNotFound("Не найден ни один из объектов");
        }
        indexOfMaxSearches = findOfMaxSearches(cntSearches);
        return searchStorage.get(searchStorage).get(indexOfMaxSearches);
    }

    private int findOfMaxSearches(List<Integer> cntSearches) {
        int maxCntSearch = 0;
        int indexOfMaxSearches = -1;
        int indexCnt = 0;

        for (Integer i : cntSearches) {
            if (i > maxCntSearch) {
                maxCntSearch = i;
                indexOfMaxSearches = indexCnt;
            }
            indexCnt++;
        }

        return indexOfMaxSearches;
    }
}