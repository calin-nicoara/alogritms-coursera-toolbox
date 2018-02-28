package week3;

import java.util.List;
import java.util.stream.Collectors;

public class MaximumSalary {

    public static String calculateMaximumSalary(List<Integer> numbers) {
        return numbers.stream()
                .sorted((n1, n2) -> {
                    char[] digitList1 = digitList(n1);
                    char[] digitList2 = digitList(n2);

                    int i = 0;

                    while (i < digitList1.length || i < digitList2.length) {
                        char firstDigitToCompare = digitList1[i % digitList1.length];
                        char secondDigitToCompare = digitList2[i % digitList2.length];

                        if (firstDigitToCompare > secondDigitToCompare) {
                            return -1;
                        } else if (firstDigitToCompare < secondDigitToCompare) {
                            return 1;
                        }

                        i++;
                    }

                    return 0;
                })
                .map(Object::toString).collect(Collectors.joining());
    }

    private static char[] digitList(final int number) {
        return String.valueOf(number).toCharArray();
    }

}
