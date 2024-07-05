package pro.sky.java.homeworks.course2.lesson1;

public class Main {
    private static Car[] carstore = new Car[2];
    private static Truck[] truckstore = new Truck[2];
    private static Bicycle[] bicyclestore = new Bicycle[2];

    public static void main(String[] args) {
        Car car = carstore[0];
        Car car2 = carstore[1];
        car.setModelName("car1");
        car2.setModelName("car2");
        car.setWheelsCount(4);
        car2.setWheelsCount(4);

        Truck truck = truckstore[0];
        Truck truck2 = truckstore[1];
        truck.setModelName("truck1");
        truck2.setModelName("truck2");
        truck.setWheelsCount(6);
        truck2.setWheelsCount(8);

        Bicycle bicycle = bicyclestore[0];
        Bicycle bicycle2 = bicyclestore[1];
        bicycle.setModelName("bicycle1");
        bicycle2.setModelName("bicycle2");
        bicycle.setWheelsCount(2);
        bicycle2.setWheelsCount(2);

        check(car);
        check(car2);
        check(bicycle);
        check(bicycle2);
        check(truck);
        check(truck2);
    }

    public static void check(Car car) {
        if (car != null) {
            System.out.println("Обслуживаем " + car.modelName);
            ServiceStation station = new ServiceStation();
            station.startService(car);
        }
    }

    public static void check(Bicycle bicycle) {
        if (bicycle != null) {
            System.out.println("Обслуживаем " + bicycle.modelName);
            for (int i = 0; i < bicycle.wheelsCount; i++) {
                bicycle.updateTyre();
            }
        }
    }

    public static void check(Truck truck) {
        else if (truck != null) {
            System.out.println("Обслуживаем " + truck.modelName);
            for (int i = 0; i < truck.wheelsCount; i++) {
                truck.updateTyre();
            }
            truck.checkEngine();
            truck.checkTrailer();
    }
}