package pro.sky.dept.services;

import org.springframework.stereotype.Service;
import pro.sky.dept.exceptions.EmployeeNotFoundException;
import pro.sky.dept.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService service;

    public DepartmentService(EmployeeService service) {
        this.service = service;
    }

    public Employee findMaxSalaryInDept(int id) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == id)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No such employee"));
    }

    public Employee findMinSalaryInDept(int id) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == id)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("No such employee"));
    }

    public List<Employee> getEmployeesOfDept(int deptNumber) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == deptNumber)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getStaffByDept() {
        return service.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
