package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchStorage;
    private static final int tempStorageSize = 5;
    private static final int startIndex = 0;

    public SearchEngine(int size) {
        if (size <= startIndex) {
            System.out.println("Передано неверное значение. Повторите запрос");
            return;
        }
        this.searchStorage = new Searchable[size];
    }

    public Searchable[] search(String searchString) {
        Searchable[] tempStorage = new Searchable[tempStorageSize];
        if (searchString == null || searchString.isEmpty()) {
            System.out.println("Передана нулевая строка.");
            return tempStorage;
        }

        int tempStorageIndex = startIndex;
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
            System.out.println("Передан нулевой объект. Добавление отменено");
            return;
        }
        for (int i = 0; i < searchStorage.length; i++) {
            if (searchStorage[i] == null) {
                searchStorage[i] = addedObject;
                System.out.println("Объект " + addedObject + " добавлен в поиск");
                break;
            } else if (i >= searchStorage.length - 1) {
                System.out.println("Массив поиска заполнен");
            }
        }
    }

    public Searchable[] getSearchStorage() {
        return searchStorage;
    }

    public Searchable getSearchTerm(String search) {
        int cnt_searchs = 0;

        for (Searchable searchable:searchStorage) {
            if (searchable != null) {
                String tempString = searchable.getStringPresentation();
                int cnt = 0;
                int index = 0;
                int indexSubstring = tempString.indexOf(search, index);
                while (indexSubstring != -1) {
                    cnt++;
                    index = indexSubstring + tempString.length();
                    indexSubstring = tempString.indexOf(search, index);
                }
            }
        }
    }
}