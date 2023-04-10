import java.util.*;

public class EmployeeMap {
    private Map<String, Employee> staff = new HashMap<>();

    // methods to change map contents
    // adding employee
    public void hireEmployee(Employee employee) {
        staff.put(employee.getFullName(), employee);
    }

    // removing employee by name
    public void fireEmployee(String fullName) {
        if (staff.containsKey(fullName)) {
            staff.remove(fullName);
        } else {
            System.out.println("There is no such employee");
        }
    }

    // removing employee by id
    public void fireEmployee(int id) {
        String fullName = "";
        for (var employee : staff.values()) {
            if (employee.getId() == id) {
                fullName = employee.getFullName();
            }
        }
        if (fullName.isEmpty()) {
            System.out.println("There is no employee with given id");
        } else {
            staff.remove(fullName);
        }
    }

    // methods to change employee characteristics
    public void changeDepartment(String fullName, int newDepartmentNumber) {
        if (staff.containsKey(fullName)) {
            staff.get(fullName).setDepartment(newDepartmentNumber);
        } else {
            System.out.println("There is no such employee");
        }
    }

    public void changeSalary(String fullName, double salary) {
        if (staff.containsKey(fullName)) {
            staff.get(fullName).setSalary(salary);
        } else {
            System.out.println("There is no such employee");
        }
    }

    // Indexing salaries by arbitrary %
    public void indexSalaries(int percent) {
        for (var e : staff.entrySet()) {
            double newSalary = e.getValue().getSalary();
            newSalary = newSalary + newSalary * percent / 100.0;
            e.getValue().setSalary(newSalary);
        }
    }

    // non-modifying service methods
    //show all staff
    public void showAllEmployees() {
        staff.forEach((k, v) -> System.out.println(v));
    }

    public void showFullNames() {
        for (var e : staff.values()) {
            System.out.println(e.getFullName());
        }
    }

    // show employees by department
    public void showEmployeesByDept() {
        var list = new ArrayList<>(staff.values());
        list.sort(Comparator.comparingInt(Employee::getDepartment));
        list.forEach(System.out::println);
    }

    // show employees of given department
    public void showEmployeesOfDept(int deptNumber) {
        var list = staff.values();
        list.forEach(e -> {
            if (e.getDepartment() == deptNumber) {
                System.out.println(e);
            }
        });
    }

    // calculates the total money paid to employees
    public double calculateFullPayments() {
        double result = 0;
        for (var e : staff.values()) {
            result += e.getSalary();
        }
        return result;
    }

    public Employee getMinPaidEmployee() {
        var list = staff.values();
        return Collections.min(list, Comparator.comparingDouble(Employee::getSalary));
    }

    public Employee getMaxPaidEmployee() {
        var list = staff.values();
        return Collections.max(list, Comparator.comparingDouble(Employee::getSalary));
    }

    public double getAverageSalary() {
        return calculateFullPayments() / staff.size();
    }

    // Find minimal salary by dept
    public Employee findMinPaidByDep(int deptNumber) {
        var list = new ArrayList<>(staff.values());
        list.removeIf(e -> e.getDepartment() != deptNumber);
        return Collections.min(list, Comparator.comparingDouble(Employee::getSalary));
    }

    // Find maximal salary by dept
    public Employee findMaxPaidByDep(int deptNumber) {
        var list = new ArrayList<>(staff.values());
        list.removeIf(e -> e.getDepartment() != deptNumber);
        return Collections.max(list, Comparator.comparingDouble(Employee::getSalary));
    }

    // Total salary by dept
    public double findTotalSalaryByDep(int deptNumber) {
        double total = 0.0;
        for (var e : staff.values()) {
            if (e.getDepartment() == deptNumber) {
                total += e.getSalary();
            }
        }
        return total;
    }

    // Average salary by dept
    public double findAverageSalaryByDep(int deptNumber) {
        double total = 0.0;
        int count = 0;
        for (var e : staff.values()) {
            if (e.getDepartment() == deptNumber) {
                total += e.getSalary();
                count++;
            }
        }
        return total / count;
    }

    // Indexing salary in department
    public void indexSalaryByDept(int deptNumber, int percent) {
        for (var e : staff.values()) {
            if (e.getDepartment() == deptNumber) {
                double salary = e.getSalary();
                salary += salary * percent / 100.0;
                e.setSalary(salary);
            }
        }
    }

    // find employees with salary below the amount
    public void showEmployeesWithLowerSalary(double amount) {
        for (var e : staff.values()) {
            if (e.getSalary() < amount) {
                System.out.println("id: " + e.getId() + ", name: " + e.getFullName()
                + ", salary: " + e.getSalary());
            }
        }
    }

    // find employees with salary above the amount
    public void showEmployeesWithHigherSalary(double amount) {
        for (var e : staff.values()) {
            if (e.getSalary() >= amount) {
                System.out.println("id: " + e.getId() + ", name: " + e.getFullName()
                + ", salary: " + e.getSalary());
            }
        }
    }

}
