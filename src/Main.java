import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАНИЕ 1:");
        System.out.println("инициализация массивов...");
        int [] arrayint = new int[] {1, 2, 3};
        double [] arraydoub = new double[] {1.57, 7.654, 9.986};
        long [] arraylong = new long[] {1_562_462_265_541_156L, -5695L, -1L, 26120598L};
        System.out.println("массивы инициализированы.");
        System.out.println();

        // Task 2
        System.out.println("ЗАДАНИЕ 2:");
        System.out.println("arrayint: " + Arrays.toString(arrayint));
        System.out.println("arraydoub: " + Arrays.toString(arraydoub));
        System.out.println("arraylong: " + Arrays.toString(arraylong));
        System.out.println();

        // Task 3
        System.out.println("ЗАДАНИЕ 3:");
        System.out.print("arrayint reversed: ");
        for (int index = arrayint.length - 1; index >= 0; index--) {
            System.out.print(arrayint[index]);
            if (index != 0)
                System.out.print(", ");
            else
                System.out.println();
        }
        System.out.print("arraydoub reversed: ");
        for (int index = arraydoub.length - 1; index >= 0; index--) {
            System.out.print(arraydoub[index]);
            if (index != 0)
                System.out.print(", ");
            else
                System.out.println();
        }
        System.out.print("arraylong reversed: ");
        for (int index = arraylong.length - 1; index >= 0; index--) {
            System.out.print(arraylong[index]);
            if (index != 0)
                System.out.print(", ");
            else
                System.out.println();
        }
        System.out.println();

        // Task 4
        System.out.println("ЗАДАНИЕ 4:");
        System.out.println("поиск чётных чисел...");
        for (int index = 0; index <= arrayint.length - 1; index++) {
            if (arrayint[index] % 2 != 0) {
                System.out.println("найдено нечётное число " + arrayint[index] + ". замена...");
                arrayint[index] = arrayint[index] + 1;
            }
        }
        System.out.println("изменённый массив: " + Arrays.toString(arrayint));
        System.out.println();
    }
}