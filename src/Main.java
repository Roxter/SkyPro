public class Main {
    public static Employee[] employeeStore= new Employee[10];

    public static void main(String[] args) {

        employeeStore[0] = new Employee("Иванов Иван Иванович", 1, 15000);
        employeeStore[1] = new Employee("Петров Петр Петрович", 3, 35000);
        employeeStore[2] = new Employee("Крылов Сергей Иванович", 2, 105000);
        employeeStore[3] = new Employee("Агуреев Константин Сергеевич", 5, 20000);
        employeeStore[4] = new Employee("Султанов Александр Григорьевич", 2, 19000);
        employeeStore[5] = new Employee("Соткин Павел Иванович", 4, 37800);
        employeeStore[6] = new Employee("Игнатьев Александр Игоревич", 3, 44600);
        employeeStore[7] = new Employee("Дулетов Ильшат Тагирович", 2, 75700);
        employeeStore[8] = new Employee("Уральский Игорь Терентьевич", 1, 90000);
        employeeStore[9] = new Employee("Кацурин Игорь Терентьевич", 4, 100000);

        listAllEmployees();
    }

    public static void listAllEmployees() {
        for (Employee employee: employeeStore) {
            System.out.println(employee.toString());
        }
    }
}
