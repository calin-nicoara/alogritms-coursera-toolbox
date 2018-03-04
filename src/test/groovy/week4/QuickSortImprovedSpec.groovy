package week4

import spock.lang.Specification
import spock.lang.Unroll

import java.util.stream.IntStream

class QuickSortImprovedSpec extends Specification {

    @Unroll
    def "Quick sort improved for equal items"() {
        given:
        def unsortedListGiven = unsortedList

        when:
        def result = QuickSortImproved.sort(unsortedListGiven)

        then:
        result == unsortedListGiven.sort()

        where:
        unsortedList          || _
        [1, 2, 3, 4, 5]       || _
        [5, 2, 4, 3, 1]       || _
        [5, 2, 4, 3, 1, 5, 1] || _
        getBigRandomList()    || _
        getBigOrderedList()   || _
    }

    def getBigRandomList() {
        def random = new Random()
        random.ints()
                .limit(100000)
                .collect()
    }

    def getBigOrderedList() {
        IntStream.range(0, 100000)
        .collect()
    }
}