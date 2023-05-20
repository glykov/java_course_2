package pro.sky.dept.services;

import org.springframework.stereotype.Service;
import pro.sky.dept.exceptions.EmployeeAlreadyAddedException;
import pro.sky.dept.exceptions.EmployeeNotFoundException;
import pro.sky.dept.exceptions.EmployeeStorageIsFullException;
import pro.sky.dept.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int CAPACITY = 10;
    private final List<Employee> staff = new ArrayList<>();

    public Employee addEmployee(Employee e) {
        if (staff.contains(e)) {
            throw new EmployeeAlreadyAddedException("This employee is already on the list");
        } else if (staff.size() < CAPACITY) {
            staff.add(e);
            return e;
        }
        throw new EmployeeStorageIsFullException("Staff is full. No new employees allowed");
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee e = staff.stream()
                .filter(emp -> emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        staff.remove(e);
        return e;
    }

    public Employee findEmployee(String firstName, String lastName) {
        return staff.stream()
                .filter(emp -> emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(staff);
    }
}
