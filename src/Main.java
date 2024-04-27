import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАНИЕ 1:");
        int [] spending = new int[] {250, 15000, 2000, 100, 17};
        int sum = 0;
        for (int cost: spending) {
            sum += cost;
        }
        System.out.println("Сумма трат за месяц составила " + sum + " рублей");
        System.out.println();

        // Task 2
        System.out.println("ЗАДАНИЕ 2:");
        int [] spending1 = new int[] {1800, 20, 2, 600000, 59856};
        int spending1Size = spending1.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < spending1Size; index++) {
            if (spending1[index] < min) {
                min = spending1[index];
            }
            if (spending1[index] > max) {
                max = spending1[index];
            }
        }
        System.out.println("Минимальная сумма трат за неделю составила " + min + " рублей. Максимальная сумма трат за неделю составила " + max + " рублей");
        System.out.println();

        // Task 3
        System.out.println("ЗАДАНИЕ 3:");
        int [] spending2 = new int[] {2100, 9, 95, 58000, 701584};
        int spending2Size = spending2.length;
        sum = 0;
        double amountSpending2 = 0.0;
        for (int cost: spending2) {
            sum += cost;
        }
        amountSpending2 = (double)sum / spending2Size;
        System.out.println("Сумма трат за месяц составила " + amountSpending2 + " рублей");
        System.out.println();

        // Task 4
        System.out.println("ЗАДАНИЕ 4:");
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        int reverseFullNameLength = reverseFullName.length;
        for (int index = reverseFullNameLength - 1; index >= 0; index--) {
            if (index == reverseFullNameLength - 1) {
                System.out.print("[");
            }
            System.out.print(reverseFullName[index]);
            if (index == 0) {
                System.out.print("]\n");
            }
        }
        System.out.println();
    }
}