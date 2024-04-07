import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        // Task 1
        double dog = 8.0;
        double cat = 3.6;
        int paper = 763789;

        System.out.println(dog + " " + cat + " " + paper);

        // Task 2
        dog = dog + 4;
        cat = cat + 4;
        paper = paper + 4;

        System.out.println(dog + " " + cat + " " + paper);

        // Task 3
        dog = dog - 3.5;
        cat = cat - 1.6;
        paper = paper - 7639;

        System.out.println(dog + " " + cat + " " + paper);

        // Task 4
        double friend = 19;
        System.out.println(friend);
        friend = friend + 2;
        System.out.println(friend);
        friend = friend / 7;
        System.out.println(friend);

        // Task 5
        double frog = 3.5;
        System.out.println(frog);
        frog = frog * 10;
        System.out.println(frog);
        frog = frog / 3.5;
        System.out.println(frog);
        frog = frog + 4;
        System.out.println(frog);

        // Task 6
        double boxer1 = 78.2;
        double boxer2 = 82.7;
        double weight = boxer1 + boxer2;
        System.out.println(weight);
        double diffWeight = abs(boxer1 - boxer2);
        System.out.println(diffWeight);

        // Task 7
        double remain = boxer2 % boxer1;
        System.out.println(remain);

        // Task 8
        int hours = 640;
        int timesInDay = 8;
        int workersInCompany = hours / timesInDay;
        System.out.println("Всего работников в компании - " + workersInCompany + " человек");

        workersInCompany = workersInCompany + 94;
        hours = workersInCompany * timesInDay;
        System.out.println("Если в компании работает " + workersInCompany + " человек, то всего " + hours + " часов работы может быть поделено между сотрудниками");
    }
}