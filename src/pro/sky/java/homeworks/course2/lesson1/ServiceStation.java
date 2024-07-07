package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStation {

    private ServiceStationForTransport serviceStationForTransport;

    public void startService(Transport transport) {
        System.out.println("Обслуживаем средство " + transport.modelName);
        boolean resultOfService = serviceStationForTransport.runProcess(transport);
        if (resultOfService) {
            System.out.println("Обслуживание средства " + transport.modelName + " завершено.\n");
        } else {
            System.out.println("В обслуживании средства " + transport.modelName + " произошла проблема. Повторите сервис.\n");
        }
    }

    public void check(Bicycle bicycle) {
        serviceStationForTransport = new ServiceStationForBicycle();

        if (bicycle != null) {
            startService(bicycle);
        } else {
            System.out.println("Передан отсутствующий объект");
        }
    }

    public void check(Car car) {
        serviceStationForTransport = new ServiceStationForCar();

        if (car != null) {
            startService(car);
        } else {
            System.out.println("Передан отсутствующий объект");
        }
    }

    public void check(Truck truck) {
        serviceStationForTransport = new ServiceStationForTruck();

        if (truck != null) {
            startService(truck);
        } else {
            System.out.println("Передан отсутствующий объект");
        }
    }
}