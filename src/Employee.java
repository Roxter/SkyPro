public class Employee {
    private String name;
    private int departmentNum;
    private int salary;
    public static int id = 0;

    public Employee(String name, int departmentNum, int salary) {
        this.name = name;
        this.departmentNum = departmentNum;
        this.salary = salary;
        id = id + 1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
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
        return name.equals(e2.name) &&
                departmentNum == e2.departmentNum &&
                salary == e2.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name + departmentNum + salary);
    }
}
