package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    //private final List<Searchable> searchStorage;
    private final Map<String, Set<Searchable>> searchStorage;

    public SearchEngine() {
        this.searchStorage = new TreeMap<>();
    }

    public Map<String, Set<Searchable>> search(String searchString) {
        Map<String, Set<Searchable>> tempStorage = new TreeMap<>();

        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }
        //int tempStorageIndex = 0;
        for (Map.Entry<String, Set<Searchable>> searchable : searchStorage.entrySet()) {
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
        HashSet<Searchable> tempSet = new HashSet<>();
        tempSet.add(addedObject);
        searchStorage.put(addedObject.searchTerm(), tempSet);
        System.out.println("Объект " + addedObject + " добавлен в поиск");
    }

    public Map<String, Set<Searchable>> getSearchStorage() {
        //List<Searchable> tempStorage = new ArrayList<>();
        Map<String, Set<Searchable>> tempStorage = new TreeMap<>();
        tempStorage.putAll(searchStorage);
        //Collections.copy(searchStorage, tempStorage);
        return tempStorage;
    }
}