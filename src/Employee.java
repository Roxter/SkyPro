public class Employee {
    private String fname;
    private int departmentNum;
    private int salary;
    public static int id = 0;

    public Employee(String fname, int departmentNum, int salary) {
        this.fname = fname;
        this.departmentNum = departmentNum;
        this.salary = salary;
        id = id + 1;
    }

    public String getFname() {
        return fname;
    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + fname + '\'' +
                ", departmentNum='" + departmentNum + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Employee e2 = (Employee) obj;
        return fname.equals(e2.fname) &&
                departmentNum == e2.departmentNum &&
                salary == e2.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fname + departmentNum + salary);
    }
}
