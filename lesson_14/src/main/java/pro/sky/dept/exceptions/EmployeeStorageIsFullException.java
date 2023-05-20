package pro.sky.dept.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super();
    }

    public EmployeeStorageIsFullException(String msg) {
        super(msg);
    }
}
