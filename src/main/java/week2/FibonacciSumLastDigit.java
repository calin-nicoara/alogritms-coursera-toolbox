package week2;

public class FibonacciSumLastDigit {
    public static long fibonacciSumLastDigit(int n) {
        int previousLastDigit = 0;
        int currentLastDigit = 1;

        int lastDigitOfSum = 1;

        for(long i = 2; i <= n; i++) {
            int newNumber = (previousLastDigit + currentLastDigit) % 10;
            previousLastDigit = currentLastDigit;
            currentLastDigit = newNumber;

            lastDigitOfSum = (lastDigitOfSum + currentLastDigit) % 10;
        }

        return lastDigitOfSum;
    }
}
