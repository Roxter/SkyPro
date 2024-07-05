public abstract class SchoolHogwarts {
    private String name;
    private int magic;
    private int transgression;

    public SchoolHogwarts(String name, int magic, int transgression) {
        this.name = name;
        this.magic = magic;
        this.transgression = transgression;
    }

    public String getName() {
        return name;
    }

    public int getMagic() {
        return magic;
    }

    public int getTransgression() {
        return transgression;
    }

    public abstract void compare(SchoolHogwarts student);

    public void compareForParent(SchoolHogwarts student) {
        int sumThisStud = this.magic + this.transgression;
        int sumAcceptedStud = student.getMagic() + student.getTransgression();
        if (sumThisStud == sumAcceptedStud) {
            System.out.println(student.getName() + " и " + this.getName() + " по баллам в Хогвартсе равны");
        } else if (sumThisStud <= sumAcceptedStud) {
            System.out.println(student.getName() + " обладает бОльшей мощностью магии, чем " + this.getName());
        } else {
            System.out.println(this.getName() + " обладает бОльшей мощностью магии, чем " + student.getName());
        }
    }
}

// Класс становится абстрактным когда у него появляется абстрактный метод. До этого он просто наследуемый.
// Все методы интерфейсов по умолчанию абстрактные