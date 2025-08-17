package org.skypro.skyshop.search;

import java.util.Set;
import java.util.TreeSet;

public class SearchEngine {
    //private final List<Searchable> searchStorage;
    private final Set<Searchable> searchStorage;

    public SearchEngine() {
        this.searchStorage = new TreeSet<>(new ReverseStringComparator());
    }

    public Set<Searchable> search(String searchString) {
        Set<Searchable> tempStorage = new TreeSet<>(new ReverseStringComparator());

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

    public Set<Searchable> getSearchStorage() {
        Set<Searchable> tempStorage = new TreeSet<>(new ReverseStringComparator());
        tempStorage.addAll(searchStorage);
        return tempStorage;
    }
}

