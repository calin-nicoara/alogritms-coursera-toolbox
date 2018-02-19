package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciTest {

    @DisplayName("Should calculate fibonacci but slow")
    @ParameterizedTest(name = "{index} => number={0}, fibonacci={1}")
    @CsvSource({
            "12, 144",
            "20, 6765",
            "67, 44945570212853"
    })
    public void calculateFibonacciSlow(final int number, final long fibonacci) {
        Assertions.assertEquals(fibonacci, Fibonacci.calc_fib_slow(number));
    }

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => number={0}, fibonacci={1}")
    @CsvSource({
            "12, 144",
            "20, 6765",
            "67, 44945570212853"
    })
    public void calculateFibonacciFast(final int number, final long fibonacci) {
        Assertions.assertEquals(fibonacci, Fibonacci.fibonacciFast(number));
    }
}
