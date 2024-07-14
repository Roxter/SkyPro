package pro.sky.java.homeworks.course2.lesson1;

public abstract class ServiceKit {
    protected String modelName;
    protected int wheelsCount;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public abstract boolean serviceMe();

    protected void updateTyre(int wheelNum) {
        System.out.println("Меняем покрышку " + wheelNum);
    }

    protected void checkEngine() {
        System.out.println("Проверяем двигатель");
    }

    protected void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}