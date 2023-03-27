package pro.sky.management.services;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
