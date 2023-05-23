package pro.sky.dept.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.dept.model.Employee;
import pro.sky.dept.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to Department Management Application";
    }

    @GetMapping("/max-salary")
    public Employee getMsxSalaryInDept(@RequestParam("departmentId") Integer id){
        return service.findMaxSalaryInDept(id);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryInDept(@RequestParam("departmentId") Integer id) {
        return service.findMinSalaryInDept(id);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getEmployeesByDept(@RequestParam Integer id) {
        return service.getEmployeesOfDept(id);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> getEmployeesByDept() {
        return service.getStaffByDept();
    }
}
