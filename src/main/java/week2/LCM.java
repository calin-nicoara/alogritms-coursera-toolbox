package week2;

public class LCM {

    public static long leatCommonMultiple(final long firstNumber, final long secondNumber) {
        return firstNumber * secondNumber / GCD.greatedCommonDenominator(firstNumber, secondNumber);
    }
}
