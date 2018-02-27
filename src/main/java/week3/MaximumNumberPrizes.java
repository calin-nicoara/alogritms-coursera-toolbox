package week3;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberPrizes {

    public static List<Long> calculateMaximumListSizeForSum(final Long numberOfCandies) {
        Long numbersOfFactors = getNumbersForSum(numberOfCandies);

        List<Long> sumList = new ArrayList<>();
        long sum = 0L;

        for(long i = 1; i <= numbersOfFactors-1; i++) {
            sumList.add(i);
            sum += i;
        }

        sumList.add(numberOfCandies-sum);

        return sumList;
    }

    private static Long getNumbersForSum(final Long numberOfCandies) {
        long possibleNumber = Math.round(Math.sqrt(numberOfCandies * 2));
        if(possibleNumber * (possibleNumber+1) / 2 <= numberOfCandies) {
            return possibleNumber;
        } else {
            return possibleNumber - 1;
        }
    }
}
