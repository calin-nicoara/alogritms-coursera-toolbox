package week2;

import java.util.ArrayList;
import java.util.List;

public class FibonacciLastDigit {
    public static long fibonacciLastDigit(int n) {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);

        for(int i = 2; i <= n; i++) {
            Integer newNumber = (integers.get(i - 2) + integers.get(i - 1)) % 10;
            integers.add(newNumber);
        }

        return integers.get(n);
    }
}
