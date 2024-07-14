package pro.sky.java.homeworks.course2.lesson1;

public class Main {
    protected static Car[] carStore = new Car[2];
    protected static Truck[] truckStore = new Truck[2];
    protected static Bicycle[] bicycleStore = new Bicycle[2];

    public static void main(String[] args) {
        Car car = carStore[0] = new Car();
        Car car2 = carStore[1] = new Car();
        car.setModelName("car1");
        car2.setModelName("car2");
        car.setWheelsCount(4);
        car2.setWheelsCount(4);

        Truck truck = truckStore[0] = new Truck();
        Truck truck2 = truckStore[1] = new Truck();
        truck.setModelName("truck1");
        truck2.setModelName("truck2");
        truck.setWheelsCount(6);
        truck2.setWheelsCount(8);

        Bicycle bicycle = bicycleStore[0] = new Bicycle();
        Bicycle bicycle2 = bicycleStore[1] = new Bicycle();
        bicycle.setModelName("bicycle1");
        bicycle2.setModelName("bicycle2");
        bicycle.setWheelsCount(2);
        bicycle2.setWheelsCount(2);

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.checkTransport(car);
        serviceStation.checkTransport(car2);
        serviceStation.checkTransport(bicycle);
        serviceStation.checkTransport(bicycle2);
        serviceStation.checkTransport(truck);
        serviceStation.checkTransport(truck2);
    }
}