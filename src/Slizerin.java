public class Slizerin extends SchoolHogwarts {
    private int trick;
    private int decision;
    private int ambition;
    private int resource;
    private int lustToPower;

    public Slizerin(String name, int magic, int transgression, int trick, int decision, int ambition, int resource, int lustToPower) {
        super(name, magic, transgression);
        this.trick = trick;
        this.decision = decision;
        this.ambition = ambition;
        this.resource = resource;
        this.lustToPower = lustToPower;
    }

    public void setTrick(int trick) {
        this.trick = trick;
    }

    public void setDecision(int decision) {
        this.decision = decision;
    }

    public void setAmbition(int ambition) {
        this.ambition = ambition;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public void setLustToPower(int lustToPower) {
        this.lustToPower = lustToPower;
    }

    public int getTrick() {
        return trick;
    }

    public int getDecision() {
        return decision;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getResource() {
        return resource;
    }

    public int getLustToPower() {
        return lustToPower;
    }

    @Override
    public String toString() {
        return "Slizerin{" +
                "name=" + super.getName() +
                ", trick=" + trick +
                ", decision=" + decision +
                ", ambition=" + ambition +
                ", resource=" + resource +
                ", lustToPower=" + lustToPower +
                ", magic=" + super.getMagic() +
                ", transgression=" + super.getTransgression() +
                '}';
    }

    @Override
    public void isEqual(Slizerin student) {
        int sumThisStud = this.trick + this.decision + this.ambition + this.resource + this.lustToPower;
        //if (this.getClass() != student.getClass()) {
        int sumAcceptedStud = student.getTrick() + student.getDecision() + student.getAmbition() + student.getLustToPower();
        if (sumThisStud == sumAcceptedStud) {
            System.out.println(student.getName() + " и " + this.getName() + " по баллам в Слизерине равны");
        } else if (sumThisStud <= sumAcceptedStud) {
            System.out.println(student.getName() + " лучший Слизеринец, чем " + this.getName());
        } else {
            System.out.println(this.getName() + " лучший Слизеринец, чем " + student.getName());
        }
        //}
    }
}
