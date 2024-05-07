import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        //Task 1
        System.out.println("ЗАДАЧА 1:");
        int checkingYear = 2015;
        checkLeapYear(checkingYear);
        System.out.println();

        //Task 2
        System.out.println("ЗАДАЧА 2:");
        int currentYear = LocalDate.now().getYear();
        int clientOS = 1;
        checkOSVersion(clientOS, currentYear);
        clientOS = 0;
        checkOSVersion(clientOS, currentYear);
        currentYear = 2010;
        checkOSVersion(clientOS, currentYear);
        clientOS = 1;
        checkOSVersion(clientOS, currentYear);
        System.out.println();

        //Task 3
        System.out.println("ЗАДАЧА 3:");
        int deliveryDistance = 95;
        int requireDays = calcDays(deliveryDistance);
        if (requireDays > 0) {
            System.out.println("Для доставки карты потребуется дней: " + requireDays);
        }
        else {
            System.out.println("Доставить вашу карту возможности нет.");
        }
        System.out.println();
    }

    public static void checkLeapYear(int year) {
        boolean isLeapYear = ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0));
        if (year > 1584) {
            if (isLeapYear) {
                System.out.println(year + " год является високосным");
            }
            else {
                System.out.println(year + " год не является високосным");
            }
        }
        else {
            System.out.println(year + " год - это год до введения високосных годов");
        }
    }

    public static void checkOSVersion(int OSType, int year) {
        if (OSType == 0 && year < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if (OSType == 1 && year < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        else if (OSType == 0 && year >= 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if (OSType == 1 && year >= 2015) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    public static int calcDays(int deliveryDistance) {
        if (deliveryDistance < 20) {
            return 1;
        }
        else if (deliveryDistance >= 20 && deliveryDistance < 60) {
            return 2;
        }
        else if (deliveryDistance >= 60 && deliveryDistance < 100) {
            return 3;
        }
        else {
            return -1;
        }
    }
}
