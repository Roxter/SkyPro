package collections.domain;

import java.util.HashSet;

public class Basket {
    private final HashSet<Integer> goods;

    public Basket() {
        goods = new HashSet<>();
    }

    public void add(int objNum) {
        this.goods.add(objNum);
    }

    public HashSet<Integer> get() {
        return goods;
    }
}
