package pro.sky.dept.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.dept.exceptions.EmployeeAlreadyAddedException;
import pro.sky.dept.exceptions.EmployeeNotFoundException;
import pro.sky.dept.exceptions.EmployeeStorageIsFullException;
import pro.sky.dept.model.Employee;

import java.util.stream.Stream;

public class EmployeeServiceTest {

    private final EmployeeService service = new EmployeeService();

    @BeforeEach
    public void fillStaff() {
        service.addEmployee(new Employee("Harry", "Potter", 3, 11.0));
        service.addEmployee(new Employee("Hermoine", "Granger", 3, 55.5));
        service.addEmployee(new Employee("Ron", "Weasley", 3, 9.75));
        service.addEmployee(new Employee("Albus", "Dumbledore", 1, 100500.0));
        service.addEmployee(new Employee("Rubeus", "Hagrid", 2, 5.0));
        service.addEmployee(new Employee("Severus", "Snape", 2, 500.0));
    }

    @AfterEach
    public void clearStaff() {
        service.getAll().forEach(emp -> service.removeEmployee(emp.getFirstName(), emp.getLastName()));
    }

    @Test
    public void addEmployeePositiveTest() {
        int count = service.getAll().size();
        Employee expected = new Employee("Drako", "Malfoy", 4, 499.0);

        Assertions.assertThat(service.addEmployee(new Employee("Drako", "Malfoy", 4, 499.0)))
                .isEqualTo(expected)
                .isIn(service.getAll());
        Assertions.assertThat(service.getAll()).hasSize(count + 1);
    }

    @Test
    public void addEmployeeWhenExistsNegativeTest() {
        Assertions.assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                .isThrownBy(() -> service.addEmployee(new Employee("Harry", "Potter", 3, 11.0)));
    }

    @Test
    public void addEmployeeWhenStorageIsFullNegativeTest() {
        Stream.iterate(1, i -> i + 1)
                .limit(4)
                .map(num ->
                        new Employee("Harry" + ('a' + num), "Potter" + ('a' + num), num, 11.0 + num))
                .forEach(emp -> service.addEmployee(emp));

        Assertions.assertThatExceptionOfType(EmployeeStorageIsFullException.class)
                .isThrownBy(() -> service.addEmployee(new Employee("Drako", "Malfoy", 4, 499.0)));
    }

    @Test
    public void removeEmployeePositiveTest() {
        int count = service.getAll().size();
        Employee expected = new Employee("Harry", "Potter", 3, 11.0);

        Assertions.assertThat(service.removeEmployee("Harry", "Potter"))
                .isEqualTo(expected)
                .isNotIn(service.getAll());
        Assertions.assertThat(service.getAll()).hasSize(count - 1);
    }

    @Test
    public void removeEmployeeWhenAbsentNegativeTest() {
        Assertions.assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> service.removeEmployee("Drako", "Malfoy"));
    }

    @Test
    public void findEmployeePositiveTest() {
        Employee expected = new Employee("Harry", "Potter", 3, 11.0);

        Assertions.assertThat(service.findEmployee("Harry", "Potter"))
                .isEqualTo(expected)
                .isIn(service.getAll());
    }

    @Test
    public void findEmployeeWhenAbsentNegativeTest() {
        Assertions.assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> service.removeEmployee("Drako", "Malfoy"));
    }

    @Test
    public void getAllPositiveTest() {
        Assertions.assertThat(service.getAll())
                .hasSize(6)
                .containsExactlyInAnyOrder(
                        new Employee("Harry", "Potter", 3, 11.0),
                        new Employee("Hermoine", "Granger", 3, 55.5),
                        new Employee("Ron", "Weasley", 3, 9.75),
                        new Employee("Albus", "Dumbledore", 1, 100500.0),
                        new Employee("Rubeus", "Hagrid", 2, 5.0),
                        new Employee("Severus", "Snape", 2, 500.0)
                );
    }
}
