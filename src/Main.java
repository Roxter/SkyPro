public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАЧА 1:");
        int startSum = 0;
        double currSum = 0;
        int increment = 15000;
        int goal = 2459000;
        double perDip = 0.01;
        int currMonth = 1;
        while (currSum <= goal) {
            System.out.printf("Месяц %d сумма накоплений равна %.1f рублей\n", currMonth, currSum);
            currMonth++;
            currSum = currSum + increment + currSum * perDip;
        }
        System.out.println();

        // Task 2
        System.out.println("ЗАДАЧА 2:");
        int min = 1;
        int max = 10;
        int i = min;
        while (i <= max) {
            System.out.printf("%d ", i);
            i++;
        }
        System.out.println();
        for (i = max; i >= min; i--) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        // Task 3
        System.out.println("ЗАДАЧА 3:");
        int burthRate = 17;
        int deathRate = 8;
        int perHum = 1000;
        int burthRateOnPop;
        int deathRateOnPop;
        int startYear = 1;
        int maxYears = 12;
        int currentPop = 12_000_000;
        for (int year = startYear; year < maxYears; year++) {
            burthRateOnPop = currentPop * burthRate / perHum;
            deathRateOnPop = currentPop * deathRate / perHum;
            currentPop = burthRateOnPop - deathRateOnPop + currentPop;
            System.out.println("Год " + year + ", численность населения составляет " + currentPop + " человек");
        }
        System.out.println();

        // Task 4
        System.out.println("ЗАДАЧА 4:");
        double currDeposit = 15000;
        goal = 12_000_000;
        perDip = 0.07;
        currMonth = 0;
        while (currDeposit <= goal) {
            currMonth++;
            currDeposit = currDeposit + currDeposit * perDip;
            System.out.printf("Месяц %d сумма накоплений равна %.1f рублей\n", currMonth, currDeposit);
        }
        System.out.println("Василию нужно копить " + goal + " рублей " + currMonth + " месяцев");
        System.out.println();

        // Task 5
        System.out.println("ЗАДАЧА 5:");
        currDeposit = 15000;
        goal = 12_000_000;
        perDip = 0.07;
        currMonth = 0;
        while (currDeposit <= goal) {
            currMonth++;
            currDeposit = currDeposit + currDeposit * perDip;
            if (currMonth % 6 != 0)
                continue;
            System.out.printf("Месяц %d сумма накоплений равна %.1f рублей\n", currMonth, currDeposit);
        }
        System.out.println("Василию нужно копить " + goal + " рублей " + currMonth + " месяцев");
        System.out.println();

        // Task 6
        System.out.println("ЗАДАЧА 6:");
        currDeposit = 15000;
        perDip = 0.07;
        currMonth = 0;
        int yearsGoal = 9;
        int monthsInYears = 12;
        while (currMonth <= yearsGoal * monthsInYears) {
            currMonth++;
            currDeposit = currDeposit + currDeposit * perDip;
            if (currMonth % 6 != 0)
                continue;
            System.out.printf("Месяц %d сумма накоплений равна %.1f рублей\n", currMonth, currDeposit);
        }
        System.out.printf("Василий за %d лет накопит %.1f рублей", currMonth / monthsInYears, currDeposit);
        System.out.println();

        // Task 7
        System.out.println("ЗАДАЧА 7:");
        int numberOfFriday = 5;
        int currentDay = 1;
        int daysInMonth = 31;
        while (currentDay <= daysInMonth) {
            if (currentDay == numberOfFriday) {
                System.out.println("Сегодня пятница, " + currentDay + "-е число. Необходимо подготовить отчет");
                numberOfFriday = numberOfFriday + 7;
            }
            currentDay++;
        }
        System.out.println();

        // Task 8
        System.out.println("ЗАДАЧА 8:");
        startYear = 0;
        int currentYear = 2024;
        int preYear = currentYear - 200;
        int postYear = currentYear + 100;
        int accountingYear = startYear;
        int stepYearKometa = 79;
        while (accountingYear <= postYear) {
            if (accountingYear >= preYear)
                System.out.println("Комета появилась в " + accountingYear + " году");
            accountingYear = accountingYear + stepYearKometa;
        }
    }
}