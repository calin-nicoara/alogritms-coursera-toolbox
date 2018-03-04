package week4;

import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {

    public static List<Integer> findIndexesInSortedList(final List<Integer> sortedList,
                                                        final List<Integer> numbersToFind) {
        return numbersToFind.stream()
                .map(numberToFind -> binarySearchNumber(sortedList, numberToFind, 0, sortedList.size()-1))
                .collect(Collectors.toList());
    }

    private static Integer binarySearchNumber(final List<Integer> sortedList,
                                              final int numberToFind,
                                              final int beginningIndex,
                                              final int endIndex) {
        if(beginningIndex > endIndex) return -1;

        int indexOfMiddle = (endIndex + beginningIndex) / 2;

        if(sortedList.get(indexOfMiddle) > numberToFind) {
            return binarySearchNumber(sortedList, numberToFind, beginningIndex, indexOfMiddle-1);
        } else if(sortedList.get(indexOfMiddle) < numberToFind) {
            return binarySearchNumber(sortedList, numberToFind, indexOfMiddle+1, endIndex);
        } else {
            return indexOfMiddle;
        }
    }
}
