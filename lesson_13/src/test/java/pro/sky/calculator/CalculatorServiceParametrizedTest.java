package pro.sky.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.services.CalculatorService;

import java.util.stream.Stream;

public class CalculatorServiceParametrizedTest {
    CalculatorService out = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForAdditionTest")
    public void additionTest(int x, int y, int result) {
        assertEquals(result, out.add(x, y));
    }

    public static Stream<Arguments> paramsForAdditionTest() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(5, -5, 0),
                Arguments.of(-5, -5, -10)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForSubtractionTest")
    public void subtractionTest(int x, int y, int result) {
        assertEquals(result, out.sub(x, y));
    }

    public static Stream<Arguments> paramsForSubtractionTest() {
        return Stream.of(
                Arguments.of(5, 5, 0),
                Arguments.of(5, -5, 10),
                Arguments.of(-5, -5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiplicationTest")
    public void multiplicationTest(int x, int y, int result) {
        assertEquals(result, out.mul(x, y));
    }

    public static Stream<Arguments> paramsForMultiplicationTest() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(5, -5, -25),
                Arguments.of(-5, -5, 25)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForDivisionTest")
    public void divisionTest(int x, int y, int result) {
        assertEquals(result, out.div(x, y));
    }

    public static Stream<Arguments> paramsForDivisionTest() {
        return Stream.of(
                Arguments.of(5, 5, 1),
                Arguments.of(5, -5, -1),
                Arguments.of(-5, -5, 1)
        );
    }
}
