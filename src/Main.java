public class Main {
    public static Employee[] employeeStore= new Employee[10];

    public static void main(String[] args) {

        employeeStore[0] = new Employee("Иванов Иван Иванович ", 1, 65000);
        employeeStore[1] = new Employee("Петров Петр Петрович", 3, 35000);
        employeeStore[2] = new Employee("Крылов Сергей Иванович", 2, 105000);
        employeeStore[3] = new Employee("Агуреев Константин Сергеевич", 5, 20000);
        employeeStore[4] = new Employee("Султанов Александр Григорьевич", 2, 19000);
        employeeStore[5] = new Employee("Соткин Павел Иванович", 4, 37800);
        employeeStore[6] = new Employee("Игнатьев Александр Игоревич", 3, 44600);
        employeeStore[7] = new Employee("Дулетов Ильшат Тагирович", 2, 75700);
        employeeStore[8] = new Employee("Уральский Игорь Терентьевич", 1, 90000);
        employeeStore[9] = new Employee("Кацурин Игорь Терентьевич", 4, 100000);

        // Low level tasks
        System.out.println("---БАЗОВАЯ СЛОЖНОСТЬ---");
        listAllEmployees();
        System.out.println();

        double cost = calcCostOnSalaryMonth();
        if (cost != 0)
            System.out.printf("Сумма всех затрат на сотрудников составляет %.0f рублей\n", cost);
        System.out.println();

        Employee minSalEmployee = findMinEmplSalary();
        if (minSalEmployee != null)
            System.out.printf("Минимальная зарплата сотрудника %s отдела %d составляет %.0f\n", minSalEmployee.getFname(), minSalEmployee.getDepartmentNum(), minSalEmployee.getSalary());
        System.out.println();

        Employee maxSalEmployee = findMaxEmplSalary();
        if (maxSalEmployee != null)
            System.out.printf("Максимальная зарплата сотрудника %s отдела %d составляет %.0f\n", maxSalEmployee.getFname(), maxSalEmployee.getDepartmentNum(), maxSalEmployee.getSalary());
        System.out.println();

        double amountSalary = findAmountEmplSalary();
        if (amountSalary != 0)
            System.out.printf("Средняя зарплата %d сотрудников составляет %.0f рублей\n", employeeStore.length, amountSalary);
        System.out.println();

        listAllFnameEmployees();
        System.out.println();

        int percent = 5;
        indexSalary(percent);
        System.out.println("Индексация на " + percent + " процентов проведена успешно.");
        System.out.println();

        listAllEmployees();
        System.out.println();

        //High level tasks
        System.out.println("---ПОВЫШЕННАЯ СЛОЖНОСТЬ---");
        int department = 2;
        Employee minEmplSalaryOnDep = findMinEmplSalaryOnDep(department);
        if (minEmplSalaryOnDep != null)
            System.out.printf("Минимальная зарплата сотрудника %s отдела %d составляет %.0f\n", minEmplSalaryOnDep.getFname(), department, minEmplSalaryOnDep.getSalary());
        System.out.println();

        department = 2;
        Employee maxEmplSalaryOnDep = findMaxEmplSalaryOnDep(department);
        if (maxEmplSalaryOnDep != null)
            System.out.printf("Максимальная зарплата сотрудника %s отдела %d составляет %.0f\n", maxEmplSalaryOnDep.getFname(), department, maxEmplSalaryOnDep.getSalary());
        System.out.println();

        department = 3;
        double costOnDep = calcCostOnSalaryMonthOnDep(department);
        if (costOnDep != 0)
            System.out.printf("Сумма всех затрат на сотрудников отдела %d составляет %.0f рублей\n", department, costOnDep);
        System.out.println();

        department = 1;
        double amountEmplSalaryOnDep = findAmountEmplSalaryOnDep(department);
        if (amountEmplSalaryOnDep != 0)
            System.out.printf("Средняя зарплата %d сотрудников отдела %d составляет %.0f рублей\n", countEmpsOnDep(department), department, amountEmplSalaryOnDep);
        System.out.println();

        percent = 10;
        department = 4;
        indexSalaryOnDep(percent, department);
        System.out.println("Индексация на " + percent + " процентов проведена успешно.");
        System.out.println();

        listAllEmployeesExclDep(department);
        System.out.println();

        double salary = 48000;
        listAllEmployeesLessSal(salary);
        System.out.println();

        salary = 48000;
        listAllEmployeesMoreSal(salary);
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

    public static double calcCostOnSalaryMonth() {
        double cost = 0;
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
        double minSal = Double.MAX_VALUE;
        Employee minSalEmployee = null;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return null;
            } else {
                double currSal = employee.getSalary();
                if (currSal < minSal) {
                    minSal = currSal;
                    minSalEmployee = employee;
                }
            }
        }
        return minSalEmployee;
    }

    public static Employee findMaxEmplSalary() {
        double maxSal = Double.MIN_VALUE;
        Employee maxSalEmployee = null;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return null;
            } else {
                double currSal = employee.getSalary();
                if (currSal > maxSal) {
                    maxSal = currSal;
                    maxSalEmployee = employee;
                }
            }
        }
        return maxSalEmployee;
    }

    public static double findAmountEmplSalary() {
        return calcCostOnSalaryMonth() / employeeStore.length;
    }

    public static void listAllFnameEmployees() {
        System.out.println("ФИО имеющихся в компании сотрудников: ");
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись. Вывод сотрудников прерван");
                break;
            } else {
                System.out.println(employee.getFname());
            }
        }
    }

    public static void indexSalary(double percent) {
        double perDip = 0.01;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                break;
            } else if (percent <= 0) {
                System.out.println("Введите корректный процент прироста");
                break;
            }
            double empSalary = employee.getSalary();
            double indexedEmpSalary = empSalary + empSalary * perDip * percent;
            employee.setSalary(indexedEmpSalary);
        }
    }

    public static Employee findMinEmplSalaryOnDep(int depNum) {
        double minSal = Double.MAX_VALUE;
        Employee minSalEmployee = null;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return null;
            } else {
                double currSal = employee.getSalary();
                if (depNum <= 0 || depNum > 5) {
                    System.out.println("Введите корректный номер отдела");
                    break;
                }
                if (currSal < minSal && employee.getDepartmentNum() == depNum) {
                    minSal = currSal;
                    minSalEmployee = employee;
                }
            }
        }
        return minSalEmployee;
    }

    public static Employee findMaxEmplSalaryOnDep(int depNum) {
        double maxSal = Double.MIN_VALUE;
        Employee maxSalEmployee = null;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return null;
            } else {
                double currSal = employee.getSalary();
                if (depNum <= 0 || depNum > 5) {
                    System.out.println("Введите корректный номер отдела");
                    return null;
                }
                if (currSal > maxSal && employee.getDepartmentNum() == depNum) {
                    maxSal = currSal;
                    maxSalEmployee = employee;
                }
            }
        }
        return maxSalEmployee;
    }

    public static double calcCostOnSalaryMonthOnDep(double depNum) {
        double cost = 0;
        for (Employee employee : employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return 0;
            }
            if (depNum <= 0 || depNum > 5) {
                System.out.println("Введите корректный номер отдела");
                return 0;
            }
            if (employee.getDepartmentNum() == depNum) {
                cost += employee.getSalary();
            }
        }
        return cost;
    }

    public static int countEmpsOnDep(int depNum) {
        int cntrEmpsOnDep = 0;
        for (Employee employee : employeeStore) {
            if (depNum <= 0 || depNum > 5) {
                System.out.println("Введите корректный номер отдела");
                return 0;
            } else if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                return 0;
            } else if (employee.getDepartmentNum() == depNum) {
                cntrEmpsOnDep++;
            }
        }
        return cntrEmpsOnDep;
    }

    public static double findAmountEmplSalaryOnDep(int depNum) {
        return calcCostOnSalaryMonthOnDep(depNum) / countEmpsOnDep(depNum);
    }

    public static void indexSalaryOnDep(double percent, int depNum) {
        double perDip = 0.01;
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись");
                break;
            } else if (percent <= 0) {
                System.out.println("Введите корректный процент прироста");
                break;
            } else if (depNum <= 0 || depNum > 5) {
                System.out.println("Введите корректный номер отдела");
                break;
            } else if (employee.getDepartmentNum() == depNum) {
                double empSalary = employee.getSalary();
                double indexedEmpSalary = empSalary + empSalary * perDip * percent;
                employee.setSalary(indexedEmpSalary);
            }
        }
    }

    public static void listAllEmployeesExclDep(int depNum) {
        System.out.println("Данные имеющихся в компании сотрудников отдела " + depNum + ":");
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись. Вывод сотрудников прерван");
                break;
            } else if (depNum <= 0 || depNum > 5) {
                System.out.println("Введите корректный номер отдела");
                break;
            } else if (employee.getDepartmentNum() == depNum) {
                System.out.printf("%s, зарплата %.0f\n", employee.getFname(), employee.getSalary());
            }
        }
    }

    public static void listAllEmployeesLessSal(double maxSalary) {
        int cntrEmp = 0;
        System.out.println("Данные имеющихся в компании с зарплатой меньше " + maxSalary + ":");
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись. Вывод сотрудников прерван");
                break;
            } else if (maxSalary <= 0) {
                System.out.println("Введите зарплату больше нуля");
                break;
            } else if (employee.getSalary() < maxSalary) {
                System.out.printf("ID %d %s, зарплата %.0f\n", employee.id, employee.getFname(), employee.getSalary());
                cntrEmp++;
            }
        }
        if (cntrEmp <= 0) {
            System.out.println("Сотрудники с зарплатой меньше " + maxSalary + " не найдены");
        }
    }

    public static void listAllEmployeesMoreSal(double minSalary) {
        int cntrEmp = 0;
        System.out.println("Данные имеющихся в компании с зарплатой больше " + minSalary + ":");
        for (Employee employee: employeeStore) {
            if (employee == null) {
                System.out.println("В хранилище ошибочная запись. Вывод сотрудников прерван");
                break;
            } else if (minSalary <= 0) {
                System.out.println("Введите зарплату больше нуля");
                break;
            } else if (employee.getSalary() >= minSalary) {
                System.out.printf("ID %d %s, зарплата %.0f\n", employee.id, employee.getFname(), employee.getSalary());
                cntrEmp++;
            }
        }
        if (cntrEmp <= 0) {
            System.out.println("Сотрудники с зарплатой больше или равно " + minSalary + " не найдены");
        }
    }
}