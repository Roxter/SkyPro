public class Employee {
    private String fname;
    private int departmentNum;
    private double salary;
    public static int counter = 0;
    public int id = counter++;

    public Employee(String fname, int departmentNum, double salary) {
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

    public double getSalary() {
        return salary;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setDepartmentNum(int departmentNum) {
        this.departmentNum = departmentNum;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
