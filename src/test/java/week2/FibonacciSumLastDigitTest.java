package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciSumLastDigitTest {

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => number={0}, fibonacci={1}")
    @CsvSource({
            "3, 4",
            "100, 5"
    })
    public void calculateFibonacciSumLastDigit(final int number, final long fibonacciLastDigit) {
        Assertions.assertEquals(fibonacciLastDigit, FibonacciSumLastDigit.fibonacciSumLastDigit(number));
    }
}
