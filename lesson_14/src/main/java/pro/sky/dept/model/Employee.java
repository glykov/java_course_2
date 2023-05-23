package pro.sky.dept.model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int dept;
    private double salary;

    public Employee(String firstName, String lastName, int dept, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dept = dept;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDepartment() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "name: " + getFullName() + ", department: " + dept + ", salary: " + salary;
    }

    public void setDepartment(int dept) {
        this.dept = dept;
    }

    public void setSalary(double amount) {
        salary = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return  dept == employee.dept
                && Double.compare(employee.salary, salary) == 0
                && Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dept, salary);
    }
}
