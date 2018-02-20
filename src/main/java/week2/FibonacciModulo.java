package week2;

public class FibonacciModulo {
    public static int fibonacciModulo(long n, int modulo) {
        int lastFibModulo = 0;
        int currentFibModulo = 1;

        for(long i = 2; i <= n; i++) {
            int newNumber = (lastFibModulo + currentFibModulo) % modulo;
            lastFibModulo = currentFibModulo;
            currentFibModulo = newNumber;

            if(i%10000 == 0) System.out.println(i);
        }

        return currentFibModulo;
    }
}
