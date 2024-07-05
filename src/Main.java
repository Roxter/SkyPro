public class Main {

    public static void main(String[] args) {
        SchoolHogwarts[] studentsHogwarts = new SchoolHogwarts[] {
            new Puffendui("Edger", 52, 54, 34, 59, 23),
            new Puffendui("Mike", 25, 67, 28, 12, 29),
            new Puffendui("Peter", 29, 73, 94, 20, 83),
            new Griffendor("Stork", 25, 18, 10, 57, 91),
            new Griffendor("Garry", 94, 95, 98, 91, 99),
            new Griffendor("Ewen", 15, 94, 26, 84, 52),
            new Kogtevran("Kris", 55, 15, 76, 34, 19, 53),
            new Kogtevran("Edward", 27, 94, 34, 40, 87, 92),
            new Kogtevran("Stem", 15, 75, 91, 24, 13, 15),
            new Slizerin("Malfoi", 14, 13, 17, 24, 20, 5, 4),
            new Slizerin("Granger", 15, 97, 53, 34, 51, 97, 73),
            new Slizerin("Nike", 18, 29, 26, 29, 37, 94, 15)
        };
        for (SchoolHogwarts stud:studentsHogwarts) {
            System.out.println(stud.toString());
        }
        studentsHogwarts[3].compare(studentsHogwarts[4]);
        studentsHogwarts[5].compare(studentsHogwarts[6]);
        studentsHogwarts[0].compare(studentsHogwarts[1]);
        studentsHogwarts[3].compare(studentsHogwarts[4]);
        studentsHogwarts[6].compare(studentsHogwarts[7]);
        studentsHogwarts[10].compare(studentsHogwarts[11]);
        studentsHogwarts[3].compareForParent(studentsHogwarts[4]);
        studentsHogwarts[5].compareForParent(studentsHogwarts[6]);
        studentsHogwarts[0].compareForParent(studentsHogwarts[1]);
        studentsHogwarts[6].compareForParent(studentsHogwarts[7]);
    }

}