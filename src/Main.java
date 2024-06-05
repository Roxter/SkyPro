public class Main {

    public static void main(String[] args) {
        int value = 33;
        changeValue(value);
        System.out.println(value);
    }

    private static void changeValue(Integer value) {
        value = 22;
    }
}
