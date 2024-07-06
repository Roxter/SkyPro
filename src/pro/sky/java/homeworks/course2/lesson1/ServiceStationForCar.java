package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStationForCar extends ServiceStation {
    Car car;

    void ServiceStationForCar() {
        car = new Car();
    }

    @Override
    public void startService(Transport transport) {
        super.startService(transport);
    }

    protected boolean runProcess(Transport transport) {
        car = (Car) transport;
        for (int wheelNum = 1; wheelNum <= car.wheelsCount; wheelNum++) {
            updateTyre(car, wheelNum);
        }
        checkEngine(car);
        return true;
    }

    private void updateTyre(Car car, int wheelNum) {
        System.out.println("Меняем покрышку " + wheelNum);
    }

    private void checkEngine(Car car) {
        System.out.println("Проверяем двигатель");
    }

    private void checkTrailer(Car car) {
        System.out.println("Проверяем прицеп");
    }
}