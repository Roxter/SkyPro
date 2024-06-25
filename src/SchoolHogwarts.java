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

    public abstract void isEqual();
}

// Класс становится абстрактным когда у него появляется абстрактный метод. До этого он просто наследуемый.
// Все методы интерфейсов по умолчанию абстрактные