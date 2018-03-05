package week4;

import java.util.ArrayList;
import java.util.List;

public class NumberInversions {

    public static int numberOfInversions(List<Integer> numbers) {
        return numberOfInversions(numbers, 0, numbers.size()-1).numberInversions;
    }

    private static InversionResult numberOfInversions(final List<Integer> numbers,
                                          final int leftIndex, final int rightIndex) {
        if(leftIndex >= rightIndex) {
            return new InversionResult(numbers.subList(leftIndex, rightIndex+1), 0);
        }

        int middle = (leftIndex + rightIndex) / 2;

        InversionResult numberInversionFromLeft = numberOfInversions(numbers, leftIndex, middle);
        InversionResult numberInversionFromRight = numberOfInversions(numbers, middle+1, rightIndex);

        int sumInversion = 0;
        List<Integer> sortedList = new ArrayList<>();

        List<Integer> leftList = numberInversionFromLeft.sortedList;
        List<Integer> rightList = numberInversionFromRight.sortedList;

        int indexForLeftList = 0;
        int indexForRightList = 0;
        while(indexForLeftList < leftList.size() || indexForRightList < rightList.size()) {
            if(indexForRightList == rightList.size() ||
                    (indexForLeftList < leftList.size() && leftList.get(indexForLeftList) <= rightList.get(indexForRightList) )) {
                sortedList.add(leftList.get(indexForLeftList));
                indexForLeftList++;
                sumInversion += indexForRightList;
            } else {
                sortedList.add(rightList.get(indexForRightList));
                indexForRightList++;
            }
        }

        int numberInversions = numberInversionFromLeft.numberInversions + numberInversionFromRight.numberInversions + sumInversion;
        return new InversionResult(sortedList, numberInversions);

    }

    private static class InversionResult {
        public List<Integer> sortedList;
        public int numberInversions;

        public InversionResult(final List<Integer> sortedList, final int numberInversions) {
            this.sortedList = sortedList;
            this.numberInversions = numberInversions;
        }
    }
}
