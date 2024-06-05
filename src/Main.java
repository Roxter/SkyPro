public class Main {

    public static void main(String[] args) {
        Integer[] value = new Integer[] {3, 4};
        changeValue(value);
        System.out.println(value[0] + " " + value[1]);
    }

    private static void changeValue(Integer[] value) {
        value = new Integer[] {1, 2};
    }
}
