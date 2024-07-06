package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStationForBicycle extends ServiceStation {
    Bicycle bicycle;

    void ServiceStationForBicycle() {
        bicycle = new Bicycle();
    }

    @Override
    public void startService(Transport transport) {
        super.startService(transport);
    }

    protected boolean runProcess(Transport transport) {
        bicycle = (Bicycle) transport;
        for (int wheelNum = 1; wheelNum <= bicycle.wheelsCount; wheelNum++) {
            updateTyre(bicycle, wheelNum);
        }
        return true;
    }

    private void updateTyre(Bicycle bicycle, int wheelNum) {
        System.out.println("Меняем покрышку " + wheelNum);
    }
}