package org.skypro.skyshop.search;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    //private final List<Searchable> searchStorage;
    private final Set<Searchable> searchStorage;

    public SearchEngine() {
        this.searchStorage = new TreeSet<>(new ReverseStringComparator());
    }

    public Set<Searchable> search(String searchString) {
        if (searchString == null || searchString.isEmpty()) {
            throw new IllegalArgumentException("Передана нулевая строка.");
        }

        Comparator<Searchable> reverseComparator = new ReverseStringComparator();
        Supplier<TreeSet<Searchable>> treeSetSupplier = () -> new TreeSet<>(reverseComparator);
        Set<Searchable> tempStorage = searchStorage.stream()
                .filter(searchable -> searchable.searchTerm().contains(searchString))
                .collect(Collectors.toCollection(treeSetSupplier));
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

