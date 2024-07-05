package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStationForBicycle implements ServiceStation {
    @Override
    public void startService(WheeledTransport wheeledTransport) {
        for (int i = 0; i < wheeledTransport.wheelsCount; i++) {
            updateTyre(wheeledTransport);
        }
        car.checkEngine();
    }

    @Override
    public void updateTyre(WheeledTransport wheeledTransport) {
        System.out.println("Меняем покрышку на велосипеде \"" + wheeledTransport.getModelName() + "\"");
    }
}