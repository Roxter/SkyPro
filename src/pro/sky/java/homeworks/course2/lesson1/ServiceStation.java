package pro.sky.java.homeworks.course2.lesson1;

public class ServiceStation {

    public void service(ServiceKit serviceKit) {
        System.out.println("Обслуживаем средство " + serviceKit.modelName);
        boolean resultOfService = serviceKit.serviceMe();
        if (resultOfService) {
            System.out.println("Обслуживание средства " + serviceKit.modelName + " завершено.\n");
        } else {
            System.out.println("В обслуживании средства " + serviceKit.modelName + " произошла проблема. Повторите сервис.\n");
        }
    }

    public void checkTransport(Bicycle bicycle) {
        service(bicycle);
    }

    public void checkTransport(Car car) {
        service(car);
    }

    public void checkTransport(Truck truck) {
        service(truck);
    }
}