import pro.sky.java.homeworks.course2.lesson1.Bicycle;
import pro.sky.java.homeworks.course2.lesson1.WheeledTransport;

public class ServiceStationForCar {

    @Override
    public void startService(WheeledTransport wheeledTransport) {
        Bicycle bicycle = (Bicycle) wheeledTransport;
        for (int i = 0; i < bicycle.wheelsCount; i++) {
            updateTyre(bicycle);
        }
        car.checkEngine();
    }

    @Override
    public void updateTyre(WheeledTransport wheeledTransport) {
        System.out.println("Меняем покрышку на велосипеде \"" + wheeledTransport.getModelName() + "\"");
    }

    for (int i = 0; i < car.wheelsCount; i++) {
        car.updateTyre();
    }
            car.checkEngine();


    public void checkEngine() {
        System.out.println("Проверяем двигатель");
    }

    public void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}
