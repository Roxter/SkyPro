package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStationForCar implements ServiceStationForTransport{

    public boolean runProcess(Transport transport) {
        Car car = (Car) transport;
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
}