package pro.sky.management.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.management.domain.Employee;
import pro.sky.management.services.EmployeeNotFoundException;
import pro.sky.management.services.ArrayEmployeeService;
import pro.sky.management.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping
    public String hello() {
        return "Welcome to employee management system";
    }

    @GetMapping("/add")
    public Object add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        try {
            return service.addEmployee(firstName, lastName);
        } catch (RuntimeException e) {
            return e;
        }
    }

    @GetMapping("/remove")
    public Object remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        try {
            return service.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e;
        }
    }

    @GetMapping("/find")
    public Object find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        try {
            return service.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e;
        }
    }

    @GetMapping("/showall")
    public List<Employee> showAll() {
        return service.getEmployees();
    }
}
