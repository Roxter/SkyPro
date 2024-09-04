package collections.domain;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int departmentNum;
    private final double salary;

    public Employee(String firstName, String lastName, int departmentNum, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentNum = departmentNum;
        this.salary = salary;
    }

   /*public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + firstName + '\'' +
                ", last name = '" + lastName +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Employee e2 = (Employee) obj;
        return firstName.equals(e2.firstName) &&
                lastName.equals(e2.lastName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName);
    }
}
