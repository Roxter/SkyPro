public class Griffendor extends SchoolHogwarts {
    private int nobility;
    private int honor;
    private int bravery;

    public Griffendor(String name, int magic, int transgression, int nobility, int honor, int bravery) {
        super(name, magic, transgression);
        this.nobility = nobility;
        this.honor = honor;
        this.bravery = bravery;
    }

    public void setNobility(int nobility) {
        this.nobility = nobility;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }

    public void setBravery(int bravery) {
        this.bravery = bravery;
    }

    public int getNobility() {
        return nobility;
    }

    public int getHonor() {
        return honor;
    }


    public int getBravery() {
        return bravery;
    }


    @Override
    public String toString() {
        return "Griffendor{" +
                "name=" + super.getName() +
                ", nobility=" + nobility +
                ", honor=" + honor +
                ", bravery=" + bravery +
                ", magic=" + super.getMagic() +
                ", transgression=" + super.getTransgression() +
                '}';
    }

    public void isEqual(Griffendor student) {
        int sumThisStud = this.nobility + this.honor + this.bravery;
        if (this.getClass() != student.getClass()) {
            int sumAcceptedStud = student.getNobility() + student.getHonor() + student.getBravery();
        }
        if (sumThisStud == sumAcceptedStud) {
            System.out.println(student.getName() + " и " + this.getName() + " по баллам в Гриффендоре равны");
        } else if (sumThisStud <= sumAcceptedStud) {
            System.out.println(student.getName() + " лучший Гриффиндорец, чем " + this.getName());
        } else {
            System.out.println(this.getName() + " лучший Гриффиндорец, чем " + student.getName());
        }
    }
}
