package pro.sky.dept.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super();
    }

    public EmployeeAlreadyAddedException(String msg) {
        super(msg);
    }
}
