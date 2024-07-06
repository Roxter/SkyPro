package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStationForTruck extends ServiceStation {

    @Override
    public void startService(Transport transport) {
        super.startService(transport);
    }

    protected boolean runProcess(Transport transport) {
        Truck truck = (Truck) transport;
        for (int wheelNum = 1; wheelNum <= truck.wheelsCount; wheelNum++) {
            updateTyre(truck, wheelNum);
        }
        checkEngine(truck);
        checkTrailer(truck);
        return true;
    }

    private void updateTyre(Truck truck, int wheelNum) {
        System.out.println("Меняем покрышку " + wheelNum);
    }

    private void checkEngine(Truck truck) {
        System.out.println("Проверяем двигатель");
    }

    private void checkTrailer(Truck truck) {
        System.out.println("Проверяем прицеп");
    }
}
