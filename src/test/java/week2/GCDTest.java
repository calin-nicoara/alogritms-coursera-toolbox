package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GCDTest {

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => firstNumber={0}, secondNumber={1}, gcd={2}")
    @CsvSource({
            "12, 8, 4",
            "18, 35, 1",
            "28851538, 1183019, 17657"
    })
    public void calculateFibonacciFast(final long firstNumber, final long secondNumber, final long gcd) {
        Assertions.assertEquals(GCD.greatedCommonDenominator(firstNumber, secondNumber), gcd);
    }
}
