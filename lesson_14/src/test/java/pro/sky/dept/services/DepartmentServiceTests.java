package pro.sky.dept.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.dept.exceptions.EmployeeNotFoundException;
import pro.sky.dept.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTests {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;

    private List<Employee> staff;

    @BeforeEach
    public void mockingEmployeeService() {
        staff = List.of(
                new Employee("Harry", "Potter", 3, 11.0),
                new Employee("Hermoine", "Granger", 3, 55.5),
                new Employee("Ron", "Weasley", 3, 9.75),
                new Employee("Albus", "Dumbledore", 1, 100500.0),
                new Employee("Rubeus", "Hagrid", 2, 5.0),
                new Employee("Severus", "Snape", 2, 500.0)
        );
        Mockito.when(employeeService.getAll()).thenReturn(staff);
    }

    @ParameterizedTest
    @MethodSource("getMaxSalaryTestParams")
    public void getMaxSalaryTest(int id, Employee e) {
        Assertions.assertThat(departmentService.findMaxSalaryInDept(id))
                .isEqualTo(e);
    }

    public static Stream<Arguments> getMaxSalaryTestParams() {
        return Stream.of(
                Arguments.of(1, new Employee("Albus", "Dumbledore", 1, 100500.0)),
                Arguments.of(2, new Employee("Severus", "Snape", 2, 500.0)),
                Arguments.of(3, new Employee("Hermoine", "Granger", 3, 55.5))

        );
    }

    @Test
    public void getMaxSalaryWhenAbsentNegativeTest() {
        Assertions.assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(()->departmentService.findMaxSalaryInDept(4));
    }

    @ParameterizedTest
    @MethodSource("getMinSalaryTestParams")
    public void getMinSalaryTest(int id, Employee e) {
        Assertions.assertThat(departmentService.findMinSalaryInDept(id))
                .isEqualTo(e);
    }

    public static Stream<Arguments> getMinSalaryTestParams() {
        return Stream.of(
                Arguments.of(1, new Employee("Albus", "Dumbledore", 1, 100500.0)),
                Arguments.of(2, new Employee("Rubeus", "Hagrid", 2, 5.0)),
                Arguments.of(3, new Employee("Ron", "Weasley", 3, 9.75))

        );
    }

    @Test
    public void getMinSalaryWhenAbsentNegativeTest() {
        Assertions.assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(()->departmentService.findMaxSalaryInDept(4));
    }

    @ParameterizedTest
    @MethodSource("getEmployeesOfDeptTestParams")
    public void getEmployeesOfDeptTest(int id, List<Employee> e) {
        Assertions.assertThat(departmentService.getEmployeesOfDept(id))
                .containsExactlyInAnyOrderElementsOf(e);
    }

    public static Stream<Arguments> getEmployeesOfDeptTestParams() {
        return Stream.of(
                Arguments.of(1,
                        List.of(new Employee("Albus", "Dumbledore", 1, 100500.0))
                ),
                Arguments.of(2,
                        List.of(new Employee("Rubeus", "Hagrid", 2, 5.0),
                                new Employee("Severus", "Snape", 2, 500.0))
                ),
                Arguments.of(3,
                        List.of(new Employee("Harry", "Potter", 3, 11.0),
                                new Employee("Hermoine", "Granger", 3, 55.5),
                                new Employee("Ron", "Weasley", 3, 9.75))
                ),
                Arguments.of(4,
                        Collections.emptyList()
                )
        );
    }

    @Test
    public void getEmployeesOfDeptTest() {
        Map<Integer, List<Employee>> e = Map.of(
                1, List.of(new Employee("Albus", "Dumbledore", 1, 100500.0)),
                2, List.of(new Employee("Rubeus", "Hagrid", 2, 5.0),
                                new Employee("Severus", "Snape", 2, 500.0)),
                3, List.of(new Employee("Harry", "Potter", 3, 11.0),
                                new Employee("Hermoine", "Granger", 3, 55.5),
                                new Employee("Ron", "Weasley", 3, 9.75))
        );
        Assertions.assertThat(departmentService.getStaffByDept())
                .containsExactlyInAnyOrderEntriesOf(e);
    }
}
