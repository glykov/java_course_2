package pro.sky.calculator.services;

import org.springframework.stereotype.Service;
import pro.sky.calculator.exceptions.MyIllegalArgumentException;

@Service
public class CalculatorService {
    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        if (y == 0) {
            throw new MyIllegalArgumentException("Division by zero!");
        }
        return x / y;
    }
}
