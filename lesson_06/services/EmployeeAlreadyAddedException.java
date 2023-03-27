package pro.sky.management.services;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
