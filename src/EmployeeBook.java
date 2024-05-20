public class EmployeeBook {
    private Employee[] employeeStore= new Employee[10];

    public void listAllEmployees() {
        System.out.println("Имеющиеся в компании сотрудники: ");
        for (int i = 0; i < employeeStore.length; i++) {
            if (employeeStore[i] == null) {
                System.out.println("В хранилище под номером " + i + " ошибочная запись! Проверьте хранилище");
                break;
            } else {
                System.out.println(employeeStore[i].toString());
            }
        }
    }

    public double calcCostOnSalaryMonth() {
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

    public Employee findMinEmplSalary() {
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

    public Employee findMaxEmplSalary() {
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

    public double findAmountEmplSalary() {
        return calcCostOnSalaryMonth() / employeeStore.length;
    }

    public void listAllFnameEmployees() {
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

    public void indexSalary(double percent) {
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

    public Employee findMinEmplSalaryOnDep(int depNum) {
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

    public Employee findMaxEmplSalaryOnDep(int depNum) {
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

    public double calcCostOnSalaryMonthOnDep(double depNum) {
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

    public int countEmpsOnDep(int depNum) {
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

    public double findAmountEmplSalaryOnDep(int depNum) {
        return calcCostOnSalaryMonthOnDep(depNum) / countEmpsOnDep(depNum);
    }

    public void indexSalaryOnDep(double percent, int depNum) {
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

    public void listAllEmployeesExclDep(int depNum) {
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

    public void listAllEmployeesLessSal(double maxSalary) {
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
                System.out.printf("ID %d %s, зарплата %.0f\n", employee.getId(), employee.getFname(), employee.getSalary());
                cntrEmp++;
            }
        }
        if (cntrEmp <= 0) {
            System.out.println("Сотрудники с зарплатой меньше " + maxSalary + " не найдены");
        }
    }

    public void listAllEmployeesMoreSal(double minSalary) {
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
                System.out.printf("ID %d %s, зарплата %.0f\n", employee.getId(), employee.getFname(), employee.getSalary());
                cntrEmp++;
            }
        }
        if (cntrEmp <= 0) {
            System.out.println("Сотрудники с зарплатой больше или равно " + minSalary + " не найдены");
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
            System.out.println("Передан неверный ID. Запись найдена");
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
