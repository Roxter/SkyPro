import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАЧА 1:");
        int min = 1;
        int max = 10;
        int i = min;
        System.out.println("Все числа от " + min + " до " + max + ": ");
        for (; i <= max; i++) {
            System.out.printf(i + " ");
        }
        System.out.println("\n");

        // Task 2
        System.out.println("ЗАДАЧА 2:");
        i = max;
        System.out.println("Все числа от " + max + " до " + min + ": ");
        for (; i >= min; i--) {
            System.out.printf(i + " ");
        }
        System.out.println("\n");

        // Task 3
        System.out.println("ЗАДАЧА 3:");
        min = 0;
        max = 17;
        int step = 2;
        System.out.println("Все чётные числа от " + min + " до " + max + ": ");
        i = min;
        for (; i <= max; i = i + step) {
            System.out.printf(i + " ");
        }
        System.out.println("\n");

        // Task 4
        System.out.println("ЗАДАЧА 4:");
        min = -10;
        max = 10;
        i = max;
        System.out.println("Все числа от " + max + " до " + min + ": ");
        for (; i >= min; i--) {
            System.out.printf(i + " ");
        }
        System.out.println("\n");

        // Task 5
        System.out.println("ЗАДАЧА 5:");
        int minYear = 1904;
        int maxYear = 2096;
        int stepForLeap = 4;
        int currYear = minYear;
        for (; currYear <= maxYear; currYear = currYear + stepForLeap) {
            System.out.println(currYear + " год является високосным");
        }
        System.out.println("\n");

        // Task 6
        System.out.println("ЗАДАЧА 6:");
        min = 7;
        max = 98;
        step = 7;
        i = min;
        System.out.println("Все числа от " + min + " до " + max + " с шагом " + step + ": ");
        for (; i <= max; i = i + 7) {
            System.out.printf(i + " ");
        }
        System.out.println("\n");

        // Task 7
        System.out.println("ЗАДАЧА 7:");
        min = 1;
        max = 512;
        int factor = 2;
        i = min;
        System.out.println("Все числа от " + min + " до " + max + " с множителем " + factor + ": ");
        for (; i <= max; i = i * factor) {
            System.out.printf(i + " ");
        }
        System.out.println("\n");

        // Task 8
        System.out.println("ЗАДАЧА 8:");
        int accum = 0;
        int increment = 27000;
        int monthInYear = 12;
        for (int currMonth = 1; currMonth <= monthInYear; currMonth++) {
            accum = accum + increment;
            System.out.println("Месяц " + currMonth + ", сумма накоплений равна " + accum + " рублей");
        }
        System.out.println("\n");

        // Task 9
        System.out.println("ЗАДАЧА 9:");
        double accumToBank = 0;
        increment = 27000;
        double perDip = 0.01;
        for (int currMonth = 1; currMonth <= monthInYear; currMonth++) {
            accumToBank = accumToBank + increment + accumToBank * perDip;
            System.out.printf("Месяц  %d, сумма накоплений равна %.01f рублей\n", currMonth, accumToBank);
        }
        System.out.println("\n");

        // Task 10
        System.out.println("ЗАДАЧА 10:");
        int startNum = 1;
        int endNum = 10;
        for (i = startNum; i <= endNum; i++) {
            System.out.println("2 * " + i + " = " + (2 * i));
        }
    }
}