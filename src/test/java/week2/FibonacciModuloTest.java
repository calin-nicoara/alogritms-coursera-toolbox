package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciModuloTest {

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => number={0}, modulo={1}, moduloResult={2}")
    @CsvSource({
            "2816213588, 30524, 10249",
            "239, 1000, 161"
    })
    public void calculateFibonacciFast(final long number, final int modulo, final long moduloResult) {
        Assertions.assertEquals(moduloResult, FibonacciModulo.fibonacciModulo(number, modulo));
    }
}
