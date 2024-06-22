public class Puffendui extends SchoolHogwarts {
    private int industry;
    private int loyality;
    private int integrity;

    public Puffendui(String name, int magic, int transgression, int industry, int loyality, int integrity) {
        super(name, magic, transgression);
        this.industry = industry;
        this.loyality = loyality;
        this.integrity = integrity;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public void setLoyality(int loyality) {
        this.loyality = loyality;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }

    public int getIndustry() {
        return industry;
    }

    public int getLoyality() {
        return loyality;
    }

    public int getIntegrity() {
        return integrity;
    }

    @Override
    public String toString() {
        return "Puffendui{" +
                "name=" + super.getName() +
                ", industry=" + industry +
                ", loyality=" + loyality +
                ", integrity=" + integrity +
                ", magic=" + super.getMagic() +
                ", transgression=" + super.getTransgression() +
                '}';
    }
}
