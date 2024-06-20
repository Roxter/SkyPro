package pro.sky.java.homeworks.course2.lesson1;

public class Main {
    private static Car[] carstore = new Car[2];
    private static Truck[] truckstore = new Truck[2];
    private static Bicycle[] bicyclestore = new Bicycle[2];

    public static void main(String[] args) {
        Car car = carstore[1];
        Car car2 = carstore[2];
        car.setModelName("car1");
        car2.setModelName("car2");
        car.setWheelsCount(4);
        car2.setWheelsCount(4);

        Truck truck = truckstore[1];
        Truck truck2 = truckstore[2];
        truck.setModelName("truck1");
        truck2.setModelName("truck2");
        truck.setWheelsCount(6);
        truck2.setWheelsCount(8);

        Bicycle bicycle = bicyclestore[1];
        Bicycle bicycle2 = bicyclestore[2];
        bicycle.setModelName("bicycle1");
        bicycle2.setModelName("bicycle2");
        bicycle.setWheelsCount(2);
        bicycle2.setWheelsCount(2);

        ServiceStation station = new ServiceStation();
        station.check(car, null, null);
        station.check(car2, null, null);
        station.check(null, bicycle, null);
        station.check(null, bicycle2, null);
        station.check(null, null, truck);
        station.check(null, null, truck2);
    }
}