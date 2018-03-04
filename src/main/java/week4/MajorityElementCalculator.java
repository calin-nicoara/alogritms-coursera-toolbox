package week4;

import java.util.List;

public class MajorityElementCalculator {

    public static Integer calculateMajorityElement(List<Integer> numbers) {
        if(numbers.isEmpty()) {
            return -1;
        }

        return calculateMajorityElement(numbers, 0, numbers.size()-1);
    }

    private static int calculateMajorityElement(final List<Integer> numbers,
                                                    final int leftIndex, final int rightIndex) {
        if(leftIndex == rightIndex || leftIndex > rightIndex) {
            return numbers.get(leftIndex);
        }

        int middleIndex = (leftIndex + rightIndex) / 2;
        int majorityElementFromLeftHalf = calculateMajorityElement(numbers, leftIndex, middleIndex);
        int majorityElementFromRightHalf = calculateMajorityElement(numbers, middleIndex + 1, rightIndex);

        if(majorityElementFromLeftHalf == majorityElementFromRightHalf) {
            return majorityElementFromLeftHalf;
        }

        int countLeftMajorityElement = 0;
        int countRightMajorityElement = 0;

        for(int i = leftIndex; i <= rightIndex; i++) {
            if(numbers.get(i) == majorityElementFromLeftHalf) countLeftMajorityElement++;
            if(numbers.get(i) == majorityElementFromRightHalf) countRightMajorityElement++;
        }

        int majorityNeeded = (rightIndex - leftIndex + 1) / 2 + 1;

        if(countLeftMajorityElement >= majorityNeeded) {
            return majorityElementFromLeftHalf;
        } else if(countRightMajorityElement >= majorityNeeded) {
            return majorityElementFromRightHalf;
        } else {
            return -1;
        }
    }
}
