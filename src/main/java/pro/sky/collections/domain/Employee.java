package pro.sky.collections.domain;

public class Employee {
    private String fname;
    private int departmentNum;
    private double salary;
    private int id;

    public Employee(String fname, int departmentNum, double salary, int id) {
        this.fname = fname;
        this.departmentNum = departmentNum;
        this.salary = salary;
        this.id = id;
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

    public int getId() {
        return id;
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
