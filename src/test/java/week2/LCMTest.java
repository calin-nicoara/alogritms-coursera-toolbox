package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LCMTest {

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => firstNumber={0}, secondNumber={1}, lcm={2}")
    @CsvSource({
            "6, 8, 24",
            "28851538, 1183019, 1933053046",
    })
    public void calculateFibonacciFast(final long firstNumber, final long secondNumber, final long lcm) {
        Assertions.assertEquals(LCM.leatCommonMultiple(firstNumber, secondNumber), lcm);
    }
}
