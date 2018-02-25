package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyChangeTest {

    @DisplayName("Should calculate fibonacci but fast")
    @ParameterizedTest(name = "{index} => numberCoinsExpected={0}, moneyValueInput={1}")
    @CsvSource({
            "0, 0",
            "1, 10",
            "1, 5",
            "1, 1",
            "6, 28",
    })
    public void calculateFibonacciSumLastDigit(final int numberCoinsExpected, final int moneyValueInput) {
        Assertions.assertEquals(numberCoinsExpected, MoneyChange.numberOfCoins(moneyValueInput));
    }
}
