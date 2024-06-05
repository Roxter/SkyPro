public class Main {

    public static void main(String[] args) {
        Integer[] value = new Integer[] {3, 4};
        changeValue(value);
        System.out.println(value[0] + " " + value[1]);
    }

    private static void changeValue(Integer[] value) {
        System.out.println(value[1]);
        value[0] = 99;
    }
}
