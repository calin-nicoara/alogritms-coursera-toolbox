package week4

import spock.lang.Specification
import spock.lang.Unroll


class BinarySearchSpec extends Specification {

    @Unroll
    "Find indexes of numbers in sorted array"() {
        when:
        def result = BinarySearch.findIndexesInSortedList(sortedList, numbersToFind)

        then:
        result == indexes

        where:
        sortedList        | numbersToFind     || indexes
        []                | []                || []
        [1, 5, 8, 12, 13] | []                || []
        [1, 5, 8, 12, 13] | [8, 5]            || [2, 1]
        [1, 5, 8, 12, 13] | [8, 1, 23, 1, 11] || [2, 0, -1, 0, -1]
    }
}