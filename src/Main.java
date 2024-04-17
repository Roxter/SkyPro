import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {

        // Task 1
        System.out.println("TASK 1:");
        int age = 17;
        if (age >= 18) {
            System.out.println("Возраст человека равен " + age + " он совершеннолетний.");
        } else {
            System.out.println("Возраст человека равен " + age + ". Возраст совершеннолетия еще не наступил, нужно немного подождать");
        }

        age = 20;
        if (age >= 18) {
            System.out.println("Возраст человека равен " + age + " он совершеннолетний.");
        } else {
            System.out.println("Возраст человека равен " + age + ". Возраст совершеннолетия еще не наступил, нужно немного подождать");
        }
        System.out.println();

        // Task 2
        System.out.println("TASK 2:");
        int temp = 2;
        if (temp < 5) {
            System.out.println("На улице холодно, нужно надеть шапку");
        } else if (temp == 5) {
            System.out.println("На улице +5, шапка на ваше усмотрение");
        } else {
            System.out.println("Сегодня тепло, можно идти без шапки");
        }

        temp = 5;
        if (temp < 5) {
            System.out.println("На улице холодно, нужно надеть шапку");
        } else if (temp == 5) {
            System.out.println("На улице +5, шапка на ваше усмотрение");
        } else
        {
            System.out.println("Сегодня тепло, можно идти без шапки");
        }

        temp = 7;
        if (temp < 5) {
            System.out.println("На улице холодно, нужно надеть шапку");
        } else if (temp == 5) {
            System.out.println("На улице +5, шапка на ваше усмотрение");
        } else {
            System.out.println("Сегодня тепло, можно идти без шапки");
        }
        System.out.println();

        // Task 3
        System.out.println("TASK 3:");
        int speed = 55;

        if (speed <= 60) {
            System.out.println("Ваша скорость равна: " + speed + ". Превышения скорости нет. Можно ездить спокойно.");
        } else {
            System.out.println("Ваша скорость равна: " + speed + ". Скорость превышена. Придётся заплатить штраф.");
        }

        speed = 65;
        if (speed <= 60) {
            System.out.println("Ваша скорость равна: " + speed + ". Превышения скорости нет. Можно ездить спокойно.");
        } else {
            System.out.println("Ваша скорость равна: " + speed + ". Скорость превышена. Придётся заплатить штраф.");
        }
        System.out.println();

        // Task 4
        System.out.println("TASK 4:");
        int ageHum = 1;

        if (ageHum < 2) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в ясли.");
        } else if (ageHum >= 2 && ageHum <= 6) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в детский сад.");
        } else if (ageHum >= 7 && ageHum <= 17) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в школу.");
        } else if (ageHum >= 18 && ageHum <= 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в университет.");
        } else if (ageHum > 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора ходить на работу.");
        }

        ageHum = 3;
        if (ageHum < 2) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в ясли.");
        } else if (ageHum >= 2 && ageHum <= 6) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в детский сад.");
        } else if (ageHum >= 7 && ageHum <= 17) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в школу.");
        } else if (ageHum >= 18 && ageHum <= 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в университет.");
        } else if (ageHum > 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора ходить на работу.");
        }

        ageHum = 9;
        if (ageHum < 2) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в ясли.");
        } else if (ageHum >= 2 && ageHum <= 6) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в детский сад.");
        } else if (ageHum >= 7 && ageHum <= 17) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в школу.");
        } else if (ageHum >= 18 && ageHum <= 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в университет.");
        } else if (ageHum > 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора ходить на работу.");
        }

        ageHum = 20;
        if (ageHum < 2) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в ясли.");
        } else if (ageHum >= 2 && ageHum <= 6) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в детский сад.");
        } else if (ageHum >= 7 && ageHum <= 17) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в школу.");
        } else if (ageHum >= 18 && ageHum <= 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в университет.");
        } else if (ageHum > 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора ходить на работу.");
        }

        ageHum = 27;
        if (ageHum < 2) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в ясли.");
        } else if (ageHum >= 2 && ageHum <= 6) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в детский сад.");
        } else if (ageHum >= 7 && ageHum <= 17) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в школу.");
        } else if (ageHum >= 18 && ageHum <= 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора в университет.");
        } else if (ageHum > 24) {
            System.out.println("Возраст: " + ageHum + ". Человеку пора ходить на работу.");
        }
        System.out.println();

        // Task 5
        System.out.println("TASK 5:");
        int ageChild = 3;
        if (ageChild <= 5) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку нельзя кататься на аттракционе.");
        } else if (ageChild > 5 && ageChild <= 14) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку можно кататься на аттракционе в сопровождении взрослого.");
        } else if (ageChild > 14) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку можно кататься на аттракционе без сопровождения взрослого.");
        }

        ageChild = 6;
        if (ageChild <= 5) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку нельзя кататься на аттракционе.");
        } else if (ageChild > 5 && ageChild <= 14) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку можно кататься на аттракционе в сопровождении взрослого.");
        } else if (ageChild > 14) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку можно кататься на аттракционе без сопровождения взрослого.");
        }

        ageChild = 15;
        if (ageChild <= 5) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку нельзя кататься на аттракционе.");
        } else if (ageChild > 5 && ageChild <= 14) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку можно кататься на аттракционе в сопровождении взрослого.");
        } else if (ageChild > 14) {
            System.out.println("Возраст ребёнка: " + ageChild + " лет. Ребёнку можно кататься на аттракционе без сопровождения взрослого.");
        }
        System.out.println();

        // Task 6
        System.out.println("TASK 6:");
        int carriagePassagesAll = 102;
        int carriagePassagesSeat = 60;
        int carriagePassagesStand = carriagePassagesAll - carriagePassagesSeat;
        int seatsBusy = 15;
        if (seatsBusy < carriagePassagesSeat) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне есть сидячие и стоячие места");
        } else if (seatsBusy >= carriagePassagesSeat && seatsBusy <= carriagePassagesAll) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне нет сидячих, но есть стоячие места");
        } else if (seatsBusy > carriagePassagesAll) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне нет мест");
        }

        seatsBusy = 65;
        if (seatsBusy < carriagePassagesSeat) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне есть сидячие и стоячие места");
        } else if (seatsBusy >= carriagePassagesSeat && seatsBusy <= carriagePassagesAll) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне нет сидячих, но есть стоячие места");
        } else if (seatsBusy > carriagePassagesAll) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне нет мест");
        }

        seatsBusy = 103;
        if (seatsBusy < carriagePassagesSeat) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне есть сидячие и стоячие места");
        } else if (seatsBusy >= carriagePassagesSeat && seatsBusy <= carriagePassagesAll) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне нет сидячих, но есть стоячие места");
        } else if (seatsBusy > carriagePassagesAll) {
            System.out.println("Занято мест: " + seatsBusy + ". В вагоне нет мест");
        }
        System.out.println();

        // Task 7
        System.out.println("TASK 7:");
        int one = 10;
        int two = 5;
        int three = 2;

        if (one > two && one > three) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". One is maximal number");
        } else if (two > one && two > three) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". Two is maximal number");
        } else if (three > one && three > two) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". Three is maximal number");
        }

        one = 10;
        two = 15;
        three = 12;

        if (one > two && one > three) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". One is maximal number");
        } else if (two > one && two > three) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". Two is maximal number");
        } else if (three > one && three > two) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". Three is maximal number");
        }

        one = 2;
        two = 10;
        three = 25;

        if (one > two && one > three) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". One is maximal number");
        } else if (two > one && two > three) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". Two is maximal number");
        } else if (three > one && three > two) {
            System.out.println("One: " + one + ", Two: " + two + ". Three: " + three + ". Three is maximal number");
        }
    }
}