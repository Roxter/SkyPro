public class Main {
    public static Employee[] employeeStore= new Employee[10];

    public static void main(String[] args) {

        employeeStore[0] = new Employee("Иванов Иван Иванович", 1, 65000);
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
        System.out.println();
        int cost = calcCostOnSalaryMonth();
        if (cost != 0)
            System.out.println("Сумма всех затрат на сотрудников составляет " + cost +  " рублей");
        System.out.println();
        Employee minSalEmployee = findMinEmplSalary();
        if (minSalEmployee != null)
            System.out.println("Минимальная зарплата сотрудника " + minSalEmployee.getFname() + " отдела " + minSalEmployee.getDepartmentNum() + " составляет " + minSalEmployee.getSalary());
        System.out.println();
        Employee maxSalEmployee = findMaxEmplSalary();
        if (maxSalEmployee != null)
            System.out.println("Максимальная зарплата сотрудника " + maxSalEmployee.getFname() + " отдела " + maxSalEmployee.getDepartmentNum() + " составляет " + maxSalEmployee.getSalary());
        System.out.println();
        long amountSalary = findAmountEmplSalary();
        if (amountSalary != 0)
            System.out.println("Средняя зарплата " + employeeStore.length + " сотрудников составляет " + amountSalary + " рублей");
        System.out.println();
        listAllFnameEmployees();
        System.out.println();
    }

    public static void listAllEmployees() {
        System.out.println("Имеющиеся в компании сотрудники: ");
        for (int i = 0; i < employeeStore.length - 1; i++) {
            if (employeeStore[i] == null) {
                System.out.println("В хранилище под номером " + i + " ошибочная запись! Проверьте хранилище");
                break;
            } else {
                System.out.println(employeeStore[i].toString());
            }
        }
    }

    public static int calcCostOnSalaryMonth() {
        int cost = 0;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return 0;
            } else {
                cost += employee.getSalary();
            }
        }
        return cost;
    }

    public static Employee findMinEmplSalary() {
        int minSal = Integer.MAX_VALUE;
        Employee minSalEmployee = null;
        for (int i = 0; i < employeeStore.length - 1; i++) {
            if (employeeStore[i] == null) {
                System.out.println("В хранилище ошибочная запись");
                return null;
            } else {
                int currSal = employeeStore[i].getSalary();
                if (currSal < minSal) {
                    minSal = currSal;
                    minSalEmployee = employeeStore[i];
                }
            }
        }
        return minSalEmployee;
    }

    public static Employee findMaxEmplSalary() {
        int maxSal = Integer.MIN_VALUE;
        Employee maxSalEmployee = null;
        for (int i = 0; i < employeeStore.length - 1; i++) {
            if (employeeStore[i] == null) {
                System.out.println("В хранилище ошибочная запись");
                return null;
            } else {
                int currSal = employeeStore[i].getSalary();
                if (currSal > maxSal) {
                    maxSal = currSal;
                    maxSalEmployee = employeeStore[i];
                }
            }
        }
        return maxSalEmployee;
    }

    public static long findAmountEmplSalary() {
        return Math.round((double) calcCostOnSalaryMonth() / (double) employeeStore.length);
    }

    public static void listAllFnameEmployees() {
        System.out.println("ФИО имеющихся в компании сотрудников: ");
        for (int i = 0; i < employeeStore.length - 1; i++) {
            if (employeeStore[i] == null) {
                System.out.println("В хранилище ошибочная запись. Вывод сотрудников прерван");
                break;
            } else {
                System.out.println(employeeStore[i].getFname());
            }
        }
    }
}