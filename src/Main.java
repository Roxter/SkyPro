import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        // Task 1
        System.out.println("ЗАДАЧА 1:");
        int seconds = 2_147_483_647;
        System.out.println("Значение переменной seconds с типом int равно " + seconds);
        byte cycles = 127;
        System.out.println("Значение переменной cycles с типом byte равно " + cycles);
        short rhytms = 32767;
        System.out.println("Значение переменной rhytms с типом short равно " + rhytms);
        long atoms = 9_223_372_036_854_775_807L;
        System.out.println("Значение переменной atoms с типом atoms равно " + atoms);
        float mathematic = 3.4E+38f;
        System.out.println("Значение переменной mathematic с типом float равно " + mathematic);
        double astronomic = 1.7E+308;
        System.out.println("Значение переменной astronomic с типом double равно " + astronomic);
        System.out.println();

        // Task 2
        System.out.println("ЗАДАЧА 2:");
        float var1 = 27.12f;
        System.out.println("Значение переменной var1 с типом float равно " + var1);
        long var2 = 987_678_965_549L;
        System.out.println("Значение переменной var2 с типом long равно " + var2);
        float var3 = 2.786f;
        System.out.println("Значение переменной var3 с типом float равно " + var3);
        short var4 = 569;
        System.out.println("Значение переменной var4 с типом short равно " + var4);
        short var5 = -159;
        System.out.println("Значение переменной var5 с типом short равно " + var5);
        short var6 = 27897;
        System.out.println("Значение переменной var6 с типом short равно " + var6);
        byte var7 = 67;
        System.out.println("Значение переменной var7 с типом byte равно " + var7);
        System.out.println();

        // Task 3
        System.out.println("ЗАДАЧА 3:");
        int teacherLP = 23;
        int teacherAS = 27;
        int teacherEA = 30;
        int sumLists = 559;
        int listsOnPerStud = sumLists / (teacherLP + teacherAS + teacherEA);
        System.out.println("На каждого ученика рассчитано " + listsOnPerStud + " листов бумаги");
        System.out.println();

        // Task 4
        System.out.println("ЗАДАЧА 4:");
        int performancePerMin = 8;
        int minutesInHour = performancePerMin * 60;
        int minutesInDay = minutesInHour * 24;
        int minutesInMonth = minutesInDay * 30;
        int performancePer2Min = performancePerMin * 2;
        int performancePer20Min = performancePerMin * 20;
        System.out.println("За 20 мин. машина произвела " + performancePer20Min + " штук бутылок");
        System.out.println("За 1 день машина произвела " + minutesInDay + " штук бутылок");
        int performancePer3Days = minutesInDay * 3;
        System.out.println("За 3 дня машина произвела " + performancePer3Days + " штук бутылок");
        System.out.println("За 1 месяц машина произвела " + minutesInMonth + " штук бутылок");
        System.out.println();

        // Task 5
        System.out.println("ЗАДАЧА 5:");
        int whitePaintTins = 2;
        int brownPaintTins = 4;
        int tinsPerClass = whitePaintTins + brownPaintTins;
        int sumTins = 120;
        int classesOnSchool = sumTins / tinsPerClass;
        int whiteTinsOnSchool = classesOnSchool * whitePaintTins;
        int brownTinsOnSchool = classesOnSchool * brownPaintTins;
        System.out.println("В школе, где " + classesOnSchool + " классов, нужно " + whiteTinsOnSchool + " банок белой краски и " + brownTinsOnSchool + " банок коричневой краски");
        System.out.println();

        // Task 6
        System.out.println("ЗАДАЧА 6:");
        int numBananas = 5;
        int numMilk = 5;
        int numIcecream = 2;
        int numEggs = 4;
        int weightBananas = 80;
        int weightMilk = 105;
        int weightIcecream = 100;
        int weightEggs = 70;
        int grPerKg = 1000;
        float sumProductInGramms = numBananas * weightBananas + numMilk * weightMilk + numIcecream * weightIcecream + numEggs * weightEggs;
        float sumProductInKilogramms = sumProductInGramms / grPerKg;
        System.out.println("Вес спортзавтрака равен: " + sumProductInGramms + " грамм, или " + sumProductInKilogramms + " килограмм");
        System.out.println();

        // Task 7
        System.out.println("ЗАДАЧА 7:");
        int weightGoal = 7000;
        int lightJump = 250;
        int hardJump = 500;
        int daysForWeightLoseLight = weightGoal / lightJump;
        int daysForWeightLoseHard = weightGoal / hardJump;
        System.out.println("7кг сбрасывается: в лайт режиме " + daysForWeightLoseLight + " дней, в хард режиме " + daysForWeightLoseHard + " дней");
        System.out.println();

        // Task 8
        System.out.println("ЗАДАЧА 8:");
        int salaryMasha = 67760;
        int salaryDenis = 83690;
        int salaryKristina = 76230;
        float degOfIncr = 0.1f;
        float salaryIncrMasha = salaryMasha * degOfIncr + salaryMasha;
        float salaryIncrDenis = salaryDenis * degOfIncr + salaryDenis;
        float salaryIncrKristina = salaryKristina * degOfIncr + salaryKristina;
        float salaryDiffMasha = salaryIncrMasha - salaryMasha;
        float salaryDiffDenis = salaryIncrDenis - salaryDenis;
        float salaryDiffKristina = salaryIncrKristina - salaryKristina;
        System.out.println("Доход Маши: " + salaryMasha + " рублей. Доход Маши после повышения: " + salaryIncrMasha + " рублей. Разница: " + salaryDiffMasha);
        System.out.println("Доход Дениса: " + salaryDenis + " рублей. Доход Дениса после повышения: " + salaryIncrDenis + " рублей. Разница: " + salaryDiffDenis);
        System.out.println("Доход Кристины: " + salaryKristina + " рублей. Доход Кристины после повышения: " + salaryIncrKristina + " рублей. Разница: " + salaryDiffKristina);
    }
}