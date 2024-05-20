public class Main {

    private static EmployeeBook empbook = new EmployeeBook();

    public static void main(String[] args) {

        empbook.addNewEmployee("Иванов Иван Иванович ", 1, 65000);
        empbook.addNewEmployee("Петров Петр Петрович", 3, 35000);
        empbook.addNewEmployee("Крылов Сергей Иванович", 2, 105000);
        empbook.addNewEmployee("Агуреев Константин Сергеевич", 5, 20000);
        //empbook.addNewEmployee("Султанов Александр Григорьевич", 2, 19000);
        empbook.addNewEmployee("Соткин Павел Иванович", 4, 37800);
        empbook.addNewEmployee("Игнатьев Александр Игоревич", 3, 44600);
        empbook.addNewEmployee("Дулетов Ильшат Тагирович", 2, 75700);
        empbook.addNewEmployee("Уральский Игорь Терентьевич", 1, 90000);
        empbook.addNewEmployee("Кацурин Игорь Терентьевич", 4, 100000);
        System.out.println();

        // Low level tasks
        System.out.println("---БАЗОВАЯ СЛОЖНОСТЬ---");
        empbook.listAllEmployees();
        System.out.println();

        double cost = empbook.calcCostOnSalaryMonth();
        if (cost != 0)
            System.out.printf("Сумма всех затрат на сотрудников составляет %.0f рублей\n", cost);
        System.out.println();

        Employee minSalEmployee = empbook.findMinEmplSalary();
        if (minSalEmployee != null)
            System.out.printf("Минимальная зарплата сотрудника %s отдела %d составляет %.0f\n", minSalEmployee.getFname(), minSalEmployee.getDepartmentNum(), minSalEmployee.getSalary());
        System.out.println();

        Employee maxSalEmployee = empbook.findMaxEmplSalary();
        if (maxSalEmployee != null)
            System.out.printf("Максимальная зарплата сотрудника %s отдела %d составляет %.0f\n", maxSalEmployee.getFname(), maxSalEmployee.getDepartmentNum(), maxSalEmployee.getSalary());
        System.out.println();

        double amountSalary = empbook.findAmountEmplSalary();
        if (amountSalary != 0)
            System.out.printf("Средняя зарплата %d сотрудников составляет %.0f рублей\n", empbook.getCountEmployees(), amountSalary);
        System.out.println();

        empbook.listAllFnameEmployees();
        System.out.println();

        int percent = 5;
        empbook.indexSalary(percent);
        System.out.println("Индексация на " + percent + " процентов проведена успешно.");
        System.out.println();

        empbook.listAllEmployees();
        System.out.println();

        //High level tasks
        System.out.println("---ПОВЫШЕННАЯ СЛОЖНОСТЬ---");
        int department = 2;
        Employee minEmplSalaryOnDep = empbook.findMinEmplSalaryOnDep(department);
        if (minEmplSalaryOnDep != null)
            System.out.printf("Минимальная зарплата сотрудника %s отдела %d составляет %.0f\n", minEmplSalaryOnDep.getFname(), department, minEmplSalaryOnDep.getSalary());
        System.out.println();

        department = 2;
        Employee maxEmplSalaryOnDep = empbook.findMaxEmplSalaryOnDep(department);
        if (maxEmplSalaryOnDep != null)
            System.out.printf("Максимальная зарплата сотрудника %s отдела %d составляет %.0f\n", maxEmplSalaryOnDep.getFname(), department, maxEmplSalaryOnDep.getSalary());
        System.out.println();

        department = 3;
        double costOnDep = empbook.calcCostOnSalaryMonthOnDep(department);
        if (costOnDep != 0)
            System.out.printf("Сумма всех затрат на сотрудников отдела %d составляет %.0f рублей\n", department, costOnDep);
        System.out.println();

        department = 1;
        double amountEmplSalaryOnDep = empbook.findAmountEmplSalaryOnDep(department);
        if (amountEmplSalaryOnDep != 0)
            System.out.printf("Средняя зарплата %d сотрудников отдела %d составляет %.0f рублей\n", empbook.countEmpsOnDep(department), department, amountEmplSalaryOnDep);
        System.out.println();

        percent = 10;
        department = 4;
        empbook.indexSalaryOnDep(percent, department);
        System.out.println("Индексация на " + percent + " процентов проведена успешно.");
        System.out.println();

        empbook.listAllEmployeesExclDep(department);
        System.out.println();

        double salary = 48000;
        empbook.listAllEmployeesLessSal(salary);
        System.out.println();

        salary = 48000;
        empbook.listAllEmployeesMoreSal(salary);
        System.out.println();

        //Very high level tasks
        System.out.println("---ОЧЕНЬ ВЫСОКАЯ СЛОЖНОСТЬ---");

        boolean askNewEmployee = empbook.addNewEmployee("Григорьев Иван Павлович", 2, 2600);
        if (askNewEmployee) {
            System.out.println("Сотрудник успешно добавлен");
        } else {
            System.out.println("Сотрудник не был добавлен");
        }
        empbook.listAllEmployees();
        System.out.println();

        boolean askDelEmployee = empbook.deleteEmployeeOnId(7);
        if (askDelEmployee) {
            System.out.println("Сотрудник успешно удален");
        } else {
            System.out.println("Сотрудник не был удален");
        }
        empbook.listAllEmployees();
        System.out.println();
    }


}