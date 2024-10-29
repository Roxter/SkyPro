package collections.domain;

import java.util.HashSet;

public class Basket {
    private final HashSet<Integer> objects;

    public Basket() {
        objects = new HashSet<>();
    }

    public void add(int objNum) {
        this.objects.add(objNum);
    }

    public void get() {
        StringBuilder out;

        for (:
             ) {

        }
        this.objects.add(objNum);
    }

/*
    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + firstName + '\'' +
                ", last name = '" + lastName +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Basket e2 = (Basket) obj;
        return firstName.equals(e2.firstName) &&
                lastName.equals(e2.lastName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName);
    }*/
}
