package pro.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final String lackOfParams = "You should pass two parameters for calculation";
    private final String divideByZero = "You cannot divide by zero";

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Welcome to calculator!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam (required = false) String num1, @RequestParam (required = false) String num2) {
        if (num1 == null || num2 == null) {
            return lackOfParams;
        }
        return "" + calculatorService.plus(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam (required = false) String num1, @RequestParam (required = false) String num2) {
        if (num1 == null || num2 == null) {
            return lackOfParams;
        }
        return "" + calculatorService.minus(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam (required = false) String num1, @RequestParam (required = false) String num2) {
        if (num1 == null || num2 == null) {
            return lackOfParams;
        }
        return "" + calculatorService.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam (required = false) String num1, @RequestParam (required = false) String num2) {
        if (num1 == null || num2 == null) {
            return lackOfParams;
        }
        if (num2.equals("0")) {
            return divideByZero;
        }
        return "" + calculatorService.divide(Integer.parseInt(num1), Integer.parseInt(num2));
    }


}
