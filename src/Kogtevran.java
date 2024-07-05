public class Kogtevran extends SchoolHogwarts {
    private int intellligence;
    private int wisdom;
    private int brillience;
    private int creativity;

    public Kogtevran(String name, int magic, int transgression, int intellligence, int wisdom, int brillience, int creativity) {
        super(name, magic, transgression);
        this.intellligence = intellligence;
        this.wisdom = wisdom;
        this.brillience = brillience;
        this.creativity = creativity;
    }

    public void setIntellligence(int intellligence) {
        this.intellligence = intellligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setBrillience(int brillience) {
        this.brillience = brillience;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public int getIntellligence() {
        return intellligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getBrillience() {
        return brillience;
    }

    public int getCreativity() {
        return creativity;
    }

    @Override
    public String toString() {
        return "Kogtevran{" +
                "name=" + super.getName() +
                ", intellligence=" + intellligence +
                ", wisdom=" + wisdom +
                ", brillience=" + brillience +
                ", creativity=" + creativity +
                ", magic=" + super.getMagic() +
                ", transgression=" + super.getTransgression() +
                '}';
    }

    public void compare(SchoolHogwarts student) {
        if (student instanceof Kogtevran) {
            isEqual((Kogtevran) student);
        } else {
            System.out.println("Ошибка сравнения. Выберите студентов из одного факультета");
        }
    }

    private void isEqual(Kogtevran student) {
        int sumThisStud = this.intellligence + this.wisdom + this.brillience + this.creativity;
        int sumAcceptedStud = student.getCreativity() + student.getIntellligence() + student.getWisdom() + student.getBrillience();
        if (sumThisStud == sumAcceptedStud) {
            System.out.println(student.getName() + " и " + this.getName() + " по баллам в Когтевране равны");
        } else if (sumThisStud <= sumAcceptedStud) {
            System.out.println(student.getName() + " лучший Когтевранец, чем " + this.getName());
        } else {
            System.out.println(this.getName() + " лучший Когтевранец, чем " + student.getName());
        }
    }
}
