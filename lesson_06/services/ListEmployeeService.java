package pro.sky.management.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pro.sky.management.domain.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ListEmployeeService implements EmployeeService{
    List<Employee> employees = new ArrayList<>();

    // выбрасывать исключение о переполнении тут как-то не очень логично,
    // ведь мы используем ArrayList чтобы переполнения не было, но введем
    // искусственное ограничение
    @Override
    public Employee addEmployee(String firstName, String lastname) {
        if (employees.size() > 10) {
            throw new EmployeeStorageIsFullException("Прием сотрудников не производится, наша фирма не резиновая");
        }
        Employee e = new Employee(firstName, lastname);
        if (employees.contains(e)) {
            throw new EmployeeAlreadyAddedException("Двойную зарплату захотел, хитрец?");
        }
        employees.add(e);
        return e;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastname) {
        int index = employees.indexOf(new Employee(firstName, lastname));
        if (index == -1) {
            throw new EmployeeNotFoundException("Мы таких не держим");
        }
        Employee e = employees.get(index);
        employees.remove(index);
        return e;
    }

    @Override
    public Employee findEmployee(String firstName, String lastname) {
        int index = employees.indexOf(new Employee(firstName, lastname));
        if (index == -1) {
            throw new EmployeeNotFoundException("Мы таких не держим");
        }
        return employees.get(index);
    }

    @Override
    public List<Employee> getEmployees() {
        // не хочу отдавать ссылку на мой приватный список
        return new ArrayList<>(employees);
    }
}
