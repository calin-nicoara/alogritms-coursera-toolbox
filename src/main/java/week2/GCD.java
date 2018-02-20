package week2;

public class GCD {

    public static long greatedCommonDenominator(final long firstNumber, final long secondNumber) {
        long numerator = firstNumber;
        long denominator = secondNumber;

        while(denominator != 0) {

            long remainder = numerator % denominator;
            numerator = denominator;
            denominator = remainder;
        }

        return numerator;
    }
}
