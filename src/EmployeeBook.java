public class EmployeeBook {
    private Employee[] employeeStore = new Employee[10];

    public void listAllEmployees() {
        System.out.println("Имеющиеся в компании сотрудники: ");
        for (Employee emp : employeeStore) {
            if (emp != null) {
                System.out.println(emp.toString());
            }
        }
    }

    public double calcCostOnSalaryMonth() {
        double cost = 0;
        for (Employee employee : employeeStore) {
            if (employee != null) {
                cost += employee.getSalary();
            }
        }
        return cost;
    }

    public Employee findMinEmplSalary() {
        double minSal = Double.MAX_VALUE;
        Employee minSalEmployee = null;
        for (Employee employee : employeeStore) {
            if (employee != null) {
                double currSal = employee.getSalary();
                if (currSal < minSal) {
                    minSal = currSal;
                    minSalEmployee = employee;
                }
            }
        }
        return minSalEmployee;
    }

    public Employee findMaxEmplSalary() {
        double maxSal = Double.MIN_VALUE;
        Employee maxSalEmployee = null;
        for (Employee employee : employeeStore) {
            if (employee != null) {
                double currSal = employee.getSalary();
                if (currSal > maxSal) {
                    maxSal = currSal;
                    maxSalEmployee = employee;
                }
            }
        }
        return maxSalEmployee;
    }

    public double findAmountEmplSalary() {
        return calcCostOnSalaryMonth() / employeeStore.length;
    }

    public void listAllFnameEmployees() {
        System.out.println("ФИО имеющихся в компании сотрудников:");
        for (Employee employee : employeeStore) {
            if (employee != null) {
                System.out.println(employee.getFname());
            }
        }
    }

    public void indexSalary(double percent) {
        double perDip = 0.01;
        if (percent <= 0) {
            System.out.println("Введите корректный процент прироста");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null) {
                    double empSalary = employee.getSalary();
                    double indexedEmpSalary = empSalary + empSalary * perDip * percent;
                    employee.setSalary(indexedEmpSalary);
                }
            }
        }
    }

    public Employee findMinEmplSalaryOnDep(int depNum) {
        double minSal = Double.MAX_VALUE;
        Employee minSalEmployee = null;
        if (depNum <= 0 || depNum > 5) {
            System.out.println("Введите корректный номер отдела");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null) {
                    double currSal = employee.getSalary();
                    if (currSal < minSal && employee.getDepartmentNum() == depNum) {
                        minSal = currSal;
                        minSalEmployee = employee;
                    }
                }
            }
        }
        return minSalEmployee;
    }

    public Employee findMaxEmplSalaryOnDep(int depNum) {
        double maxSal = Double.MIN_VALUE;
        Employee maxSalEmployee = null;
        if (depNum <= 0 || depNum > 5) {
            System.out.println("Введите корректный номер отдела");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null) {
                    double currSal = employee.getSalary();
                    if (currSal > maxSal && employee.getDepartmentNum() == depNum) {
                        maxSal = currSal;
                        maxSalEmployee = employee;
                    }
                }
            }
        }
        return maxSalEmployee;
    }

    public double calcCostOnSalaryMonthOnDep(double depNum) {
        double cost = 0;
        if (depNum <= 0 || depNum > 5) {
            System.out.println("Введите корректный номер отдела");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null) {
                    if (employee.getDepartmentNum() == depNum) {
                        cost += employee.getSalary();
                    }
                }
            }
        }
        return cost;
    }

    public int countEmpsOnDep(int depNum) {
        int cntrEmpsOnDep = 0;
        if (depNum <= 0 || depNum > 5) {
            System.out.println("Введите корректный номер отдела");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null && employee.getDepartmentNum() == depNum) {
                    cntrEmpsOnDep++;
                }
            }
        }
        return cntrEmpsOnDep;
    }

    public double findAmountEmplSalaryOnDep(int depNum) {
        return calcCostOnSalaryMonthOnDep(depNum) / countEmpsOnDep(depNum);
    }

    public void indexSalaryOnDep(double percent, int depNum) {
        double perDip = 0.01;
        if (percent <= 0) {
            System.out.println("Введите корректный процент прироста");
        } else if (depNum <= 0 || depNum > 5) {
            System.out.println("Введите корректный номер отдела");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null && employee.getDepartmentNum() == depNum) {
                    double empSalary = employee.getSalary();
                    double indexedEmpSalary = empSalary + empSalary * perDip * percent;
                    employee.setSalary(indexedEmpSalary);
                }
            }
        }
    }

    public void listAllEmployeesExclDep(int depNum) {
        System.out.println("Данные имеющихся в компании сотрудников отдела " + depNum + ":");
        if (depNum <= 0 || depNum > 5) {
            System.out.println("Введите корректный номер отдела");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null && employee.getDepartmentNum() == depNum) {
                    System.out.printf("%s, зарплата %.0f\n", employee.getFname(), employee.getSalary());
                }
            }
        }
    }

    public void listAllEmployeesLessSal(double maxSalary) {
        int cntrEmp = 0;
        System.out.println("Данные имеющихся в компании с зарплатой меньше " + maxSalary + ":");
        if (maxSalary <= 0) {
            System.out.println("Введите зарплату больше нуля");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null && employee.getSalary() < maxSalary) {
                    System.out.printf("ID %d %s, зарплата %.0f\n", employee.getId(), employee.getFname(), employee.getSalary());
                    cntrEmp++;
                }
            }
            if (cntrEmp <= 0) {
                System.out.println("Сотрудники с зарплатой меньше " + maxSalary + " не найдены");
            }
        }
    }

    public void listAllEmployeesMoreSal(double minSalary) {
        int cntrEmp = 0;
        System.out.println("Данные имеющихся в компании с зарплатой больше " + minSalary + ":");
        if (minSalary <= 0) {
            System.out.println("Введите зарплату больше нуля");
        } else {
            for (Employee employee : employeeStore) {
                if (employee != null && employee.getSalary() >= minSalary) {
                    System.out.printf("ID %d %s, зарплата %.0f\n", employee.getId(), employee.getFname(), employee.getSalary());
                    cntrEmp++;
                }
            }
            if (cntrEmp <= 0) {
                System.out.println("Сотрудники с зарплатой больше или равно " + minSalary + " не найдены");
            }
        }
    }

    public int getCountEmployees() {
        return employeeStore.length;
    }

    public boolean addNewEmployee(String fname, int departmentNum, double salary) {
        boolean isFoundNullCell = false;
        if (fname == null) {
            System.out.println("Передано неверное ФИО. Запись не добавлена");
            return false;
        }
        if (departmentNum <= 0 || departmentNum > 5) {
            System.out.println("Передан неверный номер департамента. Запись не добавлена");
            return false;
        }
        if (salary < 0) {
            System.out.println("Передано неверное значение зарплаты. Запись не добавлена");
            return false;
        }
        for (int i = 0; i < employeeStore.length; i++) {
            if (employeeStore[i] == null) {
                employeeStore[i] = new Employee(fname, departmentNum, salary, i);
                isFoundNullCell = true;
                break;
            }
        }
        return isFoundNullCell;
    }

    public boolean deleteEmployeeOnId(int id) {
        boolean isFoundNotNullCell = false;
        if (id < 0) {
            System.out.println("Передан неверный ID. Запись не найдена");
            return false;
        }
        for (int i = 0; i < employeeStore.length; i++) {
            if (employeeStore[i].getId() == id && employeeStore[i] != null) {
                employeeStore[i] = null;
                isFoundNotNullCell = true;
                break;
            }
        }
        return isFoundNotNullCell;
    }
}
