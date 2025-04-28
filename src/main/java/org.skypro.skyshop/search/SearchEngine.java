package org.skypro.skyshop.search;

public class SearchEngine {
    public Searchable[] searchStorage;
    int tempStorageSize = 5;
    String[] tempStorage;

    public SearchEngine(int size) {
        if (size <= 0) {
            System.out.println("Передано неверное значение. Повторите запрос");
            return;
        }
        searchStorage = new Searchable[size];
    }

    public String[] search(String searchString) {
        if (searchString == null) {
            System.out.println("Передана нулевая строка. Поиск отменен");
            return null;
        }
        tempStorage = new String[tempStorageSize];
        int tempStorageIndex = 0;
        for (Searchable searchable : searchStorage) {
            if (searchable.searchTerm().contains(searchString)) {
                tempStorage[tempStorageIndex] = searchString;
                tempStorageIndex++;
            }
            if (tempStorageIndex >= 5) {
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
}