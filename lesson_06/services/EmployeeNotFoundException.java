package pro.sky.management.services;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
