package pro.sky.java.homeworks.course2.lesson1;

public abstract class ServiceStation {
    public void startService(Transport transport) {
        System.out.println("Обслуживаем средство" + transport.modelName);
        boolean resultOfService = runProcess(transport);
        if (resultOfService) {
            System.out.println("Обслуживание средства " + transport.modelName + " завершено.");
        } else {
            System.out.println("В обслуживании средства " + transport.modelName + " произошла проблема. Повторите сервис.");
        }
    }

    protected abstract boolean runProcess(Transport transport);
}