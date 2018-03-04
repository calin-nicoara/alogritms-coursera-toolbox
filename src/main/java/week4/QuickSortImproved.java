package week4;

import java.util.List;
import java.util.Random;

public class QuickSortImproved {

    public static List<Integer> sort(final List<Integer> unsortedList) {
        sort(unsortedList, 0, unsortedList.size() - 1);

        return unsortedList;
    }

    private static void sort(final List<Integer> unsortedList,
                             final int leftIndex, final int rightIndex) {
        if(leftIndex > rightIndex) {
            return;
        }

        PartitionBound partitionBound = partitionByPivot(unsortedList, leftIndex, rightIndex);

        sort(unsortedList, leftIndex, partitionBound.leftBound -1);
        sort(unsortedList, partitionBound.rightBound +1, rightIndex);
    }

    private static PartitionBound partitionByPivot(final List<Integer> unsortedList, final int leftIndex, final int rightIndex) {
        int pivotIndex = leftIndex + new Random().nextInt(rightIndex-leftIndex+1);
        switchElements(unsortedList, leftIndex, pivotIndex);

        int pivot = unsortedList.get(leftIndex);

        int countPivot = 0;
        int lastIndexForLeftPartition = leftIndex;
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (pivot >= unsortedList.get(i)) {
                switchElements(unsortedList, i, lastIndexForLeftPartition+1);
                lastIndexForLeftPartition++;
                if(pivot == unsortedList.get(i)) {
                    countPivot++;
                }
            }
        }

        switchElements(unsortedList, leftIndex, lastIndexForLeftPartition-countPivot);
        return new PartitionBound(lastIndexForLeftPartition-countPivot, lastIndexForLeftPartition);
    }

    private static void switchElements(final List<Integer> unsortedList, final int i, final int indexToSwitch) {
        int temp = unsortedList.get(i);
        unsortedList.set(i, unsortedList.get(indexToSwitch));
        unsortedList.set(indexToSwitch, temp);
    }

    private static class PartitionBound {
        public int leftBound;
        public int rightBound;

        public PartitionBound(final int leftBoundOfPivotPartition, final int rightBoundOfPivotPartition) {
            this.leftBound = leftBoundOfPivotPartition;
            this.rightBound = rightBoundOfPivotPartition;
        }
    }
}
