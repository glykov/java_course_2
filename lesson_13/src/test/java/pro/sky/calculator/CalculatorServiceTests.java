package pro.sky.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.calculator.exceptions.MyIllegalArgumentException;
import pro.sky.calculator.services.CalculatorService;

@SpringBootTest
class CalculatorServiceTests {
	CalculatorService outgit add . = new CalculatorService();

	@Test
	void summingTwoPositiveNumbers() {
		int result = out.add(5, 5);
		Assertions.assertEquals(10, result);
	}

	@Test
	void summingTwoNegativeNumbers() {
		int result = out.add(-5, -5);
		Assertions.assertEquals(-10, result);
	}

	@Test
	void subtractingTwoPositiveNumbers() {
		int result = out.sub(5, 5);
		Assertions.assertEquals(0, result);
	}

	@Test
	void subtractingTwoNegativeNumbers() {
		int result = out.sub(-5, -5);
		Assertions.assertEquals(0, result);
	}

	@Test
	void multiplyingTwoPositiveNumbers() {
		int result = out.mul(5, 5);
		Assertions.assertEquals(25, result);
	}

	@Test
	void multiplyingTwoNegativeNumbers() {
		int result = out.mul(-5, -5);
		Assertions.assertEquals(25, result);
	}

	@Test
	void multiplyingPositiveAndNegativeNumbers() {
		int result = out.mul(-5, 5);
		Assertions.assertEquals(-25, result);
	}

	@Test
	void dividingTwoPositiveNumbers() {
		int result = out.div(5, 5);
		Assertions.assertEquals(1, result);
	}

	@Test
	void dividingPositiveAndNegativeNumbers() {
		int result = out.div(-5, 5);
		Assertions.assertEquals(-1, result);
	}

	@Test
	void zeroDivisionException() {
		Assertions.assertThrows(MyIllegalArgumentException.class, ()-> out.div(5, 0));
	}

}
