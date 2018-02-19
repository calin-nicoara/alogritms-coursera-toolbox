package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static long calc_fib_slow(int n) {
        if (n <= 1)
            return n;

        return calc_fib_slow(n - 1) + calc_fib_slow(n - 2);
    }

    public static long fibonacciFast(int n) {
        List<Long> integers = new ArrayList<>();
        integers.add(0L);
        integers.add(1L);

        for(int i = 2; i <= n; i++) {
            Long newNumber = integers.get(i - 2) + integers.get(i - 1);
            integers.add(newNumber);
        }

        return integers.get(n);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib_slow(n));
    }
}
