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
}
