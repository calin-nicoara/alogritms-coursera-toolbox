package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciLastDigitTest {

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => number={0}, fibonacci={1}")
    @CsvSource({
            "12, 4",
            "20, 5",
            "67, 3",
            "200, 5",
    })
    public void calculateFibonacciFast(final int number, final long fibonacci) {
        Assertions.assertEquals(fibonacci, FibonacciLastDigit.fibonacciLastDigit(number));
    }
}
