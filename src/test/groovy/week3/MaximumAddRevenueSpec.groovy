package week3

import spock.lang.Specification
import spock.lang.Unroll


class MaximumAddRevenueSpec extends Specification {

    @Unroll
    "Calculate maximum advertisement revenue"() {
        when:
        def result = MaximumAddRevenue.calculateMaximumAddRevenue(profitList, clicksList)

        then:
        result == expectedRevenue

        where:
        profitList | clicksList || expectedRevenue
        [23]       | [39]       || 897L
        [1, 3, -5] | [-2, 4, 1] || 23L
    }

}