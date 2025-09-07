package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.function.Supplier;

public class ReverseStringComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        String name1 = s1.searchTerm();
        String name2 = s2.searchTerm();
        int comp = Integer.compare(name1.length(), name2.length());

        if (comp != 0) {
            return comp;
        } else {
            return name1.compareTo(name2);
        }
    }
}