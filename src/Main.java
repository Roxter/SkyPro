public class Main {

    static private int calcDays(int deliveryDistance) {
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

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАЧА 1:");
        int clientOS = 0; // 0 - iOS, 1 - Android
        if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
        clientOS = 1; // OS Android
        if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
        System.out.println();

        // Task 2
        System.out.println("ЗАДАЧА 2:");
        int clientOS_2 = 0; // 0 - iOS, 1 - Android
        int clientDeviceYear = 2015;
        if (clientOS_2 == 0 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        else if (clientOS_2 == 0 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }

        clientOS_2 = 1; // 0 - iOS, 1 - Android
        clientDeviceYear = 2015;
        if (clientOS_2 == 0 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        else if (clientOS_2 == 0 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }

        clientOS_2 = 0; // 0 - iOS, 1 - Android
        clientDeviceYear = 2013;
        if (clientOS_2 == 0 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        else if (clientOS_2 == 0 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }

        clientOS_2 = 1; // 0 - iOS, 1 - Android
        clientDeviceYear = 2013;
        if (clientOS_2 == 0 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear < 2015) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        else if (clientOS_2 == 0 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        }
        else if (clientOS_2 == 1 && clientDeviceYear >= 2015) {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
        System.out.println();

        // Task 3
        System.out.println("ЗАДАЧА 3:");
        for (int year = 2021; year < 2030; year++) {
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
        System.out.println();

        // Task 4
        System.out.println("ЗАДАЧА 4:");
        int deliveryDistance = 95;
        int requireDays = calcDays(deliveryDistance);
        if (requireDays > 0) {
            System.out.println("Потребуется дней: " + requireDays);
        }
        else {
            System.out.println("Доставить вашу карту возможности нет.");
        }
        deliveryDistance = 10;
        requireDays = calcDays(deliveryDistance);
        if (requireDays > 0) {
            System.out.println("Потребуется дней: " + requireDays);
        }
        else {
            System.out.println("Доставить вашу карту возможности нет.");
        }
        deliveryDistance = 45;
        requireDays = calcDays(deliveryDistance);
        if (requireDays > 0) {
            System.out.println("Потребуется дней: " + requireDays);
        }
        else {
            System.out.println("Доставить вашу карту возможности нет.");
        }
        deliveryDistance = 105;
        requireDays = calcDays(deliveryDistance);
        if (requireDays > 0) {
            System.out.println("Потребуется дней: " + requireDays);
        }
        else {
            System.out.println("Доставить вашу карту возможности нет.");
        }
        System.out.println();

        // Task 5
        System.out.println("ЗАДАЧА 5:");
        int monthNumber = 0;
        for (; monthNumber < 14; monthNumber++) {
            switch (monthNumber) {
                case 1:
                    System.out.println(monthNumber + "-й месяц январь принадлежит сезону Зима");
                    break;
                case 2:
                    System.out.println(monthNumber + "-й месяц февраль принадлежит сезону Зима");
                    break;
                case 3:
                    System.out.println(monthNumber + "-й месяц март принадлежит сезону Весна");
                    break;
                case 4:
                    System.out.println(monthNumber + "-й месяц апрель принадлежит сезону Весна");
                    break;
                case 5:
                    System.out.println(monthNumber + "-й месяц май принадлежит сезону Весна");
                    break;
                case 6:
                    System.out.println(monthNumber + "-й месяц июнь принадлежит сезону Лето");
                    break;
                case 7:
                    System.out.println(monthNumber + "-й месяц июль принадлежит сезону Лето");
                    break;
                case 8:
                    System.out.println(monthNumber + "-й месяц август принадлежит сезону Лето");
                    break;
                case 9:
                    System.out.println(monthNumber + "-й месяц сентябрь принадлежит сезону Осень");
                    break;
                case 10:
                    System.out.println(monthNumber + "-й месяц октябрь принадлежит сезону Осень");
                    break;
                case 11:
                    System.out.println(monthNumber + "-й месяц ноябрь принадлежит сезону Осень");
                    break;
                case 12:
                    System.out.println(monthNumber + "-й месяц декабрь принадлежит сезону Зима");
                    break;
                default:
                    System.out.println("Ошибка! Введён некорректный месяц.");
                    break;
            }
        }
        System.out.println();
    }
}
