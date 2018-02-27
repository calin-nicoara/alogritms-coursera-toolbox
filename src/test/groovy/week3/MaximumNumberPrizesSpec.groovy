package week3

import spock.lang.Specification
import spock.lang.Unroll


class MaximumNumberPrizesSpec extends Specification {

    @Unroll
    "Calculate maximum size list of sum"() {
        when:
        def result = MaximumNumberPrizes.calculateMaximumListSizeForSum(numberCandies)

        then:
        result == sumList

        where:
        numberCandies || sumList
        6L            || [1L, 2L, 3L]
        8L            || [1L, 2L, 5L]
        23L           || [1L, 2L, 3L, 4L, 5L, 8L]
    }
}